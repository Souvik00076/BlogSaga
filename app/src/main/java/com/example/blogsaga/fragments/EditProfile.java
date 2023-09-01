//package com.example.blogsaga.fragments;
//
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import com.example.blogsaga.R;
//
//public class EditProfile extends Fragment {
//    private ImageView backbutton;
//
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//        View root= inflater.inflate(R.layout.fragment_edit_profile, container, false);
//        init(root);
//        backbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addFragment(new Profile());
//            }
//        });
//
//
//        return root;
//    }
//
//    private void init(final View root) {
//        backbutton=root.findViewById(R.id.back_button);
//    }
//
//    public void addFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getFragmentManager();
//        assert fragmentManager != null;
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.container, fragment);
//        fragmentTransaction.commit();
//
//    }
//
//}