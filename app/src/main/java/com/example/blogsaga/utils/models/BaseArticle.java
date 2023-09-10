package com.example.blogsaga.utils.models;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class BaseArticle  {
    private Uri imageUri;
    private String title;
    private String description;
    private String ID;

    public BaseArticle(Uri imageUri, String title, String description) {
        this.imageUri = imageUri;
        this.title = title;
        this.description = description;
    }

    public BaseArticle(Articles articles) {
        imageUri = articles.getImageUri();
        title = articles.getTitle();
        description = articles.getDescription();
        ID = articles.getId();
    }



    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return ID;
    }
}