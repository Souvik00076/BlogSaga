package com.example.blogsaga.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.blogsaga.R;

public class CreatePage extends Fragment {

    String[] items = {"Item 1", "Item 2", "Item 3"};
    private Spinner spinner;


    public CreatePage() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_create_page, container, false);
        init(root);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.fragment_create_page);
        spinner.setAdapter(adapter);

        return root;
    }

    private void init(View root) {
        spinner = (Spinner) root.findViewById(R.id.topic_dropdown);


    }

}