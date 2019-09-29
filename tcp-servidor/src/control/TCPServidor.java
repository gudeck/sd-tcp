/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gudeck
 */
public class TCPServidor {

    public static void main(String[] args) {
        try {
            int serverPort = 7896;
            DataInputStream in;
            DataOutputStream out;
            ServerSocket listenSocket = new ServerSocket(serverPort);

            while (true) {
                Socket clientSocket = listenSocket.accept();
                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());
                String data = in.readUTF();
                data = data.toUpperCase();
                out.writeUTF(data);
            }//while
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
