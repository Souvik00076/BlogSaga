package com.example.blogsaga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.blogsaga.fragments.HomePage;
import com.example.blogsaga.fragments.LoginFragment;
import com.example.blogsaga.fragments.CreatePage;
import com.example.blogsaga.fragments.EditProfile;
import com.example.blogsaga.fragments.SignupFragment;
import com.example.blogsaga.fragments.profile;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment(new profile());
    }

    public void addFragment(final Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).
                disallowAddToBackStack().commit();
    }
}