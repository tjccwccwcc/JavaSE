package Arithmetic;
import java.util.*;
public class sort {
    public static void main(String[] args){
        //排序算法：时间复杂度、空间复杂度、稳定性（值相同元素位置关系不变）
        int[] arr = new int[]{35,26,234,52,62,275,2542,256,23466,265,35};
        int[] arr1 = new int[]{35,26,234,52,62,275,2542,256,23466,265,35};
        int[] arr2 = new int[]{35,26,234,52,62,275,2542,256,23466,265,35};
        int[] arr3 = new int[]{35,26,234,52,62,275,2542,256,23466,265,35};
        int[] arr4 = new int[]{35,26,234,52,62,275,2542,256,23466,265,35};
        int[] arr5 = new int[]{35,26,234,52,62,275,2542,256,23466,265,35};
        int[] arr6 = new int[]{35,26,234,52,62,275,2542,256,23466,265,35};
        System.out.println(Arrays.toString(arr));

        //插入排序
        arr =  insertSort(arr);
        print(arr);

        //希尔排序
        arr1 =  shellSort(arr1);
        print(arr1);

        //交换排序
        arr2 = bubbleSort(arr2);
        print(arr2);

        //快速排序
        arr3 = quickSort(arr3,0,arr3.length - 1);//Arrays.sort()
        print(arr3);

        //选择排序
        arr4 = selectSort(arr4);
        print(arr4);

        heapSort(arr5);
        print(arr5);

        //归并排序
        mergeSort(arr6,0,arr6.length-1);
        print(arr6);
    }

    //直接插入排序
    //时间复杂度o(n*n),稳定
    public static int[] insertSort(int[] array){
        int temp = 0;
        for(int i = 1; i < array.length; i++){//第0位独自作为有序数列，从第1位开始向后遍历
            if(array[i] < array[i-1]){//0~i-1位为有序，若第i位小于i-1位，继续寻位并插入，否则认为0~i位也是有序的，忽略此次循环，相当于continue
                temp = array[i];//保存第i位的值
                int j = i - 1;
                while(j >= 0 && temp < array[j]){//从第i-1位向前遍历并移位，直至找到小于第i位值停止
                    array[j+1] = array[j];
                    j--;
                }
                array[j+1] = temp;//插入第i位的值
            }
        }
        return array;
    }

    //希尔排序
    //o(nlog2n)-o(n2)，不稳定
    public static int[] shellSort(int[] array){
        int temp = 0;
        //步长
        for (int gap = array.length/2; gap >= 1; gap = gap/2){
            for (int i = gap; i < array.length; i++){
                //分组
                for (int j = i - gap; j >= 0; j = j-gap){
                    if (array[j] > array[j+gap]){
                        temp = array[j];
                        array[j] = array[j+gap];
                        array[j+gap] = temp;
                    }
                }
            }
        }
        return array;
    }

    //冒泡排序
    //o(n2),稳定
    public static int[] bubbleSort(int[] array){
        int temp = 0;
        for (int i = 1; i < array.length; i++){
            for (int j = 0; j < array.length - i; j++){
                if (array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    //快速排序
    //o(nlogn),不稳定
    public static int[] quickSort(int[] array,int s,int t){
        int i = 0;
        if (s < t){
            i = Partition(array,s,t);
            quickSort(array,s,i-1);
            quickSort(array,i+1,t);
        }
        return array;
    }
    public static int Partition(int[] array,int low,int high){
        int temp = array[low];
        while (low < high){
            while (low < high && array[high] >= temp) high--;
            if (low < high) {
                array[low] = array[high];
                low++;
            }
            while (low < high && array[low] < temp) low++;
            if (low < high) {
                array[high] = array[low];
                high--;
            }
        }
        array[low] = temp;
        return low;
    }

    //简单选择排序
    //o(n2),不稳定
    public static int[] selectSort(int[] array){
        int k = 0;
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++){
            k = i;
            for (int j = i + 1; j < array.length; j++){
                if(array[j] < array[k]) k = j;
            }
            if (k != i){
                temp = array[k];
                array[k] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }

    //堆排序
    //o(nlog2n),不稳定,o(1)
    public static void heapSort(int[] array) {
        int N = array.length;
        for (int i = N / 2; i >= 0; i--) {// 创建最大堆
            sink(array, i, N);
        }
        while (N > 0) {//就地排序
            swap(array, 0, --N);// 将最大的元素移动到数组的尾部，同时将未排序的长度-1
            sink(array, 0, N);// 调整最大堆
        }
    }
    public static void sink(int[] array, int k, int N) {
        while (2 * k + 1 < N) {
            int j = 2 * k + 1;
            if (j < N - 1 && less(array[j], array[j + 1])) j++;
            if (!less(array[k], array[j])) break;
            swap(array, k, j);
            k = j;
        }
    }
    public static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static boolean less(int a, int b) {
        if (a > b) return false;
        else return true;
    }

    //2-路归并
    //o(nlog2n),稳定,o(n)
    public static void mergeSort(int[] arr,int left,int right) {
        if (left == right) {
            return;
        }
        int mid = left +(right-left)/2;//分成两半
        mergeSort(arr, left, mid);//左边排序
        mergeSort(arr, mid +1, right);//右边排序
        merge(arr, left, mid+1, right);
    }
    //leftPtr 指数组最左边
    //rightPtr 指数组中间
    //rightBound 数组最右边
    static void merge(int[] arr,int leftPtr,int rightPtr,int rightBound) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];
        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        while (i <= mid && j <= rightBound) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {// 将右边剩余的归并
            temp[k++] = arr[i++];
        }
        while (j <= rightBound) {//将左边剩余的归并
            temp[k++] = arr[j++];
        }
        for(int m = 0; m < temp.length; m++) arr[leftPtr+m] = temp[m];
    }

    //打印矩阵
    public static void print(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
