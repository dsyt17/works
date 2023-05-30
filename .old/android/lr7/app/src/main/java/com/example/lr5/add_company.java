package com.example.lr5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class add_company extends AppCompatActivity {



    EditText etCorporation;
    EditText etFounder;
    EditText etProduct;
    EditText etPrice;
    EditText etCategory;
    private static final short MIN_COUNT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);

        etCorporation = findViewById(R.id.editTextCorpCompany);
        etFounder = findViewById(R.id.editTextCorpFounder);
        etProduct = findViewById(R.id.editTextCorpProduct);
        etPrice = findViewById(R.id.editTextCorpPrice);
        etCategory = findViewById(R.id.editTextCorpCategory);

        // Запрет на ввод цифр
        for (EditText et : new EditText[]{etCorporation, etProduct})
            et.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (Pattern.compile("[0-9]").matcher(et.getText().toString()).find()) {
                        et.setText(et.getText().toString().substring(0,
                                et.getText().toString().length() - 1));
                        et.setSelection(et.getText().toString().length());
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });

    }

    public String getCorporation() {
        if (etCorporation.getText().toString().trim().length() == 0) return "";
        else return etCorporation.getText().toString();
    }

    public String getFounder() {
        if (etFounder.getText().toString().trim().length() == 0) return "";
        else return etFounder.getText().toString();
    }

    public String getProduct() {
        if (etProduct.getText().toString().trim().length() == 0) return "";
        else return etProduct.getText().toString();
    }

    public String getPrice() {
        if (etPrice.getText().toString().trim().length() == 0) return "";
        else return etPrice.getText().toString();
    }

    public String getCategory() {
        if (etCategory.getText().toString().trim().length() == 0) return "";
        else return etCategory.getText().toString();
    }

    public void onClickClear(View view) {
        etCorporation.setText("");
        etFounder.setText("");
        etProduct.setText("");
        etPrice.setText("");
        etCategory.setText("");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClickAddButton(View view) {
        List<String> list = Arrays.asList(getCorporation(), getFounder(), getProduct(), getPrice(), getCategory());

        dbHelper db = new dbHelper(add_company.this);
        db.addCorp(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
        finish();

    }
}
