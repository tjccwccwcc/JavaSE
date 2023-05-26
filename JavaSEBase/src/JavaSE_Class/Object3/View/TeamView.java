package JavaSE_Class.Object3.View;

import JavaSE_Class.Object3.Domain.Employee;
import JavaSE_Class.Object3.Domain.Programmer;
import JavaSE_Class.Object3.Service.NameListService;
import JavaSE_Class.Object3.Service.TeamException;
import JavaSE_Class.Object3.Service.TeamService;

public class TeamView {
    public static void main(String[] args) {
        TeamView TV = new TeamView();
        TV.showMenu();
    }
    public void showMenu(){
        int control;
        String yOrN;
        int showMenu = 0;
        NameListService s = new NameListService();
        TeamService t = new TeamService();
        Label:while(true){
            if(showMenu == 0) menu(s);
            else teamMenu(t);
            control = TeamUtility.menuOption();
            switch (control){
                case 1:
                    showMenu = 1;
                    break;
                case 2:
                    addTeamMember(t,s);
                    showMenu = 0;
                    break;
                case 3:
                    delMenuMember(t);
                    showMenu = 0;
                    break;
                case 4:
                    System.out.print("确认是否退出<Y/N>：");
                    yOrN = TeamUtility.yesOrNo();
                    if(yOrN.equals("Y")) break Label;
            }
        }
    }

    public void menu(NameListService s){
        Employee[] employees = s.getAllEmployees();
        System.out.println("--------------------------------" +
                "开发团队调度软件--------------------------------");
        System.out.println("ID        \t" + "姓名\t\t" + "年龄\t\t" +
                "工资\t\t" + "职位\t\t" + "状态\t\t" + "奖金\t\t" +
                "股票\t\t" + "领用设备");
        for(int i = 0; i < employees.length; i++){
            System.out.println(employees[i]);
        }
        System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员  4-退出  请选择(1-4)：");
    }

    public void teamMenu(TeamService t){
        Programmer[] team = t.getTeam();
        System.out.println("----------------------------------" +
                "团队成员列表----------------------------------");
        System.out.println("TDI/ID    \t" + "姓名\t\t" + "年龄\t\t" +
                "工资\t\t" + "职位\t\t" + "状态\t\t" + "奖金\t\t" +
                "股票\t\t");
        for(int i = 0; i < team.length; i++){
            System.out.println(team[i].getDetailsForTeam());
        }
        if(team.length == 0) System.out.println("目前团队中没有成员😊");
        System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员  4-退出  请选择(1-4)：");
    }

    public void addTeamMember(TeamService t,NameListService s){
        System.out.println("----------------------------------" +
                "添加成员----------------------------------");
        System.out.print("请输入要添加的员工ID：");
        int num;
        while(true){
            num = TeamUtility.readInt();
            if(num == -1) {
                System.out.println("主动退出");
                break;
            }
            try {
                t.addMember(s.getEmployee(num));
                System.out.println("添加成功");
                break;
            } catch (TeamException e) {
                System.out.print(e.getMessage() + ",请重新输入,或输入 -1 退出：");
                continue;
            }
        }
        TeamUtility.readReturn();
    }

    public void delMenuMember(TeamService t){
        System.out.println("----------------------------------" +
                "删除成员----------------------------------");
        System.out.print("请输入要删除的员工TID：");
        int num;
        String yOrN;
        while(true){
            num = TeamUtility.readInt();
            System.out.print("确认是否删除<Y/N>：");
            yOrN = TeamUtility.yesOrNo();
            if(yOrN.equals("N")){
                System.out.println("主动退出");
                break;
            }
            try {
                t.removeMember(num);
                System.out.println("删除成功");
                break;
            } catch (TeamException e) {
                System.out.println("删除失败：" + e.getMessage());
                TeamUtility.readReturn();
                break;
            }
        }
    }
}
