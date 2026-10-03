public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int lowestPrice = prices[0];
        int bestProfit = 0;
        for (int day = 1; day < prices.length; day++) {
            bestProfit = Math.max(bestProfit, prices[day] - lowestPrice);
            lowestPrice = Math.min(lowestPrice, prices[day]);
        }
        return bestProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[] {7, 6, 4, 3, 1}));
    }
}