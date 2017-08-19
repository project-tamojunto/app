package com.ambev.tamojunto.model;

/**
 * Created by matheuscatossi on 19/08/17.
 */

public class Data {
    private String data;
    private String horarioIni;
    private String horarioFim;
    private int qtdVagas;

    public Data(String data, String horarioIni, String horarioFim, int qtdVagas) {
        this.data = data;
        this.horarioIni = horarioIni;
        this.horarioFim = horarioFim;
        this.qtdVagas = qtdVagas;
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
}
