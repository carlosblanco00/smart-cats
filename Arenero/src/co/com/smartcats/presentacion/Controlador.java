/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.smartcats.presentacion;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author 57313
 */
public class Controlador extends MouseAdapter {

    private Vista ventana;
    private Modelo modelo;
    private boolean SandboxDirty;

    public Controlador(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        int x = e.getX() + ventana.getGato().getX() - ventana.getGato().getWidth() / 2;
        int y = e.getY() + ventana.getGato().getY() - ventana.getGato().getHeight() / 2;

        ventana.getGato().setLocation(x, y);
        
        if(gatoEstaEnArenero() && !SandboxDirty){
            System.out.println("ENTRA GATO");
            SandboxDirty = true;
            setImageLabel(ventana.getArenero(),"src/co/com/smartcats/img/arenero-suc.png");
            
        }
        
        if(!gatoEstaEnArenero() && SandboxDirty){
            //modelo.limpiarArenero();
            
            new Modelo(this).start();
            
            System.out.println("Limpiar");
        }

        

    }
    
    private boolean gatoEstaEnArenero(){
        if (ventana.getGato().getX() > 45 && ventana.getGato().getX() < 305 && ventana.getGato().getX() + ventana.getGato().getWidth() > 45 && ventana.getGato().getX() + ventana.getGato().getWidth() < 305) {

            if (ventana.getGato().getY() + ventana.getGato().getHeight() > 400 && ventana.getGato().getY() + ventana.getGato().getHeight() < 480) {
                return true;
            }
        }
        return false;
        
    }

    public void setImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        labelName.repaint();
        //this.ventana.repaint();
    }

    public Vista getVentana() {
        return ventana;
    }

    public void setVentana(Vista ventana) {
        this.ventana = ventana;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public boolean isSandboxDirty() {
        return SandboxDirty;
    }

    public void setSandboxDirty(boolean isSandboxDirty) {
        this.SandboxDirty = isSandboxDirty;
    }
    

}
