package Questions.ArraysAndStrings;

import Questions.IQuestion;

public class OneAway implements IQuestion {
    @Override
    public void run() {
        boolean b = isOneEditAway("hello", "hel");
        System.out.println(b);
    }

    private static boolean isOneEditAway(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException();
        }

        int lengthDifference = Math.abs(s1.length() - s2.length());
        if (lengthDifference > 1) {
            return false;
        }

        if (lengthDifference == 0) {
            // replace
            if (s1.equals(s2)) {
                return true;
            }

            int diff = 0;
            for(int i=0; i<s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diff++;
                }
            }

            return diff <= 1;
        }
        else {
            String longer = (s1.length() > s2.length()) ? s1 : s2;
            String shorter = (s1.length() > s2.length()) ? s2 : s1;
            int shorterIndex = 0;
            int foundDiff = 0;
            for(int i=0; i<longer.length(); i++) {
                if (shorterIndex >= shorter.length() ||
                        longer.charAt(i) != shorter.charAt(shorterIndex)) {
                    foundDiff++;
                } else {
                    shorterIndex++;
                }
            }
            return foundDiff <= 1;
        }
    }
}
