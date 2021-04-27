package PracticalProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FuncSelect {
    Connection connection = null;

    public FuncSelect(Connection conn) {
        connection = conn;
    }

    public void select(String name) {
        try {
            String sql = "select * from info";
            Statement statement = connection.createStatement();
            ResultSet resultSet = null;
            resultSet = statement.executeQuery(sql);
            System.out.printf("书名"+"              "+"价格"+"              "+"出版社");
            System.out.println();
            while (resultSet.next())
            {
                if(resultSet.getString("name").equals(name)) {
                    System.out.printf("%-20s", resultSet.getString("name"));
                    System.out.printf("%-20s", resultSet.getString("price"));
                    System.out.printf("%-20s", resultSet.getString("press"));
                    System.out.println();
                }
                else {
                    continue;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}