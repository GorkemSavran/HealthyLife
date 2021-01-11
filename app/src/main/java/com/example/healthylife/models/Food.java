package com.example.healthylife.models;

import java.util.ArrayList;
import java.util.Map;

public class Food {
    //private int foodID;
    private String foodName;
    private String foodImageUrl;
    private int quantity;
    private QuantityMeasure quantityMeasure;
    private int calorie;
    //private int caloriePer100Gram;



    public Food(String foodName, String foodImageUrl, int quantity, QuantityMeasure quantityMeasure, int calorie) {
        this.foodName = foodName;
        this.foodImageUrl = foodImageUrl;
        this.quantity = quantity;
        this.quantityMeasure = quantityMeasure;
        this.calorie = calorie;

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

   /* public int getCaloriePer100Gram() {
        return caloriePer100Gram;
    }

    public void setCaloriePer100Gram(int caloriePer100Gram) {
        this.caloriePer100Gram = caloriePer100Gram;
    }
*/


}
