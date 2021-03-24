package com.cibt.day9.command;

import java.io.IOException;

import com.cibt.day9.util.Client;

public interface ChatAction{
    void execute(Client buddy) throws IOException;
}