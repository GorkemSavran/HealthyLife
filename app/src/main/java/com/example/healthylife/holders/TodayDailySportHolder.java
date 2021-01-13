package com.example.healthylife.holders;


import com.example.healthylife.models.DailySport;
import com.example.healthylife.models.Sport;

import java.util.ArrayList;

public class TodayDailySportHolder {
    private static TodayDailySportHolder instance = new TodayDailySportHolder();

    private DailySport todayDailySport;

    private TodayDailySportHolder() {
        // EĞer bugün içerisinde girmişse databaseden onun bilgilerini alıp başlat

        //Eğer girmemişse 0dan oluştur
        todayDailySport = new DailySport();

    }

    public ArrayList<Sport> getSports() {
        return this.todayDailySport.getTodaySports();
    }

asdadadad
    public void addSport(Sport sport) {
        this.todayDailySport.addSport(sport);
    }

    public void removeSport(Sport sport) {
        todayDailySport.removeSport(sport);
    }

    public static TodayDailySportHolder getInstance()
    {
        return instance;
    }

    public int getTodayTotalBurnedCalories() {
        return this.todayDailySport.getTodayBurnedCalories();
    }

}