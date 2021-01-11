package com.example.healthylife.models;

import java.util.ArrayList;

public class DailyFood {

    private int todayCalories;
    private ArrayList<Food> todayFoods;

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
    }

    public void removeFood(Food food) {
        this.todayFoods.remove(food);
    }

}
