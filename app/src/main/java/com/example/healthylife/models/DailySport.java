package com.example.healthylife.models;

import java.util.ArrayList;
// KIYMET DEREN TOY
public class DailySport {

    private int todayBurnedCalories;
    private ArrayList<Sport> todaySports;

    public int getTodayBurnedCalories() {
        return todayBurnedCalories;
    }

    public void setTodayBurnedCalories(int todayBurnedCalories) {
        this.todayBurnedCalories = todayBurnedCalories;
    }

    public ArrayList<Sport> getTodaySports() {
        return todaySports;
    }

    public void setTodaySports(ArrayList<Sport> todaySports) {
        this.todaySports = todaySports;
    }

    public DailySport()
    {
        this.todayBurnedCalories = 0;
        this.todaySports = new ArrayList<Sport>();
    }

    public DailySport(int todayBurnedCalories, ArrayList<Sport> todaySports)
    {
        this.todayBurnedCalories = todayBurnedCalories;
        this.todaySports = todaySports;
    }

    public void addSport(Sport sport) {
        this.todaySports.add(sport);
        this.todayBurnedCalories = this.todayBurnedCalories + sport.getBurnedCalorie();
    }

    public void removeSport(Sport sport) {
        this.todaySports.remove(sport);
        this.todayBurnedCalories = this.todayBurnedCalories - sport.getBurnedCalorie();
    }

}
