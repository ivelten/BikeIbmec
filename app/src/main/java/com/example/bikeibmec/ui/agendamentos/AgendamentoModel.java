package com.example.bikeibmec.ui.agendamentos;

import com.google.android.gms.maps.model.LatLng;

import java.text.DateFormat;
import java.util.Date;

public class AgendamentoModel {

    private Date data;
    private int tempoEmHoras;
    private LatLng localRetirada;
    private LatLng localEntrega;

    public AgendamentoModel(
        Date data,
        int tempoEmHoras,
        LatLng localRetirada,
        LatLng localEntrega
    ) {
        this.data = data;
        this.tempoEmHoras = tempoEmHoras;
        this.localRetirada = localRetirada;
        this.localEntrega = localEntrega;
    }

    public Date getData() { return data; }

    public int getTempoEmHoras() { return tempoEmHoras; }

    public LatLng getLocalRetirada() { return localRetirada; }

    public LatLng getLocalEntrega() { return localEntrega; }

    @Override
    public String toString() {
        DateFormat dateFormat = DateFormat.getInstance();
        return "Data: " + dateFormat.format(data) + "(" + tempoEmHoras + " horas)";
    }
}
