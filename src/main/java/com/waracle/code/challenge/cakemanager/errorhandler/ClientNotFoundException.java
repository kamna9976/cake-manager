package com.waracle.code.challenge.cakemanager.errorhandler;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException (long id) {
        super("Client ID not found: " + id);
    }
}
