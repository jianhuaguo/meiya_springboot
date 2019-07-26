package com.mei.demo.Domain;

public class storesummary {
    int store_id;
    String storename;
    String storephone;
    int ordercount;
    double ordersum;
    int usercount;

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getStorephone() {
        return storephone;
    }

    public void setStorephone(String storephone) {
        this.storephone = storephone;
    }

    public int getOrdercount() {
        return ordercount;
    }

    public void setOrdercount(int ordercount) {
        this.ordercount = ordercount;
    }

    public double getOrdersum() {
        return ordersum;
    }

    public void setOrdersum(double ordersum) {
        this.ordersum = ordersum;
    }

    public int getUsercount() {
        return usercount;
    }

    public void setUsercount(int usercount) {
        this.usercount = usercount;
    }
}
