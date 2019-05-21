package Questions.ArraysAndStrings;

import Questions.IQuestion;

import java.util.Arrays;

public class Permutation implements IQuestion {
    @Override
    public void run() {
        boolean perm = isPermutation("hello", "olleh");
        System.out.println(perm);
    }

    public static boolean isPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        s1 = new String(c1);
        s2 = new String(c2);
        return s1.equals(s2);
    }

}
