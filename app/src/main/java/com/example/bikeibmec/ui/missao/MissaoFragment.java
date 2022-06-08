package com.example.bikeibmec.ui.missao;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
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

        String videoID = "PcKXjFCC2f0";

        binding.webView.getSettings().setJavaScriptEnabled(true);

        binding.webView.getSettings().setAllowContentAccess(true);
        WebSettings webSettings = binding.webView.getSettings();
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        binding.webView.canGoBack();
        binding.webView.setWebViewClient(new WebViewClient());

        binding.webView.loadUrl("http://www.youtube.com/embed/" + videoID + "?autoplay=1&vq=small");

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}