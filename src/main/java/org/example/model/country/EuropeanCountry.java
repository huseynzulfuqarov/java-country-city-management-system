package org.example.model.country;

import org.example.model.City;
import org.example.model.Country;

import java.util.Objects;

public class EuropeanCountry extends Country {
    private boolean isInEuropeanUnion;
    private String mainExport;
    private int foundingYear;

    public EuropeanCountry(int id, String name, String continent, long population, String code, City[] cities, int cityCount, boolean isInEuropeanUnion, String mainExport, int foundingYear) {
        super(id, name, continent, population, code, cities, cityCount);
        this.isInEuropeanUnion = isInEuropeanUnion;
        this.mainExport = mainExport;
        this.foundingYear = foundingYear;
    }

    public boolean getInEuropeanUnion() {
        return isInEuropeanUnion;
    }

    public void setInEuropeanUnion(boolean isInEuropeanUnion) {
        this.isInEuropeanUnion = isInEuropeanUnion;
    }

    public String getMainExport() {
        return mainExport;
    }

    public void setMainExport(String mainExport) {
        this.mainExport = mainExport;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    public void setFoundingYear(int foundingYear) {
        this.foundingYear = foundingYear;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EuropeanCountry that = (EuropeanCountry) o;
        return isInEuropeanUnion == that.isInEuropeanUnion && foundingYear == that.foundingYear && Objects.equals(mainExport, that.mainExport);
    }

    @Override
    public String toString() {
        return "EuropeanCountry{" +
                "isInEuropeanUnion=" + isInEuropeanUnion +
                ", mainExport='" + mainExport + '\'' +
                ", foundingYear=" + foundingYear +
                '}' + super.toString();
    }
}
