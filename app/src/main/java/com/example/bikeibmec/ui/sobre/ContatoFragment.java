package com.example.bikeibmec.ui.sobre;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bikeibmec.R;

public class ContatoFragment extends Fragment {

    private final String emailAddress = "bike@veigadealmeida.br";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contato, container, false);

        Button sendEmailButton = view.findViewById(R.id.sendEmailButton);

        sendEmailButton.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", emailAddress, null));

            startActivity(emailIntent);
        });

        TextView emailTextView = view.findViewById(R.id.emailTextView);

        emailTextView.setOnClickListener(v -> {
            copyTextToClipboard("E-mail copiado para a área de transferência", emailAddress);
        });

        Button openWebSiteButton = view.findViewById(R.id.openWebSiteButton);

        openWebSiteButton.setOnClickListener(v -> {
            openWebAddress("https://uva.br/");
        });

        return view;
    }

    void openWebAddress(String address) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
        startActivity(browserIntent);
    }

    void copyTextToClipboard(String message, String textToCopy) {
        ClipboardManager clipboard = getSystemService(getContext(), ClipboardManager.class);
        ClipData clip = ClipData.newPlainText(message, textToCopy);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
    }
}