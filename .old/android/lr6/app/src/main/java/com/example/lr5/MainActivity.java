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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button add_button, search_button, sort_button, price_button;
    dbHelper db;
    ArrayList<String> corpID, corpName, corpFounders, corpProducts, corpPrice, corpCategory;
    TextView main_header_tv;
    LinearLayout search_layout;
    EditText search_bar;
    boolean IsSearchViewable = false;
    int column_counter = 0;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        recreate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        add_button = findViewById(R.id.add_button);
        sort_button = findViewById(R.id.sort_button);
        price_button = findViewById(R.id.price_button);
        search_button = findViewById(R.id.search_button);
        main_header_tv = findViewById(R.id.header_main);

        corpID = new ArrayList<>();
        corpName = new ArrayList<>();
        corpFounders = new ArrayList<>();
        corpProducts = new ArrayList<>();
        corpPrice = new ArrayList<>();
        corpCategory = new ArrayList<>();

        db = new dbHelper(MainActivity.this);
        CursorData();

        recyclerView.setAdapter(new dbAdapter((Context) this, corpID, corpName, corpFounders, corpProducts, corpPrice, corpCategory));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        main_header_tv.setOnClickListener(onHeadClickListener);
        search_button.setOnClickListener(onSearchButtonClickListener);
        sort_button.setOnClickListener(onSortButtonClickListener);
        price_button.setOnClickListener(onPriceButtonClickListener);

    }

    public  View.OnClickListener onPriceButtonClickListener = view -> {
        double AvgPrice = CursorGetAvgPrice();
        double SumPrice = CursorGetSumPrice();
        Intent intent = new Intent(this, price.class);
        intent.putExtra("avg",AvgPrice);
        intent.putExtra("sum",SumPrice);
        startActivityForResult(intent, 1);
    };

    public  View.OnClickListener onSortButtonClickListener = view -> {
        //startActivityForResult(new Intent(this, SortActivity.class), 2);
        search_bar = findViewById(R.id.search_bar);
        recyclerView = findViewById(R.id.recycler_view);
        String column;
        if(column_counter%2==0){
            column = "product";
            Toast.makeText(MainActivity.this, "Сортировка по продуктам", Toast.LENGTH_SHORT).show();
        }
        else {
            column = "category";
            Toast.makeText(MainActivity.this, "Сортировка по категории", Toast.LENGTH_SHORT).show();
        }
        column_counter++;
        CursorSortData(column);
        recyclerView.setAdapter(new dbAdapter((Context) this, corpID, corpName, corpFounders, corpProducts, corpPrice, corpCategory));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    };

    public View.OnClickListener onSearchButtonClickListener = view -> {
        search_bar = findViewById(R.id.search_bar);
        recyclerView = findViewById(R.id.recycler_view);
        String data = search_bar.getText().toString().trim();
        CursorSearchData(data);
        recyclerView.setAdapter(new dbAdapter((Context) this, corpID, corpName, corpFounders, corpProducts, corpPrice, corpCategory));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    };

    public View.OnClickListener onHeadClickListener = view -> {
        search_layout = findViewById(R.id.search_layout);
        main_header_tv = findViewById(R.id.header_main);
        if(!IsSearchViewable){
            main_header_tv.setText(R.string.search_results);
            search_layout.setVisibility(View.VISIBLE);
            IsSearchViewable = true;
        }
        else {
            main_header_tv.setText(R.string.info);
            search_layout.setVisibility(View.GONE);
            recyclerView = findViewById(R.id.recycler_view);
            CursorData();
            recyclerView.setAdapter(new dbAdapter((Context) this, corpID, corpName, corpFounders, corpProducts, corpPrice, corpCategory));
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            IsSearchViewable = false;
        }
    };

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            TextView corpName = findViewById(R.id.corpName_txt);
            TextView corpFounders = findViewById(R.id.corpFounders_txt);
            TextView corpProducts = findViewById(R.id.corpProducts_txt);
            TextView corpPrice = findViewById(R.id.corpPrice_txt);
            TextView corpCategory = findViewById(R.id.corpCategory_txt);
            corpName.setWidth(500);
            corpFounders.setWidth(500);
            corpProducts.setWidth(500);
            corpPrice.setWidth(500);
            corpCategory.setWidth(500);
        }
    }

    public void CursorData(){
        Cursor cursor = db.readAllData();

        corpID.clear();
        corpName.clear();
        corpFounders.clear();
        corpProducts.clear();
        corpPrice.clear();
        corpCategory.clear();

        if (cursor.getCount() != 0){
            while (cursor.moveToNext()) {
                corpID.add(cursor.getString(0));
                corpName.add(cursor.getString(1));
                corpFounders.add(cursor.getString(2));
                corpProducts.add(cursor.getString(3));
                corpPrice.add(cursor.getString(4));
                corpCategory.add(cursor.getString(5));
            }
        }
    }

    public void CursorSearchData(String data){
        Cursor cursor = db.searchData(data);

        corpID.clear();
        corpName.clear();
        corpFounders.clear();
        corpProducts.clear();
        corpPrice.clear();
        corpCategory.clear();

        if (cursor.getCount() != 0){
            while (cursor.moveToNext()) {
                corpID.add(cursor.getString(0));
                corpName.add(cursor.getString(1));
                corpFounders.add(cursor.getString(2));
                corpProducts.add(cursor.getString(3));
                corpPrice.add(cursor.getString(4));
                corpCategory.add(cursor.getString(5));
            }
        }
    }

    public void CursorSortData(String column){
        Cursor cursor = db.sortData(column);

        corpID.clear();
        corpName.clear();
        corpFounders.clear();
        corpProducts.clear();
        corpPrice.clear();
        corpCategory.clear();

        if (cursor.getCount() != 0){
            while (cursor.moveToNext()) {
                corpID.add(cursor.getString(0));
                corpName.add(cursor.getString(1));
                corpFounders.add(cursor.getString(2));
                corpProducts.add(cursor.getString(3));
                corpPrice.add(cursor.getString(4));
                corpCategory.add(cursor.getString(5));
            }
        }
    }

    public double CursorGetAvgPrice(){
        Cursor cursor = db.getAvgOfProducts();
        double AvgPrice = 0;
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()) {
                AvgPrice = Double.parseDouble(cursor.getString(0));
            }
        }
        return AvgPrice;
    }

    public double CursorGetSumPrice(){
        Cursor cursor = db.getSumOfProducts();
        double SumPrice = 0;
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()) {
                SumPrice = Double.parseDouble(cursor.getString(0));
            }
        }
        return SumPrice;
    }

    public void onClickAddButtonMain(View view) {
        startActivityForResult(new Intent(this, add_company.class), 1);
    }

}