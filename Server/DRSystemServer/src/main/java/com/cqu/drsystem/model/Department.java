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
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    private int departmentId;
    private String name;
    private String email;
    private String mobile;

    public Department(int departmentId, String name, String email, String mobile) {

        this.departmentId = departmentId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
