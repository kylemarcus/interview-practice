package Questions.ArraysAndStrings;

import Questions.IQuestion;

public class URLify implements IQuestion {
    @Override
    public void run() {
        String s = "hello world  ";
        char[] c = s.toCharArray();
        createUrl(c);
        s = new String(c);
        System.out.println(s);
    }

    private static void createUrl(char[] c) {
        if (c == null) {
            throw new IllegalArgumentException();
        }

        int charIndex = c.length - 1;
        while (charIndex >= 0 && c[charIndex] == ' ') {
            charIndex--;
        }

        if (charIndex < 0) {
            throw new IllegalArgumentException("No chars in c");
        }

        int endIndex = c.length - 1;
        do {
            if (c[charIndex] != ' ') {
                c[endIndex--] = c[charIndex--];
            }
            else if (c[charIndex] == ' ') {
                charIndex--;
                c[endIndex--] = '0';
                c[endIndex--] = '2';
                c[endIndex--] = '%';
            }
        } while (charIndex >= 0);
    }
}
