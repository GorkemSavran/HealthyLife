package com.example.healthylife.controllers;

import com.example.healthylife.models.DailyWater;
import com.example.healthylife.models.Food;
import com.example.healthylife.models.IObservable;
import com.example.healthylife.models.IObserver;
import com.example.healthylife.models.DailyFood;
import com.example.healthylife.models.QuantityMeasure;

import java.util.ArrayList;

public class TodayDailyFoodController implements IObservable {
    private static TodayDailyFoodController instance = new TodayDailyFoodController();

    private DailyFood todayDailyFood;
    private DailyWater todayDailyWater;
    private ArrayList<IObserver> observers;

    private TodayDailyFoodController() {
        // EĞer bugün içerisinde girmişse databaseden onun bilgilerini alıp başlat

        //Eğer girmemişse 0dan oluştur
        todayDailyFood = new DailyFood();
        todayDailyWater = new DailyWater();
    }

    public void incrementTodayWater(int water_ml) {
        todayDailyWater.setTodayWater(todayDailyWater.getTodayWater() + water_ml);
        notify_observers();
    }

    public void decrementTodayWater(int water_ml) {
        todayDailyWater.setTodayWater(todayDailyWater.getTodayWater() - water_ml);
        notify_observers();
    }

    public void addFood(Food food) {
        todayDailyFood.addFood(food);
        notify_observers();
    }

    public void removeFood(Food food) {
        todayDailyFood.removeFood(food);
        notify_observers();
    }

    public static TodayDailyFoodController getInstance()
    {
        return instance;
    }

    @Override
    public void add(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notify_observers() {
        System.out.println("Notified observers");
        for (IObserver observer: this.observers) {
            observer.update();
        }
    }





}