package JavaSE_Base;

public class PrimeNumber {
    public static void main(String[] args){
        //Scanner input = new Scanner(System.in);
        //System.out.print("输入一个数：");
        //int num = input.nextInt();
        long start = System.currentTimeMillis();
        //System.out.println(num + "是质数吗？" + isPrime(num));
        int count = 0;
        label:for (int i = 0; i < 1000; i++){
            if (isPrime(i) == true) count++;//方法一
            /*
            //方法二
            if (i == 0 || i == 1) continue;
            for(int j = 2; j <= Math.sqrt(i); j++){//17ms
                if (i % j == 0) continue label;
            }
            count ++;
            */
            /*测试break和continue
            for (int j = 0; j < i; j ++){
                if (j == 2) break label;//continue;//break;
                System.out.println(j);
            }
            */
        }
        long end = System.currentTimeMillis();
        System.out.println("1000内素数的个数为：" + count);
        System.out.println("运行时间为：" + (end - start));
    }
    public static boolean isPrime(int num){
        boolean result = true;
        if (num <= 0 || num == 1) result = false;
        else{
            //for(int i = 2; i < num; i++){//无break174ms,有break38ms
            for(int i = 2; i <= Math.sqrt(num); i++){//17ms
                if (num % i == 0){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
