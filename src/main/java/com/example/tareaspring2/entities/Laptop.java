package com.example.tareaspring2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String fabricante;
    private Integer ano;
    private Double wifi;

    public Laptop() {
    }

    public Laptop(Long id, String modelo, String fabricante, Integer ano, Double wifi) {
        this.id = id;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.ano = ano;
        this.wifi = wifi;
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

    public Double getWifi() {
        return wifi;
    }

    public void setWifi(Double wifi) {
        this.wifi = wifi;
    }
}
