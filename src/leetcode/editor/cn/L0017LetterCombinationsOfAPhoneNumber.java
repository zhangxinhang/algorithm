package leetcode.editor.cn;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法

import java.util.*;

public class L0017LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new L0017LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23").stream().forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<String, List<String>> charMap = new HashMap<>();

        public List<String> letterCombinations(String digits) {
            List<String> ret = new ArrayList<>();
            if (charMap.isEmpty()) {
                initMap();
            }
            int len = digits.length();
            int i = 0;
            while (i < len) {
                List<String> newList = charMap.get(digits.charAt(i) + "");
                if (i == 0) {
                    ret = newList;
                } else {
                    List<String> newRet = new ArrayList<>();
                    for (String s : ret) {
                        for (String s1 : newList) {
                            newRet.add(s + s1);
                        }
                    }
                    ret = newRet;
                }
                i++;
            }

            return ret;
        }

        private void initMap() {
            charMap.put("2", Arrays.asList("a", "b", "c"));
            charMap.put("3", Arrays.asList("d", "e", "f"));
            charMap.put("4", Arrays.asList("g", "h", "i"));
            charMap.put("5", Arrays.asList("j", "k", "l"));
            charMap.put("6", Arrays.asList("m", "n", "o"));
            charMap.put("7", Arrays.asList("p", "q", "r", "s"));
            charMap.put("8", Arrays.asList("t", "u", "v"));
            charMap.put("9", Arrays.asList("w", "x", "y", "z"));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}