import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 1;
        int currentMax = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        for (int i = 1; i < length; i++) {
            Character cur = s.charAt(i);
            if (!set.contains(cur)) {
                set.add(cur);
                currentMax++;
            } else {
                set.clear();
                set.add(cur);
                currentMax = 1;
            }
            if (currentMax > max) {
                max = currentMax;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
