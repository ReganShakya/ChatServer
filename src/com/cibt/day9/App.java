package com.cibt.day9;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.cibt.day9.util.RequestListener;

public class App{

    public static void main(String[] args) {
        
        int port=8000;
        try{
            ServerSocket server=new ServerSocket(port);
            System.out.println("Server running at "+ port);
            while(true){
                Socket socket=server.accept();
                System.out.println("connection request from" +socket.getInetAddress().getHostAddress());
                
                RequestListener listener=new RequestListener(socket);
                listener.start();
                }

        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
    
}