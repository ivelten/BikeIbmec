package com.example.bikeibmec.ui.cadastro_clientes_confirmaco;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.bikeibmec.databinding.FragmentCadastroClientesConfirmacaoBinding;
import com.example.bikeibmec.ui.cadastro_clientes.CadastroClientesFragment;
import com.example.bikeibmec.ui.cadastro_clientes.CadastroClientesViewModel;
import com.example.bikeibmec.ui.cadastro_clientes.ClienteModel;
import com.google.android.material.button.MaterialButton;

public class CadastroClientesConfirmacaoFragment extends Fragment {

    private FragmentCadastroClientesConfirmacaoBinding binding;
    private CadastroClientesConfirmacaoViewModel cadastroClientesConfirmacaoViewModel;
    private CadastroClientesViewModel cadastroClientesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        cadastroClientesConfirmacaoViewModel =
                new ViewModelProvider(this).get(CadastroClientesConfirmacaoViewModel.class);

        binding = FragmentCadastroClientesConfirmacaoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MaterialButton materialButton = binding.cadastroClientesConfirmacaoCancel;
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel(container);
            }
        });

        materialButton = binding.cadastroClientesConfirmacaoConfirm;
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirm(container);
            }
        });

        Log.d("Confirmacao Cadastro", "Carregando Clientes View Model");

        cadastroClientesViewModel = new ViewModelProvider(requireActivity()).get(CadastroClientesViewModel.class);

        Log.d("Confirmacao Cadastro", "Clientes View Model Carregado");

//        setClients();

        return root;
    }

    void setClients(){
        //TODO
        Log.d("Confirmacao Cadastro", cadastroClientesViewModel.getCliente().toString());
        ClienteModel cliente = cadastroClientesViewModel.getCliente().getValue();
        Log.d("Confirmacao Cadastro", cliente.toString());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    void cancel(@NonNull View container){
        //TODO
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(container.getId(), new CadastroClientesFragment());
        ft.commit();
    }

    void confirm(@NonNull View container){
        //TODO
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(container.getId(), new CadastroClientesFragment());
        ft.commit();
    }

}