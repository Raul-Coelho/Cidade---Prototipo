package com.ifpb.model;


import com.vividsolutions.jts.geom.Geometry;

public class Cidade {
    private String nome;
    private Integer populacao;
    private Integer estado_id;
    private Float area;
    private Geometry geom;

    public Cidade(){};

    public Cidade(String nome, Integer populacao, Integer estado_id, Float area, Geometry geom) {
        this.nome = nome;
        this.populacao = populacao;
        this.estado_id = estado_id;
        this.area = area;
        this.geom = geom;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public Integer getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(Integer estado_id) {
        this.estado_id = estado_id;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }


    @Override
    public String toString() {
        return "CIDADE[" +
                "Nome='" + nome + ", População=" + populacao +
                ", Area=" + area +
                ", Geom=" + geom +
                ']';
    }
}
