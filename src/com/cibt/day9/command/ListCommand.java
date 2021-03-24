package com.cibt.day9.command;

import java.io.IOException;

import com.cibt.day9.util.Client;

public class ListCommand extends ChatCommand {

    @Override
    public void execute(String[] tokens) throws IOException {
        StringBuilder content=new StringBuilder();
                    content.append("list of current users")
                    .append("\r\n")
                    .append("----------------------------------")
                    .append("\r\n");

                    for(Client c:provider.getClients()){

                        if(!c.hasBlocked(client)){
                            content.append(c.getUserName());
                        if(c.equals(client)){
                            content.append("(Me)");
                        }
                        if(client.hasBlocked(c)){
                            content.append("(Blocked)");

                        }
                        content.append("\r\n");
                        }
                        
                    }
                    out.println(content.toString());
    }

}