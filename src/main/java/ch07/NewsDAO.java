package ch07;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {

  //  PreparedStatement pstmt;
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
    } finally {
      System.out.println("연결완료...");

    }
    return conn;
  }

//  public void close() {
//    try {
//      pstmt.close();
//      conn.close();
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//  }

  public NewsDAO() {
  }

  public List<News> getAll() throws SQLException {
    Connection conn = open();
    List<News> newsList = new ArrayList<>();
    PreparedStatement pstmt = conn.prepareStatement("select id, title, PARSEDATETIME(date, 'yyyy-mm-dd hh:mm:ss') as cdate from news");
    ResultSet rs = pstmt.executeQuery();

    while (rs.next()) {
      News s = new News();
      s.setId(rs.getInt("id"));
      s.setTitle(rs.getString("title"));
//      s.setImg(rs.getString("img"));
      s.setDate(rs.getString("cdate"));
//      s.setContent(rs.getString("content"));
      newsList.add(s);
    }
    pstmt.close();
    rs.close();
    conn.close();
    return newsList;
  }

  public News getNews(int id) throws SQLException {
    Connection conn = open();
    News s = new News();
    PreparedStatement pstmt = conn.prepareStatement("select * from news where id = ?");
    pstmt.setInt(1, id);
    ResultSet rs = pstmt.executeQuery();

    rs.next();
    s.setId(rs.getInt("id"));
    s.setTitle(rs.getString("title"));
    s.setImg(rs.getString("img"));
    s.setDate(rs.getString("date"));
    s.setContent(rs.getString("content"));

    pstmt.close();
    rs.close();
    conn.close();
    return s;
  }

//  public void update(int id, String email) {
//    try {
//      pstmt = conn.prepareStatement("update student set email=? where id = ?");
//      pstmt.setString(1, email);
//      pstmt.setInt(2, id);
//      int res = pstmt.executeUpdate();
//      if (res == 1) {
//        System.out.println("수정 완료");
//      }
//    } catch (SQLException e) {
//      throw new RuntimeException(e);
//    }
//  }


  public void addNews(News news) throws SQLException {
    Connection conn = open();
    PreparedStatement pstmt = conn.prepareStatement("insert into news(title, img, date, content) values(?,?,CURRENT_TIMESTAMP(),?);");
    pstmt.setString(1, news.getTitle());
    pstmt.setString(2, news.getImg());
//    pstmt.setString(3, news.getDate());
    pstmt.setString(3, news.getContent());
    int res = pstmt.executeUpdate();
    if (res == 1) {
      System.out.println("등록 완료");
    }
    pstmt.close();
  }

  public void delNews(int id) throws SQLException {
    Connection conn = open();
    PreparedStatement pstmt = conn.prepareStatement("delete from student where id = ?");
    pstmt.setInt(1, id);

    int res = pstmt.executeUpdate();
    if (res == 0) {
      throw new SQLException("News 삭제 오류");
    }
    pstmt.close();
    conn.close();
  }
}