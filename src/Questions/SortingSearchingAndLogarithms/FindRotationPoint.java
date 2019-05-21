package Questions.SortingSearchingAndLogarithms;

import Questions.IQuestion;

public class FindRotationPoint implements IQuestion {
    @Override
    public void run() {
        String[] words = new String[]{
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote",  // <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        };
        int rotationPointIndex = getRotationPointIndex(words);
        System.out.println(rotationPointIndex);
    }

    private int findRotationPointRefactored(String[] words) {
        final String firstWord = words[0];

        int floorIndex = 0;
        int ceilingIndex = words.length - 1;

        while (floorIndex < ceilingIndex) {
            int guessIndex = floorIndex + ((floorIndex + ceilingIndex) / 2);

            if (words[guessIndex].compareTo(firstWord) >= 0) {
                floorIndex = guessIndex;
            } else {
                ceilingIndex = guessIndex;
            }

            if (floorIndex + 1 == ceilingIndex) {
                break;
            }
        }

        return ceilingIndex;
    }

    private int getRotationPointIndex(String[] words) {
        return findRotationPointWithBinarySearch(words, 0, words.length);
    }

    private int findRotationPointWithBinarySearch(String[] words, int s, int e) {
        int m = (s + e) / 2;
        if (m - 1 < 0 || m + 1 >= words.length) {
            return m;
        }

        if (words[m].compareTo(words[m-1]) < 0 && words[m].compareTo( words[m+1]) < 0) {
            return m;
        }
        else if (words[m].compareTo(words[words.length - 1]) < 0) {
            // search left
            return findRotationPointWithBinarySearch(words, s, m-1);
        } else {
            // search right
            return findRotationPointWithBinarySearch(words, m+1, e);
        }
    }
}
