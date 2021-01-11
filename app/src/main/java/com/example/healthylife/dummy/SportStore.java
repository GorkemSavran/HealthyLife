package com.example.healthylife.dummy;

import com.example.healthylife.models.QuantityMeasure;
import com.example.healthylife.models.Sport;

import java.util.ArrayList;

public class SportStore {

    public static ArrayList<Sport> getDummySports(String searchString) {
        ArrayList<Sport> sports = new ArrayList<Sport>();
        sports.add(new Sport("Basketball (High - Paced)", "https://cdn.theathletic.com/app/uploads/2020/09/25135043/GettyImages-1197492510-scaled-e1601056338926-1024x682.jpg", 0, QuantityMeasure.PIECE,100));
        sports.add(new Sport("Basketball (Low - Paced)", "https://eyofbaku2019.com/images/sport%20pages/basketball.jpg", 0, QuantityMeasure.PIECE,100));
        sports.add(new Sport("Voleyball", "https://lh3.googleusercontent.com/proxy/lXaSfcxdc8F2ZHLXi4ovs76i87NXMojFm4kttK5shDVBtC7Y0auNKMyupEP3ag-zLD_F4upfiBGI0hXM9S9wCe5JiSLKdc5eapH3BV8cbKXW_wohlL7V4kyGzs5Vbh3ord91", 0, QuantityMeasure.GRAM,100));
        sports.add(new Sport("Dance", "https://store-images.s-microsoft.com/image/apps.53401.65868570385773723.e5750b9b-27e4-4bc5-b069-0df754a7d821.249ccdbf-1484-40e8-a6a5-66b6c4882b09?mode=scale&q=90&h=1080&w=1920",0, QuantityMeasure.PIECE,100));
        ArrayList<Sport> filteredSports = new ArrayList<Sport>();
        for (Sport sport:sports) {
            if(sport.getSportName().toLowerCase().contains(searchString.toLowerCase())){
                filteredSports.add(sport);
            }

        }
        return filteredSports;
    }
}
