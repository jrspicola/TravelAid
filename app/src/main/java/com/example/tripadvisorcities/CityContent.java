package com.example.tripadvisorcities;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for the city model
 */
public class CityContent {

    /**
     * An array of cities.
     */
    public static List<CityItem> CITIES = new ArrayList<>();

    /**
     * A map of cities, by ID.
     */
    public static Map<String, CityItem> CITY_MAP = new HashMap<>();

    public static void addFromFile(ArrayList<String> rows){
        int i = 0;
        for(String row : rows){
            String[] cols = row.split("\",\""); //assumes "," wont be included in the description
            if(cols.length == 4){
                addItem(new CityItem(Integer.toString(i),
                        cols[0].substring(1), //get rid of leading double quote
                        cols[1],
                        cols[2],
                        cols[3].substring(0, cols[3].length()-1))); //get rid of ending double quote
                i++;
            }
            else {
                Log.e("Adding Items",
                        "The CSV file has an incorrect number of columns (should be 4): " + cols.length);
            }
        }
    }

    private static void addItem(CityItem item) {
        CITIES.add(item);
        CITY_MAP.put(item.id, item);
    }

    /**
     * A city object.
     */
    public static class CityItem {
        public String id;
        public String cityName;
        public String countryName;
        public String url;
        public String description;

        public CityItem(String id, String cityName, String countryName, String url, String description) {
            this.id = id;
            this.cityName = cityName;
            this.countryName = countryName;
            this.url = url;
            this.description = description;
        }

        //returns it as a CSV string
        @Override
        public String toString() {
            return cityName + "," + countryName + "," + url + "," + description;
        }

        public String getCityName() {
            return cityName;
        }

        public String getCountryName() {
            return countryName;
        }

        public String getUrl() {
            return url;
        }

        public String getDescription() {
            return description;
        }
    }
}
