package com.example.week5daily3app2.model.datasource.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.week5daily3app2.model.product.Product;

import java.util.ArrayList;

import static com.example.week5daily3app2.model.datasource.local.ProductDBContract.COL_COUNT;
import static com.example.week5daily3app2.model.datasource.local.ProductDBContract.COL_DESCRIPTION;
import static com.example.week5daily3app2.model.datasource.local.ProductDBContract.COL_ID;
import static com.example.week5daily3app2.model.datasource.local.ProductDBContract.COL_NAME;
import static com.example.week5daily3app2.model.datasource.local.ProductDBContract.COL_NUMBER;
import static com.example.week5daily3app2.model.datasource.local.ProductDBContract.DB_NAME;
import static com.example.week5daily3app2.model.datasource.local.ProductDBContract.DB_VERSION;
import static com.example.week5daily3app2.model.datasource.local.ProductDBContract.TABLE_NAME;

public class ProductDBHelper extends SQLiteOpenHelper {
    public ProductDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ProductDBContract.createQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void insertProduct(@NonNull Product product) {
        SQLiteDatabase writableDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_NAME, product.getName());
        contentValues.put(COL_COUNT, product.getCount());
        contentValues.put(COL_DESCRIPTION, product.getDescription());
        contentValues.put(COL_NUMBER, product.getIdNumber());

        writableDB.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        SQLiteDatabase readableDB = getReadableDatabase();

        Cursor cursor = readableDB.rawQuery(ProductDBContract.getAllProducts(), null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
                String count = cursor.getString(cursor.getColumnIndex(COL_COUNT));
                String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                String number = cursor.getString(cursor.getColumnIndex(COL_NUMBER));

                products.add(new Product(name, number, count, description, id));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return products;
    }
}
