package com.databasefirst.database;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.databasefirst.MainActivity;
import com.databasefirst.SignedIn;

import java.util.HashMap;

public class SharedPref {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    Context context;
    final static private int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "SharedPref";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_NAME = "name";

    public SharedPref(Context context)
    {
        this.context = context;
        if (sharedPreferences==null)
        {
            sharedPreferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
            editor = sharedPreferences.edit();
        }

    }

    public void createSession(String name)
    {
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_NAME,name);
        editor.commit();
    }

    /**
     * Get stored session data
     * */
    public String getUserDetails()
    {
        String user = sharedPreferences.getString(KEY_NAME,null);
        return user;
    }


    public void logoutUser()
    {
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedin()
    {
        return sharedPreferences.getBoolean(IS_LOGIN,false);
    }
}
