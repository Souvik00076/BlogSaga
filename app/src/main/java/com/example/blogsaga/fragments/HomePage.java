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
import android.widget.Toast;

import com.example.blogsaga.R;
import com.example.blogsaga.utils.adapters.UpdateArticlesAdapter;
import com.example.blogsaga.utils.callbacks.RecyclerCallbacks;
import com.example.blogsaga.utils.models.Articles;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Fragment implements RecyclerCallbacks {

    FloatingActionButton createbtn;

    RecyclerView recyclerView;
    LinearLayoutManager LayoutManager;
    List<Articles> dataset;
    UpdateArticlesAdapter Adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_home_page, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recyclerview);
        createbtn=view.findViewById(R.id.create_button);
        initData();
        initRecyclerview();

        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new CreatePage());
            }
        });
    }

    private void initRecyclerview() {
        LayoutManager=new LinearLayoutManager(requireContext());
        LayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(LayoutManager);
        Adapter=new UpdateArticlesAdapter(dataset,getContext(),this);
        recyclerView.setAdapter(Adapter);
        Adapter.notifyDataSetChanged();

    }

    private void initData() {
        dataset=new ArrayList<>();
        dataset.add(new Articles(R.drawable.recentpic,R.drawable.recentpic,"Nasty fitness","8 days ago","5 tips for stay fit and healthy"));
        dataset.add(new Articles(R.drawable.recentpic,R.drawable.recentpic,"Nasty fitness","8 days ago","5 tips for stay fit and healthy"));
        dataset.add(new Articles(R.drawable.recentpic,R.drawable.recentpic,"Nasty fitness","8 days ago","5 tips for stay fit and healthy"));

    }

    @Override
    public void onClick(Articles articles) {
        Toast.makeText(getContext(), "hii", Toast.LENGTH_SHORT).show();
    }


    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();

    }
}