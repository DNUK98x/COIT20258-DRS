/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.drsystemserver.service;

import com.cqu.drsystem.model.PoliceResource;
import com.cqu.drsystemserver.model.dao.PoliceResourceDAO;
import java.sql.SQLException;

/**
 *
 * @author dinuk
 */
public class PoliceResourceService {

    private final PoliceResourceDAO fireResourceDAO;

    public PoliceResourceService() {
        this.fireResourceDAO = new PoliceResourceDAO();
    }

    public PoliceResourceService(PoliceResourceDAO fireResourceDAO) {
        this.fireResourceDAO = fireResourceDAO;
    }

    public Boolean allocatePoliceResources(int disasterId, int fighters, int supporters, int suppression, String status) throws SQLException {
        return fireResourceDAO.savePoliceAllocation(disasterId, fighters, supporters, suppression, status);
    }

    public PoliceResource getPoliceResources(int disasterId) throws SQLException {
        return (PoliceResource) fireResourceDAO.getPoliceResources(disasterId);
    }

    public Boolean updatePoliceResourceStatus(int disasterId, String status) throws SQLException {
        return fireResourceDAO.savePoliceResourceStatus(disasterId, status);
    }
}
