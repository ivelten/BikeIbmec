package com.example.bikeibmec.ui.missao;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.bikeibmec.databinding.FragmentMissaoBinding;

import com.example.bikeibmec.R;

public class MissaoFragment extends Fragment {

    private FragmentMissaoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MissaoViewModel missaoViewModel =
                new ViewModelProvider(this).get(MissaoViewModel.class);

        binding = FragmentMissaoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMissao;
        missaoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}