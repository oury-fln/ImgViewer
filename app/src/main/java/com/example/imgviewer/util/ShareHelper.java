package com.example.imgviewer.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class ShareHelper {
    private Context mContext;

    public ShareHelper(){}
    public ShareHelper(Context mContext) {this.mContext = mContext;}
    public Boolean save(String spname, String[] keys, String[] values) {
        SharedPreferences sp = mContext.getSharedPreferences(spname, Context.MODE_PRIVATE);
        int result = -1;
        if (keys.length != values.length) {
            // TODO: call the error handler
            Toast.makeText(mContext, spname + " 写入sp时键值不匹配", Toast.LENGTH_SHORT).show();
            //TODO: write logs
            result = 1;
        } else {
            SharedPreferences.Editor editor = sp.edit();
            for (int i = 0; i < keys.length; ++i) {
                editor.putString(keys[i], values[i]);
            }
            editor.commit();
            result = 0;
        }
        return result == 0;
    }
    public Map<String, String> read(String spname, String[] keys, String[] defaultValues) {
        Map<String, String> data = new HashMap<String, String>();
        SharedPreferences sp = mContext.getSharedPreferences(spname, Context.MODE_PRIVATE);
        for (int i = 0; i < keys.length; ++i) {
            data.put(keys[i], sp.getString(keys[i], defaultValues[i]));
        }
        return data;
    }
}
