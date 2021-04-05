package com.example.imgviewer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.imgviewer.R;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private Button loginBtn;
    private String password;
    private EditText passEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn = (Button) findViewById(R.id.button_login);
        passEdit = (EditText) findViewById(R.id.input_password);
        password = getIntent().getExtras().getString("password");
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passEdit.getText().toString().equals(password)) {
                    finish();
                }
            }
        });
        Log.d("activity start", "login activity started!");
    }

    @Override
    public void onBackPressed() {
        // magic way to kill all activities
        ActivityManager activityManager = (ActivityManager) this.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.AppTask> appTaskList = activityManager.getAppTasks();
        for (ActivityManager.AppTask appTask : appTaskList) {
            appTask.finishAndRemoveTask();
        }
    }
}