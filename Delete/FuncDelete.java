package PracticalProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncDelete {
    Connection connection = null;
    public FuncDelete(Connection conn) {
        connection = conn;
    }

    public void delete(String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from info where name = ?");
            preparedStatement.setString(1,name);
            int num = preparedStatement.executeUpdate();
            if(num != 0){
                System.out.println("删除成功");
            }
            else System.out.println("id号不存在，删除失败");
        } catch (SQLException e) {
            System.out.println("删除失败");
        }
    }
}
