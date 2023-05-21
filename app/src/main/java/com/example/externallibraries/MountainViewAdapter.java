package com.example.externallibraries;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

public class MountainViewAdapter extends RecyclerView.Adapter<MountainViewAdapter.MountainViewHolder> {

    Context context;
    List<Mountain> mountainList;

    public MountainViewAdapter(Context context, List<Mountain> mountainList) {
        this.context = context;
        this.mountainList = mountainList;
    }

    @Override
    public MountainViewAdapter.MountainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_layout, parent, false);

        return new MountainViewAdapter.MountainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MountainViewHolder holder, int position) {
        String imageUrl = mountainList.get(position).auxdata.getImg();
        holder.mountainName.setText("Name: " + mountainList.get(position).getName());
        holder.mountainLocation.setText("Location: " + mountainList.get(position).getLocation());
        holder.mountainHeight.setText("Height: " + mountainList.get(position).getHeight() );
        holder.mountainWiki.setText("Wiki: " + mountainList.get(position).auxdata.getWiki());

        if( ! imageUrl.isEmpty()){
            loadImage(imageUrl, holder.mountainImage);
        }

        if((position % 2) == 0) {
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.lightgrey));
        }else{
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.lightblue));
        }

    }

    private void loadImage(String url, ImageView imageView){
        // Set RequestOptions for Glide
        RequestOptions requestOptions = new RequestOptions().error(R.drawable.error_image) //if image can't be loaded from url show error_image instead
                                                            .fitCenter() //scale image down to size of imageview
                                                            .transform(new RoundedCorners(16)) //give image rounded corners
                                                            .diskCacheStrategy(DiskCacheStrategy.ALL); // Cache both original and resized image
        // Load the image with Glide
        Glide.with(context)                //context of the MainActivity
                    .load(url)
                    .apply(requestOptions) //apply specified options to this request
                    .into(imageView);      //this is the imageView the image should be shown in
    }

    public int getItemCount() {
        return mountainList.size();
    }

    public static class MountainViewHolder extends RecyclerView.ViewHolder {

        TextView mountainName;
        TextView mountainLocation;
        TextView mountainHeight;
        TextView mountainWiki;
        ImageView mountainImage; // we now also have an ImageView in the ViewHolder


        public MountainViewHolder(@NonNull View itemView) {
            super(itemView);
            mountainName = itemView.findViewById(R.id.mountainname);
            mountainLocation = itemView.findViewById(R.id.mountainlocation);
            mountainHeight = itemView.findViewById(R.id.mountainheight);
            mountainWiki = itemView.findViewById(R.id.mountainwiki);
            mountainImage = itemView.findViewById(R.id.mountainimage); //here we get a reference to it
        }
    }


}
