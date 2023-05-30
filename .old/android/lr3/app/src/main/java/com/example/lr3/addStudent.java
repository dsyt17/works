package com.example.lr3;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class addStudent extends AppCompatActivity {

    EditText name, sex, lang, ide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.getname);
        sex = findViewById(R.id.getsex);
        lang = findViewById(R.id.getlang);
        ide = findViewById(R.id.getide);

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClickAdd(View v) {
        List<String> list = Arrays.asList(FIO(), SEX(), LANG(), IDE());
        Intent intent = new Intent();
        intent.putExtra("List", list.toArray());
        setResult(RESULT_OK, intent);

        Toast.makeText(getApplicationContext(), "Запись добавлена", Toast.LENGTH_SHORT).show();
        Cleaner(null);
        finish();


    }
    public String FIO() {
        if (name.getText().length() == 0) return "";
        else return name.getText().toString();
    }

    public String SEX() {
        if (sex.getText().length() == 0) return "";
        else return sex.getText().toString();
    }

    public String LANG() {
        if (lang.getText().length() == 0) return "";
        else return lang.getText().toString();
    }

    public String IDE() {
        if (ide.getText().length() == 0) return "";
        else return ide.getText().toString();
    }


    public void Cleaner(View view) {
        name.setText(null);
        ide.setText(null);
        lang.setText(null);
        ide.setText(null);

    }

}
