package JavaSE_Class.Object3.Domain;

import JavaSE_Class.Object3.Service.Status;

public class Programmer extends Employee implements Equipment{
    private int memberId;
    private Equipment equipment;

    public void setStatus(Status status) {
        this.status = status;
    }

    private Status status = Status.FREE;

    public Programmer(int id, String name, int age,
                      double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public Status getStatus() {
        return status;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String getDescription() {
        return equipment.getDescription();
    }

    protected String getMemberDetails() {
        return getMemberId() + "/" + getDetails();
    }

    public String getDetailsForTeam() {
        return getMemberDetails() + "\t程序员";
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }
}

