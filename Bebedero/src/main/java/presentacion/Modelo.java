/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

/**
 *
 * @author USUARIO
 */
public class Modelo {
    
    private VistaPrincipal ventana;
    
    
    public void iniciar() {
        // codigo de inicio de app
        ventana = new VistaPrincipal();
        ventana.setSize(900, 500);
        ventana.setVisible(true);
    }
}
