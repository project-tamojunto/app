package com.ambev.tamojunto.model;

import java.util.ArrayList;

/**
 * Created by matheuscatossi on 19/08/17.
 */

public class Service {

    private int id;
    private String nome;
    private double preco;
    private String descricao;
    private String servicosAdicionais;
    private String latitude;
    private String longitude;
    private String categoria;
    private ArrayList<ListaAgenda> listaAgenda;

    public Service(int id, String nome, double preco, String descricao, String servicosAdicionais, String latitude, String longitude, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.servicosAdicionais = servicosAdicionais;
        this.latitude = latitude;
        this.longitude = longitude;
        this.categoria = categoria;
    }

    public Service(int id, String nome, double preco, String descricao, String servicosAdicionais, String latitude, String longitude, String categoria, ArrayList<ListaAgenda> listaAgenda) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.servicosAdicionais = servicosAdicionais;
        this.latitude = latitude;
        this.longitude = longitude;
        this.categoria = categoria;
        this.listaAgenda = listaAgenda;
    }


    public ArrayList<ListaAgenda> getListaAgenda() {
        return listaAgenda;
    }

    public void setListaAgenda(ArrayList<ListaAgenda> listaAgenda) {
        this.listaAgenda = listaAgenda;
    }

    public Service() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getServicosAdicionais() {
        return servicosAdicionais;
    }

    public void setServicosAdicionais(String servicosAdicionais) {
        this.servicosAdicionais = servicosAdicionais;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCategoria() {

        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
