/*
Stock Buy Sell to Maximize Profit
In the “Stock Buy Sell to Maximize Profit” problem we have given an array that contains
stock price on each day, find the maximum profit that you can make by buying and selling
in those days. Here, we can buy and sell multiple times but only after selling a stock,
you can buy another stock.

Output Format
Print an integer that denotes the maximum profit we can achieve.
You may complete as many transactions as you like (i.e., buy one and
sell one share of the stock multiple times).
O(n) where n is the size of the given array. Here we traverse the whole array just
one-time ans update our answer.
Space Complexity
O(1) because we don’t use any auxiliary space here.
 */
public class BuySellStocksForMaximumProfit {
    public static void main(String[] args) {
        int[] array1 = {4, 7, 2, 3, 6, 1};
        int[] array2 = {9, 5, 4, 2};

        System.out.println(" Get Max Profit for 1st input " +getMaxProfit(array1));
        System.out.println(" Get Max Profit for 2nd input " +getMaxProfit(array2));
    }

    public static int getMaxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > max) {
                max = prices[i] - minPrice;
            }
        }
        return max;
    }
}
