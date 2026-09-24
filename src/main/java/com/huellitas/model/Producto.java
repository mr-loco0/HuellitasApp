/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitas.model;

/**
 *
 * @author yisha
 */
public class Producto {
    //Atributos, es decir los datos que guarda cada producto
    private int idProducto;
    private String codigo;
    private String nombre;
    private int stock;
    private int stockMinimo;
    private double precio;
    
    //Consultor, vacío por ahora 
    public Producto() {
    }
    
    //Constructor de datos, con lo que crearemos productos en código rápidamente
    public Producto(String codigo, String nombre, int stock, int sotckMinimo, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.precio = precio;
       
    } 
    //Getters y setters, los métodos para leer y cambiar los datos va
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
