package JavaSE_Base;


public class XiaoTest {
    public static void main(String[] args){
        int num1 = 10;
        int num2 = 20;
        String s1 = "-20";
        System.out.println(Double.parseDouble(s1));
        //方法三(只能用于数值类型)
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        /*
        //第二种（不用临时变量，可能超过范围，只能用于数值类型）
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        */
        /*
        //第一种（推荐）
        int temp = num1;
        num1 = num2;
        num2 = temp;
         */
    }
}
        /*
        float k = 10;
        int j = 0;
        int j1 = 0;
        //System.out.println(j = j + k);//报错
        System.out.println(j1 += k);//+=不改变数据类型
        */

        //++操作
        /*
        int i1 = 10;
        int i2 = 20;
        int i3 = 40;
        System.out.println(i3 ++);
        int i = i1++;//不能(i1++)++,直接i1 += 2即可
        System.out.println(i);
        System.out.println(i1);
        i = ++i1;
        System.out.println(i);
        System.out.println(i1);
        i = i2--;
        System.out.println(i);
        System.out.println(i2);
        i = --i2;
        System.out.println(i);
        System.out.println(i2);
        */

        /*
        int n = 10;
        n += (n++) + (++n);
        //n = n + (n++) + (++n)
        //n = 10 + 10 + 12
        System.out.println(n);//32
        */

        /*
        int i = 1;
        //i = i * 0.1;//报错
        i *= 0.1;
        System.out.println(i);
        i++;//不改变数据类型
        System.out.println(i);
        i += 0.1;
        byte j = 127;
        j ++;//-128
        System.out.println(i);
        System.out.println(1*0.1);
        System.out.println(5/3);
        System.out.println(5/3.0);
        */

        /*
        int a=3;
        int b=2;
        //&&如果左边为假，那么右边不参与运算
        if (a>1 || b++>0) {}//当左边为真，右边不参与运算
        System.out.println("a1="+a+" "+"b1="+b);
        if (a>1 | b++>0) {}
        System.out.println("a2="+a+" "+"b2="+b);
        if (a>4 || b++>0) {}
        System.out.println("a3="+a+" "+"b3="+b);
        */

        /*
        System.out.println("5 + 5 = " + (5 + 5));
        System.out.println(3 << 2);
        System.out.println(3 >> 1);
        System.out.println(3 >>> 1);
        System.out.println(-3 >> 1);//对补码进行操作，同时补码右移空位补1
        System.out.println(-3 >>> 1);//补码右移空位补0
        */

        /*
        long x = 121312312131L;
        float y = 105.84f;
        double z = 5 / 2;
        System.out.println(x);
        System.out.println("\"y\"是"+y);
        System.out.println('\t');
        System.out.println('\t' + 'a');
        System.out.println("t" + "\t" + "r");
        System.out.println(z);//2.0
        System.out.println(12 % 5);
        System.out.println((-12) % 5);
        System.out.println(12 % (-5));
        System.out.println((-12) % (-5));//符号与被模数一样
         */

        /*
        boolean x = true;
        boolean y = false;
        short z = 42;
        //if(y == true)//加上这句话下个if会被跳过
        if((z++ == 42) && (y = true)) z++;//注意这里是y = true而不是y == true
        if((x = false) || (++z == 45)) z++;
        System. out.println ("z=" + z);
        System. out.println (~6);
         */