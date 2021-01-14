package com.example.healthylife.dummy;

import com.example.healthylife.models.ACTIVITY_LEVEL;
import com.example.healthylife.models.DailyUser;
import com.example.healthylife.models.GENDER;
import com.example.healthylife.models.GOAL;
import com.example.healthylife.models.User;

import java.util.Date;

public class UserStore {

    public static User getDummyUser() {
        Date dereniminBirthDayi = new Date(27081999);
        System.out.println(dereniminBirthDayi.getDay());
        User user = new User("derenimaşkuşum", "cadideren@hotmail.com", dereniminBirthDayi, GENDER.WOMAN);
        return user;
    }

    public static DailyUser getDummyDailyUser() {
        DailyUser dailyUser = new DailyUser(GOAL.STAY_FORM, 168, 62, 57, ACTIVITY_LEVEL.NORMAL);
        return dailyUser;
    }

}
