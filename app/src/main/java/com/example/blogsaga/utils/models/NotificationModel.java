package com.example.blogsaga.utils.models;

import com.google.firebase.auth.FirebaseAuth;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotificationModel {
    String Timestamp,message,Username;
     public NotificationModel(Articles articles){
         message=""+articles.getTitle()+"added";
         Date currentTime=new Date();
         SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
         Timestamp=dateFormat.format(currentTime);
         Username= FirebaseAuth.getInstance().getCurrentUser().getDisplayName().toString();
     }
    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public String getUsername() {
        return Username;
    }
}
