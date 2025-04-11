package com.yama.encurtador_url.server;

public class Base62 {
    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String encode(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, CHARACTERS.charAt((int) (num % 62)));
            num /= 62;
        }
        return sb.toString();
    }
}
