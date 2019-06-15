package com.example.myapplication;

public class Transaksi {
    public  String dateIn, dateOut, gateIn, gateOut, isPaid, tarif, tipe;

    public Transaksi(){}

    public Transaksi(String dateIn, String dateOut, String gateIn, String gateOut, String isPaid, String tarif, String tipe) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.gateIn = gateIn;
        this.gateOut = gateOut;
        this.isPaid = isPaid;
        this.tarif = tarif;
        this.tipe = tipe;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getGateIn() {
        return gateIn;
    }

    public void setGateIn(String gateIn) {
        this.gateIn = gateIn;
    }

    public String getGateOut() {
        return gateOut;
    }

    public void setGateOut(String gateOut) {
        this.gateOut = gateOut;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
}
