package com.example.lr4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

class PStudent implements Parcelable {
    private String Full_Name,Gender,Programming_Languages,IDE;
    public PStudent(String Full_Name_Add, String Gender_Add, String Programming_Languages_Add, String IDE_Add){
        this.Full_Name = Full_Name_Add;
        this.Gender = Gender_Add;
        this.Programming_Languages = Programming_Languages_Add;
        this.IDE = IDE_Add;
    }

    protected PStudent(Parcel in) {
        Full_Name = in.readString();
        Gender = in.readString();
        Programming_Languages = in.readString();
        IDE = in.readString();
    }

    public static final Creator<PStudent> CREATOR = new Creator<PStudent>() {
        @Override
        public PStudent createFromParcel(Parcel in) {
            return new PStudent(in);
        }

        @Override
        public PStudent[] newArray(int size) {
            return new PStudent[size];
        }
    };

    public String Get_Full_Name(){
        return this.Full_Name;
    }

    public void Set_Full_Name(String New_Full_Name){
        this.Full_Name = New_Full_Name;
    }
    public String Get_Gender(){
        return this.Gender;
    }
    public void Set_Gender(String New_Gender){
        this.Gender = New_Gender;
    }
    public String Get_Programming_Languages(){
        return this.Programming_Languages;
    }
    public void Set_Programming_Languages(String New_Programming_Languages){
        this.Programming_Languages = New_Programming_Languages;
    }
    public String Get_IDE(){
        return this.IDE;
    }
    public void Set_IDE(String New_IDE){
        this.IDE = New_IDE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Full_Name);
        parcel.writeString(Gender);
        parcel.writeString(Programming_Languages);
        parcel.writeString(IDE);
    }
}

public class add_student_activity extends AppCompatActivity
{
    Button save_st_button;
    EditText
            FullNameEditText,
            IDEEditText,
            PLEditText,
            GenderEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        save_st_button = findViewById(R.id.save_student_button);
        FullNameEditText = findViewById(R.id.full_name_edit_text);
        IDEEditText = findViewById(R.id.ide_edit_text);
        PLEditText = findViewById(R.id.programming_lang_edit_text);
        GenderEditText = findViewById(R.id.gender_edit_text);
        PStudent PS = null;
        int id = 0;
        Bundle arguments = getIntent().getExtras();
        int head = (int)arguments.get("head");
        if(arguments.get("student")!=null){
            PS = (PStudent) arguments.get("student");
            id = (int) arguments.get("id");
        }
        TextView tv = findViewById(R.id.change_add_head);
        if(head==0)
        {
            tv.setText(getString(R.string.add_student_head));
        }
        else {
            tv.setText(getString(R.string.change_student_head));
            FullNameEditText.setText(PS.Get_Full_Name());
            IDEEditText.setText(PS.Get_IDE());
            PLEditText.setText(PS.Get_Programming_Languages());
            GenderEditText.setText(PS.Get_Gender());
        }
        int finalId = id;
        save_st_button.setOnClickListener(view -> {
            if(     FullNameEditText.getText().toString().equals("")
                    || IDEEditText.getText().toString().equals("")
                    || PLEditText.getText().toString().equals("")
                    || GenderEditText.getText().toString().equals("")){
                Toast.makeText(add_student_activity.this,"Не все поля заполнены",Toast.LENGTH_SHORT).show();
            }
            else{
                String FullName = FullNameEditText.getText().toString();
                String IDE = IDEEditText.getText().toString();
                String PL = PLEditText.getText().toString();
                String Gender = GenderEditText.getText().toString();
                PStudent PS2 = new PStudent(FullName,Gender,PL,IDE);
                Intent resultIntent = new Intent(add_student_activity.this,xml.class);
                resultIntent.putExtra("student",PS2);
                resultIntent.putExtra("id", finalId);
                setResult(Activity.RESULT_OK,resultIntent);
                finish();
            }
        });
    }

}
