package org.example.model.country;

import org.example.model.Country;

import java.util.Objects;

public class AsianCountry extends Country {
    private double gdpPerCapita;
    private boolean hasNuclearPower;
    private String mainReligion;

    public AsianCountry(String name, String continent, long population, String code, double gdpPerCapita, boolean hasNuclearPower, String mainReligion) {
        super(name, continent, population, code);
        this.gdpPerCapita = gdpPerCapita;
        this.hasNuclearPower = hasNuclearPower;
        this.mainReligion = mainReligion;
    }

    public double getGdpPerCapita() {
        return gdpPerCapita;
    }

    public void setGdpPerCapita(double gdpPerCapita) {
        this.gdpPerCapita = gdpPerCapita;
    }

    public boolean hasNuclearPower() {
        return hasNuclearPower;
    }

    public void setHasNuclearPower(boolean hasNuclearPower) {
        this.hasNuclearPower = hasNuclearPower;
    }

    public String getMainReligion() {
        return mainReligion;
    }

    public void setMainReligion(String mainReligion) {
        this.mainReligion = mainReligion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AsianCountry that = (AsianCountry) o;
        return Double.compare(gdpPerCapita, that.gdpPerCapita) == 0 && hasNuclearPower == that.hasNuclearPower && Objects.equals(mainReligion, that.mainReligion);
    }

    @Override
    public String toString() {
        return "AsianCountry -> " + super.toString() +
                " | GDP per Capita: " + this.getGdpPerCapita() +
                " | Has Nuclear Power: " + this.hasNuclearPower() +
                " | Main Religion: " + this.getMainReligion();
    }
}
