package br.edu.ifpb.gugawag.so.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {
	
	public static void main(String[] args) throws IOException {
        System.out.println("== Servidor ==");
        
        // Configurando o socket
        ServerSocket serverSocket = new ServerSocket(7001);
        
        
        // laço infinito do servidor
        while (true) {
            Socket cliente = serverSocket.accept();
            ServerThread ServerThread = new ServerThread(cliente);
            ServerThread.start();                                        
        }   
    }
}
