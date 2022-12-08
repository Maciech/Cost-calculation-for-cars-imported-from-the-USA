public class BankTransfers {
    private String bankName;
    private String currency;
    private String type;
    private double value;
    public double result;


    BankTransfers(String bankName,double value, String currency, String type) {
        this.bankName = bankName;
        this.value = value;
        this.currency = currency;
        this.type = type;
        transferBankName();
    }

    public double transferBankName(){
        if (bankName.contains("Pekao")){
                result = transferCost(value, 0.0075, 80, 400, 22, 100);
        } else if (bankName.contains("PKO")){

        } else if (bankName.contains("Santander")){

        } else if (bankName.contains("mBank")){
                result = transferCost(value, 0.005, 50, 200, 20, 98);
        } else if (bankName.contains("ING")){

        } else if (bankName.contains("Millenium")){

        } else if (bankName.contains("Credit Agricole")){

        } else if (bankName.contains("West bank")){

        }
        return result;
    }

    private double transferCost(double transferValue, double percentValue, int lowerLimit, int upperLimit, double swiftValue, double foreignBankFee){
        if (transferValue*percentValue <= lowerLimit){
            result = lowerLimit + swiftValue + foreignBankFee;
        } else if(transferValue*percentValue >= upperLimit){
            result = upperLimit + swiftValue + foreignBankFee;
        } else {
            result = (transferValue*percentValue) + swiftValue + foreignBankFee;
        }

        return result;
    }
}
