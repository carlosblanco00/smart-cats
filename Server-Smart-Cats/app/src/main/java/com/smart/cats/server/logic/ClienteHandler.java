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
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 57313
 */
public class ClienteHandler implements Runnable{
    private Socket clienteSocket;
    
    private Model model;
    
    private List<String> mesagges = new ArrayList();

    public ClienteHandler(Socket socket, Model model) {
        clienteSocket = socket;
        this.model = model;
    }

    public void run() {
        try {
            // Obtener los flujos de entrada y salida del socket del cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

            // Leer y escribir datos del cliente
            String mensaje;
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println("Mensaje recibido: " + mensaje);
                mesagges.add(mensaje);
                model.updateClients();
                // Enviar una respuesta al cliente
//                salida.println("Respuesta recibida: " + mensaje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Socket cliente) {
        try {
            OutputStream out = cliente.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);

            writer.println("Hola, cliente!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getMesagges() {
        return mesagges;
    }

    public void setMesagges(List<String> mesagges) {
        this.mesagges = mesagges;
    }
}
