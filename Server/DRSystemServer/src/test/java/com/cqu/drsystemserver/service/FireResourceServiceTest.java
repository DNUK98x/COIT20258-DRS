/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.drsystemserver.service;

import com.cqu.drsystem.model.FireResource;
import com.cqu.drsystemserver.model.dao.FireResourceDAO;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author dinuk
 */
public class FireResourceServiceTest {

    @Mock
    private FireResourceDAO fireResourceDAOMock;

    private FireResourceService fireResourceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        fireResourceService = new FireResourceService(fireResourceDAOMock);
    }

    @Test
    void testAllocateFireResourcesSuccessful() throws SQLException {
        int disasterId = 1;
        int fighters = 10;
        int supporters = 5;
        int suppression = 3;
        String status = "Allocated";

        when(fireResourceDAOMock.saveFireAllocation(disasterId, fighters, supporters, suppression, status)).thenReturn(true);

        Boolean result = fireResourceService.allocateFireResources(disasterId, fighters, supporters, suppression, status);
        assertTrue(result);
    }

    @Test
    void testAllocateFireResourcesFailure() throws SQLException {
        int disasterId = 1;
        int fighters = 10;
        int supporters = 5;
        int suppression = 3;
        String status = "Failed";

        when(fireResourceDAOMock.saveFireAllocation(disasterId, fighters, supporters, suppression, status)).thenReturn(false);

        Boolean result = fireResourceService.allocateFireResources(disasterId, fighters, supporters, suppression, status);
        assertFalse(result);
    }

    @Test
    void testAllocateFireResourcesThrowsSQLException() throws SQLException {
        int disasterId = 1;
        int fighters = 10;
        int supporters = 5;
        int suppression = 3;
        String status = "Error";

        when(fireResourceDAOMock.saveFireAllocation(disasterId, fighters, supporters, suppression, status))
                .thenThrow(new SQLException("Database error"));

        SQLException thrown = assertThrows(SQLException.class, () -> {
            fireResourceService.allocateFireResources(disasterId, fighters, supporters, suppression, status);
        });

        assertEquals("Database error", thrown.getMessage());
    }

    @Test
    void testGetFireResourcesSuccessful() throws SQLException {
        int disasterId = 1;
        FireResource expectedResource = new FireResource(); // Initialize with specific values as necessary

        when(fireResourceDAOMock.getFireResources(disasterId)).thenReturn(expectedResource);

        FireResource result = fireResourceService.getFireResources(disasterId);
        assertEquals(expectedResource, result);
    }

    @Test
    void testGetFireResourcesThrowsSQLException() throws SQLException {
        int disasterId = 1;

        when(fireResourceDAOMock.getFireResources(disasterId)).thenThrow(new SQLException("Database error"));

        SQLException thrown = assertThrows(SQLException.class, () -> {
            fireResourceService.getFireResources(disasterId);
        });

        assertEquals("Database error", thrown.getMessage());
    }

    @Test
    void testUpdateFireResourceStatusSuccessful() throws SQLException {
        int disasterId = 1;
        String status = "Updated";

        when(fireResourceDAOMock.saveFireResourceStatus(disasterId, status)).thenReturn(true);

        Boolean result = fireResourceService.updateFireResourceStatus(disasterId, status);
        assertTrue(result);
    }

    @Test
    void testUpdateFireResourceStatusFailure() throws SQLException {
        int disasterId = 1;
        String status = "Failed";

        when(fireResourceDAOMock.saveFireResourceStatus(disasterId, status)).thenReturn(false);

        Boolean result = fireResourceService.updateFireResourceStatus(disasterId, status);
        assertFalse(result);
    }

    @Test
    void testUpdateFireResourceStatusThrowsSQLException() throws SQLException {
        int disasterId = 1;
        String status = "Error";

        when(fireResourceDAOMock.saveFireResourceStatus(disasterId, status))
                .thenThrow(new SQLException("Database error"));

        SQLException thrown = assertThrows(SQLException.class, () -> {
            fireResourceService.updateFireResourceStatus(disasterId, status);
        });

        assertEquals("Database error", thrown.getMessage());
    }
}
