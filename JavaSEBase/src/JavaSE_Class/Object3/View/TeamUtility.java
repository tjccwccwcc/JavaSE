package JavaSE_Class.Object3.View;

import java.util.*;
public class TeamUtility {
    private static int num;
    private static String yOrN;
    private static Scanner input = new Scanner(System.in);
    /**
     * 用于控制菜单的输入
     */
    public static int menuOption(){
        while(true){
            try {
                num = Integer.parseInt(readKeyBoard(1,false));
                if (num < 1 || num > 4){
                    System.out.print("选择错误，重新输入：");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.print("选择错误，重新输入：");
                continue;
            }
        }
        return num;
    }

    /**
     * 用于控制输入 yes 或 no
     */
    public static String yesOrNo(){
        while(true){
            try{
                yOrN = readKeyBoard(1,false).toUpperCase();
                if(yOrN.equals("Y") || yOrN.equals("N")){
                    break;
                }
                System.out.print("输入错误，重新输入：");
                continue;
            }catch(Exception e){
                System.out.print("输入错误，重新输入：");
                continue;
            }
        }
        return yOrN;
    }

    /**
     * 功能：输入回车，再继续显示
     */
    public static void readReturn(){
        System.out.print("按回车键继续......");
        readKeyBoard(100,true);
    }

    /**
     * 从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值
     */
    public static int readInt(){
        while(true){
            try{
                num = Integer.parseInt(readKeyBoard(2,false));
                break;
            }catch(Exception e){
                System.out.print("输入错误，重新输入：");
                continue;
            }
        }
        return num;
    }

    /**
     * 读入数据
     * @param limit
     * @param blankReturn
     * @return 输入的数据
     */
    private static String readKeyBoard(int limit,boolean blankReturn){
        String line = "";
        while(input.hasNextLine()){
            line = input.nextLine();
            if(line.length() == 0){
                if(blankReturn)return line;
                else continue;
            }
            if(line.length() < 1 || line.length() > limit){
                System.out.print("输入长度有误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }

    public static void main(String[] args) {
        TeamUtility team = new TeamUtility();
        team.menuOption();
    }
}
