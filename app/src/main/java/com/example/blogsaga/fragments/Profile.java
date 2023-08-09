package com.example.blogsaga.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.blogsaga.MainActivity;
import com.example.blogsaga.R;
import com.example.blogsaga.utils.adapters.TabAdapter;
import com.google.android.material.tabs.TabLayout;

public class Profile extends Fragment {
    public LinearLayout editbtn;
    private MainActivity activity;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_profile, container, false);
        init(root);

        tabLayout.addTab(tabLayout.newTab().setText("Drafts"));
        tabLayout.addTab(tabLayout.newTab().setText("Published"));

        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        TabAdapter adapter = new TabAdapter(fragmentManager, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new EditProfile());
            }
        });


        return root;
    }


    private void init(final View root) {
        editbtn = root.findViewById(R.id.edit_btn);
        tabLayout = root.findViewById(R.id.tab_layout);
        viewPager2 = root.findViewById(R.id.viewPager2);
    }

    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();

    }
}