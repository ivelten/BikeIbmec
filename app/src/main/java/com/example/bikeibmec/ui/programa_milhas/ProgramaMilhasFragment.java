package com.example.bikeibmec.ui.programa_milhas;

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
import com.example.bikeibmec.databinding.FragmentProgramaMilhasBinding;

public class ProgramaMilhasFragment extends Fragment {

    private FragmentProgramaMilhasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProgramaMilhasViewModel programaMilhasViewModel =
                new ViewModelProvider(this).get(ProgramaMilhasViewModel.class);

        binding = FragmentProgramaMilhasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textProgramasMilhas;
        programaMilhasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}