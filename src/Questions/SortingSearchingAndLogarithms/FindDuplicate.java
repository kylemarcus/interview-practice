package Questions.SortingSearchingAndLogarithms;

import Questions.IQuestion;

import java.util.Arrays;

public class FindDuplicate implements IQuestion {
    @Override
    public void run() {
        int[] a = new int[] {1,2,3,4,5,5};
        int d = findDuplicate(a);
        System.out.println(d);
    }

    private int findDuplicate(int[] a) {
        Arrays.sort(a);

        int duplicate = 0;
        for(int i=0; i<a.length; i++) {
            if(i != a.length - 1) {
                if (a[i] == a[i+1]) {
                    duplicate = a[i];
                }
            }
        }

        return duplicate;
    }
}
