package com.example.blogsaga.utils.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Articles implements Parcelable {
    private String imageUri;
    private String title, description;
    private long timeStamp;
    private String id;

    public Articles(String imageUri, String title, String description, long timeStamp, String id) {
        this.imageUri = imageUri;
        this.title = title;
        this.description = description;
        this.timeStamp = timeStamp;
        this.id = id;
    }

    protected Articles(Parcel in) {
        imageUri = in.readString();
        title = in.readString();
        description = in.readString();
        timeStamp = in.readLong();
        id = in.readString();
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

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
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

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeLong(timeStamp);
        parcel.writeString(id);
        parcel.writeString(imageUri);
    }
}
