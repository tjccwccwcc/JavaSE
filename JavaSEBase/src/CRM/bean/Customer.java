package CRM.bean;
public class Customer {
    //属性
    private String name;
    private String sex;
    private int age;
    private String phoneNumber;
    private String email;

    //构造器：初始化属性
    public Customer(String name,String sex,int age,String phoneNumber,String email){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
