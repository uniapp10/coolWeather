package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhudong on 2017/8/29.
 */

public class Suggestion {

    public Sport sport;

    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public CarWash carWash;

    public class Sport {
        @SerializedName("txt")
        public String info;
    }
    public class Comfort {
        @SerializedName("txt")
        public String info;
    }
   public class CarWash {
       @SerializedName("txt")
       public String info;
   }
}
