package com.cibt.day9.command;

import java.io.IOException;

import com.cibt.day9.util.Broadcaster;
import com.cibt.day9.util.Client;

public class UnblockCommand extends ChatCommand{
    @Override
    public void execute(String[] tokens) throws IOException {
        new ChatTemplate().userBased(tokens, 1, client, out, "unblock", new ChatAction(){
        
            @Override
            public void execute(Client buddy) throws IOException {
                client.unblock(buddy);
                out.println(buddy.getUserName() + " has unblocked");
                String message=client.getUserName()+" has joined the chatroom";
                Broadcaster.privateMessage(buddy, message);
            }
        });
    }
}