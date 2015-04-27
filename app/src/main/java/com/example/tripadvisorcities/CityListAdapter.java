package com.example.tripadvisorcities;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter to fill list with CityContent data
 */
public class CityListAdapter extends ArrayAdapter<ArrayList> {
    private final Context context;
    private final List<CityContent.CityItem> values;

    public CityListAdapter(Context context, List<CityContent.CityItem> values) {
        super(context, R.layout.city_row_layout, (List)values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View city_row = inflater.inflate(R.layout.city_row_layout, parent, false);

        if(getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            TextView city = (TextView) city_row.findViewById(R.id.city_row_city);
            TextView country = (TextView) city_row.findViewById(R.id.city_row_country);
            TextView description = (TextView) city_row.findViewById(R.id.city_row_desc);

            CityContent.CityItem city_data = values.get(position);
            city.setText(city_data.getCityName());
            country.setText(city_data.getCountryName());
            description.setText(city_data.getDescription());
        }
        else {//landscape
            TextView city_and_country = (TextView) city_row.findViewById(R.id.city_row_city_and_country);
            TextView description = (TextView) city_row.findViewById(R.id.city_row_desc);

            CityContent.CityItem city_data = values.get(position);
            city_and_country.setText(
                    Html.fromHtml("<font color=#060003>" + city_data.getCityName() + "," +
                            "</font> <font color=#ff000000>" + city_data.getCountryName() + "</font>"));
            description.setText(city_data.getDescription());
        }
        return city_row;
    }
}

