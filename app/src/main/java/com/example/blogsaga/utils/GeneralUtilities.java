package com.example.blogsaga.utils;

import android.text.TextUtils;
import android.widget.Toast;

public class GeneralUtilities {


    public static int verificationUtils(String[] data) {
        final String email = data[0];
        final String password = data[1];
        if(email.isEmpty()) return 23;
        if(password.isEmpty()) return 24;
        if(!isValid(email)) return 18;
        if (data.length> 2) {
            final String confPassword = data[2];
            if(confPassword.isEmpty()) return 24;
            if(!TextUtils.equals(password,confPassword)) return 19;
        }
        return -1;
    }

    private static boolean isValid(final String email) {
        //email anatomy check is done here
        return true;
    }


    private void ValidateBlog(String data[]) {

        final String title = data[0];
        final String description = data[1];
        final String imageBitmap=data[2];

        if(imageBitmap==null){
            Toast.makeText(getContext(), "add image", Toast.LENGTH_SHORT).show();
        } else if (title.isEmpty()) {
            Toast.makeText(getContext(), "add title", Toast.LENGTH_SHORT).show();
        } else if (description.isEmpty()) {
            Toast.makeText(getContext(), "please write someting in the blog", Toast.LENGTH_SHORT).show();
        }
        else {

        }

    }
}

