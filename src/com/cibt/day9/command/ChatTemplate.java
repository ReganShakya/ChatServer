package com.cibt.day9.command;

import java.io.IOException;
import java.io.PrintStream;

import com.cibt.day9.util.Client;
import com.cibt.day9.util.ClientProvider;

public class ChatTemplate {
    public void userBased(String[] tokens, int length,Client client, PrintStream out, String process, ChatAction action) throws IOException {
        if(tokens.length>length){
            String user=tokens[1];
            Client buddy=ClientProvider.getInstance().getByUserName(user);
            if(buddy!=null){
                if(buddy.equals(client)){
                    out.println("you cannot " + process+ " yourself");
                }else{
                    action.execute(buddy);
                }
            }else{
                out.println(user + " not found");
            }
        }else{
            out.println("not enough parameters");
        }
    }
}