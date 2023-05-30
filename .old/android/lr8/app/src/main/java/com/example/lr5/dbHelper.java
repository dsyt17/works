package com.example.lr5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class dbHelper extends SQLiteOpenHelper {

    public Context context;
    private static final String DATABASE_NAME = "Corporations.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "CorpTable";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME_CORP = "corp_name";
    private static final String COLUMN_FOUNDERS = "corp_founders";
    private static final String COLUMN_PRODUCTS = "corp_products";
    private static final String COLUMN_PRICE = "corp_price";
    private static final String COLUMN_CATEGORY = "corp_category";

    private static final String TABLE_NAME_USER = "User";
    private static final String COLUMN_ID_USER = "UId";
    private static final String COLUMN_LOGIN_USER = "ULogin";
    private static final String COLUMN_PASSWORD_USER = "UPassword";
    private static final String COLUMN_MAIL_USER = "UMail";


    dbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME_CORP + " TEXT, " + COLUMN_FOUNDERS + " TEXT, " + COLUMN_PRODUCTS + " TEXT, " +
                        COLUMN_PRICE + " INTEGER, " + COLUMN_CATEGORY +" TEXT);"
        );


        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Microsoft Inc.");
        cv.put(COLUMN_FOUNDERS, "Билл Гейтс, Пол Аллен");
        cv.put(COLUMN_PRODUCTS, "MS Visual Studio");
        cv.put(COLUMN_PRICE,"0");
        cv.put(COLUMN_CATEGORY,"IDE");
        db.insert(TABLE_NAME, null, cv);


        cv.put(COLUMN_NAME_CORP, "Microsoft Inc.");
        cv.put(COLUMN_FOUNDERS, "Билл Гейтс, Пол Аллен");
        cv.put(COLUMN_PRODUCTS, "MS Windows"); // +
        cv.put(COLUMN_PRICE,"21400");
        cv.put(COLUMN_CATEGORY,"OS");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Apple Inc.");
        cv.put(COLUMN_FOUNDERS, "Стив Джобс, Стив Возняк, Рональд Уэйн");
        cv.put(COLUMN_PRODUCTS, "iOS");
        cv.put(COLUMN_PRICE,"0");
        cv.put(COLUMN_CATEGORY,"OS");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Apple Inc.");
        cv.put(COLUMN_FOUNDERS, "Стив Джобс, Стив Возняк, Рональд Уэйн");
        cv.put(COLUMN_PRODUCTS, "iPhone");
        cv.put(COLUMN_PRICE,"80000");
        cv.put(COLUMN_CATEGORY,"Устройство");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Apple Inc.");
        cv.put(COLUMN_FOUNDERS, "Стив Джобс, Стив Возняк, Рональд Уэйн");
        cv.put(COLUMN_PRODUCTS, "iPad");
        cv.put(COLUMN_PRICE,"100000");
        cv.put(COLUMN_CATEGORY,"Устройство");
        db.insert(TABLE_NAME, null, cv);



        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Apple Inc.");
        cv.put(COLUMN_FOUNDERS, "Стив Джобс, Стив Возняк, Рональд Уэйн");
        cv.put(COLUMN_PRODUCTS, "MacBook");
        cv.put(COLUMN_PRICE,"120000");
        cv.put(COLUMN_CATEGORY,"Устройство");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Apple Inc.");
        cv.put(COLUMN_FOUNDERS, "Стив Джобс, Стив Возняк, Рональд Уэйн");
        cv.put(COLUMN_PRODUCTS, "iMac");
        cv.put(COLUMN_PRICE,"200000");
        cv.put(COLUMN_CATEGORY,"Устройство");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Сообщество независимых разработчиков");
        cv.put(COLUMN_FOUNDERS, "Линус Торвальдс");
        cv.put(COLUMN_PRODUCTS, "ОС Linux, Git");
        cv.put(COLUMN_PRICE,"0");
        cv.put(COLUMN_CATEGORY,"OS");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Компания ООО \"ВКонтакте\"");
        cv.put(COLUMN_FOUNDERS, "Павел Дуров");
        cv.put(COLUMN_PRODUCTS, "ВКонтакте");
        cv.put(COLUMN_PRICE,"0");
        cv.put(COLUMN_CATEGORY,"Соцсеть, мессенджер");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Компания ООО \"ВКонтакте\"");
        cv.put(COLUMN_FOUNDERS, "Павел Дуров");
        cv.put(COLUMN_PRODUCTS, "Telegram");
        cv.put(COLUMN_PRICE,"0");
        cv.put(COLUMN_CATEGORY,"Мессенджер");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Meta");
        cv.put(COLUMN_FOUNDERS, "Марк Цукерберг, Эдуардо Саверин, Дастин Московиц, Крис Хьюз");
        cv.put(COLUMN_PRODUCTS, "Facebook");
        cv.put(COLUMN_PRICE,"0");
        cv.put(COLUMN_CATEGORY,"Соцсеть, мессенджер");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Meta");
        cv.put(COLUMN_FOUNDERS, "Марк Цукерберг, Эдуардо Саверин, Дастин Московиц, Крис Хьюз");
        cv.put(COLUMN_PRODUCTS, "Instagram");
        cv.put(COLUMN_PRICE,"0");
        cv.put(COLUMN_CATEGORY,"Соцсеть");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Meta");
        cv.put(COLUMN_FOUNDERS, "Марк Цукерберг, Эдуардо Саверин, Дастин Московиц, Крис Хьюз");
        cv.put(COLUMN_PRODUCTS, "Spark AR");
        cv.put(COLUMN_PRICE,"0");
        cv.put(COLUMN_CATEGORY,"IDE, AR");
        db.insert(TABLE_NAME, null, cv);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void addCorp(String corp, String founders, String products, String price, String category){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, corp);
        cv.put(COLUMN_FOUNDERS, founders);
        cv.put(COLUMN_PRODUCTS, products);
        cv.put(COLUMN_PRICE, price);
        cv.put(COLUMN_CATEGORY, category);


        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Ошибка.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Успешно добавлено.", Toast.LENGTH_SHORT).show();
        }
    }

    public void addUser(String login, String password, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_LOGIN_USER, login);
        cv.put(COLUMN_PASSWORD_USER, password);
        cv.put(COLUMN_MAIL_USER, email);

        long result = db.insert(TABLE_NAME_USER, null, cv);
        if (result == -1){
            Toast.makeText(context, "Ошибка.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Успешно добавлено.", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor searchUser(String data){
        String query = "SELECT " + COLUMN_LOGIN_USER + " FROM " + TABLE_NAME_USER
                + " WHERE ("
                + COLUMN_LOGIN_USER + " LIKE '" + data + "')";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor searchData(String data){
        String query = "SELECT * FROM " + TABLE_NAME
                + " WHERE ("
                + COLUMN_NAME_CORP + " LIKE '%" + data + "%'"
                + " OR " + COLUMN_FOUNDERS + " LIKE '%" + data + "%'"
                + " OR " + COLUMN_PRODUCTS + " LIKE '%" + data + "%')";
        ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor searchPassword(String data){
        String query = "SELECT " + COLUMN_PASSWORD_USER + " FROM " + TABLE_NAME_USER
                + " WHERE ("
                + COLUMN_LOGIN_USER + " LIKE '" + data + "')";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor sortData(String column){
        if (column.equals("product")){
            column = COLUMN_PRODUCTS;
        }
        else if(column.equals("category")){
            column = COLUMN_CATEGORY;
        }
        String query = "SELECT * FROM " + TABLE_NAME +
                " ORDER BY " + column;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor getSumOfProducts(){
        String query = "SELECT " +
                "SUM("+COLUMN_PRICE+")" + " FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor getAvgOfProducts(){
        String query = "SELECT " +
                "AVG("+COLUMN_PRICE+")" + " FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public void updateData(String id, String name, String founders, String products, String price, String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, name);
        cv.put(COLUMN_FOUNDERS, founders);
        cv.put(COLUMN_PRODUCTS, products);
        cv.put(COLUMN_PRICE, price);
        cv.put(COLUMN_CATEGORY, category);

        long result = db.update(TABLE_NAME, cv, "id=?", new String[]{id});
        if(result == -1){
            Toast.makeText(context, "Ошибка", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Успешно добавлено!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка при удалении.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Успешно удалено.", Toast.LENGTH_SHORT).show();
        }
    }
}
