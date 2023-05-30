package com.example.lr4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class json extends AppCompatActivity {
    ListView StudentLV;
    List list = new ArrayList();
    ArrayList<Student> student_list = new ArrayList<>();
    TextView head_text_view;
    EditText StudentETJson;
    Button add_button;
    ArrayAdapter adapter;
    boolean IsText = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        add_button = findViewById(R.id.add_param_button);
        head_text_view = findViewById(R.id.json_head);
        head_text_view.setOnClickListener(change_on_head_click_listener);
        add_button.setOnClickListener(add_listener);
        StudentETJson = findViewById(R.id.editTextMultiLineJson);
        StudentLV = findViewById(R.id.listview_student);


        StringBuilder to_edit_text = new StringBuilder("[");
        String student;
        for (int i = 0; i < student_list.size(); i++)
        {
            student="\n\t\t{";
            student+="\n\t\t\t\t\"full_name\": \"";
            student+=student_list.get(i).Get_Full_Name();
            student+="\",";
            student+="\n\t\t\t\t\"ide\": \"";
            student+=student_list.get(i).Get_IDE();
            student+="\",";
            student+="\n\t\t\t\t\"gender\": \"";
            student+=student_list.get(i).Get_Gender();
            student+="\",";
            student+="\n\t\t\t\t\"pl\": \"";
            student+=student_list.get(i).Get_Programming_Languages();
            student+="\"";
            list.add
                    (
                            student_list.get(i).Get_Full_Name() +
                                    "\n" + student_list.get(i).Get_IDE() +
                                    " | " + student_list.get(i).Get_Gender() +
                                    " | " + student_list.get(i).Get_Programming_Languages()
                    );
            student+="\n\t\t},";
            if(i==student_list.size()-1){
                student = student.substring(0,student.length()-1);
            }
            to_edit_text.append(student);
        }
        to_edit_text.append("\n]");
        StudentETJson.setText(to_edit_text.toString());

        adapter = new ArrayAdapter(json.this, android.R.layout.simple_list_item_1,list);
        StudentLV.setAdapter(adapter);
        StudentLV.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Intent editIntent = new Intent("android.intent.action.add_student_activity");
            editIntent.putExtra("head",1);
            PStudent PS = new PStudent(
                    student_list.get((int) id).Get_Full_Name(),
                    student_list.get((int) id).Get_Gender(),
                    student_list.get((int) id).Get_Programming_Languages(),
                    student_list.get((int) id).Get_IDE()
            );
            editIntent.putExtra("student", PS);
            int idd = (int) id;
            editIntent.putExtra("id",idd);
            startActivityForResult(editIntent,2);
        });
        Button save_button = findViewById(R.id.push_button);
        save_button.setOnClickListener(save_json_listener);
        Button update_button = findViewById(R.id.update_button);
        update_button.setOnClickListener(update_from_json_listener);
    }

    private final View.OnClickListener update_from_json_listener = view -> {
        StudentETJson = findViewById(R.id.editTextMultiLineJson);
        FileInputStream fis;
        try
        {
            fis = openFileInput("1.json");
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            String text = new String(bytes);
            StudentETJson.setText(text);
            Toast.makeText(this, "Обновлено", Toast.LENGTH_SHORT).show();
        }
        catch (IOException ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    private final View.OnClickListener save_json_listener = view -> {
        StudentETJson = findViewById(R.id.editTextMultiLineJson);
        FileOutputStream fos;
        try
        {
            String text = StudentETJson.getText().toString();
            fos = openFileOutput("1.json", MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(json.this,"Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch (IOException ex)
        {
            Toast.makeText(json.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    private final View.OnClickListener change_on_head_click_listener = view -> {
        head_text_view = findViewById(R.id.json_head);
        StudentETJson = findViewById(R.id.editTextMultiLineJson);
        StudentLV = findViewById(R.id.listview_student);
        if(!IsText){
            // text is now visible
            head_text_view.setText(getString(R.string.json_head_text));
            StudentLV.setVisibility(View.INVISIBLE);
            StudentETJson.setVisibility(View.VISIBLE);
            IsText = true;
        }
        else {
            // text is now invisible
            head_text_view.setText(getString(R.string.json_head_visual));
            StudentLV.setVisibility(View.VISIBLE);
            StudentETJson.setVisibility(View.INVISIBLE);
            IsText = false;
        }
    };
    private final View.OnClickListener add_listener = view -> {
        Intent addIntent = new Intent("android.intent.action.add_student_activity");
        addIntent.putExtra("head",0);
        startActivityForResult(addIntent,1);
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            // add item to list
            if(resultCode == RESULT_OK){
                PStudent PS;
                if (data != null) {
                    PS = data.getParcelableExtra("student");
                    student_list.add(new Student(PS.Get_Full_Name(),PS.Get_Gender(),PS.Get_Programming_Languages(),PS.Get_IDE()));
                    int last_student_place = student_list.size()-1;
                    list.add
                            (
                                    student_list.get(last_student_place).Get_Full_Name() +
                                            "\n" + student_list.get(last_student_place).Get_IDE() +
                                            " | " + student_list.get(last_student_place).Get_Gender() +
                                            " | " + student_list.get(last_student_place).Get_Programming_Languages()
                            );
                    adapter = new ArrayAdapter(json.this, android.R.layout.simple_list_item_1,list);
                    StudentLV.setAdapter(adapter);
                    StudentETJson = findViewById(R.id.editTextMultiLineJson);
                    String from_edit_text = StudentETJson.getText().toString();
                    from_edit_text = from_edit_text.substring(0,from_edit_text.length()-2);
                    String student=",\n\t\t{";
                    student+="\n\t\t\t\t\"full_name\": \"";
                    student+=student_list.get(last_student_place).Get_Full_Name();
                    student+="\",";
                    student+="\n\t\t\t\t\"ide\": \"";
                    student+=student_list.get(last_student_place).Get_IDE();
                    student+="\",";
                    student+="\n\t\t\t\t\"gender\": \"";
                    student+=student_list.get(last_student_place).Get_Gender();
                    student+="\",";
                    student+="\n\t\t\t\t\"pl\": \"";
                    student+=student_list.get(last_student_place).Get_Programming_Languages();
                    student+="\"\n\t\t}";
                    from_edit_text+=student;
                    from_edit_text+="\n]";
                    StudentETJson.setText(from_edit_text);
                }
            }
        }
        else if(requestCode == 2){
            // edit item from list
            if(resultCode == RESULT_OK){
                PStudent PS;
                if (data != null) {
                    PS = data.getParcelableExtra("student");
                    int id = data.getIntExtra("id",0);
                    student_list.get(id).Set_Full_Name(PS.Get_Full_Name());
                    student_list.get(id).Set_Gender(PS.Get_Gender());
                    student_list.get(id).Set_IDE(PS.Get_IDE());
                    student_list.get(id).Set_Programming_Languages(PS.Get_Programming_Languages());
                    list.clear();
                    StringBuilder to_edit_text = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<students>");
                    String student;
                    for(int i = 0; i< student_list.size(); i++){
                        student="\n\t\t{";
                        student+="\n\t\t\t\t\"full_name\": \"";
                        student+=student_list.get(i).Get_Full_Name();
                        student+="\",";
                        student+="\n\t\t\t\t\"ide\": \"";
                        student+=student_list.get(i).Get_IDE();
                        student+="\",";
                        student+="\n\t\t\t\t\"gender\": \"";
                        student+=student_list.get(i).Get_Gender();
                        student+="\",";
                        student+="\n\t\t\t\t\"pl\": \"";
                        student+=student_list.get(i).Get_Programming_Languages();
                        student+="\"";
                        list.add
                                (
                                        student_list.get(i).Get_Full_Name() +
                                                "\n" + student_list.get(i).Get_IDE() +
                                                " | " + student_list.get(i).Get_Gender() +
                                                " | " + student_list.get(i).Get_Programming_Languages()
                                );
                        student+="\n\t\t},";
                        if(i==student_list.size()-1){
                            student = student.substring(0,student.length()-1);
                        }
                        to_edit_text.append(student);
                    }
                    to_edit_text.append("\n]");
                    StudentETJson.setText(to_edit_text.toString());
                    adapter = new ArrayAdapter(json.this, android.R.layout.simple_list_item_1,list);
                    StudentLV.setAdapter(adapter);
                }
            }
        }
    }
}