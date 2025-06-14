/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.drsystemserver.service;

import com.cqu.drsystem.model.FireResource;
import com.cqu.drsystemserver.model.dao.FireResourceDAO;
import java.sql.SQLException;

/**
 *
 * @author dinuk
 */
public class FireResourceService {

    private final FireResourceDAO fireResourceDAO;

    public FireResourceService() {
        this.fireResourceDAO = new FireResourceDAO();
    }

    public FireResourceService(FireResourceDAO fireResourceDAO) {
        this.fireResourceDAO = fireResourceDAO;
    }

    public Boolean allocateFireResources(int disasterId, int fighters, int supporters, int suppression, String status) throws SQLException {
        return fireResourceDAO.saveFireAllocation(disasterId, fighters, supporters, suppression, status);
    }

    public FireResource getFireResources(int disasterId) throws SQLException {
        return (FireResource) fireResourceDAO.getFireResources(disasterId);
    }

    public Boolean updateFireResourceStatus(int disasterId, String status) throws SQLException {
        return fireResourceDAO.saveFireResourceStatus(disasterId, status);
    }
}
