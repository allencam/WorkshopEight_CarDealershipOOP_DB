package com.ps.data;

import com.ps.model.Vehicle;

import java.util.List;

public interface VehicleDAOInt {

    public List<Vehicle> byPriceRange(double min, double max);
    public List<Vehicle> byMakeModel(String make, String model);
    public List<Vehicle> byColor(String color);
    public List<Vehicle> byYear(int year);
    public List<Vehicle> byMileageRange(int min, int max);
    public List<Vehicle> byType(String type);

}
