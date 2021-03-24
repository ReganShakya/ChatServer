package com.cibt.day9.util;

public class StringHelper{
    public static String join(int pos, String[] tokens) {
        StringBuilder content=new StringBuilder();
        for(int i=pos;i<tokens.length;i++){
            content.append(tokens[i]).append(" ");
        }
        return content.toString();
    }
}