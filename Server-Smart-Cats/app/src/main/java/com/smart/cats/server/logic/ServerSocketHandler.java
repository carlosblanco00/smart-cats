/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smart.cats.server.logic;

import com.smart.cats.server.view.Model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 57313
 */
public class ServerSocketHandler {

    private ServerSocket serverSocket;
    
    private Model model;

    private List<ClienteHandler> clients = new ArrayList<>();

    public ServerSocketHandler(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        while (true) {
            try {
                Socket clienteSocket = serverSocket.accept();
                
                // Crear un nuevo hilo para manejar la conexión
                var client = new ClienteHandler(clienteSocket, model);
                Thread hiloCliente = new Thread(client);
                clients.add(client);
                this.model.updateClients();
                hiloCliente.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<ClienteHandler> getClients() {
        return clients;
    }

    public void setClients(List<ClienteHandler> clients) {
        this.clients = clients;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

}
