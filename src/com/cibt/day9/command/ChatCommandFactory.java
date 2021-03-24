package com.cibt.day9.command;

import java.util.HashMap;

public class ChatCommandFactory{

    private static HashMap<String, ChatCommand> commands= initCommands();
    private static HashMap<String, ChatCommand> initCommands(){
        HashMap<String,ChatCommand> cmds=new HashMap<>();
        cmds.put("pm",new PMCommand());
        cmds.put("block",new BlockCommand());
        cmds.put("unblock",new UnblockCommand());
        cmds.put("list",new ListCommand());
        cmds.put("exit",new ExitCommand());
        cmds.put("autoreply",new AutoReplyCommand());
        cmds.put("kick",new KickCommand());

        return cmds;
    }

    public static ChatCommand get(String param){
        String cmd=param.toLowerCase();
        return (commands.containsKey(cmd))?commands.get(cmd):null;
    }
}