package com.example.blogsaga.utils.models;

public class userDetails {
    public String email,name,phone,country,dob;
    public int followers=0,following=0;
    public userDetails(){

    }

    public userDetails(int followers,int following){
        this.following=following;
        this.followers=followers;

    }

    public userDetails(String email, String name) {
        this.email = email;
        this.name = name;
    }
    public userDetails(String email, String name, String phone, String country, String dob){
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.country = country;
        this.dob = dob;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public String getDob() {
        return dob;
    }

    public String getName() {
        return name;
    }
    public String getEmail(){
        return email;
    }
}
