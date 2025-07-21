package org.example;

import org.example.model.ManagementService;

import java.util.Scanner;

public class CountryCityApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ManagementService ms = new ManagementService();

        while (true) {
            displayMenu();
            System.out.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    ms.addCounty();
                    break;
                case 2:
                    ms.addCity();
                    break;
                case 3:
                    ms.listAllCountries();
                    break;
                case 4:
                    ms.listAllCities();
                    break;
                case 5:
                    ms.updateCountry();
                    break;
                case 6:
                    ms.updateCity();
                    break;
                case 7:
                    ms.deleteCountry();
                    break;
                case 8:
                    ms.deleteCity();
                    break;
                case 9:
                    ms.performCalculations();
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("\n--- Country-City Management System ---");
        System.out.println("====================================");
        System.out.println("1. Add a new Country");
        System.out.println("2. Add a new City");
        System.out.println("3. List all Countries");
        System.out.println("4. List all Cities");
        System.out.println("5. Update a Country's information");
        System.out.println("6. Update a City's information");
        System.out.println("7. Delete a Country");
        System.out.println("8. Delete a City");
        System.out.println("9. Perform Calculations");
        System.out.println("0. Exit");
        System.out.println("====================================");
    }
}

