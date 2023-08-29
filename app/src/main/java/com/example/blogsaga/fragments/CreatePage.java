package com.example.blogsaga.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.blogsaga.R;
import com.example.blogsaga.utils.services.UploadArticleService;

import java.util.Objects;
/*

 Intent intent = new Intent(ChatScreen.this, WriteChatService.class);
                    intent.putExtra("Message", message);
                    startService(intent);


 */

public class CreatePage extends Fragment {

    androidx.appcompat.widget.AppCompatButton save;

    String[] categories = {"ART", "FASHION", "TRAVEL", "FOOD", "FITNESS", "TECH & INNOVATION", "GEO POLITICS", "OTHERS"};
    String[] comments = {"YES", "NO"};
    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompleteTextView2;

    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    ImageView crossbtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_create_page, container, false);
        init(root);

        adapter = new ArrayAdapter<>(requireContext(), R.layout.list_item, categories);
        adapter2 = new ArrayAdapter<>(requireContext(), R.layout.list_item, comments);

        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView2.setAdapter(adapter2);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), item + " SELECTED", Toast.LENGTH_SHORT).show();
                autoCompleteTextView.dismissDropDown(); // Hide the dropdown after selection
            }
        });

        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(),item + " SELECTED", Toast.LENGTH_SHORT).show();
                autoCompleteTextView2.dismissDropDown(); // Hide the dropdown after selection
            }
        });

        // Add click listeners to show the dropdown when the AutoCompleteTextView is clicked
        autoCompleteTextView.setOnClickListener(v -> autoCompleteTextView.showDropDown());
        autoCompleteTextView2.setOnClickListener(v -> autoCompleteTextView2.showDropDown());

        // Disable input in the AutoCompleteTextView
        autoCompleteTextView.setEnabled(false);
        autoCompleteTextView2.setEnabled(false);

//        this is for back to home page from the create page
        crossbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                addFragment(new HomePage());
            }
        });

        //save function implemented

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent( ,UploadArticleService.class);
//                intent.putExtra("Message", message);
//                startService(intent);

            }
        });


        return root;
    }


    private void init(View root) {
        autoCompleteTextView = root.findViewById(R.id.select_auto_complete);
        autoCompleteTextView2 = root.findViewById(R.id.select_auto_complete2);
        crossbtn=root.findViewById(R.id.cross);
        save = root.findViewById(R.id.save);
    }


    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();

    }

}