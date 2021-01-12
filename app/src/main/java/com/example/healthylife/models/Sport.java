package com.example.healthylife.models;

public class Sport {
    private String sportName;
    private String sportImageUrl;
    private int timeQuantity;
    private QuantityMeasure quantityMeasure; // hour - minutes
    private int burnedCalorie;


    public Sport(String sportName, String sportImageUrl, int timeQuantity, QuantityMeasure quantityMeasure, int burnedCalorie) {
        this. sportName =  sportName;
        this.sportImageUrl = sportImageUrl;
        this.timeQuantity = timeQuantity;
        this.quantityMeasure = quantityMeasure;
        this.burnedCalorie = burnedCalorie;

    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSportImageUrl() {
        return sportImageUrl;
    }

    public void setSportImageUrl(String sportImageUrl) {
        this.sportImageUrl = sportImageUrl;
    }

    public int getTimeQuantity() {
        return timeQuantity;
    }

    public void setTimeQuantity(int timeQuantity) {
        this.timeQuantity = timeQuantity;
    }

    public int getBurnedCalorie() {
        return burnedCalorie;
    }

    public QuantityMeasure getQuantityMeasure() {
        return quantityMeasure;
    }

    public void setQuantityMeasure(QuantityMeasure quantityMeasure) {
        this.quantityMeasure = quantityMeasure;
    }
}
