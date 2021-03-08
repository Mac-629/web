package jdbc;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {
        Connection c =null;
        Statement s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动加载成功");
            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 zztest
            // 编码方式 UTF-8
            // 账号 root
            // 密码 123456
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/zztest?characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","123456");
            System.out.println("连接成功，获取连接对象： " + c);
            s = c.createStatement();
            String sql = "select * from user";
            ResultSet rs = s.executeQuery(sql);
            System.out.println("SQL语句执行成功");
            while (rs.next()){
                int id = rs.getInt("user_id");
                String name = rs.getString("user_name");
                String password = rs.getString("user_password");
                System.out.println("%d\t");
            }

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } finally {
            if (s != null)
                try {
                    s.close();
                    System.out.println("Statement已关闭");
                }catch (SQLException e){
                    e.printStackTrace();
                }
            if (c != null)
                try {
                    c.close();
                    System.out.println("Connection已关闭");
                }catch (SQLException e){
                    e.printStackTrace();
                }
        }
    }
}
