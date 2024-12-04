package com.ps.application;

import com.ps.data.VehicleDAOImpl;
import com.ps.model.*;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static BasicDataSource basicDataSource = new BasicDataSource();
    private static VehicleDAOImpl vehicleDAOImpl = new VehicleDAOImpl(basicDataSource);

    private static Scanner commandScan = new Scanner(System.in);
    private static Scanner inputScan = new Scanner(System.in);
    private static Dealership dealership; // Declaration, still need to initialize (name, address, phone)

    private static void init(){
    }

    public static void display(String username, String password) {
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/dealership_db");
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        init();
        // Load the menu
        int mainMenuCommand;
        do {
            System.out.println("""
                    Make a selection:
                    SEARCH BY:
                    (1) Price Range
                    (2) Make/Model
                    (3) Year
                    (4) Color
                    (5) Mileage
                    (6) Vehicle Type
                    
                    OTHER OPTIONS:
                    (7) Display All Vehicles
                    (8) Add a Vehicle
                    (9) Remove a Vehicle
                    
                    (0) Exit
                    """);
            System.out.print("Your selection: ");
            mainMenuCommand = commandScan.nextInt();

            switch (mainMenuCommand) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;

                default:
                    System.out.println("Invalid input, try again.");
            }
        } while (mainMenuCommand != 0);
    }

    private static void processGetByPriceRequest() {
        double min;
        double max;
        boolean validInput = false;
        List<Vehicle> inventory;

        do {
            System.out.print("Enter minimum and maximum values to search by (xxxx.xx - xxxx.xx): ");
            String userInputMinMax = inputScan.nextLine();

            String[] values = userInputMinMax.trim().split("-",2);
            min = Double.parseDouble(values[0]);
            max = Double.parseDouble(values[1]);

            if (min < max) {
                validInput = true;
            } else {
                System.out.println("Invalid entry, try again.");
            }
        } while (!validInput);

        inventory = vehicleDAOImpl.byPriceRange(min,max);
        printFormattedTable(inventory);
    }

    private static void processGetByMakeModelRequest() {
        List<Vehicle> inventory;

        System.out.println("Enter make and model separated by a space: ");
        String inputMakeModel = inputScan.nextLine();

        String[] makeModel = inputMakeModel.split(" ",2);
        String make = String.format("%s%%", makeModel[0]);
        String model = String.format("%s%%", makeModel[1]);

        inventory = vehicleDAOImpl.byMakeModel(make, model);
        printFormattedTable(inventory);
    }

    private static void processGetByYearRequest() {
        System.out.println("Enter starting year: ");
        int minYear = inputScan.nextInt();
        System.out.println("Enter ending year: ");
        int maxYear = inputScan.nextInt();

    }

    private static void processGetByColorRequest() {
        System.out.println("Enter a color: ");
        String color = inputScan.nextLine().toLowerCase();

    }

    private static void processGetByMileageRequest() {

    }

    private static void processGetByVehicleTypeRequest() {

    }

    public static void processGetAllVehiclesRequest() {

    }

    private static void processAddVehicleRequest() {

    }

    private static void processRemoveVehicleRequest() {

    }

    private static void printFormattedTable(List<Vehicle> inventory) {
        System.out.print("""
                YEAR   MAKE          MODEL           COLOR        ODOMETER  PRICE     SOLD?
                ----- ------------- --------------- ------------- -------- ---------- ------
                """);

        for (Vehicle vehicle : inventory) {
            System.out.printf("%-6d %-13s %-15s %-13s %-8d $%-9.2f %-6s%n",
                    vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getColor(),
                    vehicle.getOdometer(), vehicle.getPrice(), vehicle.isSold() ? "Yes" : "No");
        }
    } // Helper method for iterating through Lists and displaying search results in a consistent format

}