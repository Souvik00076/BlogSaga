package com.example.blogsaga.utils.FirebaseUtilities;

import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.blogsaga.utils.models.Articles;
import com.example.blogsaga.utils.models.User;
import com.example.blogsaga.utils.models.UserToken;
import com.example.blogsaga.utils.models.UserTokens;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class DownloadUploadUtils {
    private static UserTokens tokens = UserTokens.getInstance();
    private static FirebaseAuth auth = tokens.getAuth();
    private static DatabaseReference database = tokens.getDatabaseReference().child("Users/");
    private static  int IMAGE_ID=0;

    public static void uploadArticle(Articles articles) {
        /*
                Todo 1 : get the title ,description and bytearray from articles using getter method of
                articles

                Todo 2 : first upload the image in firebase then get the download link
         */

        final String email = auth.getCurrentUser().getEmail().replace(".", "");
        UserTokens token = UserTokens.getInstance();

        StorageReference storageRef = FirebaseStorage.getInstance().getReference(email+"articles/images");
        StorageReference imageRef = storageRef.child("my-image"+IMAGE_ID+".jpg");
        IMAGE_ID++;

        imageRef.putBytes(articles.getImageBytes())
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // The image has been uploaded successfully
                        Task<Uri> downloadUrlTask = taskSnapshot.getStorage().getDownloadUrl();
                        downloadUrlTask.addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                // The download URL is available
                                // Do something with the download URL, such as storing it in a database
                                articles.setImageUri(uri);
                                database.child( email + "/articles").push().setValue(articles)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    System.out.println("Information updated");
                                                }
                                            }
                                        });
                            }
                        });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // The image upload failed
                        Log.e("TAG", "Image upload failed", e);
                    }
                });

    }

}
