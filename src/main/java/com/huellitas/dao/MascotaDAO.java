/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitas.dao;

import com.huellitas.config.ConexionBD;
import com.huellitas.model.Mascota;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

    // 1. Guardar Mascota
    public boolean guardar(Mascota m) {
        String sql = "INSERT INTO mascotas (nombre, especie, raza, edad, id_cliente) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = ConexionBD.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setInt(4, m.getEdad());
            ps.setInt(5, m.getIdCliente());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al guardar mascota: " + e.getMessage());
            return false;
        }
    }

    // 2. Listar Mascotas
    public List<Mascota> listar() {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM mascotas";
        try (Connection cn = ConexionBD.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Mascota m = new Mascota(
                    rs.getInt("id_mascota"),
                    rs.getString("nombre"),
                    rs.getString("especie"),
                    rs.getString("raza"),
                    rs.getInt("edad"),
                    rs.getInt("id_cliente")
                );
                lista.add(m);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar mascotas: " + e.getMessage());
        }
        return lista;
    }

    // 3. Modificar Mascota
    public boolean modificar(Mascota m) {
        String sql = "UPDATE mascotas SET nombre=?, especie=?, raza=?, edad=?, id_cliente=? WHERE id_mascota=?";
        try (Connection cn = ConexionBD.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setInt(4, m.getEdad());
            ps.setInt(5, m.getIdCliente());
            ps.setInt(6, m.getIdMascota());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar mascota: " + e.getMessage());
            return false;
        }
    }

    // 4. Eliminar Mascota
    public boolean eliminar(int idMascota) {
        String sql = "DELETE FROM mascotas WHERE id_mascota=?";
        try (Connection cn = ConexionBD.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, idMascota);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar mascota: " + e.getMessage());
            return false;
        }
    }
}
