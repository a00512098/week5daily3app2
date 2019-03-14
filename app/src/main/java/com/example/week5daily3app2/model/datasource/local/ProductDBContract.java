package com.example.week5daily3app2.model.datasource.local;

import android.util.Log;

public class ProductDBContract {
    public static final String DB_NAME = "PRODUCTS_DB";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "products";

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_NUMBER = "number";
    public static final String COL_COUNT = "count";
    public static final String COL_DESCRIPTION = "description";

    public static String createQuery() {
        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("CREATE TABLE ");
        queryBuilder.append(TABLE_NAME);
        queryBuilder.append(" ( ");
        queryBuilder.append(COL_ID);
        queryBuilder.append(" ");
        queryBuilder.append(" INT NONNULL IDENTITY PRIMARY KEY, ");
        queryBuilder.append(COL_NAME);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COL_NUMBER);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COL_COUNT);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COL_DESCRIPTION);
        queryBuilder.append(" TEXT )");

        Log.d("Log.d", "createQuery: " + queryBuilder.toString());

        return queryBuilder.toString();
    }

    public static String getAllProducts() {
        return "SELECT * FROM " + TABLE_NAME;
    }
}
