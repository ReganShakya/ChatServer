package com.cibt.day9.command;

import java.io.IOException;

import com.cibt.day9.util.Broadcaster;
import com.cibt.day9.util.Client;

public class BlockCommand extends ChatCommand{
    
    private ChatTemplate template=new ChatTemplate();
    @Override
    public void execute(String[] tokens) throws IOException {
       template.userBased(tokens, 1, client, out, "block", new ChatAction(){
       
           @Override
           public void execute(Client buddy) throws IOException {
                client.block(buddy);
                out.println(buddy.getUserName() + " has blocked");
                String message=client.getUserName()+" has logged out";
                Broadcaster.privateMessage(buddy, message);
           }
       });
    }
}