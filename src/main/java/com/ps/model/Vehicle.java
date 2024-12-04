package com.ps.model;

public class Vehicle {
    private String vin;
    private int year;
    private String make;
    private String model;
    private String type; // Car, truck, SUV, etc.
    private String color;
    private boolean sold;
    private int odometer;
    private double price;
    private int dealershipId;

    public Vehicle() {}

    public Vehicle(String vin, int year, String make, String model, String type, String color, boolean sold, int odometer, double price, int dealershipId) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.sold = sold;
        this.odometer = odometer;
        this.price = price;
        this.dealershipId = dealershipId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public int getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(int dealershipId) {
        this.dealershipId = dealershipId;
    }

    @Override
    public String toString() {

        return String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                vin,
                year,
                make,
                model,
                type,
                color,
                odometer,
                price
        );
    }
}