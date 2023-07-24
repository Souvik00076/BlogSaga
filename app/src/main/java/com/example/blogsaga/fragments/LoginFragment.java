package com.example.blogsaga.fragments;

import static com.example.blogsaga.utils.GeneralUtilities.verificationUtils;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blogsaga.R;
import com.example.blogsaga.utils.ErrorCodes;


public class LoginFragment extends Fragment {
    private EditText emailEt,passwordEt;
    private Button loginButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_login,container,false);
        init(root);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email=emailEt.getText().toString();
                final String password=passwordEt.getText().toString();
                String[] data={email,password};
                int errorCode=verificationUtils(data);
                if(errorCode!=-1) {
                    Toast.makeText(getContext(), ErrorCodes.getMap().get(errorCode), Toast.LENGTH_SHORT).show();
                    return ;
                }

            }
        });
        return root;
    }
    private void init(View root){
        emailEt=root.findViewById(R.id.txt_email);
        passwordEt=root.findViewById(R.id.txt_password);
        loginButton=root.findViewById(R.id.btn_login);
    }
}