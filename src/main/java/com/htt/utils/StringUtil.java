package com.htt.utils;

public class StringUtil{
    public static String makeBeautiful(String str){
    	if(str == null) return "";
        return str.trim().replaceAll("\\s+", " ");
    }
}