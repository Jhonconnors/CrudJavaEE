package com.aprendec.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import com.aprendec.conexion.Conexion;
import com.aprendec.model.Producto;
 
public class ProductoDAO {
 private Connection connection;
 private PreparedStatement statement;
 private boolean estadoOperacion;
 
 // guardar producto
 public boolean guardar(Producto producto) throws SQLException {
  String sql = null;
  estadoOperacion = false;
  connection = obtenerConexion();
 
  try {
   connection.setAutoCommit(false);
   sql = "INSERT INTO productos (id, nombre, cantidad, precio) VALUES(?,?,?,?)";
   statement = connection.prepareStatement(sql);
 
   statement.setString(1, null);
   statement.setString(2, producto.getNombre());
   statement.setInt(3, (int) producto.getCantidad());
   statement.setInt(4, (int) producto.getPrecio());
 
   estadoOperacion = statement.executeUpdate() > 0;
 
   connection.commit();
   statement.close();
   connection.close();
  } catch (SQLException e) {
   connection.rollback();
   e.printStackTrace();
  }
 
  return estadoOperacion;
 }
 
 // editar producto
 public boolean editar(Producto producto) throws SQLException {
  String sql = null;
  estadoOperacion = false;
  connection = obtenerConexion();
  try {
   connection.setAutoCommit(false);
   sql = "UPDATE productos SET nombre=?, cantidad=?, precio=? WHERE id=?";
   statement = connection.prepareStatement(sql);
 
   statement.setString(1, producto.getNombre());
   statement.setInt(2, producto.getCantidad());
   statement.setInt(3, producto.getPrecio());
   statement.setInt(4, producto.getId());
 
   estadoOperacion = statement.executeUpdate() > 0;
   connection.commit();
   statement.close();
   connection.close();
 
  } catch (SQLException e) {
   connection.rollback();
   e.printStackTrace();
  }
 
  return estadoOperacion;
 }
 
 // eliminar producto
 public boolean eliminar(int idProducto) throws SQLException {
  String sql = null;
  estadoOperacion = false;
  connection = obtenerConexion();
  try {
   connection.setAutoCommit(false);
   sql = "DELETE FROM productos WHERE id=?";
   statement = connection.prepareStatement(sql);
   statement.setInt(1, idProducto);
 
   estadoOperacion = statement.executeUpdate() > 0;
   connection.commit();
   statement.close();
   connection.close();
 
  } catch (SQLException e) {
   connection.rollback();
   e.printStackTrace();
  }
 
  return estadoOperacion;
 }
 
 // obtener lista de productos
 public List<Producto> obtenerProductos() throws SQLException {
  ResultSet resultSet = null;
  List<Producto> listaProductos = new ArrayList<>();
 
  String sql = null;
  estadoOperacion = false;
  connection = obtenerConexion();
 
  try {
   sql = "SELECT * FROM productos";
   statement = connection.prepareStatement(sql);
   resultSet = statement.executeQuery(sql);
   while (resultSet.next()) {
    Producto p = new Producto();
    p.setId(resultSet.getInt(1));
    p.setNombre(resultSet.getString(2));
    p.setCantidad(resultSet.getInt(3));
    p.setPrecio(resultSet.getInt(4));
    listaProductos.add(p);
   }
 
  } catch (SQLException e) {
   e.printStackTrace();
  }
 
  return listaProductos;
 }
 
 // obtener producto
 public Producto obtenerProducto(int idProducto) throws SQLException {
  ResultSet resultSet = null;
  Producto p = new Producto();
 
  String sql = null;
  estadoOperacion = false;
  connection = obtenerConexion();
 
  try {
   sql = "SELECT * FROM productos WHERE id =?";
   statement = connection.prepareStatement(sql);
   statement.setInt(1, idProducto);
 
   resultSet = statement.executeQuery();
 
   if (resultSet.next()) {
    p.setId(resultSet.getInt(1));
    p.setNombre(resultSet.getString(2));
    p.setCantidad(resultSet.getInt(3));
    p.setPrecio(resultSet.getInt(4));
   }
 
  } catch (SQLException e) {
   e.printStackTrace();
  }
 
  return p;
 }
 
 // obtener conexion pool
 private Connection obtenerConexion() throws SQLException {
  return Conexion.getConnection();
 }
 
}