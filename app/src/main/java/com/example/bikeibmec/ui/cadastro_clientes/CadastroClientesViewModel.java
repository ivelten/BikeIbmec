package com.example.bikeibmec.ui.cadastro_clientes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CadastroClientesViewModel extends ViewModel {

    private final MutableLiveData<ClienteModel> mCliente;

    public CadastroClientesViewModel() {
        this.mCliente = new MutableLiveData<ClienteModel>();
    }

    public CadastroClientesViewModel(ClienteModel cliente) {
        this.mCliente = new MutableLiveData<ClienteModel>(cliente);
    }

    public LiveData<ClienteModel> getCliente() {
        return mCliente;
    }

    public void setCliente(ClienteModel cliente){
        this.mCliente.setValue(cliente);
    }

}