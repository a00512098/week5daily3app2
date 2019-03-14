package com.example.week5daily3app2.view;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.week5daily3app2.R;
import com.example.week5daily3app2.controller.CustomBroadcastReceiver;
import com.example.week5daily3app2.controller.RecyclerAdapter;
import com.example.week5daily3app2.model.datasource.local.ProductDBHelper;
import com.example.week5daily3app2.model.product.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CustomBroadcastReceiver customBroadcastReceiver;
    IntentFilter intentFilter;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ProductDBHelper database;
    ArrayList<Product> products;

    public static final String SEND_ACTION = "com.example.week5daily3app1.view.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter();
        intentFilter.addAction(SEND_ACTION);
        customBroadcastReceiver = new CustomBroadcastReceiver();

        products = new ArrayList<>();
        database = new ProductDBHelper(this);
        products = database.getAllProducts();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(products);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }

    private void updateList() {
        Log.d("Log.d", "Update Adapter");
        recyclerAdapter.updateList(database.getAllProducts());
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(customBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        unregisterReceiver(customBroadcastReceiver);
    }
}
