package JavaSE_Class.Object3.Service;

//public class Status {
//    private final String Name;
//    private Status(String Name){
//        this.Name = Name;
//    }
//
//    public static final Status FREE = new Status("FREE");
//    public static final Status VOCATION = new Status("VOCATION");
//    public static final Status BUSY = new Status("BUSY");
//
//    public String getName() {
//        return Name;
//    }
//
//    @Override
//    public String toString() {
//        return Name;
//    }
//}

public enum Status{
    FREE,
    VOCATION,
    BUSY
}