package com.example.healthylife.models;



public class Food {
    private String foodName;
    private String foodImageUrl;
    private int quantity;
    private QuantityMeasure quantityMeasure;
    private int totalCalories;



    public Food(String foodName, String foodImageUrl, int quantity, QuantityMeasure quantityMeasure, int totalCalories) {
        this.foodName = foodName;
        this.foodImageUrl = foodImageUrl;
        this.quantity = quantity;
        this.quantityMeasure = quantityMeasure;
        this.totalCalories = totalCalories;

    }


    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodImageUrl() {
        return foodImageUrl;
    }

    public void setFoodImageUrl(String foodImageUrl) {
        this.foodImageUrl = foodImageUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public QuantityMeasure getQuantityMeasure() {
        return quantityMeasure;
    }

    public void setQuantityMeasure(QuantityMeasure quantityMeasure) {
        this.quantityMeasure = quantityMeasure;
    }


    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }
}
