/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smart.cats.server.view;

import com.smart.cats.server.logic.ClienteHandler;
import java.util.stream.Collectors;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author 57313
 */
public class Controller {
    
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
    }
    
    

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    public void loadClients(){
         view.getjPanel1().removeAll();
        int i = 1;
        var sizeY = 0;
        for (ClienteHandler elemento : model.getClients()) {
            JTextPane txf = new JTextPane();
            
            txf.setBounds(0, sizeY, 1000, 300);
            sizeY += 300;
            txf.setName("Cliente: " + i);
            txf.setText("Cliente: " + i + " -> " +elemento.getMesagges().stream().map(String::toString).collect(Collectors.joining(" // ")));
            i++;
            view.getjPanel1().add(txf);
            view.getjPanel1().revalidate();
            view.getjPanel1().repaint();
            System.out.println("ENTRA");
            
        }
        System.out.println("se cargaron clientes: " + model.getClients().size() );
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
    
    
    
    
}
