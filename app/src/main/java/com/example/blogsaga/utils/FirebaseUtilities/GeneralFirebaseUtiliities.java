package com.example.blogsaga.utils.FirebaseUtilities;

import androidx.annotation.NonNull;

import com.example.blogsaga.utils.callbacks.GeneralCallbacks;
import com.example.blogsaga.utils.models.User;
import com.example.blogsaga.utils.models.UserToken;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GeneralFirebaseUtiliities {
    private static User user = User.getInstance();

    public static void registerUser(final UserToken token, final GeneralCallbacks callbacks) {
        FirebaseAuth auth = user.getAuth();
        final String email = token.getEmail();
        final String password = token.getPassword();
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            if (user != null) {
                                sendVerificationEmail(user, callbacks);
                            }
                        }
                    }
                });
    }

    private static void sendVerificationEmail(final FirebaseUser user, final GeneralCallbacks callbacks) {
        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    callbacks.onLoaded(true, "Successfull");
                } else {
                    callbacks.onLoaded(false, "Errror message");
                }
            }
        });
    }

}
