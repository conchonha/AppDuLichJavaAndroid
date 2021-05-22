package com.example.myapplication.util;

import android.content.Context;
import android.content.SharedPreferences;

public class ShaPrefs {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static ShaPrefs mInstance;

    public static ShaPrefs getInstance(Context context){
        if(mInstance == null){
            sharedPreferences = context.getSharedPreferences("datalogin",Context.MODE_PRIVATE);
            editor=sharedPreferences.edit();
            mInstance = new ShaPrefs();
        }
       return mInstance;
    }

     public boolean checkUserAcount(){
        if(sharedPreferences.getString("user","").equals("")){
            return false;
        }else{
            return true;
        }
    }

    public void saveUser(String user){
        editor.putString("user",user);
        editor.commit();
    }

    public String getUser(){
        return sharedPreferences.getString("user","");
    }

    public void clear(){
        editor.clear();
        editor.commit();
    }
}
