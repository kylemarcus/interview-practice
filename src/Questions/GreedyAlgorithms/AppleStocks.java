package Questions.GreedyAlgorithms;

import Questions.IQuestion;

public class AppleStocks implements IQuestion {
    @Override
    public void run() {
        int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};
        int maxProfit = getMaxProfit(stockPricesYesterday);
        System.out.println(maxProfit);
    }

    private int getMaxProfit(int[] stockPricesYesterday) {
        if (stockPricesYesterday.length < 1) return 0;

        int maxProfit = 0;
        int lowestSeen = stockPricesYesterday[0];

        for(int stockPrice : stockPricesYesterday) {
            maxProfit = Math.max(maxProfit, stockPrice - lowestSeen);
            lowestSeen = Math.min(lowestSeen, stockPrice);
        }

        return maxProfit;
    }
}
