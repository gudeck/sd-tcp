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

/**
 * @author gudeck
 */
public class TCPServidor {

    public static void main(String[] args) {
        Mensagem mensagem;
        InputStream inputStream;
        List<Mensagem> mensagens = new ArrayList<>();
        ObjectInputStream objectInputStream;
        OutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        ServerSocket serverSocket;
        Socket socket;

        try {
            serverSocket = new ServerSocket(7777);
            while (true) {
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                objectInputStream = new ObjectInputStream(inputStream);

                mensagem = (Mensagem) objectInputStream.readObject();
                if (!mensagem.getTexto().isEmpty()) {
                    mensagens.add(mensagem);
                }

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
