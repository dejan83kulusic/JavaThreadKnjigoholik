package com.downloadKnjigaServer;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class KnigaServer {

    public static final int TCP_PORT = 9000;

    public static void main(String[] args) {
        try {
            // slusaj zahteve na datom portu
            ServerSocket ss = new ServerSocket(TCP_PORT);
            System.out.println("Server running...");
            while (true) {
                //prihvataj klijente
                Socket sock = ss.accept();
                System.out.println("Client accepted");
                //startuj nit za svakog klijenta
                new KnjigaServerThread(sock);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}