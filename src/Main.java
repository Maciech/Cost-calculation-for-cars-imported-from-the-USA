public class Main {


    public static void main(String[] args) {
        System.out.println("Hello in Car Import Calculator \n");
        double kursDolara = 4.52;
        System.out.println("Aktualny kurs dolara to: "+kursDolara +"\n");
        CarProperties carEvaluation = new CarProperties(1200,4200);

        System.out.println(carEvaluation.sumFees(carEvaluation));
        displayEstimatedValues(carEvaluation);

    }
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
    private static double customDuty(CarProperties carProperties){
        return carProperties.carBid*0.1;
    }
    //Tax 21% Calculation - 21% counter from car value plus the value of the duty
    private static double tax21(CarProperties carProperties){
        double result = carProperties.carBid + customDuty(carProperties);
        return result*1.21;
    }
    private static void displayEstimatedValues(CarProperties carProperties){
        StringBuilder stringBuilder = new StringBuilder("\n" +"Costs estimation"+ "\n");
        stringBuilder.append("Car bid set for: " + carProperties.carBid).append("\n");
        stringBuilder.append("Car auction fee calculated: " + auctionFee(carProperties.carBid)).append("\n");
        stringBuilder.append("Cost of transport from USA: " + carProperties.transportUSA).append("\n");
        stringBuilder.append("Cost of custom clearance USA: " + carProperties.customClearanceUSA).append("\n");
        stringBuilder.append("Cost of transport from EU: " + carProperties.transportEU).append("\n");
        stringBuilder.append("Cost of custom clearance EU: " + carProperties.customClearanceEU).append("\n");
        System.out.println(stringBuilder);
    }
}