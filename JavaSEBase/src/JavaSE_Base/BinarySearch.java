package JavaSE_Base;
public class BinarySearch {
    public static void main(String[] args){
        //线性查找
        String[] str = {"JJ","DD","MM","BB","GG","AA"};
        String test = "BB";
        boolean isFlag = true;
        for (int i = 0; i < str.length; i++){
            if (str[i].equals(test)){
                System.out.println("所查元素索引为：" + i);
                isFlag = false;
                break;
            }
        }
        if(isFlag)System.out.println("没有找到");
        //二分查找：有序
        //可以多分查找，如果元素分布均匀且递增，可以用(被查数-首值)/(尾值-首值)确定如何分
        int[] intTest = new int[]{99, 54, 2,0,2,33,43,256,999};
        int test1 = 54;
        int start = 0;//首索引
        int end = intTest.length - 1;//尾索引
        boolean isFlag1 = true;
        while(start < end){
            int mid = (end - start)/2;
            if (intTest[mid] == test1){
                System.out.println("找到，索引为：" + mid);
                isFlag1 = false;
                break;
            }
            else if (intTest[mid] < test1) start += 1;
            else end -= 1;
        }
        if(isFlag1)System.out.println("没有找到");
    }
}
