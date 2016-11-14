package kourosh.drivingapp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by patrickczeczko on 2016-11-12.
 */

public class Fuel {
    public String title;
    public String date;
    public String amountFueled;
    public String milage;
    public String cost;

    public Fuel (String title,String date,String amountFueled, String milage, String cost){
        this.title = title;
        this.date = date;
        this.amountFueled = amountFueled;
        this.milage = milage;
        this.cost = cost;
    }

    public Fuel (){

    }

    public static ArrayList<Fuel> getfuelsFromFile(String filename, Context context){
        final ArrayList<Fuel> fuelList = new ArrayList<>();

        try {
            // Load data
            String jsonString = loadJsonFromAsset("fuelData.json", context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray fuels = json.getJSONArray("data");

            // Get fuel objects from data
                for(int i = 0; i < fuels.length(); i++){
                    Fuel fuel = new Fuel();

                    fuel.title = fuels.getJSONObject(i).getString("title");
                    fuel.date = fuels.getJSONObject(i).getString("date");
                    fuel.amountFueled = fuels.getJSONObject(i).getString("amountFueled") + " L";
                    fuel.milage = fuels.getJSONObject(i).getString("milage");
                    fuel.cost = "$"  + fuels.getJSONObject(i).getString("cost");

                fuelList.add(fuel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return fuelList;
    }

    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }

}
