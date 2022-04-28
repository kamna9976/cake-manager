package com.waracle.code.challenge.cakemanager.errorhandler;

public class CakeNotFoundException extends RuntimeException {
    public CakeNotFoundException (long id) {
        super("Cake id not found : " + id);
    }
}
