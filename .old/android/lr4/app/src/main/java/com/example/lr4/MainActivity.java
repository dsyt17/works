package com.example.lr4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button txt_button = (Button) findViewById(R.id.txt);
        Button csv_button = (Button) findViewById(R.id.csv);
        Button xml_button = (Button) findViewById(R.id.xml);
        Button json_button = (Button) findViewById(R.id.json);
        txt_button.setOnClickListener(txt_listener);
        csv_button.setOnClickListener(csv_listener);
        xml_button.setOnClickListener(xml_listener);
        json_button.setOnClickListener(json_listener);

    }
    private View.OnClickListener txt_listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent addIntent = new Intent("android.intent.action.txt");
            startActivity(addIntent);
        }
    };
    private View.OnClickListener csv_listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent addIntent = new Intent("android.intent.action.csv");
            startActivity(addIntent);
        }
    };
    private View.OnClickListener xml_listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent addIntent = new Intent("android.intent.action.xml");
            startActivity(addIntent);
        }
    };
    private View.OnClickListener json_listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent addIntent = new Intent("android.intent.action.json");
            startActivity(addIntent);
        }
    };
}