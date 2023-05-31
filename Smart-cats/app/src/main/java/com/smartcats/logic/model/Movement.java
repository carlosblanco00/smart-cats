/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcats.logic.model;

/**
 *
 * @author 57313
 */
public class Movement {
    private Integer gatoId;
    private String componente;

    public Movement(Integer gatoId, String componente) {
        this.gatoId = gatoId;
        this.componente = componente;
    }

    public Integer getGatoId() {
        return gatoId;
    }

    public void setGatoId(Integer gatoId) {
        this.gatoId = gatoId;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }
    
    
}
