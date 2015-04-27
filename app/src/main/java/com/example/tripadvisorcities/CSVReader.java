package com.example.tripadvisorcities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * A class for reading a CSV file.
 * Puts each line into an array of Strings, with each line being a full row of CSV.
 *
 * adapted from http://javapapers.com/android/android-read-csv-file/
 */
public class CSVReader {
    InputStream inputStream;

    public CSVReader(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public ArrayList<String> read(){
        ArrayList<String> resultList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                resultList.add(csvLine);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error reading CSV file: " + ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error closing input stream: " + e);
            }
        }

        return resultList;
    }
}
