/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.drsystemserver.service;

import com.cqu.drsystem.model.*;
import com.cqu.drsystemserver.model.dao.UserDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dinuk
 */
public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User login(String email, String password) throws SQLException {
        return (User) userDAO.login(email, password);
    }

    public boolean registerUser(String name, String email, String password, String mobile, String role, String departmentType) throws SQLException {
        if (name == null || name.isEmpty() || email == null || email.isEmpty()
                || password == null || password.isEmpty() || mobile == null || mobile.isEmpty() || role == null || role.isEmpty()) {
            return false;
        }
        return userDAO.registerUser(name, email, password, mobile, role, departmentType);
    }

    public String getDepartmentTypeByUserId(int userId) throws SQLException {
        return userDAO.getDepartmentTypeByUserId(userId);
    }

    public User getReportedByUser(int userId) throws SQLException {
        return (User) userDAO.getReportedByUser(userId);
    }

    public boolean deleteUser(int userId) throws SQLException {
        return userDAO.deleteUser(userId);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public boolean updateUser(User selectedUser) throws SQLException {
        return userDAO.updateUser(selectedUser);
    }
}
