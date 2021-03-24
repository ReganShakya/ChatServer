package com.cibt.day9.command;

import java.io.IOException;

import com.cibt.day9.util.Broadcaster;
import com.cibt.day9.util.Client;

public class MuteCommand extends ChatCommand{
    @Override
    public void execute(String[] tokens) throws IOException {
        if(tokens.length>1){
            String user=tokens[1];
            Client buddy=provider.getByUserName(user);
            if(buddy!=null){
                if(buddy.equals(client)){
                    out.println("you cannot mute yourself");
                }else{
                    client.block(buddy);
                    out.println(user + " has blocked");
                    String message=client.getUserName()+" has logged out";
                    Broadcaster.privateMessage(buddy, message);

                }
        }else{
            out.println(user+"not found");
            }
        }else{
            out.println("not enough parameters");
        }

    }
}