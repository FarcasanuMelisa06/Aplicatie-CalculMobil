package com.example.loginregister;

public class ProdusClass {
    public String nume;
    public int pret;
    public int cantitate = 0;

    public ProdusClass(){

    }

    public ProdusClass(String nume, int pret, int cantitate){
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    public String getNume() {
        return nume;
    }

    public int getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setCantitate(int cantitate){
        this.cantitate = cantitate;
    }
}
