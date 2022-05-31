package com.example.bikeibmec.ui.cadastro_clientes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CadastroClientesViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public CadastroClientesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Cadastro Clientes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}