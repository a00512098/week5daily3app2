package com.example.week5daily3app2.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week5daily3app2.R;
import com.example.week5daily3app2.model.product.Product;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    ArrayList<Product> products;

    public RecyclerAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_product, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Product product = products.get(i);
        Context context = viewHolder.itemView.getContext();
        String name = context.getResources().getString(R.string.name_s);
        String number = context.getResources().getString(R.string.number_s);
        String count = context.getResources().getString(R.string.count_s);

        viewHolder.productName.setText(String.format(name, product.getName()));
        viewHolder.productNumber.setText(String.format(number, product.getIdNumber()));
        viewHolder.productCount.setText(String.format(count, product.getCount()));

        if (viewHolder.productDescription != null) {
            String description = context.getResources().getString(R.string.description_s);
            viewHolder.productDescription.setText(String.format(description, product.getDescription()));
        }

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName, productNumber, productCount, productDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productNumber = itemView.findViewById(R.id.productNumber);
            productCount = itemView.findViewById(R.id.productCount);
            productDescription = itemView.findViewById(R.id.productDescription);
        }
    }

    public void updateList(ArrayList<Product> updatedProducts) {
        products = updatedProducts;
        notifyDataSetChanged();
    }
}
