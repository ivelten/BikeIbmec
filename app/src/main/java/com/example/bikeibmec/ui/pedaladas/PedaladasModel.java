package com.example.bikeibmec.ui.pedaladas;

import java.util.List;

public class PedaladasModel {

    private List<PedaladaModel> pedaladas;

    public PedaladasModel() {

    }

    public PedaladasModel(List<PedaladaModel> pedaladas) {
        this.pedaladas = pedaladas;
    }

    public List<PedaladaModel> getPedaladas() { return pedaladas; }

    @Override
    public String toString() {
        return "PedaladasModel{" +
                "pedaladas='" + pedaladas + '\'' +
                '}';
    }

}
