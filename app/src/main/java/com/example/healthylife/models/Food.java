package com.example.healthylife.models;

import java.util.ArrayList;
import java.util.Map;

public class Food {
    private int foodID;
    private String foodName;
    private String foodImageUrl;
    private int quantity;
    private QuantityMeasure quantityMeasure;
    private int calorie;
    private int caloriePer100Gram;
    private Map<QuantityMeasure, Integer> caloriesPerQuantityMeasure;


    public Food(int foodID, String foodName, String foodImageUrl, int quantity, QuantityMeasure quantityMeasure, int calorie, int caloriePer100Gram, Map<QuantityMeasure, Integer> caloriesPerQuantityMeasure) throws Exception {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodImageUrl = foodImageUrl;
        this.quantity = quantity;
        this.quantityMeasure = quantityMeasure;
        this.calorie = calorie;
        this.caloriePer100Gram = caloriePer100Gram;
        this.caloriesPerQuantityMeasure = caloriesPerQuantityMeasure;
    }


    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public QuantityMeasure getQuantityMeasure() {
        return quantityMeasure;
    }

    public void setQuantityMeasure(QuantityMeasure quantityMeasure) {
        this.quantityMeasure = quantityMeasure;
    }

    public int getCaloriePer100Gram() {
        return caloriePer100Gram;
    }

    public void setCaloriePer100Gram(int caloriePer100Gram) {
        this.caloriePer100Gram = caloriePer100Gram;
    }

    public String getFoodImageUrl() {
        return foodImageUrl;
    }

    public void setFoodImageUrl(String foodImageUrl) {
        this.foodImageUrl = foodImageUrl;
    }

    public Map<QuantityMeasure, Integer> getCaloriesPerQuantityMeasure() {
        return caloriesPerQuantityMeasure;
    }

    public void setCaloriesPerQuantityMeasure(Map<QuantityMeasure, Integer> caloriesPerQuantityMeasure) {
        this.caloriesPerQuantityMeasure = caloriesPerQuantityMeasure;
    }
}
