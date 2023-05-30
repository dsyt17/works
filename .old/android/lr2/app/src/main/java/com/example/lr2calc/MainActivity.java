package com.example.lr2calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private CalcClass calc;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int [] NumberId =new int[] {
                R.id.zero,
                R.id.one,
                R.id.two,
                R.id.three,
                R.id.four,
                R.id.five,
                R.id.six,
                R.id.seven,
                R.id.eight,
                R.id.nine,
        };

        int [] ButtonId =new int[] {
                R.id.plus,
                R.id.minus,
                R.id.delit,
                R.id.multiply,
                R.id.clear,
                R.id.equality,
        };


        text = findViewById(R.id.text);




    calc = new CalcClass ();

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc.onNumPressed(view.getId());
                text.setText(calc.getText());

            }
        };

        View.OnClickListener actionButtonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calc.onActionPressed(view.getId());
                text.setText(calc.getText());

            }
        };

        for (int i = 0; i < NumberId.length; i++) {
            findViewById(NumberId[i]).setOnClickListener(numberButtonClickListener);

        }

        for (int i = 0; i < ButtonId.length; i++) {
            findViewById(ButtonId[i]).setOnClickListener(actionButtonOnClickListener);

        }











    }
}