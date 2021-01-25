package com.example.healthylife.activities;

import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthylife.R;
import com.example.healthylife.holders.TodayDailyFoodHolder;
import com.example.healthylife.models.Food;
import com.example.healthylife.models.QuantityMeasure;
import com.example.healthylife.tasks.DownloadImageTask;

// GÖRKEM SAVRAN
public class AddFoodPage extends AppCompatActivity  implements View.OnClickListener, AdapterView.OnItemSelectedListener, TextWatcher{
    Context context = this;
    Button backButton;
    TextView foodNameText;
    ImageView foodPhoto;
    EditText numberOfFood;
    Spinner materialSpinner;
    TextView howMuchCalorie;
    String item;
    String foodName;
    String foodImageUrl;
    int caloriePer100Gram;
    Button addFoodButton;
    FragmentManager fragmentManager;
    TodayDailyFoodHolder todayDailyFoodHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_page);
        init();
        fragmentManager = getSupportFragmentManager();
    }
    public void init() {
        backButton = findViewById(R.id.backButton);
        foodNameText = findViewById(R.id.foodName_text);
        foodPhoto = findViewById(R.id.food_photo);
        numberOfFood = findViewById(R.id.number_of_food);
        materialSpinner = findViewById(R.id.material_spinner);
        howMuchCalorie = findViewById(R.id.how_much_calorie);
        addFoodButton = findViewById(R.id.add_food_btn);

        Bundle extras = getIntent().getExtras();
        foodName = extras.getString("foodName");
        foodImageUrl = extras.getString("foodImageUrl");
        caloriePer100Gram = extras.getInt("caloriePer100Gram",0);

        foodNameText.setText(foodName);
        new DownloadImageTask(foodPhoto)
                .execute(foodImageUrl);

        addFoodButton.setOnClickListener(this);
        materialSpinner.setOnItemSelectedListener(this);
        numberOfFood.addTextChangedListener(this);
        backButton.setOnClickListener(this);
    }

    public double calculateTotalCalories(int numberOfFoods, String selectedItem, String foodName) {
        double total_calorie = 0;
        switch (selectedItem) {
            case "piece":
                switch (foodName) {
                    case "Egg (Boiled)":
                        total_calorie = numberOfFoods * 78;
                        break;
                    case "Egg (Scrambled)":
                        total_calorie = numberOfFoods * 122;
                        break;
                    case "Rice":
                        total_calorie = numberOfFoods;
                        break;
                }
            break;

            case "gram":
                switch (foodName) {
                    case "Egg (Boiled)":
                        total_calorie = numberOfFoods * 15.5;
                        break;
                    case "Egg (Scrambled)":
                        total_calorie = numberOfFoods * 22.1;
                        break;
                    case "Rice":
                        total_calorie = numberOfFoods * 16.7;
                        break;
                }
            break;

            case "water glass":
                switch (foodName) {
                    case "Egg (Boiled)":
                        total_calorie = numberOfFoods * 31;
                        break;
                    case "Egg (Scrambled)":
                        total_calorie = numberOfFoods * 44.2;
                        break;
                    case "Rice":
                        total_calorie = numberOfFoods * 25;
                        break;

                }
            break;
                
        }
        return total_calorie;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backButton:
                finish();
                break;
            case R.id.add_food_btn:
                QuantityMeasure measure = QuantityMeasure.PIECE;
                switch (item) {
                    case "piece":
                        measure = QuantityMeasure.PIECE;
                        break;
                    case "gram":
                        measure = QuantityMeasure.GRAM;
                        break;
                    case "waterglass":
                        measure = QuantityMeasure.WATER_GLASS;
                        break;
                }
                double totalCalorie = calculateTotalCalories(Integer.parseInt(numberOfFood.getText().toString()), item, foodName);
                Food newFood = new Food(foodName,"0", Integer.parseInt(numberOfFood.getText().toString()), measure, (int)totalCalorie);
                todayDailyFoodHolder = TodayDailyFoodHolder.getInstance();
                todayDailyFoodHolder.addFood(newFood);
                finish();
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item = (String) parent.getItemAtPosition(position);
        double totalCalorie = calculateTotalCalories(Integer.parseInt(numberOfFood.getText().toString()), item, foodName);
        howMuchCalorie.setText(String.format("%s Kcal", (int)totalCalorie));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        try {
            double totalCalorie = calculateTotalCalories(Integer.parseInt(numberOfFood.getText().toString()), item, foodName);
            howMuchCalorie.setText(String.format("%s Kcal", (int)totalCalorie));
        }catch (NumberFormatException e){
            //System.out.println("not a number");
        }

    }
}