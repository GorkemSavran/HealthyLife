package com.example.healthylife.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.healthylife.R;
import com.example.healthylife.holders.TodayDailySportHolder;
import com.example.healthylife.models.QuantityMeasure;
import com.example.healthylife.models.Sport;
import com.example.healthylife.tasks.DownloadImageTask;

// KIYMET DEREN TOY
public class AddSportPage extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, TextWatcher {
    Button backButton, addSportButton;
    EditText timeOfSport;
    Spinner timeSpinner;
    TextView howMuchBurn;
    FragmentManager manager;
    Context context = this;
    ImageView sportPhoto;
    TextView sportNameText;
    String sportImageUrl, sportName;
    String item;
    TodayDailySportHolder todayDailySportHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sport_page);
        manager = getSupportFragmentManager();
        init();
    }
    public void init(){
        backButton = findViewById(R.id.backbutton14);
        addSportButton = findViewById(R.id.add_sport_btn);
        timeOfSport = findViewById(R.id.time_of_sport);
        timeSpinner = findViewById(R.id.time_spinner);
        howMuchBurn = findViewById(R.id.how_much_burn);
        sportPhoto = findViewById(R.id.sport_photo);
        sportNameText = findViewById(R.id.sportName_text);

        Bundle extras = getIntent().getExtras();
        sportName = extras.getString("sportName");
        sportImageUrl = extras.getString("sportImageUrl");

        sportNameText.setText(sportName);
        new DownloadImageTask(sportPhoto)
                .execute(sportImageUrl);
        timeSpinner.setOnItemSelectedListener(this);
        timeOfSport.addTextChangedListener(this);
        backButton.setOnClickListener(this);
        addSportButton.setOnClickListener(this);
    }

    public double calculateTotalBurnedCalories(int timeOfSport, String selectedItem, String sportName) {
        double total_burned_calorie = 0;
        switch (selectedItem) {
            case "hour":
                switch (sportName) {
                    case "Basketball (High - Paced)":
                        total_burned_calorie = timeOfSport * 410;
                        break;
                    case "Basketball (Low - Paced)":
                        total_burned_calorie = timeOfSport * 284;
                        break;
                    case "Voleyball":
                        total_burned_calorie = timeOfSport * 252;
                        break;
                    case "Dance":
                        total_burned_calorie = timeOfSport * 200;
                        break;
                }
                break;

            case "minutes":
                switch (sportName) {
                    case "Basketball (High - Paced)":
                        total_burned_calorie= timeOfSport * 6.83333333;
                        break;
                    case "Basketball (Low - Paced)":
                        total_burned_calorie = timeOfSport * 4.73333333;
                        break;
                    case "Voleyball":
                        total_burned_calorie = timeOfSport * 4.2;
                        break;
                    case "Dance":
                        total_burned_calorie = timeOfSport * 3.33333333;
                        break;
                }
                break;

        }
        return total_burned_calorie;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton14:
                finish();
                break;
            case R.id.add_sport_btn:
                QuantityMeasure measure = item.equals("hour") ? QuantityMeasure.HOUR : QuantityMeasure.MINUTES;
                double totalCalorie = calculateTotalBurnedCalories(Integer.parseInt(timeOfSport.getText().toString()), item, sportName);
                Sport newSport = new Sport(sportName,"0", Integer.parseInt(timeOfSport.getText().toString()), measure, (int)totalCalorie);
                todayDailySportHolder = TodayDailySportHolder.getInstance();
                todayDailySportHolder.addSport(newSport);
                finish();
        }

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item = (String) parent.getItemAtPosition(position);
        System.out.println(item);
        double totalCalorie = calculateTotalBurnedCalories(Integer.parseInt(timeOfSport.getText().toString()), item, sportName);
        howMuchBurn.setText(String.format("%s Kcal", (int)totalCalorie));
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
            double totalCalorie = calculateTotalBurnedCalories(Integer.parseInt(timeOfSport.getText().toString()), item, sportName);
            howMuchBurn.setText(String.format("%s Kcal", (int)totalCalorie));
        }catch (NumberFormatException e){
            //System.out.println("not a number");
        }
    }


}