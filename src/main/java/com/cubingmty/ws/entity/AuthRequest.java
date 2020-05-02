package com.cubingmty.ws.entity;

import com.cubingmty.ws.exceptions.EmptyValuesException;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthRequest {

    private String username;

    private String password;

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void checkEmpty() throws EmptyValuesException{
        if(username.equals("") || password.equals("")) throw new EmptyValuesException();
    }
    
}