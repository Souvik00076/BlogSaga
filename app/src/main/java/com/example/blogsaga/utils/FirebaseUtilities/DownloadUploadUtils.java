package com.example.blogsaga.utils.FirebaseUtilities;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.blogsaga.utils.models.Articles;
import com.example.blogsaga.utils.models.User;
import com.example.blogsaga.utils.models.UserTokens;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class DownloadUploadUtils {
    private static UserTokens tokens = UserTokens.getInstance();
    private static FirebaseAuth auth = tokens.getAuth();
    private static FirebaseDatabase database = tokens.getDatabase();

    public static void uploadArticle(Articles articles) {
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
