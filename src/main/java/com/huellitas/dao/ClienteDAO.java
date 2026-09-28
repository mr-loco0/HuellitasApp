/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitas.dao;

/**
 *
 * @author yisha
 */
import com.huellitas.model.Cliente;
import com.huellitas.config.ConexionBD; // Ajusta el paquete de tu conexión si es necesario
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // 1. Guardar cliente
    public boolean guardar(Cliente c) {
        String sql = "INSERT INTO clientes (nombre, telefono, correo, direccion) VALUES (?, ?, ?, ?)";
        try (Connection cn = ConexionBD.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getCorreo());
            ps.setString(4, c.getDireccion());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al guardar cliente: " + e.getMessage());
            return false;
        }
    }

    // 2. Listar clientes
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection cn = ConexionBD.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Cliente c = new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("direccion")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());
        }
        return lista;
    }

    // 3. Modificar cliente
    public boolean modificar(Cliente c) {
        String sql = "UPDATE clientes SET nombre=?, telefono=?, correo=?, direccion=? WHERE id_cliente=?";
        try (Connection cn = ConexionBD.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getCorreo());
            ps.setString(4, c.getDireccion());
            ps.setInt(5, c.getIdCliente());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar cliente: " + e.getMessage());
            return false;
        }
    }

    // 4. Eliminar cliente
    public boolean eliminar(int idCliente) {
        String sql = "DELETE FROM clientes WHERE id_cliente=?";
        try (Connection cn = ConexionBD.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, idCliente);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }}


