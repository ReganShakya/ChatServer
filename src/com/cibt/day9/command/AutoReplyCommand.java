package com.cibt.day9.command;

import java.io.IOException;

import com.cibt.day9.util.StringHelper;

public class AutoReplyCommand extends ChatCommand{
    @Override
    public void execute(String[] tokens) throws IOException {
        if(tokens.length==1){
            if(client.getAutoReply()!=null){
                out.println(client.getAutoReply());
            }else{
                out.println("Auto reply message not set yet");
            }
        }
        else if(tokens.length>1){
            client.setAutoReply(
                StringHelper.join(1, tokens)
            );
            out.println("Autoreply message added ");
        }else{
            out.println("not enough parameters");
        }

    }
}