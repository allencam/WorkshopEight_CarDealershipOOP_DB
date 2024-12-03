package com.ps.model;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;
    private ArrayList<Contract> contractList;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
        this.contractList = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();
        if(max == 0) { // if no max just get vehicles > min
            for(Vehicle vehicle : inventory) {
                if(vehicle.getPrice() >= min) {
                    vehicles.add(vehicle);
                }
            }
        } else {
            for(Vehicle vehicle : inventory) {
                if(vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                    vehicles.add(vehicle);
                }
            }
        }
        return vehicles;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        if(model.isEmpty()) {
            for(Vehicle vehicle : inventory) {
                if(vehicle.getMake().toLowerCase().contains(make)) {
                    vehicles.add(vehicle);
                }
            }
        } else {
            for(Vehicle vehicle : inventory) {
                if(vehicle.getMake().toLowerCase().contains(make) && vehicle.getModel().toLowerCase().contains(model)) {
                    vehicles.add(vehicle);
                }
            }
        }

        return vehicles;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory) {
            if(vehicle.getYear() >= min && vehicle.getYear() <= max) {
                inventory.add(vehicle);
            }
        }
        return vehicles;
    }
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : inventory) {
            if(vehicle.getColor().toLowerCase().contains(color)) {
                inventory.add(vehicle);
            }
        }
        return vehicles;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return null;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return null;
    }
    public List<Vehicle> getAllVehicles() {
        return this.inventory;
    }
    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}