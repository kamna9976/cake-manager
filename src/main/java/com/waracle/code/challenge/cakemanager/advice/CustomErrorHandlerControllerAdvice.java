package com.waracle.code.challenge.cakemanager.advice;

import com.waracle.code.challenge.cakemanager.errorhandler.CakeNotFoundException;
import com.waracle.code.challenge.cakemanager.errorhandler.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@ControllerAdvice
public class CustomErrorHandlerControllerAdvice {

    @ExceptionHandler(CakeNotFoundException.class)
    public void cakeNotFoundHandler(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), "Cake not found");
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public void clientNotFoundHandler(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), "Client not found");
    }

}
