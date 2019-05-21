package Questions.ArraysAndStrings;

import Questions.IQuestion;

public class ReverseStringInPlace implements IQuestion {
    @Override
    public void run() {
        String s = "helloworld";
        char[] c = s.toCharArray();
        reverse(c);
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (char c1 : c) {
            sb.append(c1).append(", ");
        }
        sb.append("]");

        System.out.println(sb);
    }

    private void reverse(char[] c) {
        int s = 0;
        int e = c.length - 1;

        while (s < e) {
            char t = c[s];
            c[s++] = c[e];
            c[e--] = t;
        }
    }
}
