package Arithmetic.B4_Dp_Dynamic_Programming;

/**
 * 背包最大重量为4。
 *
 * 物品为：
 *
 *         重量	价值
 * 物品  0	1	15
 * 物品  1	3	20
 * 物品  2	4	30
 * 每件商品都有无限个！
 *
 * 问背包能背的物品最大价值是多少？
 *
 * 01背包和完全背包唯一不同就是体现在遍历顺序上，所以本文就不去做动规五部曲了，我们直接针对遍历顺序经行分析！
 *
 * 其实还有一个很重要的问题，为什么遍历物品在外层循环，遍历背包容量在内层循环？
 * 这个问题很多题解关于这里都是轻描淡写就略过了，大家都默认 遍历物品在外层，遍历背包容量在内层，好像本应该如此一样，那么为什么呢？
 * 01背包中二维dp数组的两个for遍历的先后循序是可以颠倒了，
 * 一维dp数组的两个for循环先后循序一定是先遍历物品，再遍历背包容量。
 *
 * 在完全背包中，对于一维dp数组来说，其实两个for循环嵌套顺序是无所谓的！
 * 因为dp[j] 是根据 下标j之前所对应的dp[j]计算出来的。
 * 只要保证下标j之前的dp[j]都是经过计算的就可以了。
 *
 * 完全背包中，两个for循环的先后循序，都不影响计算dp[j]所需要的值（这个值就是下标j之前所对应的dp[j]）。
 * 先遍历背包在遍历物品，代码如下：
 */
public class C1_CompletePacking {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        C1_CompletePacking c1_completePacking = new C1_CompletePacking();
        System.out.println(c1_completePacking.completePacking(weight, value, bagSize));
    }
    public int completePacking(int[] weight, int[] value, int bagSize){
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j < dp.length; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagSize];
    }
}
