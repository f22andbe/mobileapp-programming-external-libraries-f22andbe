package com.example.externallibraries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MountainViewAdapter extends RecyclerView.Adapter<MountainViewAdapter.MountainViewHolder> {

    Context context;
    ArrayList<Mountain> mountainArrayList;

    public MountainViewAdapter(Context context, ArrayList<Mountain> mountainArrayList) {
        this.context = context;
        this.mountainArrayList = mountainArrayList;
    }

    @Override
    public MountainViewAdapter.MountainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_layout, parent, false);

        return new MountainViewAdapter.MountainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MountainViewHolder holder, int position) {
        holder.mountainName.setText("Name: " + mountainArrayList.get(position).getName());
        holder.mountainLocation.setText("Location: " + mountainArrayList.get(position).getLocation());
        holder.mountainHeight.setText("Height: " + mountainArrayList.get(position).getHeight() );
        holder.mountainWiki.setText("Wiki: " + mountainArrayList.get(position).auxdata.getWiki());

        if((position % 2) == 0) {
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.lightgrey));
        }else{
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.lightblue));
        }

    }

    public int getItemCount() {
        return mountainArrayList.size();
    }

    public static class MountainViewHolder extends RecyclerView.ViewHolder {

        TextView mountainName;
        TextView mountainLocation;
        TextView mountainHeight;
        TextView mountainWiki;

        public MountainViewHolder(@NonNull View itemView) {
            super(itemView);
            mountainName = itemView.findViewById(R.id.mountainname);
            mountainLocation = itemView.findViewById(R.id.mountainlocation);
            mountainHeight = itemView.findViewById(R.id.mountainheight);
            mountainWiki = itemView.findViewById(R.id.mountainwiki);
        }
    }


}
