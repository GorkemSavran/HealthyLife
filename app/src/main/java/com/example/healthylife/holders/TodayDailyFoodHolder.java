package com.example.healthylife.holders;

import com.example.healthylife.models.DailyWater;
import com.example.healthylife.models.Food;
import com.example.healthylife.models.DailyFood;

import java.util.ArrayList;

public class TodayDailyFoodHolder {
    private static TodayDailyFoodHolder instance = new TodayDailyFoodHolder();

    private DailyFood todayDailyFood;
    private DailyWater todayDailyWater;

    private TodayDailyFoodHolder() {
        // EĞer bugün içerisinde girmişse databaseden onun bilgilerini alıp başlat

        //Eğer girmemişse 0dan oluştur
        todayDailyFood = new DailyFood();
        todayDailyWater = new DailyWater();
    }

    public ArrayList<Food> getFoods() {
        return this.todayDailyFood.getTodayFoods();
    }

    public void incrementTodayWater(int water_ml) {
        this.todayDailyWater.setTodayWater(this.todayDailyWater.getTodayWater() + water_ml);
    }

    public void decrementTodayWater(int water_ml) {
        this.todayDailyWater.setTodayWater(todayDailyWater.getTodayWater() - water_ml);
        if(todayDailyWater.getTodayWater() < 0)
            todayDailyWater.setTodayWater(0);
    }

    public int getTodayWater() {
        return todayDailyWater.getTodayWater();
    }

    public void addFood(Food food) {
        todayDailyFood.addFood(food);
    }

    public void removeFood(Food food) {
        todayDailyFood.removeFood(food);
    }

    public static TodayDailyFoodHolder getInstance()
    {
        return instance;
    }

    public int getTodayTotalCalories() {
        return this.todayDailyFood.getTodayCalories();
    }

}