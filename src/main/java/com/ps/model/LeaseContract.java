package com.ps.model;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private float leaseFee;

    public LeaseContract(double expectedEndingValue, float leaseFee) {
        this.expectedEndingValue = vehicleSold.getPrice() / 2;
        this.leaseFee = leaseFee;
    }

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment, double expectedEndingValue, float leaseFee) {
        super(dateOfContract, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getTotalPrice(){
        return 0;
    }
    public double getMonthlyPayment(){
        return 0;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public void setLeaseFee(float leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public String toString() {
        return String.format("LEASE|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f",
                this.dateOfContract, this.customerName, this.customerEmail,
                vehicleSold.toString(), this.expectedEndingValue, this.leaseFee,
                getTotalPrice(), this.monthlyPayment);
    }
}