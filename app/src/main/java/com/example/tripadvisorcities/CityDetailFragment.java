package com.example.tripadvisorcities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

/**
 * A fragment representing a single City detail screen.
 */
public class CityDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The city content this fragment is presenting.
     */
    private CityContent.CityItem mCity;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CityDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the content specified by the fragment
            // arguments.
            mCity = CityContent.CITY_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_city_detail, container, false);

        if (mCity != null) {
            ((TextView) rootView.findViewById(R.id.city_detail_city)).setText(mCity.getCityName());
            ((TextView) rootView.findViewById(R.id.city_detail_country)).setText(mCity.getCountryName());
            ((TextView) rootView.findViewById(R.id.city_detail_desc)).setText(mCity.getDescription());

            Ion.with((ImageView) rootView.findViewById(R.id.city_detail_url))
                    .error(R.drawable.image_unavailable)
                    .load(mCity.getUrl());
        }

        return rootView;
    }
}
