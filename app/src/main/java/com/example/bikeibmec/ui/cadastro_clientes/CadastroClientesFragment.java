package com.example.bikeibmec.ui.cadastro_clientes;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bikeibmec.R;
import com.example.bikeibmec.databinding.FragmentCadastroClientesBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class CadastroClientesFragment extends Fragment {

    private FragmentCadastroClientesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        CadastroClientesViewModel cadastroClientesViewModel =
                new ViewModelProvider(this).get(CadastroClientesViewModel.class);

        binding = FragmentCadastroClientesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MaterialButton materialButton = binding.cadastroClientesSubmit;

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onClickSubmit(root);

            }
        });

//        final TextView textView = binding.textCadastroClientes;
//        cadastroClientesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    void onClickSubmit(View root){

        ClienteModel clienteModel = criaClienteModel(root);

        if(!validaCliente(clienteModel)) {
            takeAction();
        } else {
            goToConfirmationPage(clienteModel);
        }
    }

    ClienteModel criaClienteModel(View root){

        MaterialRadioButton mrbSexo = root.findViewById(binding.cadastroClientesSexo.getCheckedRadioButtonId());
        MaterialRadioButton mrbBandeira = root.findViewById(binding.cadastroClientesCartaoBandeira.getCheckedRadioButtonId());

        List<String> cursos = new ArrayList<String>();
        if(binding.cadastroClientesCursoEngComp.isChecked())
            cursos.add(String.valueOf(binding.cadastroClientesCursoEngComp.getEditableText()));
        if(binding.cadastroClientesCursoEngCiv.isChecked())
            cursos.add(String.valueOf(binding.cadastroClientesCursoEngCiv.getEditableText()));
        if(binding.cadastroClientesCursoEngProd.isChecked())
            cursos.add(String.valueOf(binding.cadastroClientesCursoEngProd.getEditableText()));
        if(binding.cadastroClientesCursoEngMec.isChecked())
            cursos.add(String.valueOf(binding.cadastroClientesCursoEngMec.getEditableText()));

        return new ClienteModel(
                String.valueOf(binding.cadastroClientesMatricula.getEditText()),
                String.valueOf(binding.cadastroClientesNome.getEditText()),
                String.valueOf(binding.cadastroClientesSobrenome.getEditText()),
                String.valueOf(mrbSexo.getEditableText()),
                cursos,
                String.valueOf(binding.cadastroClientesCelular.getEditText()),
                String.valueOf(binding.cadastroClientesEmail.getEditText()),
                String.valueOf(mrbBandeira.getEditableText()),
                String.valueOf(binding.cadastroClientesCartaoNumero.getEditText()),
                String.valueOf(binding.cadastroClientesCartaoTitular.getEditText()),
                String.valueOf(binding.cadastroClientesCartaoValidade.getEditText()),
                String.valueOf(binding.cadastroClientesCartaoCv.getEditText())
        );
    }

    void takeAction(){
        //TODO
    }

    boolean validaCliente(ClienteModel clienteModel){
        //TODO
        return false;
    }

    void goToConfirmationPage(ClienteModel clienteModel){
        //TODO
    }

}