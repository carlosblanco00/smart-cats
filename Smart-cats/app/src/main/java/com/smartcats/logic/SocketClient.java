/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcats.logic;

/**
 *
 * @author 57313
 */
import com.smartcats.util.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient{
    
    private static SocketClient socketClient;
    private Socket socket;

    
     private SocketClient() {
        // Se crea el socket y se establece la conexión con el servidor
        try {
            socket = new Socket("localhost", Constants.PORT);
            System.out.println("Conexión establecida");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SocketClient serverConnection() {
        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void sendMessage(String mensaje) {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream);

            out.println(mensaje);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String receiveMessage() {

        try {
            InputStream inputStream = socket.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String mensaje = reader.readLine();

            return mensaje;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

