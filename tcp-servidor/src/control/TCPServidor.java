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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author gudeck
 */
public class TCPServidor {

    public static void main(String[] args) {
        ServerSocket ss;
        Socket socket;
        InputStream inputStream;
        ObjectInputStream objectInputStream;
        OutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        
        try {
            ss = new ServerSocket(7777);
            socket = ss.accept();
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
          
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(new Mensagem(null, null, null, "Pao"));
            
            ss.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(TCPServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
