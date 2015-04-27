package com.example.tripadvisorcities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.io.InputStream;


/**
 * An activity representing a list of Cities.
 */
public class CityListActivity extends FragmentActivity
        implements CityListFragment.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        //if data already exists, don't read the file again.
        if(CityContent.CITIES.isEmpty() && CityContent.CITY_MAP.isEmpty()) {
            InputStream inputStream = getResources().openRawResource(R.raw.cities);
            CSVReader csvFile = new CSVReader(inputStream);
            CityContent.addFromFile(csvFile.read());
        }
    }

    /**
     * Callback method from {@link CityListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
            Intent detailIntent = new Intent(this, CityDetailActivity.class);
            detailIntent.putExtra(CityDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
    }
}
