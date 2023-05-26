package Arithmetic;

import java.util.*;
import edu.princeton.cs.algs4.*;
public class Chapter1 {
    public static void main(String[] args){
        int[][] a = new int[3][4];
        for (int i = 0; i < 3; i ++){
            for (int j = 0; j < 4; j ++){
                a[i][j] = i + j;
            }
        }
        int[][] b = new int[4][3];
        for (int i1 = 0; i1 < 4; i1 ++){
            for (int j1 = 0; j1 < 3; j1 ++){
                b[i1][j1] = i1 * j1;
            }
        }
        int[][] c = new int[3][3];
        for (int i2 = 0; i2 < 3; i2 ++){
            for (int j2 = 0; j2 < 3; j2 ++){
                for (int k = 0; k < 4; k++){
                    c[i2][j2] += a[i2][k] * b[k][j2];
                }
            }
        }
        int[] d = new int[10];
        for (int i3 = 0; i3 < d.length; i3 ++){
            d[i3] = i3;
        }
        System.out.println(Arrays.deepToString(c));
        System.out.println(Arrays.toString(d));
        System.out.println(rank(3, d));
    }
    public static int rank(int key, int[] a){
        return rank(key, a, 0, a.length - 1);
    }
    public static int rank(int key, int[] a, int lo, int hi){
        if (lo > hi)return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid] / 2)return rank(key, a, lo, mid - 1);
        else if (key > a[mid] / 2)return rank(key, a, mid + 1, hi);
        else return mid;
    }
}
/**
 文档注释
 javadoc -d mydoc -author -version Helloworld.java
 */