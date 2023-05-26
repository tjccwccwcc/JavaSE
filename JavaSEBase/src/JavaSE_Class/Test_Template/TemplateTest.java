package JavaSE_Class.Test_Template;

public class TemplateTest {
    public static void main(String[] args) {
        Template t = new SubTemplate();
        t.spendTime();
    }
}
abstract class Template{
    //计算代码花费的时间
    public void spendTime(){
        long start = System.currentTimeMillis();
        code();//不确定的部分、异变的部分
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));
    }
    public abstract void code();
}
class SubTemplate extends Template{
    public void code(){
        for (int i = 2; i < 1000; i++){
            boolean isTrue = true;
            for (int j = 2; j <= Math.sqrt(i); j ++){
                if (i % j == 0){
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) System.out.println(i);
        }
    }
}