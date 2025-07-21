package org.example.model;

import java.util.Arrays;
//By Huseyn
public class Country {
    private static int nextId = 1;
    private final int id;
    private String name;
    private String continent;
    private long population;
    private String code;
    private City[] cities = new City[10];  //(max 10 city)
    private int cityCount;

    public Country(String name, String continent, long population, String code) {
        this.id = nextId++;
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.code = code;
        this.cityCount = 0;
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
        return Arrays.copyOf(this.cities, this.cityCount);
    }

    public int getCityCount() {
        return cityCount;
    }

    public boolean addCity(City city) {
        if (cityCount >= 10) {
            return false;
        }
        cities[cityCount] = city;
        cityCount++;
        return true;
    }

    public void removeCityByName(String cityName) {
        int indexToDelete = -1;

        for (int i = 0; i < this.cityCount; i++) {
            if (this.cities[i].getName().equalsIgnoreCase(cityName)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete != -1) {
            for (int i = indexToDelete; i < this.cityCount - 1; i++) {
                this.cities[i] = this.cities[i + 1];
            }
            this.cityCount--;
            this.cities[this.cityCount] = null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id;
    }

    @Override
    public String toString() {
        City[] actualCities = Arrays.copyOf(this.cities, this.cityCount);
        return "ID: " + id +
                " | Name: " + name +
                " | Continent: " + continent +
                " | Population: " + population +
                " | Code: " + code +
                " | City count: " + cityCount +
                " | Cities: " + Arrays.toString(actualCities);
    }
}
