package com.cibt.day9.util;

import java.util.ArrayList;
import java.util.List;

public class ClientProvider {
    private static ClientProvider provider;
    private List<Client> clients= new ArrayList<>();
    private ClientProvider() {

    }

    public static ClientProvider getInstance(){
        if(provider==null){
            provider=new ClientProvider();
        }
        return provider;
    }
    
    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public boolean removeClient(Client client) {
        return clients.remove(client);
    }

    public Client getByUserName(String userName) {
        for(Client c:clients) {
            if(c.getUserName().equals(userName)){
                return c;
            }
        }
        return null;
    }
}