package com.example.bikeibmec.ui.agendamentos;

import java.util.List;

public class AgendamentosModel {

    private List<AgendamentoModel> agendamentos;

    public AgendamentosModel(List<AgendamentoModel> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public List<AgendamentoModel> getAgendamentos() { return agendamentos; }
}
