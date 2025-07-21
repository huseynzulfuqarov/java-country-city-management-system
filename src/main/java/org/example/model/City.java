package org.example.model;

public class City {
    private static int nextId = 1;
    private final int id;
    private String name;
    private long population;
    private boolean isCapital;
    private double area;
    private Country country;

    public City(String name, long population, boolean isCapital, double area, Country country) {
        this.id = nextId++;
        this.name = name;
        this.population = population;
        this.isCapital = isCapital;
        this.area = area;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public double calculateGrowthRate(double previousPop, int years) {
        if (years <= 0 || previousPop <= 0) return 0.0;
        double growth = (this.getPopulation() - previousPop) / previousPop;
        return (growth / years) * 100;
    }

    public double calculateGrowthRate(double previousPop, int years, double migrationEffect) {
        return calculateGrowthRate(previousPop, years) + migrationEffect;
    }

    public double calculateTourismGrowth(double prevRevenue, int years) {
        return 0.0;
    }

    public double calculateProductionGrowth(double prevVolume, int years) {
        return 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Population: " + population +
                " | IsCapital: " + isCapital +
                " | Area: " + area +
                " | Country: " + country.getName();
    }
}
