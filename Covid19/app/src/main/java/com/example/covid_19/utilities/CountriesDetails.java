package com.example.covid_19.utilities;

public class CountriesDetails implements Comparable<CountriesDetails> {
    private String country;
    private String code;
    private int confirmed;
    private int recovered;
    private int critical;
    private int deaths;
    private double latitude;
    private double longitude;
    private String lastChange;
    private String lastUpdate;


    // Getter Methods

    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getCritical() {
        return critical;
    }

    public int getDeaths() {
        return deaths;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getLastChange() {
        return lastChange;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    // Setter Methods

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    @Override
    public int compareTo(CountriesDetails comparestu) {
        int compareage= comparestu.getConfirmed();

        return compareage-this.confirmed;
    }
}