package org.example.model.city;

import org.example.model.City;
import org.example.model.Country;

public class TouristCity extends City {
    private int annualVisitors;
    private String mainAttraction;
    private double annualTourismRevenue;

    public TouristCity(String name, long population, boolean isCapital, double area, Country country, int annualVisitors, String mainAttraction, double annualTourismRevenue) {
        super(name, population, isCapital, area, country);
        this.annualVisitors = annualVisitors;
        this.mainAttraction = mainAttraction;
        this.annualTourismRevenue = annualTourismRevenue;
    }

    public int getAnnualVisitors() {
        return annualVisitors;
    }

    public void setAnnualVisitors(int annualVisitors) {
        this.annualVisitors = annualVisitors;
    }

    public String getMainAttraction() {
        return mainAttraction;
    }

    public void setMainAttraction(String mainAttraction) {
        this.mainAttraction = mainAttraction;
    }

    public double getAnnualTourismRevenue() {
        return annualTourismRevenue;
    }

    public void setAnnualTourismRevenue(double annualTourismRevenue) {
        this.annualTourismRevenue = annualTourismRevenue;
    }

    @Override
    public double calculateTourismGrowth(double prevRevenue, int years) {
        if (years <= 0 || prevRevenue <= 0) return 0.0;
        double growth = (this.getAnnualTourismRevenue() - prevRevenue) / prevRevenue;
        return (growth / years) * 100;
    }

    @Override
    public String toString() {
        return "TouristCity -> " + super.toString() +
                " | Annual Visitors: " + annualVisitors +
                " | Main Attraction: " + mainAttraction +
                " | Annual Tourism Revenue: " + annualTourismRevenue;
    }
}

