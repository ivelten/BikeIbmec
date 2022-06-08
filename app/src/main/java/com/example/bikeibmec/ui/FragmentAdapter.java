package com.example.bikeibmec.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bikeibmec.ui.sobre.ContatoFragment;
import com.example.bikeibmec.ui.sobre.RedesSociaisFragment;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStateAdapter {
    private final ArrayList<Fragment> fragments = new ArrayList<>();
    private final ArrayList<String> fragmentTitles = new ArrayList<>();

    public FragmentAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    public void insertFragment(Fragment fragment, String fragmentTitle) {
        fragments.add(fragment);
        fragmentTitles.add(fragmentTitle);
    }

    public String getFragmentTitle(int position) {
        return fragmentTitles.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
