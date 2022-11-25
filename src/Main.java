public class Main {


    public static void main(String[] args) {
        System.out.println("Hello in Car Import Calculator \n");
        double kursDolara = 4.52;
        System.out.println("Current $ calculation: "+kursDolara + "zł" +"\n");
        CarProperties carEvaluation = new CarProperties(1200,4200);

        System.out.println(carEvaluation.sumTransportFees(carEvaluation));
        displayEstimatedValues(carEvaluation);

    }
    //Auction fee based on car Value - minimum 690$ max 1090$, depend on car bid value
    private static double auctionFee(double bidAmount){
        double auctionPercent = 0.195;
        double min = 690;
        double max = 1090;
        bidAmount = bidAmount*auctionPercent;
        if (bidAmount >= max){
            bidAmount = max;
        } else if (bidAmount <= min){
            bidAmount = min;
        }
        return bidAmount;
    }

    //Custom duty fee - 10% of car bid value
    private static double customDuty(CarProperties carProperties){
        return carProperties.carBid*0.1;
    }

    //Tax 21% Calculation - 21% counted from car value plus the value of the duty
    private static double tax21(CarProperties carProperties){
        double result = carProperties.carBid + customDuty(carProperties);
        return result*1.21;
    }

    //Excise fee - 18.6% when engine capacity over 2.0L, otherwise 3.1%
    private static double exciseTax(CarProperties carProperties){
        double result;
        if (carProperties.over2l){
            result = carProperties.carBid * 1.186;
        } else {
            result = carProperties.carBid * 1.031;
        }
        return result;
    }

    //Display parameters
    private static void displayEstimatedValues(CarProperties carProperties){
        String displayParameters = "\n" + "Costs estimation" + "\n" + "Car bid set for: " + carProperties.carBid + "\n" +
                "Car auction fee calculated: " + auctionFee(carProperties.carBid) + "\n" +
                "Cost of transport from USA: " + carProperties.transportUSA + "\n" +
                "Cost of custom clearance USA: " + carProperties.customClearanceUSA + "\n" +
                "Cost of transport from EU: " + carProperties.transportEU + "\n" +
                "Cost of custom clearance EU: " + carProperties.customClearanceEU + "\n";
        System.out.println(displayParameters);
    }


}