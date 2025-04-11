package com.yama.encurtador_url.server;

public class UrlInvalidationException extends RuntimeException{
    public UrlInvalidationException(String mensagem){
        super(mensagem);
    }
}
