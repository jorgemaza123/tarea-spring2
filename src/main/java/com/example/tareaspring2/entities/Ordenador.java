package com.example.tareaspring2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ordenadores")
public class Ordenador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String fabricante;
    private Integer ano;

    public Ordenador() {
    }

    public Ordenador(Long id, String modelo, String fabricante, Integer ano) {
        this.id = id;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.ano = ano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
