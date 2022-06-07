package com.example.bikeibmec.ui.pedaladas;

import java.text.DateFormat;
import java.util.Date;

public class PedaladaModel {

    private double startLat;
    private double startLon;
    private double endLat;
    private double endLon;
    private Date startDate;
    private Date endDate;

    public PedaladaModel() {

    }

    public PedaladaModel(
        double startLat,
        double startLon,
        double endLat,
        double endLon,
        Date startDate,
        Date endDate
    ) {
        this.startLat = startLat;
        this.startLon = startLon;
        this.endLat = endLat;
        this.endLon = endLon;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public double getStartLat() { return startLat; }

    public double getStartLon() { return startLon; }

    public double getEndLat() { return endLat; }

    public double getEndLon() { return endLon; }

    public Date getStartDate() { return startDate; }

    public Date getEndDate() { return endDate; }

    @Override
    public String toString() {
        DateFormat dateFormat = DateFormat.getInstance();
        return "Saída: " + dateFormat.format(startDate) + "\nChegada: " + dateFormat.format(endDate);
    }

}
