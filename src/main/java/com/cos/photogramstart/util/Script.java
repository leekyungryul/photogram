package com.cos.photogramstart.util;

public class Script {

    public static String back(String message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("alert('").append(message).append("');");
        sb.append("history.back();");
        sb.append("</script>");
        return sb.toString();
    }
}
