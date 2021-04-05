package com.example.imgviewer.util;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class HttpHandler {
    RequestQueue mQueue;

    public HttpHandler(Context mContext) {
        mQueue = Volley.newRequestQueue(mContext);
    }

    public void startDownload(String base_url) {
        StringRequest stringRequest = new StringRequest(base_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    ///html/body/div[4]/div/div[3]/div/div[1]/a
                    Log.d("xpath: ", );
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        mQueue.add(stringRequest);
    }
}
