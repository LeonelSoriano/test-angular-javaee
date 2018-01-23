package com.sample.ws.model;

import java.io.Serializable;



import javax.persistence.*;

/**
 *
 * Model of user
 *
 * @author leonelsoriano3@gmail.com
 *
 */
@Entity
@Table(name = "user")
public class UserModel implements Serializable{

    private static final long serialVersionUID = 7711505597348200997L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
