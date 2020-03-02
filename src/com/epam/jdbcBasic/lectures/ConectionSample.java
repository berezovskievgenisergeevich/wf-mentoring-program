package com.epam.jdbcBasic.lectures;

import com.epam.jdbcIntro.lectures.TestConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class ConectionSample extends TestConnection {
    public static void main(String[] args) {
        try (Connection  connection = getConnection();
             PreparedStatement st = connection.prepareStatement("select * from users where name=?"/*, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    *//* ResultSet.CONCUR_READ_ONLY*//* ResultSet.CONCUR_UPDATABLE*/);
             PreparedStatement update = connection.prepareStatement("UPDATE users SET name = ? WHERE id = ?")){


            st.setString(1,"New Name");
            ResultSet rs = st.executeQuery();
            while (rs.next())
                System.out.println(rs.getRow()+ " "+rs.getString("name"));

            if (new Random().nextBoolean())
                throw new SQLException("Transaction crash");

            update.setString(1, "Update Name");
            update.setInt(2,1);
            update.executeUpdate();

          // ResultSet rs = st.executeQuery();


      /*      //update start
             rs.afterLast();
            while (rs.previous()){
                // для 2 столбца в базе данных(его имя 'name') меняем имя на 'New Name'
                rs.updateString(2,"New Name");
                rs.updateRow();
                //update end
            }*/


     /*       //insert start
            rs.last();
            rs.moveToInsertRow();
            rs.updateString(2,"Last add name");
            rs.updateString(3,"Last add Sname");
            rs.updateString(4,"01-01-1111");
            rs.insertRow();
            //insert end*/

/*
            // print
            while (rs.next())
                System.out.println(rs.getString("name"));*/


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
