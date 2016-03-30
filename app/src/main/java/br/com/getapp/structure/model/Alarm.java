package br.com.getapp.structure.model;

import java.util.HashMap;

/**
 * Created by matheusoliveira on 09/03/2016.
 */
public class Alarm {

    private int ID;

    private String hora;
    private String minuto;

    private String segunda = "no";
    private String terca = "no";
    private String quarta = "no";
    private String quinta = "no";
    private String sexta = "no";
    private String sabado = "no";
    private String domingo = "no";

    public Alarm(String hora, String minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public Alarm() {

    }

    public String getSegunda() {
        return segunda;
    }

    public void setSegunda(String segunda) {
        this.segunda = segunda;
    }

    public String getTerca() {
        return terca;
    }

    public void setTerca(String terca) {
        this.terca = terca;
    }

    public String getQuarta() {
        return quarta;
    }

    public void setQuarta(String quarta) {
        this.quarta = quarta;
    }

    public String getQuinta() {
        return quinta;
    }

    public void setQuinta(String quinta) {
        this.quinta = quinta;
    }

    public String getSexta() {
        return sexta;
    }

    public void setSexta(String sexta) {
        this.sexta = sexta;
    }

    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sabado) {
        this.sabado = sabado;
    }

    public String getDomingo() {
        return domingo;
    }

    public void setDomingo(String domingo) {
        this.domingo = domingo;
    }

    public String getHora() {
        return hora;
    }

    public String getMinuto() {
        return minuto;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }
}
