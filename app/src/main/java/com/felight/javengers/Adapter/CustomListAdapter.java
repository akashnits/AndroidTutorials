package com.felight.javengers.Adapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.felight.javengers.App.AppController;
import com.felight.javengers.Model.Movie;
import com.felight.javengers.R;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter{

    private ArrayList<Movie> movieItems;
    private Activity activity;
    private LayoutInflater inflater;

    public CustomListAdapter(Activity activity, ArrayList<Movie> movieItems)
    {
        this.movieItems=movieItems;
        this.activity=activity;
    }
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null)
        {
             inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        if(convertView == null)
        {
            convertView=inflater.inflate(R.layout.volley_row, null);
        }
        if(imageLoader == null)
        {
            imageLoader = AppController.getInstance().getImageLoader();}

            NetworkImageView thumbnail = (NetworkImageView) convertView.findViewById(R.id.thumbnail);
            TextView title = (TextView) convertView.findViewById(R.id.movieTitle);
            TextView rating = (TextView) convertView.findViewById(R.id.rating);
            TextView year = (TextView) convertView.findViewById(R.id.year);
            TextView genre = (TextView) convertView.findViewById(R.id.genre);

            Movie m = movieItems.get(position);
            thumbnail.setImageUrl(m.getUrl(), imageLoader);
            title.setText(m.getTitle());
            rating.setText("Rating: " + String.valueOf(m.getRating()));
            year.setText(String.valueOf(m.getYear()));
            String m_gen ="";

            for(String gen:m.getGenre())
            {
                m_gen =m_gen+gen + ", ";
            }
            genre.setText(m_gen);


        return convertView;
    }
}
