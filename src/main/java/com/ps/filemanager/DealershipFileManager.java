package com.ps.filemanager;

import com.ps.model.*;

import java.io.*;
import java.util.List;

public class DealershipFileManager {
    public static Dealership getDealership() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
            String dealershipInfo = bufferedReader.readLine();
            String input;
            // Getting dealership info
            String[] dealershipInfoDetails = dealershipInfo.split("\\|");
            String name = dealershipInfoDetails[0];
            String address = dealershipInfoDetails[1];
            String phone = dealershipInfoDetails[2];
            Dealership dealership = new Dealership(name,address,phone);

            // Getting inventory
            while((input = bufferedReader.readLine()) != null) {
                String[] vehicleInfo = input.split("\\|");
                Vehicle vehicle = createVehicle(vehicleInfo);
                dealership.addVehicle(vehicle);
            }
            bufferedReader.close();
            return dealership;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Vehicle createVehicle(String[] vehicleInfo) { // Factory method made in case we wanted to add different vehicle types in the future, can implement switch statement
        int vin = Integer.parseInt(vehicleInfo[0]);
        int year = Integer.parseInt(vehicleInfo[1]);
        String make = vehicleInfo[2];
        String model = vehicleInfo[3];
        String vehicleType = vehicleInfo[4];
        String color = vehicleInfo[5];
        int odometer = Integer.parseInt(vehicleInfo[6]);
        double price = Double.parseDouble(vehicleInfo[7]);
        // Switch can go here for handling motorcycles, RVs, boats, etc.

        return new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
    }


    public static void saveDealership(Dealership dealership) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inventory.csv",true));

            String firstLine = String.format("%s|%s|%s", dealership.getName(), dealership.getAddress(), dealership.getPhone());
            List<Vehicle> vehicles = dealership.getAllVehicles();
            for(Vehicle vehicle: vehicles){
                String vehicleLine = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice()
                );
                bufferedWriter.write(vehicleLine);
            }
            bufferedWriter.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}