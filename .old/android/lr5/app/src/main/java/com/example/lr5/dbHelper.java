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

    dbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME_CORP + " TEXT, " + COLUMN_FOUNDERS + " TEXT, " + COLUMN_PRODUCTS + " TEXT);"
        );


        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Microsoft Inc.");
        cv.put(COLUMN_FOUNDERS, "Билл Гейтс, Пол Аллен");
        cv.put(COLUMN_PRODUCTS, "MS Visual Studio, MS SQL Server, MS Windows");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Apple Inc.");
        cv.put(COLUMN_FOUNDERS, "Стив Джобс, Стив Возняк, Рональд Уэйн");
        cv.put(COLUMN_PRODUCTS, "iOS, iPhone, iPad, iPod, MacOS, MacBook, iMac");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Сообщество независимых разработчиков");
        cv.put(COLUMN_FOUNDERS, "Линус Торвальдс");
        cv.put(COLUMN_PRODUCTS, "ОС Linux, Git");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Компания ООО \"ВКонтакте\"");
        cv.put(COLUMN_FOUNDERS, "Павел Дуров");
        cv.put(COLUMN_PRODUCTS, "ВКонтакте, Telegram");
        db.insert(TABLE_NAME, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Meta");
        cv.put(COLUMN_FOUNDERS, "Марк Цукерберг, Эдуардо Саверин, Дастин Московиц, Крис Хьюз");
        cv.put(COLUMN_PRODUCTS, "Facebook, Instagram, WhatsApp, Spark AR, Messenger");
        db.insert(TABLE_NAME, null, cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void addCorp(String corp, String founders, String products){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, corp);
        cv.put(COLUMN_FOUNDERS, founders);
        cv.put(COLUMN_PRODUCTS, products);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Ошибка.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Успешно добавлено.", Toast.LENGTH_SHORT).show();
        }
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

    public void updateData(String id, String name, String founders, String products) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, name);
        cv.put(COLUMN_FOUNDERS, founders);
        cv.put(COLUMN_PRODUCTS, products);

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
