package Impl;

import dao.BaseDao;
import dao.UserDao;
import entity.User;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public int save(User user,int Id) {
        int i = 0;
        String sql = "insert into t_user(ID,name,pwd,gender,category,interest,photo,regTime) value(?,?,?,?,?,?,?,?);";
        //将user的信息存入参数数组中
        Date date=new Date();//注册时间
        String rTime =date.toString();
        System.out.println(rTime);
        Object [] param={Id,user.getUserName(),user.getPwd(),user.getGender(),user.getCategory(),user.getInterest(),user.getPhoto(),rTime};
        i = super.exUpdate(sql,param);
        return i;
    }

    @Override
    public int delete(int Id) {
        int i = 0;
        String sql ="delete from t_user where ID=?;";
        Object [] param={Id};
        i = super.exUpdate(sql,param);
        return i;
    }

    @Override
    public int update(User user,int Id) {
        int i = 0;
        String sql ="update t_user set name=?,pwd=?,gender=?,category=?,interest=?,photo=? where ID=?;";
        Object [] param={user.getUserName(),user.getPwd(),user.getGender(),user.getCategory(),user.getInterest(),user.getPhoto(),Id};
        i = super.exUpdate(sql,param);
        return i;
    }

    @Override
    public User selectById(int Id) {
        User user=null;
        String sql ="select name,pwd,gender,category,interest,photo,regTime from t_user where ID=?;";
        Object [] param={Id};
        ResultSet rs = super.executeQuery(sql,param);
        //封装进查询用的user中
        try{
            while(rs.next()){
                user = new User();
                user.setUserName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setGender(rs.getString("gender"));
                user.setCategory(rs.getString("category"));
                user.setInterest(rs.getString("interest"));
                user.setPhoto(rs.getString("photo"));
                user.setRegTime(rs.getString("regTime"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            //记得关闭资源
            super.sourclose();
            return user;
        }
    }

    @Override
    public List<User> selectAll() {
        List<User> list= new ArrayList<>();
        String sql ="select * from t_user;";
        ResultSet rs = super.executeQuery(sql,null);
        try{
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setUserName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setGender(rs.getString("gender"));
                user.setCategory(rs.getString("category"));
                user.setInterest(rs.getString("interest"));
                user.setPhoto(rs.getString("photo"));
                user.setRegTime(rs.getString("regTime"));
                list.add(user);//加入集合中
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            super.sourclose();
            return list;
        }
    }
}

