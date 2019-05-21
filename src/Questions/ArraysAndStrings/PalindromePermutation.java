package Questions.ArraysAndStrings;

import Questions.IQuestion;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation implements IQuestion {

    @Override
    public void run() {
        boolean b = isPalindromePermutation("hello");
        System.out.println(b);
    }

    private static boolean isPalindromePermutation(String s) {
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return set.size() <= 1;
    }
}
