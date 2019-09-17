package tech.saadfauzi.nay;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Font1942 extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/1942.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        //....
    }
}