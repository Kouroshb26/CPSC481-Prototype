package kourosh.drivingapp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Service {
    String title;
    String date;
    String type;
    String currentKM;

    public Service (String title, String date, String type, String currentKM) {
        this.title = title;
        this.date = date;
        this.type = type;
        this.currentKM = currentKM;
    }

    public Service () {    }

    public static ArrayList<Service> getServices(String file, Context context) {
        final ArrayList<Service> services = new ArrayList<>();

        try {
            String fromFile = loadFile("services.json", context);
            JSONObject json = new JSONObject(fromFile);
            JSONArray serv = json.getJSONArray("data");

            for(int i=0; i<serv.length(); i++) {
                Service service = new Service();
                service.title = serv.getJSONObject(i).getString("title");
                service.date = serv.getJSONObject(i).getString("date");
                service.type = serv.getJSONObject(i).getString("type");
                service.currentKM = serv.getJSONObject(i).getString("currentKM");
                services.add(service);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return services;
    }

    public static ArrayList<Service> getService(String file, Context context, int position) {
        final ArrayList<Service> newService = new ArrayList<>();
        try {
            String fromFile = loadFile("services.json", context);
            JSONObject json = new JSONObject(fromFile);
            JSONArray serv = json.getJSONArray("data");

            Service service = new Service();
            service.title = serv.getJSONObject(position).getString("title");
            service.date = serv.getJSONObject(position).getString("date");
            service.type = serv.getJSONObject(position).getString("type");
            service.currentKM = serv.getJSONObject(position).getString("currentKM");
            newService.add(service);
        }
        catch (JSONException eee) {
            eee.printStackTrace();
        }
        return newService;
    }

    public static String loadFile(String filename, Context context) {
        String temp = null;
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            temp = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ee) {
            ee.printStackTrace();
            return null;
        }
        return temp;
    }
}
