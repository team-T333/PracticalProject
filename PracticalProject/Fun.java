package PracticalProject;

import java.sql.*;

public class Fun implements Func {
    Conn conn = new Conn();
    Connection connection = conn.getConnection();
    @Override
    public void show() {
        String sql = "select * from info";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = null;
            resultSet = statement.executeQuery(sql);
            System.out.printf("图书id"+"              "+"书名"+"              "+"作者");
            System.out.println();
            while (resultSet.next())
            {
                System.out.printf("%-20s",resultSet.getString("id"));
                System.out.printf("%-20s",resultSet.getString("name"));
                System.out.printf("%-20s",resultSet.getString("author"));
                System.out.println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from info where id = ?");
            preparedStatement.setString(1,id);
            int num = preparedStatement.executeUpdate();
            if(num != 0){
                System.out.println("删除成功");
            }
            else System.out.println("id号不存在，删除失败");
        } catch (SQLException e) {
            System.out.println("删除失败");
        }
    }

    @Override
    public void select(String id) {
        try {
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = connection.prepareStatement("select * from info where id = ?");
            preparedStatement.setString(1,id);
            System.out.printf("图书id"+"              "+"书名"+"              "+"作者");
            System.out.println();
            while (resultSet.next())
            {
                System.out.printf("%-20s",resultSet.getString("id"));
                System.out.printf("%-20s",resultSet.getString("name"));
                System.out.printf("%-20s",resultSet.getString("author"));
                System.out.println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
