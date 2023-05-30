package com.example.myg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button button;
    EditText editTextNumber, editTextNumber2, editTextNumber3;
    TextView textView, textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextNumber2 = (EditText) findViewById(R.id.editTextTextPersonName3);
        editTextNumber3 = (EditText) findViewById(R.id.editTextTextPersonName4);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editTextNumber.getText().toString());
                int b = Integer.parseInt(editTextNumber2.getText().toString());
                int c = Integer.parseInt(editTextNumber3.getText().toString());
                double d = Math.pow(b, 2) - 4*a*c;
                double x1 = (-b - Math.pow(d, 0.5))/(2*a);
                double x2 = (-b + Math.pow(d, 0.5))/(2*a);
                String ans = "x1 = "+String.valueOf(x1)+", x2 = "+String.valueOf(x2);
                textView2.setText(ans);
            }
        });



    }
}