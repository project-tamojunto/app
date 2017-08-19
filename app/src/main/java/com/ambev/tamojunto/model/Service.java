package com.ambev.tamojunto.model;

/**
 * Created by matheuscatossi on 19/08/17.
 */

public class Service {
    private String nome;
    private String preco;
    private String descricao;
    private String servicosAdicionais;
    private String lat;
    private String lng;
    private int idCategoria;

    public Service(String nome, String preco, String descricao, String servicosAdicionais, String lat, String lng, int idCategoria) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.servicosAdicionais = servicosAdicionais;
        this.lat = lat;
        this.lng = lng;
        this.idCategoria = idCategoria;
    }

    public Service() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
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

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
