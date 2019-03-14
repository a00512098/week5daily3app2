package com.example.week5daily3app2.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.week5daily3app2.model.datasource.local.ProductDBHelper;
import com.example.week5daily3app2.model.product.Product;

public class CustomBroadcastReceiver extends BroadcastReceiver {
    private ProductDBHelper database;
    private static final String PRODUCT_KEY = "PRODUCT_KEY";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
//                Product product = bundle.getParcelable(PRODUCT_KEY);
//                if (product != null) {
//                    Log.d("Log.d", "Object Received");
//                    database = new ProductDBHelper(context);
//                    database.insertProduct(product);
//                }
                Product product = new Product();
                product.setName(bundle.getString("name"));
                product.setIdNumber(bundle.getString("number"));
                product.setCount(bundle.getString("count"));
                product.setDescription(bundle.getString("description"));
                Log.d("Log.d", "Object Received");
                database = new ProductDBHelper(context);
                database.insertProduct(product);
            }
        }
    }
}
