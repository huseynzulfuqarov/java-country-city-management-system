package org.example.model;

import org.example.model.city.CapitalCity;
import org.example.model.city.IndustrialCity;
import org.example.model.city.TouristCity;
import org.example.model.country.AfricanCountry;
import org.example.model.country.AsianCountry;
import org.example.model.country.EuropeanCountry;
import java.util.Scanner;

public class ManagementService {
    private Scanner sc = new Scanner(System.in);
    private Country[] allCountry = new Country[20];
    private int countryCount;
    private City[] allCities = new City[60];
    private int cityCount;

    public ManagementService() {
    }

    public void addCounty() {
        if (countryCount == 20) {
            System.out.println("Error: Maximum number of countries reached. Please delete a country to add a new one.");
            return;
        }
        System.out.printf("You selected 'Add Country'. Please provide the following information.\n");
        System.out.println("What is the country's name?");
        String name = sc.nextLine();
        for (int i = 0; i < countryCount; i++) {
            if (allCountry[i].getName().equalsIgnoreCase(name)) {
                System.out.println("This country already exists!");
                return;
            }
        }
        System.out.println("Which continent is it on?");
        String continent = sc.nextLine();
        System.out.println("Enter the population:");
        long population = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter the country code:");
        String code = sc.nextLine();
        System.out.println("Select the type of country:");
        System.out.println("""
                1. African Country
                2. Asian Country
                3. European Country
                """);

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1: {
                System.out.println("You have selected African Country.");
                System.out.println("Please provide the following additional details.");
                System.out.println("What is the main language?");
                String mainLanguage = sc.nextLine();
                System.out.println("Is it a developing country? (y/n)");
                String c = sc.nextLine();
                boolean isDeveloping = c.equalsIgnoreCase("y") ? true : false;
                System.out.println("What is the currency?");
                String currency = sc.nextLine();
                AfricanCountry obj = new AfricanCountry(name, continent, population, code, mainLanguage, isDeveloping, currency);
                allCountry[countryCount] = obj;
                countryCount++;
                System.out.println("Country added successfully.");
                break;
            }
            case 2: {
                System.out.println("You have selected Asian Country.");
                System.out.println("Please provide the following additional details.");
                System.out.println("What is the GDP per capita?");
                double gdpPerCapita = sc.nextDouble();
                sc.nextLine();
                System.out.println("Does it have nuclear power? (y/n)");
                String c = sc.nextLine();
                boolean hasNuclearPower = c.equalsIgnoreCase("y") ? true : false;
                System.out.println("What is the main religion?");
                String mainReligion = sc.nextLine();
                AsianCountry obj = new AsianCountry(name, continent, population, code, gdpPerCapita, hasNuclearPower, mainReligion);
                allCountry[countryCount] = obj;
                countryCount++;
                System.out.println("Country added successfully.");
                break;
            }
            case 3: {
                System.out.println("You have selected European Country.");
                System.out.println("Please provide the following additional details.");
                System.out.println("Is it in the European Union? (y/n)");
                String c = sc.nextLine();
                boolean isInEuropeanUnion = c.equalsIgnoreCase("y") ? true : false;
                System.out.println("What is the main export?");
                String mainExport = sc.nextLine();
                System.out.println("What is the founding year?");
                int foundingYear = sc.nextInt();
                sc.nextLine();
                EuropeanCountry obj = new EuropeanCountry(name, continent, population, code, isInEuropeanUnion, mainExport, foundingYear);
                allCountry[countryCount] = obj;
                countryCount++;
                System.out.println("Country added successfully.");
                break;
            }
        }
    }

    public void addCity() {
        if (cityCount == 60) {
            System.out.println("Error: Maximum number of cities reached. Please delete a city to add a new one.");
            return;
        }
        System.out.printf("You selected 'Add City'. Please provide the following information.\n");
        System.out.println("Which country does this city belong to?");
        String countryName = sc.nextLine();
        Country foundCountry = null;
        for (int i = 0; i < countryCount; i++) {
            if (allCountry[i].getName().equalsIgnoreCase(countryName)) {
                foundCountry = allCountry[i];
                break;
            }
        }
        if (foundCountry == null) {
            System.out.println("This country does not exist in the system. Please add the country first.");
            return;
        }
        if (foundCountry.getCityCount() == 10) {
            System.out.println("Error: The city limit for this country is full. Cannot add new city.");
            return;
        }

        System.out.println("Enter the city's name:");
        String name = sc.nextLine();
        for (int i = 0; i < cityCount; i++) {
            if (name.equalsIgnoreCase(allCities[i].getName())) {
                System.out.println("This city already exists in the system.");
                return;
            }
        }

        System.out.println("Enter the population:");
        long population = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter the area of the city (in km2):");
        double area = sc.nextDouble();
        sc.nextLine();
        System.out.println("What type of city do you want to add?");
        System.out.println("""
                1. Capital City
                2. Tourist City
                3. Industrial City
                4. Simple City
                """);

        int choice = sc.nextInt();
        sc.nextLine();
        boolean isCapital = false;
        switch (choice) {
            case 1: {
                isCapital = true;
                System.out.println("You have selected Capital City.");
                System.out.println("Please provide the following additional details.");
                System.out.println("What is the government type?");
                String governmentType = sc.nextLine();
                System.out.println("Enter the number of parliament members:");
                int parliamentMembers = sc.nextInt();
                sc.nextLine();
                System.out.println("What is the mayor's name?");
                String mayorName = sc.nextLine();
                CapitalCity obj = new CapitalCity(name, population, isCapital, area, foundCountry, governmentType, parliamentMembers, mayorName);
                allCities[cityCount] = obj;
                cityCount++;
                boolean isAddedToCountry = foundCountry.addCity(obj);
                System.out.println("City added successfully.");
                break;
            }
            case 2: {
                System.out.println("You have selected Tourist City.");
                System.out.println("Please provide the following additional details.");
                System.out.println("Enter the number of annual visitors:");
                int annualVisitors = sc.nextInt();
                sc.nextLine();
                System.out.println("What is the main attraction?");
                String mainAttraction = sc.nextLine();
                System.out.println("What is the annual tourism revenue?");
                double annualTourismRevenue = sc.nextDouble();
                sc.nextLine();
                TouristCity obj = new TouristCity(name, population, isCapital, area, foundCountry, annualVisitors, mainAttraction, annualTourismRevenue);
                allCities[cityCount] = obj;
                cityCount++;
                boolean isAddedToCountry = foundCountry.addCity(obj);
                System.out.println("City added successfully.");

            }
            case 3: {
                System.out.println("You have selected Industrial City.");
                System.out.println("Please provide the following additional details.");
                System.out.println("Enter the number of factories:");
                int numberOfFactories = sc.nextInt();
                sc.nextLine();
                System.out.println("What is the main industry?");
                String mainIndustry = sc.nextLine();
                System.out.println("What is the annual production volume?");
                double annualProductionVolume = sc.nextDouble();
                sc.nextLine();
                IndustrialCity obj = new IndustrialCity(name, population, isCapital, area, foundCountry, numberOfFactories, mainIndustry, annualProductionVolume);
                allCities[cityCount] = obj;
                cityCount++;
                boolean isAddedToCountry = foundCountry.addCity(obj);
                System.out.println("City added successfully.");
                break;
            }
            case 4: {
                City obj = new City(name, population, isCapital, area, foundCountry);
                allCities[cityCount] = obj;
                cityCount++;
                System.out.println("City added successfully.");
                boolean isAddedToCountry = foundCountry.addCity(obj);
                break;
            }
        }
    }

    public void deleteCity() {
        System.out.println("Enter the name of the city to delete:");
        String cityName = sc.nextLine();
        int indexToDelete = -1;
        for (int i = 0; i < cityCount; i++) {
            if (allCities[i].getName().equalsIgnoreCase(cityName)) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete == -1) {
            System.out.println("City not found.");
            return;
        }
        Country country = allCities[indexToDelete].getCountry();
        country.removeCityByName(cityName);
        for (int i = indexToDelete; i < cityCount - 1; i++) {
            allCities[i] = allCities[i + 1];
        }
        cityCount--;
        allCities[cityCount] = null;

        System.out.println("City deleted successfully.");
    }

    public void deleteCountry() {
        System.out.println("Enter the name of the country to delete:");
        String countryName = sc.nextLine();
        int indexToDelete = -1;

        for (int i = 0; i < countryCount; i++) {
            if (allCountry[i].getName().equalsIgnoreCase(countryName)) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete == -1) {
            System.out.println("Country not found.");
            return;
        }

        Country country = allCountry[indexToDelete];
        City[] cities = new City[60];
        int index = 0;
        if (country.getCityCount() != 0) {
            System.out.println("Are you sure? All cities related to this country will also be deleted. (y/n)");
            String answer = sc.next();
            sc.nextLine();
            if (answer.equalsIgnoreCase("y")) {

                for (int i = 0; i < cityCount; i++) {
                    if (!allCities[i].getCountry().getName().equalsIgnoreCase(country.getName())) {
                        cities[index] = allCities[i];
                        index++;
                    }
                }
                allCities = cities;
                cityCount = index;
            } else {
                System.out.println("Operation cancelled.");
                return;
            }
        }

        for (int i = indexToDelete; i < countryCount - 1; i++) {
            allCountry[i] = allCountry[i + 1];
        }
        countryCount--;
        allCountry[countryCount] = null;

        System.out.println("Country and all its cities have been deleted.");

    }

    public void updateCountry() {
        int indexToUpdate = -1;
        System.out.println("Enter the name of the country to update:");
        String countryName = sc.nextLine();
        for (int i = 0; i < countryCount; i++) {
            if (countryName.equalsIgnoreCase(allCountry[i].getName())) {
                indexToUpdate = i;
                break;
            }
        }
        if (indexToUpdate == -1) {
            System.out.println("Country not found.");
            return;
        }
        System.out.println("Current country details:");
        System.out.println(allCountry[indexToUpdate].toString());
        Country obj = allCountry[indexToUpdate];
        System.out.println("Enter the new information for the country.");
        System.out.print("Enter new name: ");
        obj.setName(sc.nextLine());
        System.out.print("Enter new continent: ");
        obj.setContinent(sc.nextLine());
        System.out.print("Enter new population: ");
        obj.setPopulation(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter new code: ");
        obj.setCode(sc.nextLine());
        if (obj instanceof AfricanCountry) {
            AfricanCountry african = (AfricanCountry) obj;
            System.out.println("Enter new main language: ");
            african.setMainLanguage(sc.nextLine());
            System.out.println("Is it a developing country? (y/n)");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                african.setDeveloping(true);
            } else {
                african.setDeveloping(false);
            }
            System.out.println("Enter new currency: ");
            african.setCurrency(sc.nextLine());
        } else if (obj instanceof AsianCountry) {
            AsianCountry asian = (AsianCountry) obj;
            System.out.println("Enter new GDP per capita:");
            asian.setGdpPerCapita(sc.nextDouble());
            sc.nextLine();
            System.out.println("Does it have nuclear power? (y/n)");
            String answer = sc.next();
            sc.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                asian.setHasNuclearPower(true);
            } else {
                asian.setHasNuclearPower(false);
            }
            System.out.println("Enter new main religion:");
            asian.setMainReligion(sc.nextLine());
        } else if (obj instanceof EuropeanCountry) {
            EuropeanCountry european = (EuropeanCountry) obj;
            System.out.println("Is it in the EU? (y/n)");
            String answer = sc.next();
            sc.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                european.setInEuropeanUnion(true);
            } else {
                european.setInEuropeanUnion(false);
            }
            System.out.println("Enter new main export:");
            european.setMainExport(sc.nextLine());
            System.out.println("Enter new founding year:");
            european.setFoundingYear(sc.nextInt());
            sc.nextLine();
        }
        System.out.println("Country updated successfully.");
    }

    public void updateCity() {
        System.out.println("Enter the name of the city to update:");
        String cityName = sc.nextLine();
        int indexToUpdate = -1;
        for (int i = 0; i < cityCount; i++) {
            if (cityName.equalsIgnoreCase(allCities[i].getName())) {
                indexToUpdate = i;
            }
        }
        if (indexToUpdate == -1) {
            System.out.println("City not found.");
            return;
        }
        System.out.println("Current city details:");
        System.out.println(allCities[indexToUpdate].toString());
        City obj = allCities[indexToUpdate];
        System.out.println("Enter the new information for the city.");
        System.out.print("Enter new name: ");
        obj.setName(sc.nextLine());
        System.out.print("Enter new population: ");
        obj.setPopulation(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter new area: ");
        obj.setArea(sc.nextDouble());
        sc.nextLine();
        if (obj instanceof CapitalCity) {
            CapitalCity capital = (CapitalCity) obj;
            System.out.println("Enter new government type:");
            capital.setGovernmentType(sc.nextLine());
            System.out.println("Enter new number of parliament members:");
            capital.setParliamentMembers(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter new mayor's name:");
            capital.setMayorName(sc.nextLine());
        } else if (obj instanceof TouristCity) {
            TouristCity tourist = (TouristCity) obj;
            System.out.println("Enter new number of annual visitors:");
            tourist.setAnnualVisitors(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter new main attraction:");
            tourist.setMainAttraction(sc.nextLine());
            System.out.println("Enter new annual tourism revenue:");
            tourist.setAnnualTourismRevenue(sc.nextInt());
            sc.nextLine();
        } else if (obj instanceof IndustrialCity) {
            IndustrialCity industrial = (IndustrialCity) obj;
            System.out.println("Enter the updated number of factories:");
            industrial.setNumberOfFactories(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter new main industry:");
            industrial.setMainIndustry(sc.nextLine());
            System.out.println("Enter new annual production volume:");
            industrial.setAnnualProductionVolume(sc.nextDouble());
            sc.nextLine();
        }
        System.out.println("City updated successfully.");
    }

    public void listAllCities() {
        if (cityCount == 0) {
            System.out.println("No cities found in the system.");
            return;
        }
        boolean flag = false;
        System.out.println("--- Capital Cities ---");
        for (int i = 0; i < cityCount; i++) {
            if (allCities[i] instanceof CapitalCity) {
                System.out.println(allCities[i].toString());
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("No capital cities found.");
        }

        flag = false;
        System.out.println("--- Tourist Cities ---");
        for (int i = 0; i < cityCount; i++) {
            if (allCities[i] instanceof TouristCity) {
                System.out.println(allCities[i].toString());
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("No tourist cities found.");
        }

        flag = false;
        System.out.println("--- Industrial Cities ---");
        for (int i = 0; i < cityCount; i++) {
            if (allCities[i] instanceof IndustrialCity) {
                System.out.println(allCities[i].toString());
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("No industrial cities found.");
        }

        flag = false;
        System.out.println("--- Simple Cities ---");
        for (int i = 0; i < cityCount; i++) {
            if (!(allCities[i] instanceof CapitalCity) &&
                    !(allCities[i] instanceof TouristCity) &&
                    !(allCities[i] instanceof IndustrialCity)) {
                System.out.println(allCities[i].toString());
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("No simple cities found.");
        }
    }

    public void listAllCountries() {
        if (countryCount == 0) {
            System.out.println("No countries found in the system.");
            return;
        }
        boolean flag = false;
        System.out.println("--- African Country ---");
        for (int i = 0; i < countryCount; i++) {
            if (allCountry[i] instanceof AfricanCountry) {
                System.out.println(allCountry[i].toString());
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("No African countries found.");
        }

        flag = false;
        System.out.println("--- Asian Country ---");
        for (int i = 0; i < countryCount; i++) {
            if (allCountry[i] instanceof AsianCountry) {
                System.out.println(allCountry[i].toString());
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("No Asian countries found.");
        }

        flag = false;
        System.out.println("--- European Countries ---");
        for (int i = 0; i < countryCount; i++) {
            if (allCountry[i] instanceof EuropeanCountry) {
                System.out.println(allCountry[i].toString());
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("No European countries found.");
        }
    }

    public void performCalculations() {
        if (cityCount == 0) {
            System.out.println("No cities found in the system.");
            return;
        }
        System.out.println("Enter the name of the city: ");
        String cityName = sc.nextLine();
        City city = null;
        for (int i = 0; i < cityCount; i++) {
            if (allCities[i].getName().equalsIgnoreCase(cityName)) {
                city = allCities[i];
                break;
            }
        }
        if (city == null) {
            System.out.println("City not found.");
            return;
        }

        System.out.println("\nSelect a calculation:");
        System.out.println("1. Calculate Population Growth Rate");
        System.out.println("2. Calculate Population Growth Rate (with migration effect)");
        if (city instanceof TouristCity) {
            System.out.println("3. Calculate Tourism Growth");
        } else if (city instanceof IndustrialCity) {
            System.out.println("3. Calculate Production Growth");
        }
        System.out.println("0. Back to Main Menu");
        System.out.print("Select an option: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1: {
                System.out.print("Enter the previous population: ");
                double prevPop = sc.nextDouble();
                System.out.print("Enter the number of years: ");
                int years = sc.nextInt();
                sc.nextLine();
                double growthRate = city.calculateGrowthRate(prevPop, years);
                System.out.printf("The average annual population growth rate is: %.2f\n", growthRate);
                break;
            }
            case 2: {
                System.out.print("Enter the previous population: ");
                double prevPop = sc.nextDouble();
                System.out.print("Enter the number of years: ");
                int years = sc.nextInt();
                System.out.print("Enter the annual migration effect (as a percentage like 0.3): ");
                double migrationEffect = sc.nextDouble();
                sc.nextLine();

                double growthRate = city.calculateGrowthRate(prevPop, years, migrationEffect);
                System.out.printf("The average annual population growth rate (with migration) is: %.2f\n", growthRate);
                break;
            }
            case 3: {
                if (city instanceof TouristCity) {
                    TouristCity touristCity = (TouristCity) city;
                    System.out.print("Enter the previous annual tourism revenue: ");
                    double prevRevenue = sc.nextDouble();
                    System.out.print("Enter the number of years: ");
                    int years = sc.nextInt();
                    sc.nextLine();

                    double tourismGrowth = touristCity.calculateTourismGrowth(prevRevenue, years);
                    System.out.printf("The average annual tourism growth is: %.2f\n", tourismGrowth);
                } else if (city instanceof IndustrialCity) {
                    IndustrialCity industrialCity = (IndustrialCity) city;
                    System.out.print("Enter the previous annual production volume: ");
                    double prevVolume = sc.nextDouble();
                    System.out.print("Enter the number of years: ");
                    int years = sc.nextInt();
                    sc.nextLine();
                    double productionGrowth = industrialCity.calculateProductionGrowth(prevVolume, years);
                    System.out.printf("The average annual production growth is: %.2f\n", productionGrowth);
                } else {
                    System.out.println("Invalid option for this type of city."); // When the user enters 3, which is not among the available options(f.e simple city)
                }
                break;
            }
            case 0:
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }
}
