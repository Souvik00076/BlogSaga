package com.example.blogsaga.utils.models;

import java.sql.Time;

public class NotificationModel {
    String Username,message;
     NotificationModel(Articles articles){
         Username=articles.getId();
         message=""+articles.getDescription()+"added";
     }

    public String getMessage() {
        return message;
    }
}
