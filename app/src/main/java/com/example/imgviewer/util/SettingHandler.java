package com.example.imgviewer.util;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingHandler {
    private String[] keys = {"url", "password", "lastId", "isDownloading"};
    private String[] default_values = {"https://baidu.com", "a", "0", "T"};
    private Map<String, String> settings;
    private ShareHelper sh;
    private Context mContext;
    private String spname;

    public SettingHandler(Context mContext){
        settings = new HashMap<String, String>();
        this.mContext = mContext;
        spname = "setting";
        sh = new ShareHelper(this.mContext);
        settings = sh.read(spname, keys, default_values);
    }

    public String getSetting(String setting_name) {
        String result;
        if ((result = settings.get(setting_name)) == null) {
            // TODO: error handler and logs
            Toast.makeText(mContext, setting_name + " 找不到该名称的设置项", Toast.LENGTH_SHORT).show();
            result = "";
        }
        return result;
    }

    public void setSettings(Map<String, String> settings) {
        List<String> keysList = new ArrayList<>();
        List<String> valuesList = new ArrayList<>();
        for (String key: keys) {
            String value;
            if ((value = settings.get(key)) != null) {
                keysList.add(key);
                valuesList.add(value);
                this.settings.replace(key, value);
            }
        }
        // TODO: handle if failed
        if (sh.save(spname, keysList.toArray(new String[keysList.size()]),
                valuesList.toArray(new String[valuesList.size()]))) {
            Toast.makeText(mContext, "setting保存成功", Toast.LENGTH_SHORT).show();
        }
    }
}
