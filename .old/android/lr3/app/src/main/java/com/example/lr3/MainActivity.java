package com.example.lr3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Student> Student = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updLV();

    }

    public void addbtn(View view)
    {
        Intent intent = new Intent(this, addStudent.class);
        startActivityForResult(intent, 1);
    }



    private void updLV()
    {
        ListView listView = findViewById(R.id.listView);
        Adapter Adapter = new Adapter(this, R.layout.list_layout, Student);
        listView.setAdapter(Adapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent info) {
        super.onActivityResult(requestCode, resultCode, info);
        if (info != null) {
            String name = info.getStringArrayExtra("List")[0];
            String sex = info.getStringArrayExtra("List")[1];
            String lang = info.getStringArrayExtra("List")[2];
            String ide = info.getStringArrayExtra("List")[3];

            Student.add(new Student(name, sex, lang, ide));
            updLV();


        }
    }
}