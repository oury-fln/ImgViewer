package com.example.imgviewer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;

import com.example.imgviewer.R;
import com.example.imgviewer.bean.MagnetBean;
import com.example.imgviewer.util.DBHelper;
import com.example.imgviewer.util.HttpHandler;
import com.example.imgviewer.util.SettingHandler;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //private Fragment firstFragment;
    private SettingHandler settingHandler;
    private Context mContext;
    private Button settingBtn;
    private ImageButton exitBtn;
    private Button imageBtn;
    private Button magnetBtn;
    private DBHelper dbHelper;
    //private SQLiteDatabase db;
    private Button testBtn;
    private HttpHandler httpHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("activity create", "main activity created!");

        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        settingHandler = new SettingHandler(mContext);
        //startLogin();
        bindViews();
        setListeners();

        dbHelper = new DBHelper(mContext, "main_db.db", null, 1);

        httpHandler = new HttpHandler(mContext);
        //db = dbHandler.getWritableDatabase();

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }
    private void bindViews() {
        imageBtn = (Button) findViewById(R.id.button_open_image);
        magnetBtn = (Button) findViewById(R.id.button_open_magnet);
        settingBtn = (Button) findViewById(R.id.button_open_setting);
        exitBtn = (ImageButton) findViewById(R.id.button_exit);

        testBtn = (Button) findViewById(R.id.button_test);
    }

    View.OnClickListener onClickListener = v -> {
        switch (v.getId()) {
            case R.id.button_open_image:
                startImage();
                break;
            case R.id.button_open_magnet:
                startMagnet();
                break;
            case R.id.button_open_setting:
                startSetting();
                break;
            case R.id.button_exit:
                startSetting();
                break;
            case R.id.button_test:
                String base_url = "https://www.dmmsee.bar";
                //String base_url = "https://www.baidu.com";
                httpHandler.startDownload(base_url);
                break;
        }
    };

    private void setListeners() {
        imageBtn.setOnClickListener(onClickListener);
        magnetBtn.setOnClickListener(onClickListener);
        settingBtn.setOnClickListener(onClickListener);
        exitBtn.setOnClickListener(onClickListener);

        testBtn.setOnClickListener(onClickListener);
    }

    private void startLogin() {
        Intent loginIntent = new Intent(mContext, LoginActivity.class);
        Bundle loginBundle = new Bundle();
        loginBundle.putString("password", settingHandler.getSetting("password"));
        loginIntent.putExtras(loginBundle);
        startActivity(loginIntent);
    }

    private void startSetting() {
        Intent settingIntent = new Intent(mContext, SettingActivity.class);
        Bundle settingBundle = new Bundle();
        settingBundle.putString("password", settingHandler.getSetting("password"));
        settingBundle.putString("url", settingHandler.getSetting("url"));
        settingIntent.putExtras(settingBundle);
        startActivityForResult(settingIntent, 0x11);
    }

    private void startImage() {
        Intent imageIntent = new Intent(mContext, ImageActivity.class);
        startActivity(imageIntent);
    }

    private void startMagnet() {
        Intent magnetIntent = new Intent(mContext, MagnetActivity.class);
        startActivity(magnetIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0x11 && resultCode == 0x11) {
            Bundle resultBundle = data.getExtras();
            Map<String, String> settingMap = new HashMap<>();
            settingMap.put("url", resultBundle.getString("url"));
            settingMap.put("password", resultBundle.getString("password"));
            settingHandler.setSettings(settingMap);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("activity pause", "main activity paused!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("activity stop", "main activity stopped!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
        Log.d("activity destroy", "main activity destroyed!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("activity start", "main activity started!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("activity resume", "main activity resumed!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("activity restart", "main activity restarted!");
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}