package com.ps.data;

import com.ps.model.Vehicle;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAOInt {
    private DataSource dataSource;

    public VehicleDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Vehicle> byPriceRange(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE price BETWEEN ? and ?;";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
            ) {

            preparedStatement.setDouble(1, min);
            preparedStatement.setDouble(2, max);

            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
                ) {
                while (resultSet.next()) {
                    Vehicle vehicle = mapVehicle(resultSet);
                    vehicles.add(vehicle);
                }
            }
        return vehicles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vehicle> byMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE make LIKE ? AND model LIKE ?;";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {

            preparedStatement.setString(1, make);
            preparedStatement.setString(2, model);

            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    Vehicle vehicle = mapVehicle(resultSet);
                    vehicles.add(vehicle);
                }
            }
            return vehicles;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vehicle> byColor(String color) {
        return null;
    }

    @Override
    public List<Vehicle> byYear(int year) {
        return null;
    }

    @Override
    public List<Vehicle> byMileageRange(int min, int max) {
        return null;
    }

    @Override
    public List<Vehicle> byType(String type) {
        return null;
    }

    private Vehicle mapVehicle(ResultSet resultSet) throws SQLException {
        String vin = resultSet.getString("vin");
        int year = resultSet.getInt("year");
        String make = resultSet.getString("make");
        String model = resultSet.getString("model");
        String type = resultSet.getString("type");
        String color = resultSet.getString("color");
        boolean sold = resultSet.getBoolean("sold");
        int odometer = resultSet.getInt("odometer");
        double price = resultSet.getDouble("price");
        int dealershipId = resultSet.getInt("dealership_id");

        return new Vehicle(vin,year,make,model,type,color,sold,odometer,price,dealershipId);
    }
}
