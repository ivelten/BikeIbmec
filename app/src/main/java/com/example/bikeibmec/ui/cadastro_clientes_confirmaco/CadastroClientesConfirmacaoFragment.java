package com.example.bikeibmec.ui.cadastro_clientes_confirmaco;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.bikeibmec.databinding.FragmentCadastroClientesConfirmacaoBinding;
import com.example.bikeibmec.ui.cadastro_clientes.CadastroClientesFragment;
import com.example.bikeibmec.ui.cadastro_clientes.ClienteModel;
import com.google.android.material.button.MaterialButton;

public class CadastroClientesConfirmacaoFragment extends Fragment {

    private FragmentCadastroClientesConfirmacaoBinding binding;
    private CadastroClientesConfirmacaoViewModel cadastroClientesConfirmacaoViewModel;
//    private CadastroClientesViewModel cadastroClientesViewModel;

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

        setClients();

        return root;
    }

    void setClients(){

        Bundle bundle = this.getArguments();

        if(bundle != null){

            ClienteModel clienteModel = (ClienteModel) bundle.get("cliente");

            binding.cadastroClientesConfirmacaoMatricula.getEditText()
                    .setText(clienteModel.getMatricula());

            binding.cadastroClientesConfirmacaoNome.getEditText()
                    .setText(clienteModel.getNome());

            binding.cadastroClientesConfirmacaoSobrenome.getEditText()
                    .setText(clienteModel.getSobrenome());

            binding.cadastroClientesConfirmacaoSexo.getEditText()
                    .setText(clienteModel.getSexo());

            //TODO se todos selecionados, texto sai de vista. Concertar futuramente
            binding.cadastroClientesConfirmacaoCurso.getEditText()
                    .setText(clienteModel.getCursos().toString());

            binding.cadastroClientesConfirmacaoCelular.getEditText()
                    .setText(clienteModel.getCelular());

            binding.cadastroClientesConfirmacaoEmail.getEditText()
                    .setText(clienteModel.getEmail());

            binding.cadastroClientesConfirmacaoCartaoBandeira.getEditText()
                    .setText(clienteModel.getCartaoBandeira());

            binding.cadastroClientesConfirmacaoCartaoNumero.getEditText()
                    .setText(clienteModel.getCartaoNumero());

            binding.cadastroClientesConfirmacaoCartaoTitular.getEditText()
                    .setText(clienteModel.getCartaoTitular());

            binding.cadastroClientesConfirmacaoCartaoValidade.getEditText()
                    .setText(clienteModel.getCartaoValidade());

            binding.cadastroClientesConfirmacaoCartaoCv.getEditText()
                    .setText(clienteModel.getCartaoCv());
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    void cancel(@NonNull View container){

        CadastroClientesFragment cadastroClientesFragment = new CadastroClientesFragment();
        cadastroClientesFragment.setArguments(this.getArguments());


        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(container.getId(),cadastroClientesFragment);
        ft.commit();
    }

    void confirm(@NonNull View container){

        Toast.makeText(getActivity().getApplicationContext(),
                "Cliente cadastrado com sucesso!",
                Toast.LENGTH_SHORT).show();

        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(container.getId(), new CadastroClientesFragment());
        ft.commit();
    }

}