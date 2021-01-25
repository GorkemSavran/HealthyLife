package com.example.healthylife.models;

// GÖRKEM SAVRAN
public class DailyUser {
    private GOAL goal;
    private int height;
    private float currentWeight;
    private float targetWeight;
    private ACTIVITY_LEVEL activityLevel;
    private int targetCalorie;

    public DailyUser(GOAL goal, int height, float currentWeight, float targetWeight, ACTIVITY_LEVEL activityLevel) {
        this.goal = goal;
        this.height = height;
        this.currentWeight = currentWeight;
        this.targetWeight = targetWeight;
        this.activityLevel = activityLevel;
        this.targetCalorie = 0;
    }

    public GOAL getGoal() {
        return goal;
    }

    public void setGoal(GOAL goal) {
        this.goal = goal;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(float currentWeight) {
        this.currentWeight = currentWeight;
    }

    public float getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(float targetWeight) {
        this.targetWeight = targetWeight;
    }

    public ACTIVITY_LEVEL getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(ACTIVITY_LEVEL activityLevel) {
        this.activityLevel = activityLevel;
    }

    public int getTargetCalorie() {
        return targetCalorie;
    }

    public void setTargetCalorie(int targetCalorie) {
        this.targetCalorie = targetCalorie;
    }
}
