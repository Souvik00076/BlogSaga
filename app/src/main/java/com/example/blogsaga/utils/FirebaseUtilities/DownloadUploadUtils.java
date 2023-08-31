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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class DownloadUploadUtils {
    private static UserTokens tokens = UserTokens.getInstance();
    private static FirebaseAuth auth = tokens.getAuth();
    private static FirebaseDatabase database = tokens.getDatabase();

    public static void uploadArticle(Articles articles) {
        /*
                Todo 1 : get the title ,description and bytearray from articles using getter method of
                articles

                Todo 2 : first upload the image in firebase then get the download link
         */

        articles.getDescription();
        articles.getTitle();
        UserTokens token = UserTokens.getInstance();

        StorageReference storageRef = FirebaseStorage.getInstance().getReference("images");

        StorageReference imageRef = storageRef.child("my-image.jpg");

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
                                String downloadUrl = uri.toString();
                                // Do something with the download URL, such as storing it in a database
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








        final String email = auth.getCurrentUser().getEmail().replace(".", "");
        database.getReference("Users/" + email + "/articles").setValue(articles)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            System.out.println("Data Uploaded");
                        }
                    }
                });
    }

}
