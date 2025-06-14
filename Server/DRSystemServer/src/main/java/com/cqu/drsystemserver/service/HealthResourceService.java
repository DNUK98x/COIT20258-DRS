/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.drsystemserver.service;

import com.cqu.drsystem.model.HealthResource;
import com.cqu.drsystemserver.model.dao.HealthResourceDAO;
import java.sql.SQLException;

/**
 *
 * @author dinuk
 */
public class HealthResourceService {

    private final HealthResourceDAO fireResourceDAO;

    public HealthResourceService() {
        this.fireResourceDAO = new HealthResourceDAO();
    }

    public HealthResourceService(HealthResourceDAO fireResourceDAO) {
        this.fireResourceDAO = fireResourceDAO;
    }

    public Boolean allocateHealthResources(int disasterId, int doctors, int nurses, int ambulance, String status) throws SQLException {
        return fireResourceDAO.saveHealthAllocation(disasterId, doctors, nurses, ambulance, status);
    }

    public HealthResource getHealthResources(int disasterId) throws SQLException {
        return (HealthResource) fireResourceDAO.getHealthResources(disasterId);
    }

    public Boolean updateHealthResourceStatus(int disasterId, String status) throws SQLException {
        return fireResourceDAO.saveHealthResourceStatus(disasterId, status);
    }
}
