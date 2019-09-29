/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import domain.Mensagem;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author gudeck
 */
public class TCPServidor {

    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        InputStream inputStream;
        ObjectInputStream objectInputStream;
        OutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        List<Mensagem> mensagens = new ArrayList<>();

        try {
            serverSocket = new ServerSocket(7777);
            while (true) {
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                objectInputStream = new ObjectInputStream(inputStream);

                mensagens.add((Mensagem) objectInputStream.readObject());

                outputStream = socket.getOutputStream();
                objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(mensagens);

                socket.close();
            }
        } catch (ClassNotFoundException | IOException ex) {
            System.err.println("Erro servidor: " + ex.getMessage());
        }
    }
}
