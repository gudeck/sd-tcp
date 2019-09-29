/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import domain.Mensagem;
import domain.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author gudeck
 */
public class TCPCliente {

    public static List<Mensagem> enviaMensagem(Usuario usuario, String mensagem) {
        Socket socket;
        OutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        InputStream inputStream;
        ObjectInputStream objectInputStream;

        try {
            socket = new Socket("localhost", 7777);

            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(new Mensagem(LocalDateTime.now(), usuario, mensagem));

            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            return (List<Mensagem>) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            System.err.println("Erro cliente: " + ex.getMessage());
        }
        return null;
    }
}
