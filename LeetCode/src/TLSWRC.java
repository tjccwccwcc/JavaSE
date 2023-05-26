import groovy.transform.ASTTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
* The longest string without repeating characters
* 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
示例1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 

提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
 */
public class TLSWRC {
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    @Test()
    public void test(){
        String s = "ebeaec";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring1(s));
    }

}
