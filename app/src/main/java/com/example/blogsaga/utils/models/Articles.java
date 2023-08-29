package com.example.blogsaga.utils.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Articles  implements Parcelable{

    //private int article_image, acc_image;
    private String acc_name,time,title;
    public Articles(/*int article_image, int acc_image, String acc_name,*/ String time, String title) {
      //  this.article_image=article_image;
        //this.acc_image=acc_image;
        this.acc_name=acc_name;
        this.time=time;
        this.title=title;
    }





    public int getArticle_image() {
        return article_image;

    protected Articles(Parcel in) {
        //article_image = in.readInt();
        //acc_image = in.readInt();
        acc_name = in.readString();
        time = in.readString();
        title = in.readString();

    }

    public static final Creator<Articles> CREATOR = new Creator<Articles>() {
        @Override
        public Articles createFromParcel(Parcel in) {
            return new Articles(in);
        }

        @Override
        public Articles[] newArray(int size) {
            return new Articles[size];
        }
    };

    /*public int getArticle_image() {
        return article_image;
    }*/
    /*
    public int getAcc_image() {
        return acc_image;
    }*/

    public String getAcc_name() {
        return acc_name;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
         //parcel.writeInt(article_image);
        // parcel.writeInt(acc_image);
        parcel.writeString(acc_name);
        parcel.writeString(time);
        parcel.writeString(title);
    }
}


