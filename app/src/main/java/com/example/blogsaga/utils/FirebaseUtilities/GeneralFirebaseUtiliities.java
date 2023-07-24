package com.example.blogsaga.utils.FirebaseUtilities;

import android.graphics.Bitmap;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.blogsaga.utils.callbacks.GeneralCallbacks;
import com.example.blogsaga.models.User;
import com.example.blogsaga.models.UserToken;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

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
                                Log.i("Create User ","Completed");
                                sendVerificationEmail(user, token, callbacks);
                                return;
                            }
                        }
                        callbacks.onLoaded(false, 102);
                    }
                });
    }

    private static void sendVerificationEmail(final FirebaseUser user, UserToken token, final GeneralCallbacks callbacks) {
        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.i("Send verfication mail","Completed");
                    uploadUser(token, callbacks);
                    return;
                }
                callbacks.onLoaded(false, 106);
            }
        });
    }

    private static void uploadUser(UserToken token, final GeneralCallbacks callbacks) {
        String email = token.getEmail();
        Bitmap dpMap = token.getDpBitMap();
        StorageReference imageReference = user.getStorageReference().child("Users");


        //convert to byte arraystream and set the compression type
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        dpMap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageData = baos.toByteArray();
        final String uniqueKey = email.replace(".", "");
        UploadTask uploadTask = imageReference.child(uniqueKey + "/dp.jpg").putBytes(imageData);
        uploadTask.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                Log.i("Upload User", "Called");
                if (task.isSuccessful()) uploadUserRealTimeDb(email);
            }

            public void uploadUserRealTimeDb(final String email) {
                final String uniqueKey = email.replace(".", "");
                user.getReference().child("Users/" + uniqueKey + "/info/").setValue(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.i("Upload At Real time"," Completed");
                            callbacks.onLoaded(true, -1);
                            return ;
                        }
                         callbacks.onLoaded(true, 103);
                    }
                });
            }
        });

    }
}
