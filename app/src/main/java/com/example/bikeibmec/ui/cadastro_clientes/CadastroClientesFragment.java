package com.example.bikeibmec.ui.cadastro_clientes;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.bikeibmec.R;
import com.example.bikeibmec.databinding.FragmentCadastroClientesBinding;
import com.example.bikeibmec.ui.cadastro_clientes_confirmaco.CadastroClientesConfirmacaoFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CadastroClientesFragment extends Fragment {

    private FragmentCadastroClientesBinding binding;
    private CadastroClientesViewModel cadastroClientesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        cadastroClientesViewModel =
                new ViewModelProvider(this).get(CadastroClientesViewModel.class);

        binding = FragmentCadastroClientesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setClients();

        MaterialButton materialButton = binding.cadastroClientesSubmit;

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onClickSubmit(container);

            }
        });

        addListeners();

        return root;
    }

    void addListeners(){

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

        // new PhoneNumberFormattingTextWatcher("BR")
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
        Bundle bundle = new Bundle();
        bundle.putSerializable("cliente",clienteModel);

        goToConfirmationPage(root, bundle);
    }

    ClienteModel criaClienteModel(@NonNull View root){

        String sexo = null;
        if(binding.cadastroClientesSexo.getCheckedRadioButtonId() != -1){
            MaterialRadioButton mrbSexo = root.findViewById(binding.cadastroClientesSexo.getCheckedRadioButtonId());
            sexo = mrbSexo.getText().toString();
        } else {
            sexo = "";
        }

        String bandeira = null;
        if(binding.cadastroClientesCartaoBandeira.getCheckedRadioButtonId() != -1){
            MaterialRadioButton mrbBandeira = root.findViewById(binding.cadastroClientesCartaoBandeira.getCheckedRadioButtonId());
            bandeira = mrbBandeira.getText().toString();
        } else {
            bandeira = "";
        }

        List<String> cursos = new ArrayList<String>();
        if(binding.cadastroClientesCursoEngComp.isChecked())
            cursos.add(binding.cadastroClientesCursoEngComp.getText().toString());
        if(binding.cadastroClientesCursoEngCiv.isChecked())
            cursos.add(binding.cadastroClientesCursoEngCiv.getText().toString());
        if(binding.cadastroClientesCursoEngProd.isChecked())
            cursos.add(binding.cadastroClientesCursoEngProd.getText().toString());
        if(binding.cadastroClientesCursoEngMec.isChecked())
            cursos.add(binding.cadastroClientesCursoEngMec.getText().toString());

        ClienteModel clienteModel = new ClienteModel(
                binding.cadastroClientesMatricula.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesMatricula.getEditText().getText()),
                binding.cadastroClientesNome.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesNome.getEditText().getText()),
                binding.cadastroClientesSobrenome.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesSobrenome.getEditText().getText()),
                sexo,
                cursos,
                binding.cadastroClientesCelular.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesCelular.getEditText().getText()),
                binding.cadastroClientesEmail.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesEmail.getEditText().getText()),
                bandeira,
                binding.cadastroClientesCartaoNumero.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesCartaoNumero.getEditText().getText()),
                binding.cadastroClientesCartaoTitular.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesCartaoTitular.getEditText().getText()),
                binding.cadastroClientesCartaoValidade.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesCartaoValidade.getEditText().getText()),
                binding.cadastroClientesCartaoCv.getEditText() == null ? "" : String.valueOf(binding.cadastroClientesCartaoCv.getEditText().getText())
        );



        return clienteModel;

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

    boolean validaRadioGroup(@NonNull RadioGroup radioGroup){

        if(radioGroup.getCheckedRadioButtonId() == -1) {
            return false;
        }

        return true;
    }

    boolean validaCheckList(@NonNull List<MaterialCheckBox> checkBoxes, int min, int max){

        int nChecked = 0;

        for(MaterialCheckBox checkBox : checkBoxes){

            if(checkBox.isChecked()) {
                nChecked++;
            }

        }

        if(nChecked < min || nChecked > max)
            return false;

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

        boolean valid = valida(binding.cadastroClientesMatricula,
                "^[^\\s]*\\d+[^\\s]*$", getResources().getInteger(R.integer.matricula_length_min), getResources().getInteger(R.integer.matricula_length_max));

        Log.d("Validacao", "Valida Matricula: "+valid);

        return valid;

    }

    boolean validaNome(){

        boolean valid = validaNomeGenerico(binding.cadastroClientesNome,
                getResources().getInteger(R.integer.nome_length_min), getResources().getInteger(R.integer.nome_length_max));

        Log.d("Validacao", "Valida Nome: "+valid);

        return valid;
    }

    boolean validaSobrenome() {

        boolean valid = validaNomeGenerico(binding.cadastroClientesSobrenome,
                getResources().getInteger(R.integer.sobrenome_length_min), getResources().getInteger(R.integer.sobrenome_length_max));

        Log.d("Validacao", "Valida Sobrenome: "+valid);

        return valid;
    }

    boolean validaSexo(){
        boolean valid = validaRadioGroup(binding.cadastroClientesSexo);

        Log.d("Validacao", "Valida Sexo: "+valid);

        return valid;
    }

    boolean validaCurso(){
        List<MaterialCheckBox> checkBoxes = new ArrayList<MaterialCheckBox>();

        checkBoxes.add(binding.cadastroClientesCursoEngComp);
        checkBoxes.add(binding.cadastroClientesCursoEngCiv);
        checkBoxes.add(binding.cadastroClientesCursoEngProd);
        checkBoxes.add(binding.cadastroClientesCursoEngMec);

        boolean valid = validaCheckList(checkBoxes, 1, checkBoxes.size());

        Log.d("Validacao", "Valida Curso: "+valid);

        return valid;
    }

    boolean validaCelular(){

        boolean valid = valida(binding.cadastroClientesCelular,
                "\\d+", getResources().getInteger(R.integer.celular_length_min), getResources().getInteger(R.integer.celular_length_max));

        Log.d("Validacao", "Valida Celular: "+valid);

        return valid;
    }

    boolean validaEmail(){
        boolean valid = valida(binding.cadastroClientesEmail,
                "^[\\p{Alnum}_\\-.]+@([\\p{Alnum}_\\-]+\\.)+[\\p{Alnum}_\\-]{2,4}$",
                getResources().getInteger(R.integer.email_length_min), getResources().getInteger(R.integer.email_length_max));

        Log.d("Validacao", "Valida Email: "+valid);

        return valid;
    }

    boolean validaCartaoBandeira(){
        boolean valid = validaRadioGroup(binding.cadastroClientesCartaoBandeira);

        Log.d("Validacao", "Valida Cartao Bandeira: "+valid);

        return valid;
    }

    boolean validaCartaoNumero(){
        boolean valid = valida(binding.cadastroClientesCartaoNumero,"\\d+",
                getResources().getInteger(R.integer.cartao_numero_length_min), getResources().getInteger(R.integer.cartao_numero_length_max));

        Log.d("Validacao", "Valida Cartao Numero: "+valid);

        return valid;
    }

    boolean validaCartaoTitular() {
        boolean valid = validaNomeGenerico(binding.cadastroClientesCartaoTitular,
                getResources().getInteger(R.integer.cartao_titular_length_min), getResources().getInteger(R.integer.cartao_titular_length_max));

        Log.d("Validacao", "Valida Cartao Titular: "+valid);

        return valid;
    }

    boolean validaValidade(){

        TextInputLayout in = binding.cadastroClientesCartaoValidade;

        boolean valid = true;

        if( ! validaLength(in ,5,5) ) {

            valid = false;
        } else {

            String sDate = in.getEditText() == null ? "" : String.valueOf(in.getEditText().getText());

            valid = false;

            try {

                YearMonth.parse(sDate,
                        DateTimeFormatter.ofPattern( "MM/uu" )
                );

                valid = true;

            } catch (DateTimeParseException e) {
                e.printStackTrace();
                valid = false;
            }
        }

        if(valid){

            in.setError(null);

        } else {

            in.requestFocus();
            in.setError("Campo deve ser valido.");

        }

        Log.d("Validacao", "Valida Cartao Validade: "+valid);

        return valid;
    }

    boolean validaCv(){
        boolean valid = valida(binding.cadastroClientesCartaoCv,"\\d+",
                getResources().getInteger(R.integer.cartao_cv_length_min), getResources().getInteger(R.integer.cartao_cv_length_max));

        Log.d("Validacao", "Valida Cartao CV: "+valid);

        return valid;
    }

    void takeAction(){

        Toast toast = Toast.makeText(
                getActivity().getApplicationContext(),
                "Entre com valores validos nos campos!",
                Toast.LENGTH_SHORT
        );

        toast.show();
    }

    void goToConfirmationPage(@NonNull View container, Bundle bundle){
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();

        CadastroClientesConfirmacaoFragment cadastroClientesConfirmacaoFragment = new CadastroClientesConfirmacaoFragment();

        cadastroClientesConfirmacaoFragment.setArguments(bundle);

        ft.replace(container.getId(), cadastroClientesConfirmacaoFragment);
        ft.commit();
    }

    void setClients(){

        Bundle bundle = this.getArguments();

        if(bundle != null){

            ClienteModel clienteModel = (ClienteModel) bundle.get("cliente");

            binding.cadastroClientesMatricula.getEditText()
                    .setText(clienteModel.getMatricula());

            binding.cadastroClientesNome.getEditText()
                    .setText(clienteModel.getNome());

            binding.cadastroClientesSobrenome.getEditText()
                    .setText(clienteModel.getSobrenome());

            if(binding.cadastroClientesSexoMasculino.getText().toString().equals(clienteModel.getSexo()))
                binding.cadastroClientesSexoMasculino.setChecked(true);
            else
                binding.cadastroClientesSexoFeminino.setChecked(true);

            //TODO curso
            for(String curso:clienteModel.getCursos()){
                if(curso.equals(binding.cadastroClientesCursoEngComp.getText().toString()))
                    binding.cadastroClientesCursoEngComp.setChecked(true);
                else if(curso.equals(binding.cadastroClientesCursoEngCiv.getText().toString()))
                    binding.cadastroClientesCursoEngCiv.setChecked(true);
                else if(curso.equals(binding.cadastroClientesCursoEngProd.getText().toString()))
                    binding.cadastroClientesCursoEngProd.setChecked(true);
                else if(curso.equals(binding.cadastroClientesCursoEngMec.getText().toString()))
                    binding.cadastroClientesCursoEngMec.setChecked(true);
            }

            binding.cadastroClientesCelular.getEditText()
                    .setText(clienteModel.getCelular());

            binding.cadastroClientesEmail.getEditText()
                    .setText(clienteModel.getEmail());

            //TODO cartao bandeira
            String cartaoBandeira = clienteModel.getCartaoBandeira();
            if(cartaoBandeira.equals(binding.cadastroClientesCartaoBandeiraElo.getText().toString()))
                binding.cadastroClientesCartaoBandeiraElo.setChecked(true);
            if(cartaoBandeira.equals(binding.cadastroClientesCartaoBandeiraMastercard.getText().toString()))
                binding.cadastroClientesCartaoBandeiraMastercard.setChecked(true);
            if(cartaoBandeira.equals(binding.cadastroClientesCartaoBandeiraVisa.getText().toString()))
                binding.cadastroClientesCartaoBandeiraVisa.setChecked(true);

            binding.cadastroClientesCartaoNumero.getEditText()
                    .setText(clienteModel.getCartaoNumero());

            binding.cadastroClientesCartaoTitular.getEditText()
                    .setText(clienteModel.getCartaoTitular());

            binding.cadastroClientesCartaoValidade.getEditText()
                    .setText(clienteModel.getCartaoValidade());

            binding.cadastroClientesCartaoCv.getEditText()
                    .setText(clienteModel.getCartaoCv());
        }

    }

}