package com.example.lr5;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class change_company extends AppCompatActivity {

    EditText etCorpName, etCorpFounders, etCorpProducts;
    Button clearButton, updateButton, deleteButton;

    String id, name, founders, products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);

        etCorpName = findViewById(R.id.editTextCorpName);
        etCorpFounders = findViewById(R.id.editTextCorpFounders);
        etCorpProducts = findViewById(R.id.editTextCorpProducts);
        clearButton = findViewById(R.id.clear_button);
        updateButton = findViewById(R.id.update_button);
        deleteButton = findViewById(R.id.delete_button);

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }

        updateButton.setOnClickListener(view -> {

            dbHelper myDB = new dbHelper(change_company.this);
            name = etCorpName.getText().toString().trim();
            founders = etCorpFounders.getText().toString().trim();
            products = etCorpProducts.getText().toString().trim();
            myDB.updateData(id, name, founders, products);
            finish();
        });


        deleteButton.setOnClickListener(view -> confirmDialog());
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("corp_name") &&
                getIntent().hasExtra("corp_founders") && getIntent().hasExtra("corp_products")){

            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("corp_name");
            founders = getIntent().getStringExtra("corp_founders");
            products = getIntent().getStringExtra("corp_products");

            etCorpName.setText(name);
            etCorpFounders.setText(founders);
            etCorpProducts.setText(products);
            Log.d("stev", name+" "+founders+" "+products);
        }else{
            Toast.makeText(this, "Нет данных.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Удалить " + name + " ?");
        builder.setMessage("Вы уверены?");
        builder.setPositiveButton("Да", (dialogInterface, i) -> {
            dbHelper myDB = new dbHelper(change_company.this);
            myDB.deleteOneRow(id);
            finish();
        });
        builder.setNegativeButton("Отмена", (dialogInterface, i) -> {

        });
        builder.create().show();
    }

    public void onClickClear(View view) {
        etCorpName.setText("");
        etCorpFounders.setText("");
        etCorpProducts.setText("");
    }
}