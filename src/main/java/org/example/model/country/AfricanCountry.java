package org.example.model.country;

import org.example.model.Country;
import java.util.Objects;

public class AfricanCountry extends Country {
    private String mainLanguage;
    private boolean isDeveloping;
    private String currency;

    public AfricanCountry(String name, String continent, long population, String code, String mainLanguage, boolean isDeveloping, String currency) {
        super(name, continent, population, code);
        this.mainLanguage = mainLanguage;
        this.isDeveloping = isDeveloping;
        this.currency = currency;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public void setMainLanguage(String mainLanguage) {
        this.mainLanguage = mainLanguage;
    }

    public boolean isDeveloping() {
        return isDeveloping;
    }

    public void setDeveloping(boolean developing) {
        isDeveloping = developing;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AfricanCountry that = (AfricanCountry) o;
        return isDeveloping == that.isDeveloping && Objects.equals(mainLanguage, that.mainLanguage) && Objects.equals(currency, that.currency);
    }

    @Override
    public String toString() {
        return "AfricanCountry -> " + super.toString() +
                " | Main Language: " + this.getMainLanguage() +
                " | Is Developing: " + this.isDeveloping() +
                " | Currency: " + this.getCurrency();
    }
}
