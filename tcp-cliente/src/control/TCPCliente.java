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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author gudeck
 */
public class TCPCliente {

    public static void main(String[] args) {
        Socket socket;
        OutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        InputStream inputStream;
        ObjectInputStream objectInputStream;
        Mensagem mensagem;
        try {
            socket = new Socket("localhost", 7777);
            mensagem = null;
            
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(mensagem);
            
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            mensagem = (Mensagem) objectInputStream.readObject();
            
            System.out.println(mensagem.getTexto());
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(TCPCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TCPCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
