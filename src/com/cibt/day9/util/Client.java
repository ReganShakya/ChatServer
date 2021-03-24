package com.cibt.day9.util;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;



public class Client{
    private Socket socket;
    private String userName;
    private List<Client> blockList= new ArrayList<>();
    private List<Client> muteList=new ArrayList<>();

    private String autoReply=null;

    public Client() {

    }

    public Client(String userName, Socket socket) {
        this.socket=socket;
        this.userName=userName;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private boolean isInList(List<Client> list,Client client){
        for(Client c:list){
            if(c.equals(client)){
                return true;
            }
        }
        return false;
    }

    public boolean hasBlocked(Client client){
        return isInList(blockList, client);
    }

    public void block (Client client) {
        if(!hasBlocked(client)){
            blockList.add(client);
        }
    }

    public void unblock (Client client) {
        if(!hasBlocked(client)){
            blockList.remove(client);
        }
    }

    public boolean hasAutoReply(){
        return autoReply!=null && !autoReply.equals("");
    }

    public String getAutoReply() {
        return autoReply;
    }

    public void setAutoReply(String autoReply){
        this.autoReply=autoReply;
    }
    
    public boolean hasMuted(Client client){
        return isInList(muteList, client);

    }

    public void mute (Client client) {
        if(!hasMuted(client)){
            muteList.add(client);
        }
    }

    public void unmute (Client client) {
        if(!hasMuted(client)){
            muteList.remove(client);
        }
    }
}