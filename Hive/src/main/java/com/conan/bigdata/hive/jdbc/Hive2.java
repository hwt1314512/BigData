package com.conan.bigdata.hive.jdbc;

import java.sql.*;

/**
 * Created by Administrator on 2018/8/1.
 */
public class Hive2 {

    public static Connection conn=null;

    static {
        try{
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            conn=DriverManager.getConnection("jdbc:hive2://10.1.24.166:10000/default","hive","hive");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        PreparedStatement ps=conn.prepareStatement("select * from ods.resta_citytable limit 10");
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString(1));
        }
    }
}