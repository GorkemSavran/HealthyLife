package com.example.healthylife.fragments;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.healthylife.R;
import com.example.healthylife.SportPage;
import com.example.healthylife.activities.AddSportPage;
import com.example.healthylife.holders.TodayDailySportHolder;
import com.example.healthylife.models.Sport;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

// KIYMET DEREN TOY
public class SportRecyclerViewAdapter extends RecyclerView.Adapter<SportRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Sport> sports;
    boolean isAddingList;

    public SportRecyclerViewAdapter(ArrayList<Sport> sports, boolean isAddingList) {
        this.sports = sports;
        this.isAddingList = isAddingList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_sport, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Sport sport = sports.get(position);
        holder.sport = sport;
        holder.imageButton.setImageResource((isAddingList ? R.mipmap.addpic_foreground : R.mipmap.extract_foreground));
        holder.sportName.setText(sport.getSportName());
        holder.burnedKcal.setText(sport.getBurnedCalorie() + " kcal - ");

        switch (sport.getQuantityMeasure()) {

            case HOUR:
                holder.timeQuantity.setText(sport.getTimeQuantity() + " hour");
                break;
            case MINUTES:
                holder.timeQuantity.setText(sport.getTimeQuantity() + "  minutes");
                break;

        }
        if (isAddingList) {
            ((ViewManager) holder.burnedKcal.getParent()).removeView(holder.burnedKcal);
            ((ViewManager) holder.timeQuantity.getParent()).removeView(holder.timeQuantity);
            holder.sportName.setPadding(0, 10, 0, 0);
        }
    }

    @Override
    public int getItemCount() {
        return sports.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View sportFragment;

        Sport sport;
        ImageButton imageButton;
        TextView sportName;
        TextView burnedKcal;
        TextView timeQuantity;

        public ViewHolder(View view) {
            super(view);
            sportFragment = view;
            imageButton = (ImageButton) view.findViewById(R.id.sport_image_btn);
            sportName = (TextView) view.findViewById(R.id.sport_name);
            burnedKcal = (TextView) view.findViewById(R.id.burned_kcal);
            timeQuantity = (TextView) view.findViewById(R.id.time_quantity);
            imageButton.setOnClickListener(this);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + sportName.getText() + "'";
        }

        @Override
        public void onClick(View v) {
            if(isAddingList) {
                Intent addSportPage = new Intent(sportFragment.getContext(), AddSportPage.class);
                addSportPage.putExtra("sportName", this.sport.getSportName());
                addSportPage.putExtra("sportImageUrl", this.sport.getSportImageUrl());
                startActivity(sportFragment.getContext(), addSportPage,null);
            }
            else {
                TodayDailySportHolder.getInstance().removeSport(sport);
                SportPage activity = (SportPage)sportFragment.getContext();
                activity.listSports();
            }
        }
    }
}