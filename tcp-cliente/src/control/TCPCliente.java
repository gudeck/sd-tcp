/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author gudeck
 */
public class TCPCliente {

    public static void main(String[] args) {

        InetAddress nomeHost = null;
        Socket socket = null;
        String mensagem = "pao";
        try {
            int serverPort = 7896;
            nomeHost = InetAddress.getLocalHost();
            socket = new Socket(nomeHost, serverPort);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(mensagem); //UTF é uma codificação de string.

            String data = in.readUTF();
            System.out.println("Recebido: " + data);
        } catch (UnknownHostException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    /*close falhou*/
                }
            }

        }//finally
    }
}
