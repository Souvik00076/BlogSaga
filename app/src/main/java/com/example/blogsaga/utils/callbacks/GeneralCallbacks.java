package com.example.blogsaga.utils.callbacks;

public interface GeneralCallbacks {
    void onSignUp(final boolean flag, final int errorCode);

    void onLogin(final boolean flag, final int errorCode);
}
