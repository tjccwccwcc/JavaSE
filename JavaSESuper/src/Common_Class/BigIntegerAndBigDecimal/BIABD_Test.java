package Common_Class.BigIntegerAndBigDecimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BIABD_Test {
    @Test
    public void test2() {
        //处理过大的整型
        BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
        //处理精度要求高的数据
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
//         System.out.println(bd.divide(bd2));//除不尽报错
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));

    }
}
