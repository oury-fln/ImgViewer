package com.example.imgviewer.bean;

import java.util.Date;

public class MagnetBean {
    //imageid integer, mid text, magnet text, copied integer, deleted integer, insrttime real, deltime real
    private int id;
    private int imageid;
    private String mid;
    private String magnet;
    private boolean copied;
    private boolean deleted;
    private Date insrttime;
    private Date deltime;

    public void setCopiedByInt(int copied) {
        this.copied = !(copied == 0);
    }

    public void setDeletedByInt(int deleted) {
        this.deleted = !(deleted == 0);
    }

    public void setInsrttimeByLong(long insrttime) {
        this.insrttime = new Date(insrttime);
    }

    public void setDeltimeByLong(long deltime) {
        this.deltime = new Date(deltime);
    }

    public int getCopiedAsInt() {
        return copied?1:0;
    }

    public int getDeletedAsInt() {
        return deleted?1:0;
    }

    public long getInsrttimeAyLong() {
        return insrttime.getTime();
    }

    public long getDeltimeAsLong() {
        return deltime.getTime();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public void setMagnet(String magnet) {
        this.magnet = magnet;
    }

    public void setCopied(boolean copied) {
        this.copied = copied;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setInsrttime(Date insrttime) {
        this.insrttime = insrttime;
    }

    public void setDeltime(Date deltime) {
        this.deltime = deltime;
    }

    public int getId() {
        return id;
    }

    public int getImageid() {
        return imageid;
    }

    public String getMid() {
        return mid;
    }

    public String getMagnet() {
        return magnet;
    }

    public boolean isCopied() {
        return copied;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Date getInsrttime() {
        return insrttime;
    }

    public Date getDeltime() {
        return deltime;
    }
}
