package com.uinsk.mobileppkapps.connection;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.entity.StringEntity;

public class PropClient {

    private static final String BASE_URL = "https://api-ppkapps.herokuapp.com/api/v1/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.addHeader("Accept", "application/json");
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {

        client.addHeader("Accept", "application/json");

        client.post(getAbsoluteUrl(url), params, responseHandler);

    }

    private static String getAbsoluteUrl(String relativeUrl) {
        String url = BASE_URL + relativeUrl;
        System.out.println("URL : "+url);
        return url;
    }
}
