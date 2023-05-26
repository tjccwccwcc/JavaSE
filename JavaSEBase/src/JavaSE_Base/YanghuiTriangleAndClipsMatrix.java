package JavaSE_Base;
public class YanghuiTriangleAndClipsMatrix {
    public static void main(String[] args){
        //十行杨辉三角
        int[][] yanHui = new int[10][];
        for (int i = 0; i < yanHui.length; i++){
            yanHui[i] = new int[i+1];
            yanHui[i][0] = 1;
            for (int j = 0; j < yanHui[i].length; j++){
                if(j > 0 && j < i)
                    yanHui[i][j] = yanHui[i-1][j-1] + yanHui[i-1][j];
                if(i == j)
                    yanHui[i][j] = 1;
                System.out.printf("%4d", yanHui[i][j]);
            }
            System.out.println();
        }
        //创建一个长度为6的int型数组，要求数组元素的值都在1-30 之间，且是随机赋值。同时，要求元素的值各不相同。
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++){
            boolean control = true;
            while (control){
                arr[i] = (int)(Math.random() * 30) + 1;
                control = false;
                for (int j = i - 1; j >= 0; j--){
                    if(arr[j] == arr[i]) {
                        control = true;
                        break;//向前找到一个一样的就跳出循环
                    }
                }
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        //回形矩阵
        int len = 10;
        int control = 0;
        int[][] arr1 = new int[len][len];
        for (int i = 0; i < 2 * arr1.length; i++){
            if (i % 4 == 0){//分四段为一圈
                for (int j = control; j < len; j++){
                    if(j != 0)
                        arr1[control][j] = arr1[control][j-1] + 1;
                    else
                        arr1[control][j] = 1;
                }
                control ++;
            }
            if (i % 4 == 1){
                for (int j = control; j < len; j++){
                    arr1[j][len-1] = arr1[j-1][len-1] + 1;
                }
            }
            if (i % 4 == 2){
                for (int j = len - 2; j >= control - 1; j--){
                    arr1[len-1][j] = arr1[len-1][j+1] + 1;
                }
                len --;
            }
            if (i % 4 == 3){
                for (int j = len - 1; j >= control; j--){
                    arr1[j][control-1] = arr1[j+1][control-1] + 1;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1.length; j++){
                System.out.printf("%4d",arr1[i][j]);
            }
            System.out.println();
        }
    }
}
//1
//1 1
//1 2 1
//1 3 3 1


//int[][] yanHui = new int[10][10];
        /*
        for (int i = 0; i < yanHui.length; i++){
            for (int j = 0; j <= i; j++){
                System.out.printf("%4d", yanHui[i][j]);
            }
            System.out.println();
        }
         */

