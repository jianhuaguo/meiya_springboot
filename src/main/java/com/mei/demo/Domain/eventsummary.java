package com.mei.demo.Domain;

import java.util.Date;

public class eventsummary {

    String name;
    int foodcount;
    int storecount;
    Date start_time;
    Date end_time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoodcount() {
        return foodcount;
    }

    public void setFoodcount(int foodcount) {
        this.foodcount = foodcount;
    }

    public int getStorecount() {
        return storecount;
    }

    public void setStorecount(int storecount) {
        this.storecount = storecount;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}
