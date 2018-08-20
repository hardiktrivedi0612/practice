package com.trivedi.hardik.interviewcake;

/**
 * Writing programming interview questions hasn't made me rich yet ... so I
 * might give up and start trading Apple stocks all day instead.
 * 
 * First, I wanna know how much money I could have made yesterday if I'd been
 * trading Apple stocks all day.
 * 
 * So I grabbed Apple's stock prices from yesterday and put them in an array
 * called stockPrices, where:
 * 
 * The indices are the time (in minutes) past trade opening time, which was
 * 9:30am local time. The values are the price (in US dollars) of one share of
 * Apple stock at that time.
 * 
 * So if the stock cost $500 at 10:30am, that means stockPrices[60] = 500.
 * 
 * Write an efficient method that takes stockPrices and returns the best profit
 * I could have made from one purchase and one sale of one share of Apple stock
 * yesterday.
 * 
 * For example:
 * 
 * int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};
 * 
 * getMaxProfit(stockPrices); // returns 6 (buying for $5 and selling for $11)
 * 
 * No "shorting"—you need to buy before you can sell. Also, you can't buy and
 * sell in the same time step—at least 1 minute has to pass.
 * 
 * @author hatrivedi
 * @date Jun 30, 2018
 * @since 2.5
 */
public class Stocks {

	/**
	 * @author hatrivedi
	 * @date Jun 30, 2018
	 * @since 2.5
	 * @param args
	 */
	public static void main(String[] args) {
		int[] stockPrices = new int[] { 10, 7, 5, 8, 11, 9 };

		System.out.println(getMaxProfit(stockPrices));
		// returns 6 (buying for $5 and selling for $11)
	}

	/**
	 * @author hatrivedi
	 * @date Jun 30, 2018
	 * @since 2.5
	 * @param stockPrices
	 */
	private static int getMaxProfit(int[] stockPrices) {
		if (stockPrices.length < 2) {
			throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
		}

		int minPrice = stockPrices[0];
		int maxProfit = stockPrices[1] - stockPrices[0];

		for (int i = 1; i < stockPrices.length; i++) {
			int currentPrice = stockPrices[i];

			int potentialProfit = currentPrice - minPrice;

			maxProfit = Math.max(maxProfit, potentialProfit);

			minPrice = Math.min(minPrice, currentPrice);
		}

		return maxProfit;
	}

}
