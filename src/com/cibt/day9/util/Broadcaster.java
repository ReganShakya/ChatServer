package com.cibt.day9.util;

import java.io.IOException;
import java.io.PrintStream;

public class Broadcaster{
    public static void broadcastMessage(Client client, String message) throws IOException{
        for(Client c:ClientProvider.getInstance().getClients()){
            if(!c.equals(client)){
                PrintStream ps=new PrintStream((c.getSocket().getOutputStream()));
                ps.println(message);
            }
            
        }
    }

    public static void privateMessage(Client to, String message) throws IOException{
        PrintStream ps=new PrintStream(to.getSocket().getOutputStream());
        ps.println(message);
    }
}