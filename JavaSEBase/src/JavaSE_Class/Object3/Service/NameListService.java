package JavaSE_Class.Object3.Service;

import JavaSE_Class.Object3.Domain.*;

public class NameListService {
    private Employee[] employee;
    public NameListService() {
        employee = new Employee[Data.EMPLOYEES.length];
        for(int i = 0; i < employee.length; i++){
            int memberId = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            int salary = Integer.parseInt(Data.EMPLOYEES[i][4]);
            int EquipmentId = (memberId != Data.EMPLOYEE) ?
                    Integer.parseInt(Data.EQUIPMENTS[i][0]) : 0;
            Equipment equipment;
            int bonus;
            int stock;

            if (EquipmentId == Data.PC) {
                equipment = new PC(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
            } else if (EquipmentId == Data.NOTEBOOK) {
                double price = Double.parseDouble(Data.EQUIPMENTS[i][2]);
                equipment = new NoteBook(Data.EQUIPMENTS[i][1], price);
            } else if (EquipmentId == Data.PRINTER){
                equipment = new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
            } else{
                equipment = null;
            }

            switch(memberId){
                case Data.EMPLOYEE:
                    employee[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:
                    employee[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case Data.DESIGNER:
                    bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
                    employee[i] = new Designer(id, name, age, salary, equipment,bonus);
                    break;
                case Data.ARCHITECT:
                    bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employee[i] = new Architect(id, name, age, salary, equipment,bonus,stock);
                    break;
            }
            //注释段一
        }
    }

    public Employee[] getAllEmployees(){
        return employee;
    }

    public Employee getEmployee(int id) throws TeamException {
        for(int i = 0; i < employee.length; i++){
            if(id == employee[i].getId()){
                return employee[i];
            }
        }
        throw new TeamException("该员工不存在");
    }

    public static void main(String[] args) {
        NameListService s = new NameListService();
        Employee[] employees = s.getAllEmployees();
        System.out.println(employees[0]);
        try {
            System.out.println(s.getEmployee(10));
        } catch (TeamException e) {
            e.printStackTrace();
        }
    }
}

//注释段一
//            if(memberId >= Data.EMPLOYEE) {
//                int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
//                String name = Data.EMPLOYEES[i][2];
//                int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
//                int salary = Integer.parseInt(Data.EMPLOYEES[i][4]);
//                employee[i] = new Employee(id, name, age, salary);
//                if (memberId >= Data.PROGRAMMER) {
//                    EquipmentId = Integer.parseInt(Data.EQUIPMENTS[i][0]);
//                    if (EquipmentId == Data.PC) {
//                        equipment = new PC(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
//                    } else if (EquipmentId == Data.NOTEBOOK) {
//                        double price = Double.parseDouble(Data.EQUIPMENTS[i][2]);
//                        equipment = new NoteBook(Data.EQUIPMENTS[i][1], price);
//                    } else if (EquipmentId == Data.PRINTER){
//                        equipment = new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
//                    } else{
//                        equipment = null;
//                    }
//                    employee[i] = new Programmer(id, name, age, salary, equipment);
//                    if (memberId >= Data.DESIGNER) {
//                        int bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
//                        employee[i] = new Designer(id, name, age, salary, equipment,bonus);
//                        if (memberId >= Data.ARCHITECT) {
//                            int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
//                            employee[i] = new Architect(id, name, age, salary, equipment,bonus,stock);
//                        }
//                    }
//                }
//            }