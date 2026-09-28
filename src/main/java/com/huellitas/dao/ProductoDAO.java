/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitas.dao;

import com.huellitas.config.ConexionBD;
import com.huellitas.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // Método para GUARDAR un producto en la base de datos
    public boolean registrar(Producto p) {
        String sql = "INSERT INTO productos (codigo, nombre, stock, stock_minimo, precio) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection cn = ConexionBD.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getStockMinimo());
            ps.setDouble(5, p.getPrecio());
            
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.err.println("Error al registrar producto: " + e.getMessage());
            return false;
        }
    }

    // Método para LISTAR todos los productos guardados
    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        
        try (Connection cn = ConexionBD.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("id_producto"));
                p.setCodigo(rs.getString("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setStock(rs.getInt("stock"));
                p.setStockMinimo(rs.getInt("stock_minimo"));
                p.setPrecio(rs.getDouble("precio"));
                
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar productos: " + e.getMessage());
        }
        return lista;
    }
    // Método para ELIMINAR un producto por su ID
public boolean eliminar(int idProducto) {
    String sql = "DELETE FROM productos WHERE id_producto = ?";
    
    try (Connection cn = ConexionBD.getConexion();
         PreparedStatement ps = cn.prepareStatement(sql)) {
        
        ps.setInt(1, idProducto);
        ps.executeUpdate();
        return true;
        
    } catch (SQLException e) {
        System.err.println("Error al eliminar producto: " + e.getMessage());
        return false;
    }
}

// Método para MODIFICAR / ACTUALIZAR un producto existente
public boolean modificar(Producto p) {
    String sql = "UPDATE productos SET codigo=?, nombre=?, stock=?, stock_minimo=?, precio=? WHERE id_producto=?";
    
    try (Connection cn = ConexionBD.getConexion();
         PreparedStatement ps = cn.prepareStatement(sql)) {
        
        ps.setString(1, p.getCodigo());
        ps.setString(2, p.getNombre());
        ps.setInt(3, p.getStock());
        ps.setInt(4, p.getStockMinimo());
        ps.setDouble(5, p.getPrecio());
        ps.setInt(6, p.getIdProducto());
        
        ps.executeUpdate();
        return true;
        
    } catch (SQLException e) {
        System.err.println("Error al modificar producto: " + e.getMessage());
        return false;
    }
}
}
