package com.example.lr5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button add_button;

    dbHelper db;
    ArrayList<String> corpID, corpName, corpFounders, corpProducts;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        recreate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);
        add_button = findViewById(R.id.add_button);

        corpID = new ArrayList<>();
        corpName = new ArrayList<>();
        corpFounders = new ArrayList<>();
        corpProducts = new ArrayList<>();

        db = new dbHelper(MainActivity.this);
        CursorData();

        recyclerView.setAdapter(new dbAdapter((Context) this, corpID, corpName, corpFounders, corpProducts));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            TextView corpName = findViewById(R.id.corpName_txt);
            TextView corpFounders = findViewById(R.id.corpFounders_txt);
            TextView corpProducts = findViewById(R.id.corpProducts_txt);
            corpName.setWidth(500);
            corpFounders.setWidth(500);
            corpProducts.setWidth(500);
        }
    }

    public void CursorData(){
        Cursor cursor = db.readAllData();

        if (cursor.getCount() != 0){
            while (cursor.moveToNext()) {
                corpID.add(cursor.getString(0));
                corpName.add(cursor.getString(1));
                corpFounders.add(cursor.getString(2));
                corpProducts.add(cursor.getString(3));
            }
        }
    }

    public void onClickAddButtonMain(View view) {
        startActivityForResult(new Intent(this, add_company.class), 1);
    }
}