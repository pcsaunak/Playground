package com.example.playground;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button add;
    Button subtract;
    TextView displayNumber;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayNumber = findViewById(R.id.text);
        add = findViewById(R.id.add);
        add.setOnClickListener(this);
        subtract = findViewById(R.id.subtract);
        subtract.setOnClickListener(this);

        next = findViewById(R.id.next);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add) {
            Toast.makeText(this, "Add Button clicked", Toast.LENGTH_SHORT).show();
            int val = Integer.parseInt(displayNumber.getText().toString());
            val = val + 1;
            displayNumber.setText(Integer.toString(val));
        } else if (v.getId() == R.id.next) {
            Intent nextActivityIntent = new Intent(this,NextActivity.class);
            nextActivityIntent.putExtra("qty",displayNumber.getText().toString());
            startActivity(nextActivityIntent);
        } else {
            Toast.makeText(this, "Subtract Button clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
