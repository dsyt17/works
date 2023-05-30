package com.example.lr4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class csv extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csv);


        EditText et = findViewById(R.id.editTextCsv);
        FileInputStream f;
        try{
            f = openFileInput("1.csv");
            byte[] bytes = new byte[f.available()];
            f.read(bytes);
            String text = new String(bytes);
            et.setText(text);
        }
        catch (IOException ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }


        Button push_csv = findViewById(R.id.push_button);
        push_csv.setOnClickListener(csv_export_listener);
    }
    private final View.OnClickListener csv_export_listener = view -> {
        FileOutputStream f;
        try
        {
            EditText et = findViewById(R.id.editTextCsv);
            String text = et.getText().toString();
            f = openFileOutput("1.csv", MODE_PRIVATE);
            f.write(text.getBytes());
            Toast.makeText(csv.this,"Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch (IOException ex)
        {
            Toast.makeText(csv.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };
}
