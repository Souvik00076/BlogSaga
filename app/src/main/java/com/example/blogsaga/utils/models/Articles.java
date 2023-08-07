package com.example.blogsaga.utils.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Articles  {

    private int article_image, acc_image;
    private String acc_name,time,title;

    public Articles(int article_image, int acc_image, String acc_name, String time, String title) {
        this.article_image=article_image;
        this.acc_image=acc_image;
        this.acc_name=acc_name;
        this.time=time;
        this.title=title;
    }

    public int getArticle_image() {
        return article_image;
    }

    public int getAcc_image() {
        return acc_image;
    }

    public String getAcc_name() {
        return acc_name;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }
}


