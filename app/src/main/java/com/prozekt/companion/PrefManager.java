package com.prozekt.companion;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Prithvi Chavhan on 31-01-2018.
 */

public class PrefManager {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    Context ctx;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "pinPreference";
    private static final String PIN_VALUE = "pinValue";
    private static final String ISFIRST = "IsFirstTimeLaunch";

    public PrefManager(Context context){
        this.ctx = context;
        sp = ctx.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = sp.edit();
    }

    public void setPinValue(int pinValue) {
        editor.putInt(PIN_VALUE, pinValue);
        editor.commit();
    }

    public int getPinValue() {
        return sp.getInt(PIN_VALUE, -1);
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(ISFIRST, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return sp.getBoolean(ISFIRST, true);
    }
}
