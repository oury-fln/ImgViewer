package com.example.imgviewer.bean;

import java.util.Date;
import com.example.imgviewer.util.StringUtil;

public class ImageBean {
    //create table imagedb(id integer PRIMARY KEY AUTOINCREMENT, " +
    //                "url text, mid text, actress text, imgcnt integer, downloadingcnt integer, maglist text, " +
    //                "uploadtime real, copied integer, viewed integer, insrttime real)
    private int id;
    private String url;
    private String mid;
    private String actress;
    private int imgcnt;
    private int downloadingcnt;
    private String[] maglist;
    private Date uploadtime;
    private boolean copied;
    private boolean viewed;
    private Date insrttime;

    public void setUploadtimeByLong(long uploadtime) {
        this.uploadtime = new Date(uploadtime);
    }

    public void setInsrttimeByLong(long insrttime) {
        this.insrttime = new Date(insrttime);
    }

    public void setCopiedByInt(int copied) {
        this.copied = !(copied == 0);
    }

    public void setViewedByInt(int viewed) {
        this.viewed = !(viewed == 0);
    }

    public void setMaglistByString(String maglist) {
        if (maglist.equals("") || maglist == null)
            this.maglist = null;
        this.maglist = maglist.split("%%");
    }

    public long getUploadtimeAyLong() {
        return uploadtime.getTime();
    }

    public long getInsrttimeAsLong() {
        return insrttime.getTime();
    }

    public int getCopiedAsInt() {
        return copied?1:0;
    }

    public int getViewedAsInt() {
        return viewed?1:0;
    }

    public String getMaglistAsString() {
        return StringUtil.join(maglist, "%%");
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getMid() {
        return mid;
    }

    public String getActress() {
        return actress;
    }

    public int getImgcnt() {
        return imgcnt;
    }

    public int getDownloadingcnt() {
        return downloadingcnt;
    }

    public String[] getMaglist() {
        return maglist;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public boolean getCopied() {
        return copied;
    }

    public boolean getViewed() {
        return viewed;
    }

    public Date getInsrttime() {
        return insrttime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }

    public void setImgcnt(int imgcnt) {
        this.imgcnt = imgcnt;
    }

    public void setDownloadingcnt(int downloadingcnt) {
        this.downloadingcnt = downloadingcnt;
    }

    public void setMaglist(String[] maglist) {
        this.maglist = maglist;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public void setCopied(boolean copied) {
        this.copied = copied;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    public void setInsrttime(Date insrttime) {
        this.insrttime = insrttime;
    }
}
