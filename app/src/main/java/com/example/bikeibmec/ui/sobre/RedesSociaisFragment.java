package com.example.bikeibmec.ui.sobre;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.bikeibmec.R;

public class RedesSociaisFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_redes_sociais, container, false);

        ImageView facebookImageView = view.findViewById(R.id.facebookImageView);
        ImageView instagramImageView = view.findViewById(R.id.instagramImageView);
        ImageView twitterImageView = view.findViewById(R.id.twitterImageView);
        ImageView downloadImageView = view.findViewById(R.id.downloadImageView);

        facebookImageView.setOnClickListener(v -> {
            openWebAddress("https://web.facebook.com/veigadealmeida/");
        });

        instagramImageView.setOnClickListener(v -> {
            openWebAddress("https://www.instagram.com/uva_oficial/");
        });

        twitterImageView.setOnClickListener(v -> {
            openWebAddress("https://twitter.com/uva_veiga");
        });

        downloadImageView.setOnClickListener(v -> {
            openWebAddress("https://play.google.com/store/apps/details?id=br.uva.AppUVA&hl=en&gl=US");
        });

        return view;
    }

    void openWebAddress(String address) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
        startActivity(browserIntent);
    }
}