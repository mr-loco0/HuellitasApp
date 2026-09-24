/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitas.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Datos de conexión aqui has de ajustar con los datos que tienes en tu MySQL Workbench 8.0 xd
    private static final String URL = "jdbc:mysql://localhost:3306/db_huellitas?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "n0melase"; 

    public static Connection getConexion() {
        Connection conexion = null;
        try {
            // 1. Cargamos el driver de MySQL en memoria
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Intentamos la conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver JDBC -> " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar a la Base de Datos -> " + e.getMessage());
        }
        return conexion;
    }
    public static void main(String[] args) {
    if (getConexion() != null) {
        System.out.println("¡Conexión exitosa a la base de datos!");
    } else {
        System.out.println("Error: No se pudo conectar.");
    }
}
}
