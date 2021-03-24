package com.cibt.day9.command;

import java.io.IOException;
import java.io.PrintStream;

import com.cibt.day9.util.Client;
import com.cibt.day9.util.ClientProvider;

public abstract class ChatCommand {
    protected Client client;
    protected ClientProvider provider=ClientProvider.getInstance();
    protected PrintStream out;

    public void init(Client client,PrintStream out){
        this.client=client;
        this.out=out;
    }
    public abstract void execute(String[] tokens) throws IOException;
}