package Questions.GreedyAlgorithms;

import Questions.IQuestion;

public class HighestProductOf3 implements IQuestion {
    @Override
    public void run() {
        int answer = highestProductRefactored(new int[] {1, 2, 3, 4, 5, -10, -2});
        System.out.println(answer);
    }

    private int highestProductRefactored(int[] array) {
        int highestProductOf3 = 0;

        int highestProductOf2 = 0;
        int highest = 0;

        int lowestProductOf2 = 0;
        int lowest = 0;

        for(int i : array) {
            if (i >= 0) {
                //positive
                if (i > highest) {
                    highestProductOf2 = i * highest;
                    highest = i;
                }
            } else {
                if (i < lowest) {
                    lowestProductOf2 = i * lowest;
                    lowest = i;
                }
            }

            highestProductOf3 = Math.max(highestProductOf2 * highest, lowestProductOf2 * highest);
        }

        return highestProductOf3;
    }

    private int highestProduct(int[] arrayOfInts) {
        int[] top3HighestPos = new int[3];
        int[] top2LowestNeg = new int[2];

        for(int i : arrayOfInts) {
            if (i >= 0) {
                //positive
                if (i > top3HighestPos[0]) {
                    top3HighestPos[2] = top3HighestPos[1];
                    top3HighestPos[1] = top3HighestPos[0];
                    top3HighestPos[0] = i;
                } else if (i > top3HighestPos[1]) {
                    top3HighestPos[2] = top3HighestPos[1];
                    top3HighestPos[1] = i;
                } else if (i > top3HighestPos[2]) {
                    top3HighestPos[2] = i;
                }
            } else {
                //negative
                if (i < top2LowestNeg[0]) {
                    top2LowestNeg[1] = top2LowestNeg[0];
                    top2LowestNeg[0] = i;
                } else if (i < top2LowestNeg[1]) {
                    top2LowestNeg[1] = i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : top3HighestPos) {
            sb.append(i).append(", ");
        }
        System.out.println(sb);
        sb.setLength(0);

        for(int i : top2LowestNeg) {
            sb.append(i).append(", ");
        }
        System.out.println(sb);

        int highestPos = top3HighestPos[0] * top3HighestPos[1] * top3HighestPos[2];
        int highestNeg = top2LowestNeg[0] * top2LowestNeg[1] * top3HighestPos[0];

        return Math.max(highestPos, highestNeg);
    }

}
