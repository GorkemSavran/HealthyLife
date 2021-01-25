package com.example.healthylife.models;

import java.util.ArrayList;
// GÖRKEM SAVRAN
public class DailyFood {

    private int todayCalories;
    private ArrayList<Food> todayFoods;

    public int getTodayCalories() {
        return todayCalories;
    }

    public void setTodayCalories(int todayCalories) {
        this.todayCalories = todayCalories;
    }

    public ArrayList<Food> getTodayFoods() {
        return todayFoods;
    }

    public void setTodayFoods(ArrayList<Food> todayFoods) {
        this.todayFoods = todayFoods;
    }

    public DailyFood ()
    {
        this.todayCalories = 0;
        this.todayFoods = new ArrayList<Food>();
    }

    public DailyFood(int todayCalories, ArrayList<Food> todayFoods)
    {
        this.todayCalories = todayCalories;
        this.todayFoods = todayFoods;
    }

    public void addFood(Food food) {
        this.todayFoods.add(food);
        this.todayCalories = this.todayCalories + food.getTotalCalories();
    }

    public void removeFood(Food food) {
        this.todayFoods.remove(food);
        this.todayCalories = this.todayCalories - food.getTotalCalories();
    }

}
