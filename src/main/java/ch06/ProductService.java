package ch06;

import java.sql.*;
import java.util.*;

public class ProductService {
  Connection conn = null;
  PreparedStatement pstmt;
  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://localhost:3306/jwbook?serverTimezone=Asia/Seoul";

  public void open() {
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(JDBC_URL,"root", "1111");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void close() {
    try {
      pstmt.close();
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  Map<String, Product> products = new HashMap<>();

  public ProductService() {

  }

  public List<Product> findAll() {
    List<Product> products = new ArrayList<>();
    try {
      pstmt = conn.prepareStatement("select * from jwbook.products");
      ResultSet rs = pstmt.executeQuery();
      while(rs.next()) {
        Product p = new Product();
        p.setId(rs.getString("id"));
        p.setName(rs.getString("name"));
        p.setMaker(rs.getString("maker"));
        p.setPrice(rs.getInt("price"));
        p.setDate(rs.getString("date"));
        products.add(p);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return products;
  }

  public Product findById(String id){
    Product p = new Product();
    try {
      pstmt = conn.prepareStatement("select * from jwbook.products where id="+id);
      ResultSet rs = pstmt.executeQuery();
      while(rs.next()) {
        p.setId(rs.getString("id"));
        p.setName(rs.getString("name"));
        p.setMaker(rs.getString("maker"));
        p.setPrice(rs.getInt("price"));
        p.setDate(rs.getString("date"));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return p;
  }

//  public Product updateById(String id, String name, String maker, String price){
//    Product newProduct = new Product(id, name, maker, Integer.parseInt(price), "2023-10-19");
//    products.replace(id, newProduct);
//    return newProduct;
//  }
}