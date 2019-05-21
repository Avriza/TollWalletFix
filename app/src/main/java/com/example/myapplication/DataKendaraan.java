package com.example.myapplication;

public class DataKendaraan {
    private String platNo, tipe;
    public DataKendaraan(){}

    public DataKendaraan(String platNo, String tipe){
        this.platNo=platNo;
        this.tipe=tipe;
    }

    public String getPlatNo() {
        return platNo;
    }

    public void setPlatNo(String platNo) {
        this.platNo = platNo;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
}
