package com.example.healthylife.fragments;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.healthylife.activities.AddFoodPage;
import com.example.healthylife.R;
import com.example.healthylife.models.Food;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Food> foods;
    boolean isAddingList;

    public FoodRecyclerViewAdapter(ArrayList<Food> foods, boolean isAddingList) {
        this.foods = foods;
        this.isAddingList = isAddingList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Food food = foods.get(position);

        holder.food = food;
        holder.imageButton.setImageResource((isAddingList? R.mipmap.addpic_foreground : R.mipmap.extract_foreground ));
        holder.foodName.setText(food.getFoodName());
        holder.kcal.setText(food.getTotalCalories() + " kcal - ");
        switch (food.getQuantityMeasure()) {
            case PIECE:
                holder.quantity.setText(food.getQuantity() + " piece");
                break;
            case GRAM:
                holder.quantity.setText(food.getQuantity() + "  gram");
                break;
            case WATER_GLASS:
                holder.quantity.setText(food.getQuantity() + "  water glass");
                break;
        }
        if(isAddingList){
            ((ViewManager)holder.kcal.getParent()).removeView(holder.kcal);
            ((ViewManager)holder.quantity.getParent()).removeView(holder.quantity);
            holder.foodName.setPadding(0,10,0,0);
        }
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View foodFragment;

        Food food;

        ImageButton imageButton;
        TextView foodName;
        TextView kcal;
        TextView quantity;


        public ViewHolder(View view) {
            super(view);
            foodFragment = view;
            imageButton = (ImageButton) view.findViewById(R.id.food_image_btn);
            foodName = (TextView) view.findViewById(R.id.food_name);
            kcal = (TextView) view.findViewById(R.id.kcal);
            quantity = (TextView) view.findViewById(R.id.quantity);
            imageButton.setOnClickListener(this);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + foodName.getText() + "'";
        }

        @Override
        public void onClick(View v) {
            Intent addFoodPage = new Intent(foodFragment.getContext(), AddFoodPage.class);
            addFoodPage.putExtra("foodName", this.food.getFoodName());
            //addFoodPage.putExtra("caloriePer100Gram", this.food.getCaloriePer100Gram());
            addFoodPage.putExtra("foodImageUrl", this.food.getFoodImageUrl());
            startActivity(foodFragment.getContext(), addFoodPage,null);
        }
    }
}