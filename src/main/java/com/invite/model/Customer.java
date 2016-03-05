package com.invite.model;


/**
 * Created by Amit
 */
public class Customer implements Comparable<Customer>{
    private long userId;
    private String name;
    private double latitude;
    private double longitude;

    public Customer(long userId, String name, double latitude, double longitude) {
        this.userId = userId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return name + ", "+ userId;
    }

    @Override
    public int compareTo(Customer customer) {
        return (int) (this.getUserId() - customer.getUserId());
    }
}
