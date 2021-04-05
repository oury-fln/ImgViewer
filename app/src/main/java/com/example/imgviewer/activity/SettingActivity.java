package com.example.imgviewer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imgviewer.R;

public class SettingActivity extends AppCompatActivity {
    private EditText editUrl;
    private EditText editPassword;
    private Button loginBtn;
    private String password;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Bundle settingBundle = getIntent().getExtras();
        password = settingBundle.getString("password");
        url = settingBundle.getString("url");
        bindViews();
        setListeners();
        setSettings();
    }
    private void bindViews() {
        editUrl = (EditText) findViewById(R.id.input_url);
        editPassword = (EditText)findViewById(R.id.edit_password);
        loginBtn = (Button)findViewById(R.id.button_save);
    }

    private void setSettings() {
        editUrl.setText(url);
        editPassword.setText(password);
    }

    private void setListeners() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlText = editUrl.getText().toString();
                String passwordText = editPassword.getText().toString();
                if (urlText.equals("") || urlText == null) {
                    Toast.makeText(SettingActivity.this, "url不可未空", Toast.LENGTH_SHORT).show();
                } else if (passwordText.equals("") || passwordText == null) {
                    Toast.makeText(SettingActivity.this, "password不可未空", Toast.LENGTH_SHORT).show();
                } else {
                    Intent resultIntent = getIntent();
                    Bundle resultBundle = new Bundle();
                    resultBundle.putString("url", urlText);
                    resultBundle.putString("password", passwordText);
                    resultIntent.putExtras(resultBundle);
                    setResult(0x11, resultIntent);
                    finish();
                }
            }
        });
    }
}