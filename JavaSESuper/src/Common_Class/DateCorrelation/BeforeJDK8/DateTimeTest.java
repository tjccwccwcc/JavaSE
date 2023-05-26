package Common_Class.DateCorrelation.BeforeJDK8;

import org.junit.Test;

import java.text.*;
import java.util.*;

public class DateTimeTest {
    @Test
    public void test(){
        long startTime = System.currentTimeMillis();
        String string = "";
        for (int i = 0; i < 1000; i++) {
            string += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(endTime-startTime);
    }

    @Test
    public void test1(){
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());

        Date date1 = new Date(date.getTime());
        System.out.println(date1);

        java.sql.Date date2 = new java.sql.Date(date.getTime());//Date转java.sql.Date
        System.out.println(date2);
//        System.out.println(date2.getTime());

//        java.sql.Date date3 = (java.sql.Date) date;//报错
//        Date date4 = new java.sql.Date(date.getTime());
//        java.sql.Date date5 = (java.sql.Date) date3;
    }

    @Test
    public void test2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);

        String str = "22-11-15 下午1:11";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        System.out.println("----------------------------");
//        SimpleDateFormat sdf2 = new SimpleDateFormat
//                ("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf2 = new SimpleDateFormat
                ("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf2.format(date);
        System.out.println(format1);
        Date date2 = sdf2.parse("2022-11-15 04:16:00");
        System.out.println(date2);
    }
    /*
    Date and Time Pattern               Result
    "yyyy.MM.dd G 'at' HH:mm:ss z"      2001.07.04 AD at 12:08:56 PDT
    "EEE, MMM d, ''yy"                  Wed, Jul 4, '01
    "h:mm a"                            12:08 PM
    "hh 'o''clock' a, zzzz"             12 o'clock PM, Pacific Daylight Time
    "K:mm a, z"                         0:08 PM, PDT
    "yyyyy.MMMMM.dd GGG hh:mm aaa"      02001.July.04 AD 12:08 PM
    "EEE, d MMM yyyy HH:mm:ss Z"        Wed, 4 Jul 2001 12:08:56 -0700
    "yyMMddHHmmssZ"                     010704120856-0700
    "yyyy-MM-dd'T'HH:mm:ss.SSSZ"        2001-07-04T12:08:56.235-0700
    "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"      2001-07-04T12:08:56.235-07:00
    "YYYY-'W'ww-u"                      2001-W27-3
    */

    @Test
    public void test3(){
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();

        //get()
        System.out.println(calendar.getClass());
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set()
        calendar1.set(Calendar.DAY_OF_MONTH,22);
        System.out.println(calendar1.getTime());
        //add()
        calendar1.add(Calendar.DAY_OF_MONTH,-7);
        System.out.println(calendar1.getTime());
        //getTime()
        // 从一个 Calendar 对象中获取 Date 对象
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime()
        // 使用给定的 Date 设置此 Calendar 的时间
        date = new Date(234234235235L);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        System.out.println("当前时间日设置为8后,时间是:" + calendar.getTime()); calendar.add(Calendar.HOUR, 2);
        System.out.println("当前时间加2小时后,时间是:" + calendar.getTime()); calendar.add(Calendar.MONTH, -2);
        System.out.println("当前日期减2个月后,时间是:" + calendar.getTime());
        //获取月份时：一月是0，二月是1，以此类推，12月是11
        //获取星期时：周日是1，周二是2 ， 。。。。周六是7
    }
}
