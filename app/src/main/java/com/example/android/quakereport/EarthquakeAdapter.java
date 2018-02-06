package com.example.android.quakereport;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aakashbasnet on 1/23/18.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquakes> {



    public EarthquakeAdapter(EarthquakeActivity earthquakeActivity, ArrayList<Earthquakes> earthquakes) {
        super(earthquakeActivity, 0 , earthquakes);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }


        Earthquakes earthquake = getItem(position);

        TextView mMagnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);

        //GradientDrawable magnitudeCircle = (GradientDrawable)mMagnitudeView.getBackground();
        //int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());
        //magnitudeCircle.setColor(magnitudeColor);
        assert earthquake != null;
        mMagnitudeView.setText(Integer.toString(earthquake.getMagnitude()));


        TextView nCityname = (TextView) listItemView.findViewById(R.id.city);
        nCityname.setText(earthquake.getCityName());

        Date dateObj = new Date(earthquake.getmTimeinmilliseconds());

        TextView dateView = (TextView)listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObj);
        dateView.setText(formattedDate);

        TextView timeView = (TextView)listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObj);
        timeView.setText(formattedTime);

        return listItemView;
    }

   /* private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);

    }*/

    private String formatTime(Date dateObj) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObj);
    }

    private String formatDate(Date dateObj) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObj);
    }
}
