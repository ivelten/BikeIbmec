package com.example.bikeibmec.ui.agendamentos;

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

import com.example.bikeibmec.databinding.FragmentAgendamentosBinding;

public class AgendamentosFragment extends Fragment {

    private FragmentAgendamentosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AgendamentosViewModel agendamentosViewModel =
                new ViewModelProvider(this).get(AgendamentosViewModel.class);

        binding = FragmentAgendamentosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAgendamentos;
        agendamentosViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}