/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.drsystem.model;

import java.io.Serializable;

/**
 *
 * @author dinuk
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private int userId;
    private String name;
    private String email;
    private String password;
    private String mobile;
    private String role;

    public User(int id, String name, String email, String role, String mobile) {
        this.userId = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.mobile = mobile;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
