package PracticalProject;

import LibSys.Func;

import java.sql.Connection;
import java.util.Scanner;

public class MainInterface {

    public void mainInter(){
        Conn conn = new Conn();
        Connection connection = conn.getConnection();
        FuncShow fsh = new FuncShow(connection);
        FuncDelete fd = new FuncDelete(connection);
        FuncSelect fs = new FuncSelect(connection);
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("**********欢迎使用图书商城系统**********");
            System.out.println("               1.查看");
            System.out.println("               2.删除");
            System.out.println("               3.模糊查找");
            System.out.println("***************************************");
            int choose = input.nextInt();
            String name;
            switch (choose) {
                case 1:
                    //查看
                    System.out.println("查看操作");
                    fsh.show();
                    break;
                case 2:
                    //删除
                    System.out.println("删除操作");
                    System.out.print("请输入要删除的书名:");
                    fd.delete(name = input.next());
                    break;
                case 3:
                    System.out.println("模糊查找");
                    System.out.print("请输入要查找的书名:");
                    fs.select(name = input.next());
                    break;
                default:
                    System.out.println("输入错误！");
                    break;
            }
            System.out.println("是否继续使用（y/n）");
            if(input.next().toUpperCase().equals("Y") != true) {
                break;
            }
        }while(true);
        System.out.println("正在退出系统 谢谢使用！");
    }
}
