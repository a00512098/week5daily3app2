package com.example.week5daily3app2.model.product;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    // Everything is a String for convenience
    String name;
    String idNumber;
    String count;
    String description;
    int id;

    public Product() {
    }

    public Product(String name, String idNumber, String count, String description, int id) {
        this.name = name;
        this.idNumber = idNumber;
        this.count = count;
        this.description = description;
        this.id = id;
    }

    public Product(String name, String idNumber, String count, String description) {
        this.name = name;
        this.idNumber = idNumber;
        this.count = count;
        this.description = description;
    }

    protected Product(Parcel in) {
        name = in.readString();
        idNumber = in.readString();
        count = in.readString();
        description = in.readString();
        id = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(idNumber);
        dest.writeString(count);
        dest.writeString(description);
        dest.writeInt(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }
}
