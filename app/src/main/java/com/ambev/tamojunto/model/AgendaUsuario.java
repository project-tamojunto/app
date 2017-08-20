package com.ambev.tamojunto.model;

/**
 * Created by matheuscatossi on 20/08/17.
 */

public class AgendaUsuario {

    private int idUsuario;
    private int idAgendaServico;

    public AgendaUsuario(){

    }

    public AgendaUsuario(int idUsuario, int idAgendaServico){
        this.idAgendaServico = idAgendaServico;
        this.idUsuario = idUsuario;
    }
}
