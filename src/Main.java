import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Hello in Car Import Calculator \n");
        double dollarCourse = 4.47;
        System.out.println("Current $ calculation: "+dollarCourse + "zł" +"\n");
        //CarProperties carEvaluation = new CarProperties(1200,4200);
        //webConnection conn = new webConnection();
        //  conn.readWeb();
        Main main = new Main();
        main.startCalculation(dollarCourse);

    }
    //Initial method from main to start calculating costs
    private void startCalculation(double dollarCourse) throws IOException {

        CarProperties carEvaluation = new DataReader().readData();
        System.out.println("\n" + "Calculated costs in dollars and zloty");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        if (carEvaluation.carBid != 0){
            //System.out.format("%.2f%n",sumAllCosts(carEvaluation, dollarCourse)+"$");
            System.out.println(Math.round(sumAllCosts(carEvaluation, dollarCourse))+" $");
            System.out.println(Math.round(sumAllCosts(carEvaluation, dollarCourse)*dollarCourse)+" zł");
            displayEstimatedValues(carEvaluation);
            System.out.println("Another calculation? ( yes / no )");
            if (bufferedReader.readLine().contains("yes")){
                startCalculation(dollarCourse);
            }

        } else {
            System.out.println("Error 404 - you can't calculate from zero car value!");
            System.out.println("Try again? ( yes / no )");

            if (bufferedReader.readLine().contains("yes")){
                startCalculation(dollarCourse);
            }
        }
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
        return Math.round(bidAmount);
    }

    //Custom duty fee - 10% of car bid value
    private static double customDuty(double bidAmount){
        return Math.round(bidAmount*0.1);
    }

    //Tax 21% Calculation - 21% counted from car value plus the value of the duty
    private static double tax21(double bidAmount){
        double result = bidAmount + customDuty(bidAmount);
        return Math.round(result*0.21);
    }

    //Excise fee - 18.6% when engine capacity over 2.0L, otherwise 3.1%
    private static double exciseTax(CarProperties carProperties){
        double result;
        if (carProperties.over2l){
            result = carProperties.carBid * 0.186;
        } else {
            result = carProperties.carBid * 0.031;
        }
        return Math.round(result);
    }

    //
    private static double serviceSalary(double bidAmount){
        double result = 650;
        return bidAmount*0.05 > 650 ? Math.round(bidAmount*0.05) : Math.round(result);
    }
    //Display parameters
    private static void displayEstimatedValues(CarProperties carProperties){
        String displayParameters = "\n" + "Costs estimation" + "\n" +
                "   Car bid set for: " + carProperties.carBid + "$" + "\n" +
                "   Car auction fee calculated: " + auctionFee(carProperties.carBid) + " $" +"\n" +
                "   Cost of transport from USA: " + carProperties.transportUSA + " $" + "\n" +
                "   Cost of custom clearance USA: " + carProperties.customClearanceUSA + " $" + "\n" +
                "   Cost of transport from EU: " + carProperties.transportEU + " $" + "\n" +
                "   Cost of custom clearance EU: " + carProperties.customClearanceEU + " $" + "\n" +
                "   Cost of custom duty: " + customDuty(carProperties.carBid) + " $" + "\n" +
                "   Cost of 21% tax: " + tax21(carProperties.carBid) + " $" + "\n" +
                "   Cost of excise tax: " + exciseTax(carProperties) + " $" + "\n" +
                "   Cost of service salary: " + serviceSalary(carProperties.carBid) + " $" + "\n" +
                "   Cost of car delivery in Poland " + carProperties.transportPL + " zł" + "\n"
                ;
        System.out.println(displayParameters);
    }

    private static double sumAllCosts(CarProperties carProperties, double dollarCourse){
        double totalCost;
        totalCost = carProperties.sumTransportFees(carProperties);
        totalCost += auctionFee(carProperties.carBid);
        totalCost += customDuty(carProperties.carBid);
        totalCost += tax21(carProperties.carBid);
        totalCost += exciseTax(carProperties);
        totalCost += serviceSalary(carProperties.carBid) + carProperties.transportPL/dollarCourse;

        return (totalCost);
    }
}