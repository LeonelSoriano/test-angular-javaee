package com.sample.ws.dto.in;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * Login service in json parce
 *
 * @author leonelsoriano3@gmail.com
 *
 */
public class LoginIn {

    @NotNull(message="No puede ser vacio")
    @Size(min = 0, max = 20, message="200 caracteres maximo  y un minimo de 3")
    @Email(message = "Debe ser de formato valido")
    private String user;

    @NotNull(message="No puede ser vacio")
    @Size(min = 0, max = 20, message="200 caracteres maximo y un minimo de 3")
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
