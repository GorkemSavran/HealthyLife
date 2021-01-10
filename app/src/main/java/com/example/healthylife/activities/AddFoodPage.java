package com.example.healthylife.activities;

import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthylife.R;
import com.example.healthylife.tasks.DownloadImageTask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AddFoodPage extends AppCompatActivity  implements View.OnClickListener {
    Context context = this;
    Button backButton;
    TextView foodNameText;
    ImageView foodPhoto;
    EditText numberOfFood;
    Spinner materialSpinner;
    TextView howMuchCalorie;

    String foodName;
    String foodImageUrl;
    int caloriePer100Gram;
    FragmentManager fragmentManager;

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

        materialSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                System.out.println(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Bundle extras = getIntent().getExtras();

        foodName = extras.getString("foodName");
        foodImageUrl = extras.getString("foodImageUrl");
        caloriePer100Gram = extras.getInt("caloriePer100Gram",0);
        foodNameText.setText(foodName);
        new DownloadImageTask(foodPhoto)
                .execute(foodImageUrl);

        backButton.setOnClickListener(this);
    }


    public void calculateTotalCalories(int numberOfFoods, String selectedItem) {
        switch (selectedItem) {
            case "piece":

                break;
            case "gram":
                break;
            case "water glass":
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backButton:
                finish();
                break;
        }

    }



}