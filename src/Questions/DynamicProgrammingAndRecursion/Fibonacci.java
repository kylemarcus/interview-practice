package Questions.DynamicProgrammingAndRecursion;

import Questions.IQuestion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci implements IQuestion {
    @Override
    public void run() {
        int answer = fib(40, new HashMap<>());
        System.out.println(answer);
    }

    private int fib(int i, Map<Integer, Integer> memo) {
        if (i < 2) {
            memo.put(i, i);
            return i;
        }

        if (memo.containsKey(i))
            return memo.get(i);

        int x = fib(i - 1, memo) + fib(i - 2, memo);
        memo.put(i, x);
        return x;
    }
}
