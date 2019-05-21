package Questions.ArraysAndStrings;

import Questions.IQuestion;

public class StringCompression implements IQuestion {
    @Override
    public void run() {
        String s = compress("aaabbbcccccc");
        System.out.println(s);
    }

    private static String compress(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        if (s.length() <= 2) {
            return s;
        }

        char current = c[0];
        int count = 1;
        for(int i=1; i<c.length; i++) {
            if (c[i] == current) {
                count++;
            } else {
                sb.append(current).append(count);
                current = c[i];
                count = 1;
            }
        }
        sb.append(current).append(count);

        return  (sb.length() < s.length()) ? sb.toString() : s;
    }
}
