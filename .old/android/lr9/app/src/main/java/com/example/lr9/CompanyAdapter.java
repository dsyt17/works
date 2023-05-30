package com.example.lr9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.MyViewHolderForCalendar> {


    Context context;

    ArrayList<Company> list;


    public CompanyAdapter(Context context, ArrayList<Company> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolderForCalendar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolderForCalendar(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderForCalendar holder, int position) {

        Company company = list.get(position);
        holder.Name.setText(company.getName());
        holder.Founders.setText(company.getFounders());
        holder.Product.setText(company.getProduct());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolderForCalendar extends RecyclerView.ViewHolder{

        TextView Name, Founders, Product;

        public MyViewHolderForCalendar(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.ticketTitle);
            Founders = itemView.findViewById(R.id.ticketText);
            Product = itemView.findViewById(R.id.ticketPeople);

        }


    }




}

