package com.hxp.pithymenu;

import android.app.Application;
import android.content.Context;

/**
 * Created by HXP on 2016/12/11.
 */

public class PithyApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getAppContext(){
        return context;
    }
}
