package com.example.blogsaga.utils;

import android.text.TextUtils;
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
}
