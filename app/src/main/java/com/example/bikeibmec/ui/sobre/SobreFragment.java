package com.example.bikeibmec.ui.sobre;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bikeibmec.R;
import com.example.bikeibmec.databinding.FragmentSobreBinding;
import com.example.bikeibmec.ui.FragmentAdapter;
import com.google.android.material.tabs.TabLayoutMediator;

public class SobreFragment extends Fragment {

    private FragmentSobreBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SobreViewModel sobreViewModel =
                new ViewModelProvider(this).get(SobreViewModel.class);

        binding = FragmentSobreBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

        FragmentAdapter fragmentAdapter = new FragmentAdapter(this);

        fragmentAdapter.insertFragment(new ContatoFragment(), "Contato");
        fragmentAdapter.insertFragment(new RedesSociaisFragment(), "Redes Sociais");

        binding.viewPager.setAdapter(fragmentAdapter);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
           String title = fragmentAdapter.getFragmentTitle(position);
           tab.setText(title);
        }).attach();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}