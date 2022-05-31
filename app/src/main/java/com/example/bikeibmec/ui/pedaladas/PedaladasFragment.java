package com.example.bikeibmec.ui.pedaladas;

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
import com.example.bikeibmec.databinding.FragmentPedaladasBinding;

public class PedaladasFragment extends Fragment {

    private FragmentPedaladasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PedaladasViewModel pedaladasViewModel =
                new ViewModelProvider(this).get(PedaladasViewModel.class);

        binding = FragmentPedaladasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPedaladas;
        pedaladasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}