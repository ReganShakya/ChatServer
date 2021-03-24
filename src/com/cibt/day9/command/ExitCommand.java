package com.cibt.day9.command;

import java.io.IOException;

import com.cibt.day9.util.Broadcaster;

public class ExitCommand extends ChatCommand{

    @Override
    public void execute(final String[] tokens) throws IOException {
        provider.removeClient(client);
        Broadcaster.broadcastMessage(client, client.getUserName() + " has left the chat room ");
        client.getSocket().close();
    }
}