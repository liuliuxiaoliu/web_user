package dao;

import entity.User;

import java.sql.*;

public class BaseDao {
    protected Connection conn = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;

    //数据库连接
    public boolean getConnection() {
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //创建连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?serverTimezone=UTC", "root", "root");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //关闭资源
    public void sourclose() {
        try {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //执行增删改
    public int exUpdate(String sql, Object [] param) {
        int num = 0;//Object获取参数在另一个类中
        try {
            if (this.getConnection()) {
                pstmt = conn.prepareStatement(sql);
                //放参数值
                if(param!=null){
                    if (param.length > 0) {
                        for (int i = 0; i < param.length; i++) {
                            pstmt.setObject((i + 1), param[i]);
                        }
                        System.out.println("参数放入成功");
                    }
                    num = pstmt.executeUpdate();
                    /**pstmt.setString(1,user.getUserName());
                     pstmt.setString(2,user.getPwd());
                     pstmt.setString(3,user.getGender());
                     pstmt.setString(4,user.getCategory());
                     pstmt.setString(5,user.getInterest());
                     pstmt.setString(6,user.getPhoto());
                     pstmt.setString(7,user.getRegTime().toString());**/                }

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.sourclose();
            return num;
        }

    }

    //查询
    public ResultSet executeQuery(String sql, Object[] param) {
        try {
            if (this.getConnection()) {
                pstmt = conn.prepareStatement(sql);
                //放参数值
                if(param!=null){
                    if (param.length > 0) {
                        for (int i = 0; i < param.length; i++) {
                            pstmt.setObject((i + 1), param[i]);
                        }
                    }
                }
                //查询
                rs = pstmt.executeQuery();
            }
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            //this.sourclose();先不能关闭资源
            return rs;
        }
    }

}
