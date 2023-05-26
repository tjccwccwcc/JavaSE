package Common_Class.MathCorrelation;

public class MathTest {
    /*
    abs 绝对值
    acos,asin,atan,cos,sin,tan 三角函数
    sqrt 平方根
    pow(double a,doble b) a的b次幂
    log 自然对数
    exp e为底指数
    max(double a,double b)
    min(double a,double b)
    random() 返回0.0到1.0的随机数
    long round(double a) double型数据a转换为long型（四舍五入）
    toDegrees(double angrad) 弧度—>角度
    toRadians(double angdeg) 角度—>弧度
    */
    public static void main(String[] args) {
        System.out.println(Math.abs(-1));
        System.out.println(Math.acos(-1));
        System.out.println(Math.cos(Math.PI));
        System.out.println(Math.asin(1));
        System.out.println(Math.sin(Math.PI/2));
        System.out.println(Math.atan(Math.sqrt(3)/3));
        System.out.println(Math.tan(Math.PI/6));
    }
}
