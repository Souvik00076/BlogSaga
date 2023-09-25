package com.example.blogsaga.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.blogsaga.R;
import com.example.blogsaga.utils.adapters.UpdateArticlesAdapter;
import com.example.blogsaga.utils.callbacks.RecyclerCallbacks;
import com.example.blogsaga.utils.models.Articles;
import com.example.blogsaga.utils.models.User;
import com.example.blogsaga.utils.models.UserTokens;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Fragment implements RecyclerCallbacks {

    FloatingActionButton createbtn;
    ImageView notificationbtn, bookmarkbtn;
    RecyclerView ownRv;
    UpdateArticlesAdapter ownAdapter;
    LinearLayoutManager LayoutManager;
    ArrayList<Articles> dataset;
    ChildEventListener ownArticleListener;
    DatabaseReference ownArticleReference;
    FirebaseAuth auth;
    UserTokens token;
//    UpdateArticlesAdapter Adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home_page, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerview(view);

        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new CreatePage());
            }
        });
        notificationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new Notification());
            }
        });
        bookmarkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new MyBookmark());
            }
        });
    }

    private void initRecyclerview(View view) {
        dataset = new ArrayList<>();
        createbtn = view.findViewById(R.id.create_button);
        ownRv = view.findViewById(R.id.recyclerview);
        notificationbtn = view.findViewById(R.id.notification);
        bookmarkbtn = view.findViewById(R.id.bookmark);
        ownAdapter = new UpdateArticlesAdapter(dataset);
        token = UserTokens.getInstance();
        LayoutManager = new LinearLayoutManager(requireContext());
        LayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        ownRv.setAdapter(ownAdapter);
        ownRv.setLayoutManager(LayoutManager);
        auth = token.getAuth();
        ownArticleReference = token.getDatabaseReference().child("Users/" + auth.getCurrentUser().getEmail().replace(".", "") + "/articles");

        ownArticleListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

               for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                   Articles articles=dataSnapshot.getValue(Articles.class);
                   dataset.add(articles);
                   ownAdapter.setData(articles);
               }
               ownAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };
        ownArticleReference.addChildEventListener(ownArticleListener);
    }


    @Override
    public void onClick(Articles articles) {
        Toast.makeText(getContext(), "hii"+articles.getTitle(), Toast.LENGTH_SHORT).show();
    }


    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}