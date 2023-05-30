package com.example.lr5;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class dbAdapter extends RecyclerView.Adapter<dbAdapter.ViewHolder> {

    private Context context;
    private ArrayList corpID, corpName, corpFounders, corpProducts, corpPrice, corpCategory;

    dbAdapter(Context context, ArrayList corpID, ArrayList corpName, ArrayList corpFounders, ArrayList corpProducts, ArrayList corpPrice, ArrayList corpCategory){
        this.context = context;
        this.corpID = corpID;
        this.corpName = corpName;
        this.corpFounders = corpFounders;
        this.corpProducts = corpProducts;
        this.corpPrice = corpPrice;
        this.corpCategory = corpCategory;
    }

    @NonNull
    @Override
    public dbAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dbAdapter.ViewHolder holder, int position) {
        holder.corpID_txt.setText(String.valueOf(corpID.get(position)));
        holder.corpName_txt.setText(String.valueOf(corpName.get(position)));
        holder.corpFounders_txt.setText(String.valueOf(corpFounders.get(position)));
        holder.corpProducts_txt.setText(String.valueOf(corpProducts.get(position)));
        holder.corpPrice_txt.setText(String.valueOf(corpPrice.get(position)));
        holder.corpCategory_txt.setText(String.valueOf(corpCategory.get(position)));


        holder.mainLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, change_company.class);
            intent.putExtra("id", String.valueOf(corpID.get(position)));
            intent.putExtra("corp_name", String.valueOf(corpName.get(position)));
            intent.putExtra("corp_founders", String.valueOf(corpFounders.get(position)));
            intent.putExtra("corp_products", String.valueOf(corpProducts.get(position)));
            intent.putExtra("corp_price", String.valueOf(corpPrice.get(position)));
            intent.putExtra("corp_category", String.valueOf(corpCategory.get(position)));
            ((Activity) context).startActivityForResult(intent,1);
        });
    }

    @Override
    public int getItemCount() { return corpID.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView corpID_txt, corpName_txt, corpFounders_txt, corpProducts_txt, corpPrice_txt, corpCategory_txt;
        LinearLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            corpID_txt = itemView.findViewById(R.id.corpID_txt);
            corpName_txt = itemView.findViewById(R.id.corpName_txt);
            corpFounders_txt = itemView.findViewById(R.id.corpFounders_txt);
            corpProducts_txt = itemView.findViewById(R.id.corpProducts_txt);
            corpPrice_txt = itemView.findViewById(R.id.corpPrice_txt);
            corpCategory_txt = itemView.findViewById(R.id.corpCategory_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
