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
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
