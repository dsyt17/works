package com.example.lr9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    CompanyAdapter adapter;
    ArrayList<Company> list;


    Button addBoardBtn;
    LinearLayout root;

    DatabaseReference companyR;

    Integer myNumTicket = 0;

    String companyName;
    String companyFounders;
    String companyProducts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBoardBtn =  findViewById(R.id.addBoardBtn);
        recyclerView = findViewById(R.id.ticketList);
        root = findViewById(R.id.calendar_root_layout);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);


        CompGetTicket();
        AddTicket();
        GetCompany();

    }

    //добавить компанию
    private void AddTicket() {

        addBoardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder addT = new AlertDialog.Builder(MainActivity.this);
                addT.setTitle("Добавление новой компании");
                addT.setMessage("Заполните все поля");

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                View addT_window = inflater.inflate(R.layout.add_company, null);
                addT.setView(addT_window);

                final MaterialEditText name = addT_window.findViewById(R.id.addTicketName);
                final MaterialEditText founders = addT_window.findViewById(R.id.addTicketText);
                final MaterialEditText product = addT_window.findViewById(R.id.addTicketPeople);


                addT.setNegativeButton("Назад", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                addT.setPositiveButton("Отправить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (TextUtils.isEmpty(name.getText().toString())){
                            Snackbar.make(root, "Введите название!", Snackbar.LENGTH_SHORT).show();
                            return;
                        }
                        if (TextUtils.isEmpty(founders.getText().toString())){
                            Snackbar.make(root, "Введите имена разработчиков!", Snackbar.LENGTH_SHORT).show();
                            return;
                        }
                        if (TextUtils.isEmpty(product.getText().toString())){
                            Snackbar.make(root, "Введите продукты!", Snackbar.LENGTH_SHORT).show();
                            return;
                        }


                        companyName = name.getText().toString();
                        companyFounders = founders.getText().toString();
                        companyProducts = product.getText().toString();


                        Company company = new Company(companyName, companyFounders, companyProducts);

                        CompGetTicket();

                        companyR.child(String.valueOf(myNumTicket+1)).setValue(company);


                    }
                });

                addT.show();


            }
        });


    }

    //для добавления
    private void CompGetTicket(){

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        companyR = db.getReference("Company");

        companyR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()) {
                    String increment = ds.getKey();
                    myNumTicket = Integer.parseInt(increment);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    //получить тикеты
    private void GetCompany() {

        database = FirebaseDatabase.getInstance().getReference("Company");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        list = new ArrayList<>();
        adapter = new CompanyAdapter(MainActivity.this, list);
        recyclerView.setAdapter(adapter);

        database.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshotT) {
                            for (DataSnapshot statusSnapshot : snapshotT.getChildren()) {
                                Company company = statusSnapshot.getValue(Company.class);
                                list.add(company);
                            }
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


    }

    //Свайпы(удаление)
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            int position = viewHolder.getAdapterPosition();

            switch (direction){

                case ItemTouchHelper.LEFT:

                    Company company = list.get(position);
                    String nameC = company.getName();

                    DatabaseReference dReference = FirebaseDatabase.getInstance().getReference();

                    Query delQuery = dReference.child("Company").orderByChild("name").equalTo(nameC);
                    delQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot delSnapshot: dataSnapshot.getChildren()) {
                                delSnapshot.getRef().removeValue();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    list.remove(position);
                    adapter.notifyItemRemoved(position);
                    Toast.makeText(MainActivity.this,"Удалена компания "+nameC,Toast.LENGTH_SHORT).show();
                    break;

            }

        }
    };



}

