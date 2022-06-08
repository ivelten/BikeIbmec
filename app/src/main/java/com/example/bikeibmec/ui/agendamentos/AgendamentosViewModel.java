package com.example.bikeibmec.ui.agendamentos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bikeibmec.ui.pedaladas.PedaladasModel;

public class AgendamentosViewModel extends ViewModel {

    private final MutableLiveData<AgendamentosModel> mAgendamentos;

    public AgendamentosViewModel() {
        mAgendamentos = new MutableLiveData<>();
    }

    public AgendamentosViewModel(AgendamentosModel agendamentos) {
        mAgendamentos = new MutableLiveData<>(agendamentos);
    }

    public LiveData<AgendamentosModel> getAgendamentos() { return mAgendamentos; }

    public void setAgendamentos(AgendamentosModel agendamentos) { mAgendamentos.setValue(agendamentos); }
}