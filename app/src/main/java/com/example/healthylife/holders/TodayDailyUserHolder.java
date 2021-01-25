package com.example.healthylife.holders;

import com.example.healthylife.dummy.UserStore;
import com.example.healthylife.models.ACTIVITY_LEVEL;
import com.example.healthylife.models.DailyUser;
import com.example.healthylife.models.GENDER;
import com.example.healthylife.models.GOAL;
import com.example.healthylife.models.User;

import java.util.Date;

// GÖRKEM SAVRAN
public class TodayDailyUserHolder {
    private static TodayDailyUserHolder instance = new TodayDailyUserHolder();

    private DailyUser todayDailyUser;
    private User user;

    public TodayDailyUserHolder() {
        this.todayDailyUser = UserStore.getDummyDailyUser();
        this.user = UserStore.getDummyUser();
    }

    public static TodayDailyUserHolder getInstance() { return instance; }

    public String getUsername() { return user.getUsername(); }
    public String getEmail() { return user.getEmail(); }
    public float getTargetWeight() { return todayDailyUser.getTargetWeight(); }
    public GENDER getGender() { return user.getGender(); }
    public Date getBirthday() { return user.getBirthday(); }
    public ACTIVITY_LEVEL getActivityLevel() { return todayDailyUser.getActivityLevel(); }
    public int getHeight() { return todayDailyUser.getHeight(); }
    public float getCurrentWeight() { return todayDailyUser.getCurrentWeight(); }
    public GOAL getGoal() { return todayDailyUser.getGoal(); }

    public int getTargetCalories() {
        if(todayDailyUser.getTargetCalorie() != 0)
            return todayDailyUser.getTargetCalorie();
        int age = 2021 - getBirthday().getYear();
        float BMR;
        int dailyCaloryRequirement = 0;
        if(getGender() == GENDER.WOMAN)
            BMR = 655.1f + (9.56f * getCurrentWeight()) + (1.85f * getHeight()) - (4.67f * age);
        else
            BMR = 66.5f + (13.75f * getCurrentWeight()) + (5 * getHeight()) - (6.77f * age);
        switch (getActivityLevel()) {
            case VERY_LOW:
                dailyCaloryRequirement = (int)(BMR * 1.1);
                break;
            case LOW:
                dailyCaloryRequirement = (int)(BMR * 1.2);
                break;
            case NORMAL:
                dailyCaloryRequirement = (int)(BMR * 1.3);
                break;
            case HIGH:
                dailyCaloryRequirement = (int)(BMR * 1.4);
                break;
            case VERY_HIGH:
                dailyCaloryRequirement = (int)(BMR * 1.5);
                break;
        }
        dailyCaloryRequirement = dailyCaloryRequirement + (int)(dailyCaloryRequirement * 10 / 100);
        if(getGender() == GENDER.WOMAN) {
            switch (getGoal()) {
                case STAY_FORM:
                    todayDailyUser.setTargetCalorie(dailyCaloryRequirement);
                    break;
                case LOSE_WEIGHT:
                    todayDailyUser.setTargetCalorie(dailyCaloryRequirement - 500);
                    break;
                case GAIN_WEIGHT:
                    todayDailyUser.setTargetCalorie(dailyCaloryRequirement + 500);
                    break;
            }
        } else {
            switch (getGoal()) {
                case STAY_FORM:
                    todayDailyUser.setTargetCalorie(dailyCaloryRequirement);
                    break;
                case LOSE_WEIGHT:
                    todayDailyUser.setTargetCalorie(dailyCaloryRequirement - 700);
                    break;
                case GAIN_WEIGHT:
                    todayDailyUser.setTargetCalorie(dailyCaloryRequirement + 700);
                    break;
            }
        }
        return dailyCaloryRequirement;
    }

    public void setCurrentWeight(float currentWeight) {
        todayDailyUser.setCurrentWeight(currentWeight);
    }
}
