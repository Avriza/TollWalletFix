package com.example.myapplication;

public class Transaksi {
    public  String gateIn, gateOut, tarif, date;

    public Transaksi(String gateIn, String gateOut, String tarif, String date) {
        this.gateIn = gateIn;
        this.gateOut = gateOut;
        this.tarif = tarif;
        this.date = date;
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

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
