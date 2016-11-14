package kourosh.drivingapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kourosh on 2016-11-11.
 */

public class Activity {
    int type;
    String title;
    String description;
    int photoid;

    Activity(int type,String title,String description,int photoid){
        this.type = type;
        this.title = title;
        this.description = description;
        this.photoid = photoid;
    }
}

