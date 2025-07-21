package org.example.model.city;

import org.example.model.City;
import org.example.model.Country;

public class IndustrialCity extends City {
    private int numberOfFactories;
    private String mainIndustry;
    private double annualProductionVolume;

    public IndustrialCity(String name, long population, boolean isCapital, double area, Country country, int numberOfFactories, String mainIndustry, double annualProductionVolume) {
        super(name, population, isCapital, area, country);
        this.numberOfFactories = numberOfFactories;
        this.mainIndustry = mainIndustry;
        this.annualProductionVolume = annualProductionVolume;
    }

    public int getNumberOfFactories() {
        return numberOfFactories;
    }

    public void setNumberOfFactories(int numberOfFactories) {
        this.numberOfFactories = numberOfFactories;
    }

    public String getMainIndustry() {
        return mainIndustry;
    }

    public void setMainIndustry(String mainIndustry) {
        this.mainIndustry = mainIndustry;
    }

    public double getAnnualProductionVolume() {
        return annualProductionVolume;
    }

    public void setAnnualProductionVolume(double annualProductionVolume) {
        this.annualProductionVolume = annualProductionVolume;
    }

    @Override
    public double calculateProductionGrowth(double prevVolume, int years) {
        if (years <= 0 || prevVolume <= 0) return 0.0;
        double growth = (this.getAnnualProductionVolume() - prevVolume) / prevVolume;
        return (growth / years) * 100;
    }

    @Override
    public String toString() {
        return "IndustrialCity -> " + super.toString() +
                " | NumberOfFactories: " + numberOfFactories +
                " | MainIndustry: " + mainIndustry +
                " | AnnualProductionVolume: " + annualProductionVolume;
    }
}
