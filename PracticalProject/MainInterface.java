package PracticalProject;

import LibSys.Func;

import java.util.Scanner;

public class MainInterface {

    public void mainInter(){
        Fun fun = new Fun();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("**********欢迎使用图书馆系统**********");
            System.out.println("              1.查看");
            System.out.println("              2.删除");
            System.out.println("*************************************");
            int choose = input.nextInt();
            switch (choose) {
                case 1:
                    //查看
                    System.out.println("查看操作");
                    fun.show();
                    break;
                case 2:
                    //删除
                    System.out.println("删除操作");
                    System.out.print("请输入要删除的书号:");
                    String id2 = input.next();
                    fun.delete(id2);
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
