package com.aprendec.model;

public class Producto {
 
 private int id;
 private String nombre;
 private int cantidad;
 private int precio;

 
 public Producto(int id, String nombre, int cantidad, int precio) {
  super();
  this.id = id;
  this.nombre = nombre;
  this.cantidad = cantidad;
  this.precio = precio;
 }
 
 public Producto() {
  // TODO Auto-generated constructor stub
 }
 
 public int getId() {
  return id;
 }
 
 public void setId(int id) {
  this.id = id;
 }
 
 public String getNombre() {
  return nombre;
 }
 
 public void setNombre(String nombre) {
  this.nombre = nombre;
 }
 
 public int getCantidad() {
  return cantidad;
 }
 
 public void setCantidad(int cantidad) {
  this.cantidad = cantidad;
 }
 
 public int getPrecio() {
  return precio;
 }
 
 public void setPrecio(int precio) {
  this.precio = precio;
 }
 
 @Override
 public String toString() {
  return "Producto [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio+ "]";
 }
 
}