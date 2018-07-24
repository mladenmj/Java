package soluzioneAbitativa;

import servizi.Servizio;

import java.util.Map;

public abstract class Camere {
    protected int m2, nMaxPers;
    private String id;
    protected int costoFisso;
    public Map<Servizio, Boolean> services;
    private boolean available;

    public Camere(String id, int m2, int nMaxPers) {
        this.m2 = m2;
        this.nMaxPers = nMaxPers;
        this.id = id;
        this.available = true;
    }

    public int getnMaxPers() {
        return nMaxPers;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public abstract int calcoloCosto();

    @Override
    public String toString() {
        return "Camera:";
    }
}