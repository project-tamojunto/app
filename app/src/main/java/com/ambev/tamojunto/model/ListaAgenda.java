package com.ambev.tamojunto.model;

/**
 * Created by matheuscatossi on 20/08/17.
 */

public class ListaAgenda {

    private int id;
    private String data;
    private String horarioIni;
    private String horarioFim;
    private int qtdVagas;
    private int qtdOcupadas;

    public ListaAgenda() {

    }

    public ListaAgenda(int id, String data, String horarioIni, String horarioFim, int qtdVagas, int qtdOcupadas) {
        this.id = id;
        this.data = data;
        this.horarioIni = horarioIni;
        this.horarioFim = horarioFim;
        this.qtdVagas = qtdVagas;
        this.qtdOcupadas = qtdOcupadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorarioIni() {
        return horarioIni;
    }

    public void setHorarioIni(String horarioIni) {
        this.horarioIni = horarioIni;
    }

    public String getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(String horarioFim) {
        this.horarioFim = horarioFim;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }

    public void setQtdVagas(int qtdVagas) {
        this.qtdVagas = qtdVagas;
    }

    public int getQtdOcupadas() {
        return qtdOcupadas;
    }

    public void setQtdOcupadas(int qtdOcupadas) {
        this.qtdOcupadas = qtdOcupadas;
    }
}
