package com.example.healthylife.models;

public class DailyWater {
    private int todayWater;

    public DailyWater() {
        this.todayWater = 0;
    }

    public DailyWater(int water) {
        this.todayWater = water;
    }

    public int getTodayWater() {
        return todayWater;
    }

    public void setTodayWater(int todayWater) {
        this.todayWater = todayWater;
    }
}
