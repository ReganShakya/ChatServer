package com.cibt.day9.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;

import com.cibt.day9.command.ChatCommand;
import com.cibt.day9.command.ChatCommandFactory;

public class RequestListener extends Thread{
    private Socket socket;
    private ClientProvider provider= ClientProvider.getInstance();
    private BufferedReader reader;
    private PrintStream out;
    private Client client;

    public RequestListener(Socket socket) throws IOException{
        this.socket=socket;
        out=new PrintStream(socket.getOutputStream());
            
        reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
          
    }

    @Override
    public void run() {
        try{
            login();
            while(true){
                out.println("[Me]>");
                String line=reader.readLine();
                String[] tokens=line.split(" ");

                ChatCommand cmd=ChatCommandFactory.get(tokens[0]);
                if(cmd!=null){
                    cmd.init(client, out);
                    cmd.execute(tokens);
                }else{
                    Broadcaster.broadcastMessage(client, client.getUserName() + " says>" + line);
                }        
                
            }
            
        }catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private void login() throws IOException{
        out.println("Welcome to CIBT Cha Server");
        out.println("Today is: " + new Date());
        out.println("Enter Your UserName: ");
        String username = reader.readLine();
        client = new Client(username, socket);
        provider.addClient(client);
        out.println("Hello " + username);
        System.out.println("user " + username + " connected");
        Broadcaster.broadcastMessage(client, client.getUserName() + " has joined the chat room");
    }

   
    
}