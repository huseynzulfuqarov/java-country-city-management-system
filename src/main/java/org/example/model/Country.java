package org.example.model;

import java.util.Arrays;

public class Country {
    private int id;
    private String name;
    private String continent;
    private long population;
    private String code;
    City[] cities; //(maksimum 10 şəhər)
    int cityCount;

    public Country(int id, String name, String continent, long population, String code, City[] cities, int cityCount) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.code = code;
        this.cities = cities;
        this.cityCount = cityCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public int getCityCount() {
        return cityCount;
    }

    public void setCityCount(int cityCount) {
        this.cityCount = cityCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return false;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", code='" + code + '\'' +
                ", cities=" + Arrays.toString(cities) +
                ", cityCount=" + cityCount +
                '}';
    }
}
