package com.cibt.day9.command;

import java.io.IOException;

import com.cibt.day9.util.Broadcaster;
import com.cibt.day9.util.Client;

public class KickCommand extends ChatCommand{

    @Override
    public void execute(final String[] tokens) throws IOException {
        new ChatTemplate().userBased(tokens, 1, client, out, "kick", new ChatAction(){
        
            @Override
            public void execute(Client buddy) throws IOException {
                provider.removeClient(buddy);
                Broadcaster.broadcastMessage(buddy, client.getUserName() + " has kicked out "+buddy.getUserName()+" from chat room");
                buddy.getSocket().close();
            }
        });
    }
}