public class Solution {





    private static double auctionFee(double bidAmount){
        double auctionPercent = 0.195;
        double min = 690;
        double max = 1090;

        bidAmount = bidAmount*auctionPercent;
        if (bidAmount >= max){
            bidAmount = max;
        } else if (bidAmount <= min){
            bidAmount = min;
        } else {
            return bidAmount;
        }
        return bidAmount;
    }




}
