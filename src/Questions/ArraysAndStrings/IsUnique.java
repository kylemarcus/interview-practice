package Questions.ArraysAndStrings;

import Questions.IQuestion;

import java.util.Arrays;

public class IsUnique implements IQuestion {
    @Override
    public void run() {
        boolean unique = isUnique("hello");
        System.out.println(unique);
    }

    public static boolean isUnique(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String can not be null");
        }

        char[] c = s.toCharArray();
        Arrays.sort(c);

        for(int i=0; i<s.length(); i++) {
            if (i != s.length()-1 && c[i] == c[i+1]) {
                return false;
            }
        }

        return true;
    }
}
