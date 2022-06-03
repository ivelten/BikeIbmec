package com.example.bikeibmec.ui.cadastro_clientes;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bikeibmec.R;
import com.example.bikeibmec.databinding.FragmentCadastroClientesBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        addListeners();

//        final TextView textView = binding.textCadastroClientes;
//        cadastroClientesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    void addListeners(){

        //TODO radio e check

        binding.cadastroClientesMatricula.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validaMatricula();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        binding.cadastroClientesNome.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validaNome();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        binding.cadastroClientesSobrenome.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validaSobrenome();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        binding.cadastroClientesCelular.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validaCelular();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        binding.cadastroClientesEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validaEmail();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        binding.cadastroClientesCartaoNumero.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validaCartaoNumero();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        binding.cadastroClientesCartaoTitular.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validaCartaoTitular();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        binding.cadastroClientesCartaoValidade.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validaValidade();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        binding.cadastroClientesCartaoCv.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validaCv();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    void onClickSubmit(View root){

        if(!validaCliente()) {
            takeAction();
            return;
        }

        ClienteModel clienteModel = criaClienteModel(root);

        goToConfirmationPage(clienteModel);
    }

    ClienteModel criaClienteModel(@NonNull View root){



        MaterialRadioButton mrbSexo = binding.cadastroClientesSexo.getCheckedRadioButtonId()==-1 ? null: root.findViewById(binding.cadastroClientesSexo.getCheckedRadioButtonId());
        MaterialRadioButton mrbBandeira = binding.cadastroClientesCartaoBandeira.getCheckedRadioButtonId()==-1 ? null : root.findViewById(binding.cadastroClientesCartaoBandeira.getCheckedRadioButtonId());

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
                binding.cadastroClientesMatricula.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesMatricula.getEditText().getText()),
                binding.cadastroClientesNome.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesNome.getEditText().getText()),
                binding.cadastroClientesSobrenome.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesSobrenome.getEditText().getText()),
                String.valueOf(mrbSexo == null ? "" : mrbSexo.getEditableText()),
                cursos,
                binding.cadastroClientesCelular.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesCelular.getEditText().getText()),
                binding.cadastroClientesEmail.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesEmail.getEditText().getText()),
                String.valueOf(mrbBandeira == null ? "" : mrbBandeira.getEditableText()),
                binding.cadastroClientesCartaoNumero.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesCartaoNumero.getEditText().getText()),
                binding.cadastroClientesCartaoTitular.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesCartaoTitular.getEditText().getText()),
                binding.cadastroClientesCartaoValidade.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesCartaoValidade.getEditText().getText()),
                binding.cadastroClientesCartaoCv.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesCartaoCv.getEditText().getText())
        );
    }

    boolean validaCliente(){

        if(!validaMatricula())
            return false;

        if(!validaNome())
            return false;

        if(!validaSobrenome())
            return false;

        if(!validaSexo())
            return false;

        if(!validaCurso())
            return false;

        if(!validaCelular())
            return false;

        if(!validaEmail())
            return false;

        if(!validaCartaoBandeira())
            return false;

        if(!validaCartaoNumero())
            return false;

        if(!validaCartaoTitular())
            return false;

        if(!validaValidade())
            return false;

        if(!validaCv())
            return false;

        return true;
    }

    boolean validaLength(@NonNull TextInputLayout in, int min_length, int max_length){

        String s = in.getEditText() == null ? "" : String.valueOf(in.getEditText().getText());

        if(s.length() == 0){

            in.requestFocus();
            in.setError("Campo nao deve ser vazio.");

            return false;
        }

        if(min_length == max_length){

            if(s.length() != min_length){

                in.requestFocus();
                in.setError("Campo deve ter " + min_length +" caracteres.");

                return false;
            }

        } else {

            if(s.length() < min_length
                    || s.length() > max_length){

                in.requestFocus();
                in.setError("Campo deve ter de " + min_length + " a " + max_length + " caracteres.");

                return false;
            }

        }

        in.setError(null);

        return true;
    }

    boolean validaRegex(@NonNull TextInputLayout in, String regex){


        String s = in.getEditText() == null ? "" : String.valueOf(in.getEditText().getText());

        if( ! Pattern.compile(regex).
                matcher(s)
                .matches()
        ) {
            in.requestFocus();
            in.setError("Campo deve estar devidamente formatado.");

            return false;
        }

        in.setError(null);

        return true;
    }

    boolean valida(@NonNull TextInputLayout in, String regex, int min_length, int max_length){

        if(!validaLength(in, min_length, max_length))
            return false;

        if(!validaRegex(in, regex))
            return false;

        return true;
    }

    boolean validaNomeGenerico(@NonNull TextInputLayout in, int min_length, int max_length){

        return valida(in, "^[^\\s]*(\\p{Upper}\\p{Lower}+)((\\s\\p{Lower}+)*(\\s\\p{Upper}\\p{Lower}+))*[^\\s]*$", min_length, max_length);
    }

    boolean validaMatricula(){

        return valida(binding.cadastroClientesMatricula,
                "\\d+", getResources().getInteger(R.integer.matricula_length_min), getResources().getInteger(R.integer.matricula_length_max));
    }

    boolean validaNome(){
        return validaNomeGenerico(binding.cadastroClientesNome,
                getResources().getInteger(R.integer.nome_length_min), getResources().getInteger(R.integer.nome_length_max));
    }

    boolean validaSobrenome() {

        return validaNomeGenerico(binding.cadastroClientesSobrenome,
                getResources().getInteger(R.integer.sobrenome_length_min), getResources().getInteger(R.integer.sobrenome_length_max));
    }

    boolean validaSexo(){ return true; }

    boolean validaCurso(){ return true; }

    boolean validaCelular(){

        return valida(binding.cadastroClientesCelular,
                "\\d+", getResources().getInteger(R.integer.celular_length_min), getResources().getInteger(R.integer.celular_length_max));
    }

    boolean validaEmail(){
        return valida(binding.cadastroClientesEmail,
                "^[\\p{Alnum}_\\-.]+@([\\p{Alnum}_\\-]+\\.)+[\\p{Alnum}_\\-]{2,4}$",
                getResources().getInteger(R.integer.email_length_min), getResources().getInteger(R.integer.email_length_max));
    }

    boolean validaCartaoBandeira(){ return true; }

    boolean validaCartaoNumero(){
        return valida(binding.cadastroClientesCartaoNumero,"\\d+",
                getResources().getInteger(R.integer.cartao_numero_length_min), getResources().getInteger(R.integer.cartao_numero_length_max));
    }

    boolean validaCartaoTitular() {
        return validaNomeGenerico(binding.cadastroClientesCartaoTitular,
                getResources().getInteger(R.integer.cartao_titular_length_min), getResources().getInteger(R.integer.cartao_titular_length_max));
    }

    boolean validaValidade(){ return true; }

    boolean validaCv(){
        return valida(binding.cadastroClientesCartaoCv,"\\d+",
                getResources().getInteger(R.integer.cartao_cv_length_min), getResources().getInteger(R.integer.cartao_cv_length_max));
    }

    void takeAction(){

        Toast toast = Toast.makeText(
                getActivity().getApplicationContext(),
                "Entre com valores validos nos campos!",
                Toast.LENGTH_SHORT
        );

        toast.show();
    }

    void goToConfirmationPage(ClienteModel clienteModel){
        //TODO
    }

}