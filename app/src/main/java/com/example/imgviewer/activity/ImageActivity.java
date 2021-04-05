package com.example.imgviewer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.imgviewer.R;
import com.example.imgviewer.util.HttpHandler;

public class ImageActivity extends AppCompatActivity {
    private HttpHandler httpHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        httpHandler = new HttpHandler(this);
        String base_url = "https://www.dmmsee.bar";
        httpHandler.startDownload(base_url);
    }
}