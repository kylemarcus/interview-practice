package Questions.DynamicProgrammingAndRecursion;

import Questions.IQuestion;

import java.util.HashSet;
import java.util.Set;

public class RecursiveStringPermutations implements IQuestion {
    @Override
    public void run() {
        Set<String> set = allPermutations("abc");
        for(String s : set) {
            System.out.println(s);
        }
    }

    private Set<String> allPermutations(String s) {
        if (s.length() == 1) {
            Set<String> set = new HashSet<>();
            set.add(s);
            return set;
        }

        char c = s.charAt(0);
        Set<String> subsets = allPermutations(s.substring(1));

        Set<String> addedSubsets = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(String subset : subsets) {
            for(int i=0; i<=subset.length(); i++) {
                sb.setLength(0);
                String prefix = subset.substring(0,i);
                String postfix = subset.substring(i);
                sb.append(prefix).append(c).append(postfix);
                addedSubsets.add(sb.toString());
            }
        }

        return addedSubsets;
    }
}
