package com.example.myapplication.services;

public class APIServices {
    private static String baseurl="http://192.168.1.10/AppDuLich/public/";

    public static DataService getService(){
    //Pager Adapter
        //CoodinatorLayout
        return APIRetrofitClient.getClient(baseurl).create(DataService.class);
    }
}
