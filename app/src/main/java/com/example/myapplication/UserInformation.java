package com.example.myapplication;

public class UserInformation {
    public String name, pass, email, alat, plat, saldo;

    public UserInformation(){}

    public UserInformation(String name, String pass, String email, String alat, String plat, String saldo) {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.alat = alat;
        this.plat = plat;
        this.saldo = saldo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlat() {
        return alat;
    }

    public void setAlat(String alat) {
        this.alat = alat;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
}
