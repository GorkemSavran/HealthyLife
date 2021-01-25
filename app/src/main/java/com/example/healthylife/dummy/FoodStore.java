package com.example.healthylife.dummy;

import com.example.healthylife.models.Food;
import com.example.healthylife.models.QuantityMeasure;

import java.util.ArrayList;
// GÖRKEM SAVRAN
public class FoodStore {

    public static ArrayList<Food> getDummyFoods(String searchString) {
        ArrayList<Food> foods = new ArrayList<Food>();
        foods.add(new Food("Egg (Boiled)", "https://lezzet.blob.core.windows.net/images-xxlarge-recipe/haslanmis-yumurta-d9e6ef6f-29d4-4aa3-a455-0e4b2fc3f6e4.jpg", 0, QuantityMeasure.PIECE,100));
        foods.add(new Food("Egg (Scrambled)", "https://cdn.yemek.com/mncrop/940/625/uploads/2014/10/cirpilmis-yumurta-tarifi-nasil-yapilir.jpg", 0, QuantityMeasure.PIECE,100));
        foods.add(new Food("Rice", "https://img-s2.onedio.com/id-57c5624084b0907e7d694c85/rev-0/w-635/listing/f-jpg-webp/s-53127ef61e07da5afcfd50ad56a3b7f0ef5d9aa3.webp", 0, QuantityMeasure.GRAM,100));
        ArrayList<Food> filteredFoods = new ArrayList<Food>();
        for (Food food:foods) {
            if(food.getFoodName().toLowerCase().contains(searchString.toLowerCase())){
                filteredFoods.add(food);
            }

        }
        return filteredFoods;
    }
}
