package com.example.imgviewer.util;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HttpHandler {
    RequestQueue mQueue;

    public HttpHandler(Context mContext) {
        mQueue = Volley.newRequestQueue(mContext);
    }

    public void startDownload(String base_url) {
        StringRequest stringRequest = new StringRequest(base_url, response -> {
            Pattern pattern = Pattern.compile("<a class=\"movie-box\"[\\s\\S]+?href=\"([^\"]+)[\\s\\S]+?<date>([^<]+)[\\s\\S]+?</a>", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(response);
            if (matcher.find()) {
                Log.d("matched", matcher.group(1));
                Log.d("matched", matcher.group(2));
            }
        }, error -> Log.e("TAG", error.getMessage(), error));
        mQueue.add(stringRequest);
    }
}
