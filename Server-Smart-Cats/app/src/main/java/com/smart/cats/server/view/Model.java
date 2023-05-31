/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smart.cats.server.view;

import com.smart.cats.server.logic.ClienteHandler;
import com.smart.cats.server.logic.ServerSocketHandler;
import java.io.IOException;
import java.net.Socket;
import java.sql.ClientInfoStatus;
import java.util.List;

/**
 *
 * @author 57313
 */
public class Model {

    private Controller controller;
    private ServerSocketHandler serverSocketHandler;

    public Model() {
        new Thread() {
            public void run() {
                initServer();
            }
        }.start();
        
    }

    private void initServer() {

        
        int port = 5000;
        try {
            this.serverSocketHandler = new ServerSocketHandler(port);
            this.serverSocketHandler.setModel(this);
            serverSocketHandler.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ClienteHandler> getClients() {
        return serverSocketHandler.getClients();
    }
    
    public void updateClients(){
        controller.loadClients();
    }
    

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    

}
