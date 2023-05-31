/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcats.logic.model;

/**
 *
 * @author 57313
 */
public class Dish {
    private String img;
    private Double gramos;

    public Dish(String img, Double gramos) {
        this.img = img;
        this.gramos = gramos;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getGramos() {
        return gramos;
    }

    public void setGramos(Double gramos) {
        this.gramos = gramos;
    }
}
