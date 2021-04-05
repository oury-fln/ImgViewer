package com.example.imgviewer.util;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.imgviewer.bean.ImageBean;
import com.example.imgviewer.bean.MagnetBean;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_create_image_db = "create table imagedb(id integer PRIMARY KEY AUTOINCREMENT, " +
                "url text, mid text, actress text, imgcnt integer, downloadingcnt integer, maglist text, " +
                "uploadtime real, copied integer, viewed integer, insrttime real)";
        db.execSQL(sql_create_image_db);
        String sql_create_magnet_db = "create table magnetdb(id integer PRIMARY KEY AUTOINCREMENT, " +
                "imageid integer, mid text, magnet text, copied integer, deleted integer, insrttime real, deltime real)";
        db.execSQL(sql_create_magnet_db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertImageDB(ImageBean imageBean) {
        ContentValues values = new ContentValues();
        values.put("url", imageBean.getUrl());
        values.put("mid", imageBean.getMid());
        values.put("actress", imageBean.getActress());
        values.put("imgcnt", imageBean.getImgcnt());
        values.put("downloadingcnt", imageBean.getDownloadingcnt());
        values.put("maglist", imageBean.getMaglistAsString());
        values.put("uploadtime", imageBean.getUploadtimeAyLong());
        values.put("copied", imageBean.getCopiedAsInt());
        values.put("viewed", imageBean.getViewedAsInt());
        values.put("insrttime", imageBean.getInsrttimeAsLong());
        getWritableDatabase().insert("imagedb", null, values);
    }

    public ImageBean selectImageDBbyId(int id) {
        //create table imagedb(id integer PRIMARY KEY AUTOINCREMENT, " +
        //                "url text, mid text, actress text, imgcnt integer, downloadingcnt integer, maglist text, " +
        //                "uploadtime real, copied integer, viewed integer, insrttime real)
        Cursor cursor = getReadableDatabase().query("imagedb", null, "id=?",
                new String[]{Integer.toString(id)}, null, null, null);
        ImageBean imageBean = new ImageBean();
        if (cursor.moveToFirst()) {
            imageBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
            imageBean.setUrl(cursor.getString(cursor.getColumnIndex("url")));
            imageBean.setMid(cursor.getString(cursor.getColumnIndex("mid")));
            imageBean.setImgcnt(cursor.getInt(cursor.getColumnIndex("imgcnt")));
            imageBean.setDownloadingcnt(cursor.getInt(cursor.getColumnIndex("downloadingcnt")));
            imageBean.setMaglistByString(cursor.getString(cursor.getColumnIndex("maglist")));
            imageBean.setActress(cursor.getString(cursor.getColumnIndex("actress")));
            imageBean.setUploadtimeByLong(cursor.getLong(cursor.getColumnIndex("uploadtime")));
            imageBean.setCopiedByInt(cursor.getInt(cursor.getColumnIndex("copied")));
            imageBean.setViewedByInt(cursor.getInt(cursor.getColumnIndex("viewed")));
            imageBean.setInsrttimeByLong(cursor.getLong(cursor.getColumnIndex("insrttime")));
        }
        cursor.close();
        return imageBean;
    }

    public void updateImageDB(ImageBean imageBean) {
        ContentValues values = new ContentValues();
        values.put("viewed", imageBean.getViewedAsInt());
        values.put("copied", imageBean.getCopiedAsInt());
        values.put("downloadingcnt", imageBean.getDownloadingcnt());
        getWritableDatabase().update("imagedb", values, "id=?",
                new String[]{Integer.toString(imageBean.getId())});
    }

    public void insertMagnetDB(MagnetBean magnetBean) {
        //imageid integer, mid text, magnet text, copied integer, deleted integer, insrttime real, deltime real
        ContentValues values = new ContentValues();
        values.put("imageid", magnetBean.getImageid());
        values.put("mid", magnetBean.getMid());
        values.put("magnet", magnetBean.getMagnet());
        values.put("copied", magnetBean.getCopiedAsInt());
        values.put("deleted", magnetBean.getDeletedAsInt());
        values.put("insrttime", magnetBean.getInsrttimeAyLong());
        values.put("deltime", magnetBean.getDeltimeAsLong());
        getWritableDatabase().insert("magnetdb", null, values);
    }

    public ArrayList<MagnetBean> selectMagnetDB(String[] selection, String[] selectionArgs) {
        String sel = StringUtil.join(selection, "=?,") + "=?";
        Cursor cursor = getReadableDatabase().query("magnetdb", null, sel,
                selectionArgs,null, null, null);
        ArrayList<MagnetBean> magnetBeanList = new ArrayList<MagnetBean>();
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                MagnetBean magnetBean = new MagnetBean();
                magnetBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                magnetBean.setImageid(cursor.getInt(cursor.getColumnIndex("imageid")));
                magnetBean.setMid(cursor.getString(cursor.getColumnIndex("mid")));
                magnetBean.setMagnet(cursor.getString(cursor.getColumnIndex("magnet")));
                magnetBean.setCopiedByInt(cursor.getInt(cursor.getColumnIndex("copied")));
                magnetBean.setDeletedByInt(cursor.getInt(cursor.getColumnIndex("deleted")));
                magnetBean.setInsrttimeByLong(cursor.getLong(cursor.getColumnIndex("insrttime")));
                magnetBean.setDeltimeByLong(cursor.getLong(cursor.getColumnIndex("deltime")));
                magnetBeanList.add(magnetBean);
            }
        }
        cursor.close();
        return magnetBeanList;
    }

    public void updateMagnetDB(MagnetBean magnetBean) {
        ContentValues values = new ContentValues();
        values.put("copied", magnetBean.getCopiedAsInt());
        values.put("deleted", magnetBean.getDeletedAsInt());
        values.put("deltime", magnetBean.getDeltimeAsLong());
        getWritableDatabase().update("magnetdb", values, "id=?",
                new String[] {Integer.toString(magnetBean.getId())});
    }
}
