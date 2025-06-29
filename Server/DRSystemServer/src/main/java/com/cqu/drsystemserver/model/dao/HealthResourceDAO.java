/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.drsystemserver.model.dao;

import com.cqu.drsystem.model.HealthResource;
import com.cqu.drsystemserver.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dinuk
 */
public class HealthResourceDAO {

    public Boolean saveHealthAllocation(int disasterId, int doctors, int nurses, int ambulances, String status) throws SQLException {
        String query = "INSERT INTO health (disasterId, doctors, nurses, ambulances, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, disasterId); // Foreign key to the disaster
            stmt.setInt(2, doctors);
            stmt.setInt(3, nurses);
            stmt.setInt(4, ambulances);
            stmt.setString(5, status);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public HealthResource getHealthResources(int disasterId) throws SQLException {
        String query = "SELECT healthId, doctors, nurses, ambulances, status FROM health WHERE disasterId = ?";

        try (Connection conn = DatabaseConnection.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, disasterId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    HealthResource healthResource = new HealthResource(rs.getInt("healthId"), disasterId, rs.getInt("doctors"), rs.getInt("nurses"), rs.getInt("ambulances"), rs.getString("status"));

                    return healthResource;

                }
            }
        }
        return null;
    }

    public Boolean saveHealthResourceStatus(int disasterId, String status) throws SQLException {
        String query = "UPDATE health SET status = ? WHERE disasterId = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setInt(2, disasterId);
            int res = stmt.executeUpdate();
            return res > 0;
        }
    }
}
