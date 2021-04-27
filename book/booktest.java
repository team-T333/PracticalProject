import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class booktest {
    //添加
    public void insertForlist(String name,int num){
        Connection connection=DBconnection.getConnection();// 获取连接
        Statement statement=null;
        try {
            statement =connection.createStatement(); //通过连接获取 statement 对象
            String insertStr="insert into dept(name) values ";
            String values="";
            for (int i=1;i<=num;i++){
                if (i!=num){
                    values+=" ('"+name+i+"'),";
                }else {
                    values+=" ('"+name+i+"')";
                }
            }
            insertStr=insertStr+values;
            int i= statement.executeUpdate(insertStr);  //通过 statement 执行sql 语句  返回操作的条数
            if (i>0){
                System.out.println( "插入成功"+i+"条");
            }else {
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();  //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close(); //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //添加
    public void insert(String name){
        Connection connection=DBconnection.getConnection();// 获取连接
        Statement statement=null;
        try {
            statement =connection.createStatement(); //通过连接获取 statement 对象
            String insertStr="insert into dept(name) values('"+name+"')";
            int i= statement.executeUpdate(insertStr);  //通过 statement 执行sql 语句  返回操作的条数
            if (i>0){
                System.out.println( "插入成功");
            }else {
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();  //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close(); //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //添加
    public void PreParedInsert(String name){
        Connection connection=DBconnection.getConnection();// 获取连接
        PreparedStatement statement=null;
        try {

            String insertStr="insert into dept(name) values(?)";
            statement =connection.prepareStatement(insertStr); //通过连接获取 statement 对象
            statement.setString(1,name);
            int i= statement.executeUpdate();  //通过 statement 执行sql 语句  返回操作的条数
            if (i>0){
                System.out.println( "插入成功");
            }else {
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();  //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close(); //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除
     * @param id
     */
    public void deleteById(int id){
        Connection connection=DBconnection.getConnection();// 获取连接
        Statement statement=null;
        try {
            statement =connection.createStatement(); //通过连接获取 statement 对象
            String deleteStr="delete from dept where id="+id;
            int i= statement.executeUpdate(deleteStr);  //通过 statement 执行sql 语句  返回操作的条数
            if (i>=0){
                System.out.println( "删除成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();  //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close(); //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 删除
     * @param id
     */
    public void prepareDeleteById(int id){
        Connection connection=DBconnection.getConnection();// 获取连接
        PreparedStatement statement=null;
        try {
            String deleteStr="delete from dept where id=?";
            statement =connection.prepareStatement(deleteStr); //通过连接获取 statement 对象
            statement.setInt(1,id);
            int i= statement.executeUpdate();  //通过 statement 执行sql 语句  返回操作的条数
            if (i>=0){
                System.out.println( "删除成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();  //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close(); //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 更改
     * @param id
     */
    public void updateById(int id,String name){
        Connection connection=DBconnection.getConnection();// 获取连接
        Statement statement=null;
        try {
            statement =connection.createStatement(); //通过连接获取 statement 对象
            String deleteStr="update dept set name='"+name+"' where id="+id;
            int i= statement.executeUpdate(deleteStr);  //通过 statement 执行sql 语句  返回操作的条数
            if (i>=0){
                System.out.println( "更新成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("更新失败");
        }finally {
            if (statement!=null){
                try {
                    statement.close();  //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close(); //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 更改
     * @param id
     */
    public void prePareupdateById(int id,String name){
        Connection connection=DBconnection.getConnection();// 获取连接
        PreparedStatement statement=null;
        try {

            String deleteStr="update dept set name=? where id=?";
            statement =connection.prepareStatement(deleteStr); //通过连接获取 statement 对象
            statement.setString(1,name);
            statement.setInt(2,id);
            int i= statement.executeUpdate();  //通过 statement 执行sql 语句  返回操作的条数
            if (i>=0){
                System.out.println( "更新成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("更新失败");
        }finally {
            if (statement!=null){
                try {
                    statement.close();  //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close(); //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 查询
     */
    public List<book> query(String name){
        List<book> books =new ArrayList<>();
        Connection connection=DBconnection.getConnection();// 获取连接
        Statement statement=null;
        ResultSet set=null;
        try {
            statement =connection.createStatement(); //通过连接获取 statement 对象
            String selectStr="";
            if (name!=null&&!name.equals("")){
                selectStr="select * from dept where name like '%"+name+"%'";
            }else {
                selectStr="select * from dept ";
            }

            set= statement.executeQuery(selectStr);

            while (set.next()){   //遍历 resultSet
                book book =new book();
                book.setId(set.getInt("id"));
                book.setName(set.getString("name"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("更新失败");
        }finally {
            if (set!=null){
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();  //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close(); //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return books;
    }


    /**
     * 分页查询
     */
    public List<book> queryForPage(int pageNum, int pageSize, String name){
        List<book> books =new ArrayList<>();
        Connection connection=DBconnection.getConnection();// 获取连接
        Statement statement=null;
        ResultSet set=null;
        try {
            statement =connection.createStatement(); //通过连接获取 statement 对象
            String selectStr="";
            if (name!=null&&!name.equals("")){
                selectStr="select * from dept where name like '%"+name+"%' limit  "+((pageNum-1)*pageSize)+","+pageSize;
            }else {
                selectStr="select * from dept limit  "+((pageNum-1)*pageSize)+","+pageSize;
            }

            set= statement.executeQuery(selectStr);

            while (set.next()){   //遍历 resultSet
                book book =new book();
                book.setId(set.getInt("id"));
                book.setName(set.getString("name"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("更新失败");
        }finally {
            if (set!=null){
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();  //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close(); //关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return books;
    }

}
