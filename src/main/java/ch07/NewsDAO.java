package ch07;

import ch06.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://127.0.0.1/jwbook?serverTimezone=Asia/Seoul";

  public Connection open() {
    Connection conn = null;
    try {
      Class.forName(JDBC_DRIVER);
      System.out.println("연결하는중...");
      conn = DriverManager.getConnection(JDBC_URL, "root", "1111");

    } catch (Exception e) {
      e.printStackTrace();
    } finally{
      System.out.println("연결완료...");
    }
    return conn;
  }

//    public void close(){
//        try {
//            pstmt.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

  public NewsDAO() {
  }

  public List<News> getAll() throws SQLException{
    Connection conn = open();
    List<News> newsList = new ArrayList<>();
    PreparedStatement pstmt = null;
    pstmt = conn.prepareStatement("select id, title, date_format(date, '%Y-%m-%d %h-%m-%s') as cdate from news");
    ResultSet rs = pstmt.executeQuery();

    while(rs.next()) {
      News news = new News();
      news.setId(rs.getInt("id"));
      news.setTitle(rs.getString("title"));
      news.setDate(rs.getString("cdate"));
      System.out.println("id  == "+ rs.getInt("id"));
      newsList.add(news);
    }
    pstmt.close();
    rs.close();
    conn.close();
    return newsList;
  }

  public News getNews(int id) throws SQLException{
    Connection conn = open();
    News news = new News();
    PreparedStatement pstmt = null;

    pstmt = conn.prepareStatement("select id, title, img, date_format(date, '%Y-%m-%d %h-%m-%s') as cdate, content " +
        "from news where id = ?");
    pstmt.setInt(1,id);
    ResultSet rs = pstmt.executeQuery();

    rs.next();

    news.setId(rs.getInt("id"));
    news.setTitle(rs.getString("title"));
    news.setImg(rs.getString("img"));
    news.setDate(rs.getString("cdate"));
    news.setContent(rs.getString("content"));

    pstmt.close();
    rs.close();
    conn.close();
    return news;
  }

//    public void update(String id, int price){
//        try {
//            pstmt = conn.prepareStatement("update product set price=? where id = ?");
//            pstmt.setInt(1,price);
//            pstmt.setString(2,id);
//            int res = pstmt.executeUpdate();
//            if (res == 1) {
//                System.out.println("수정 완료");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


  public void addNews(News news) throws SQLException{
    Connection conn = open();
    PreparedStatement pstmt;
    pstmt = conn.prepareStatement("insert into news(title, img, date, content) " +
        "values(?,?,CURRENT_TIMESTAMP(),?);");
    pstmt.setString(1,news.getTitle());
    pstmt.setString(2,news.getImg());
    pstmt.setString(3,news.getContent());

    int res = pstmt.executeUpdate();
    if (res == 1) {
      System.out.println("등록 완료");
    }
    pstmt.close();
    conn.close();
  }

  public void delNews(int id) throws SQLException{
    Connection conn = open();
    PreparedStatement pstmt = conn.prepareStatement("delete from news where id = ?");
    pstmt.setInt(1,id);

    int res = pstmt.executeUpdate();

    if (res == 0) {
      throw new SQLException("News 삭제 오류");
    }
    pstmt.close();
    conn.close();
  }
}