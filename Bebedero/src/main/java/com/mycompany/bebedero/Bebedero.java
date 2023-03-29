/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bebedero;

import presentacion.Modelo;

/**
 *
 * @author USUARIO
 */
public class Bebedero {

    private Modelo miApp = new Modelo();
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Bebedero bebedero = new Bebedero();
        bebedero.Launcher();
    }
    
    public void Launcher(){
        miApp = new Modelo();
        miApp.iniciar();
    }
}
