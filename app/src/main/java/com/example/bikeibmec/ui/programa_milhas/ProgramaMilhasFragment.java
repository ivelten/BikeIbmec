package com.example.bikeibmec.ui.programa_milhas;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
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

        final TextView textView = binding.milhasTextView;
        programaMilhasViewModel.getPoints().observe(getViewLifecycleOwner(), textView::setText);

        binding.americanasImageView.setOnClickListener(view -> {
            openWebAddress("https://www.americanas.com.br/");
        });

        binding.magaluImageView.setOnClickListener(view -> {
            openWebAddress("https://www.magazineluiza.com.br/");
        });

        binding.netshoesImageView.setOnClickListener(view -> {
            openWebAddress("https://www.netshoes.com.br/");
        });

        binding.pontoImageView.setOnClickListener(view -> {
            openWebAddress("https://www.pontofrio.com.br/");
        });

        binding.rennerImageView.setOnClickListener(view -> {
            openWebAddress("https://www.lojasrenner.com.br/");
        });

        binding.centauroImageView.setOnClickListener(view -> {
            openWebAddress("https://www.centauro.com.br/");
        });

        return root;
    }

    void openWebAddress(String address) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
        startActivity(browserIntent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}