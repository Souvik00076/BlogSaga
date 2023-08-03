package com.example.blogsaga.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.blogsaga.R;

public class CreatePage extends Fragment {

    String[] categories = {"ART", "FASHION", "TRAVEL", "FOOD", "FITNESS", "TECH & INNOVATION", "GEO POLITICS", "OTHERS"};
    String[] comments = {"YES", "NO"};
    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompleteTextView2;

    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
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

        adapter = new ArrayAdapter<>(requireContext(), R.layout.list_item, categories);
        adapter2 = new ArrayAdapter<>(requireContext(), R.layout.list_item, comments);

        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView2.setAdapter(adapter2);

        autoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Item : " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        autoCompleteTextView2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(),"Item : " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return root;
    }

    private void init(View root) {
        autoCompleteTextView = root.findViewById(R.id.select_auto_complete);
        autoCompleteTextView2 = root.findViewById(R.id.select_auto_complete2);

    }

}