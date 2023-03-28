/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.smartcats.presentacion;

/**
 *
 * @author 57313
 */
public class Modelo extends Thread{
    
    private Controlador controlador;

    public Modelo(Controlador controlador) {
        this.controlador = controlador;
    }
    
    
    
    public void limpiarArenero(){
        controlador.setImageLabel(controlador.getVentana().getArenero(), "src/co/com/smartcats/img/arenero-lim.png");
        controlador.setImageLabel(controlador.getVentana().getPala(), "");
        controlador.setSandboxDirty(false);
        
    }

    @Override
    public void run() {
        try {
            
            
            controlador.setImageLabel(controlador.getVentana().getPala(), "src/co/com/smartcats/img/pala.png");
            
            controlador.getVentana().getPala().setLocation(controlador.getVentana().getArenero().getLocation());
            
            int distancia = controlador.getVentana().getArenero().getX() +  controlador.getVentana().getArenero().getWidth();
            
            while (controlador.getVentana().getPala().getX() < distancia) {
                sleep((long) (Math.random() * 1000));
                controlador.getVentana().getPala().setLocation(controlador.getVentana().getPala().getLocation().x + 5, controlador.getVentana().getPala().getLocation().y);
                //controlador.getVentana().getPala().repaint();
            }
            
            limpiarArenero();
            
        } catch (InterruptedException e) {
        }
    }
    
    
}
