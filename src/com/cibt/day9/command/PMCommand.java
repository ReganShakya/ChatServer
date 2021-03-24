package com.cibt.day9.command;

import java.io.IOException;

import com.cibt.day9.util.Broadcaster;
import com.cibt.day9.util.Client;
import com.cibt.day9.util.StringHelper;

public class PMCommand extends ChatCommand{
    @Override
    public void execute(String[] tokens) throws IOException {
        new ChatTemplate().userBased(tokens, 2, client, out, "PM", new ChatAction(){
        
            @Override
            public void execute(Client buddy) throws IOException {
                String user=buddy.getUserName();
                if(!buddy.hasBlocked(client)){
                        
                    String message="[PM from "+client.getUserName()+"] says> "+ StringHelper.join(2, tokens);
                    Broadcaster.privateMessage(buddy, message);
                    if(buddy.hasAutoReply()){
                        out.println("[AutoReply from "+ user + "]> "+ buddy.getAutoReply());
                    }

                }else {
                    out.println(user + " not available at this moment");
                }
            }
        });
    }
}