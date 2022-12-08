public class bankTransfers {
    private String bankName;
    private String currency;
    private String type;
    private double value;
    public double result;


    bankTransfers(String bankName,int value, String currency, String type) {
        this.bankName = bankName;
        this.value = value;
        this.currency = currency;
        this.type = type;
    }
    public double transferCost(bankTransfers bankTransfersMethod){
        if (bankTransfersMethod.bankName.contains("Pekao")){

        } else if (bankTransfersMethod.bankName.contains("PKO")){

        } else if (bankTransfersMethod.bankName.contains("Santander")){

        } else if (bankTransfersMethod.bankName.contains("mBank")){

        } else if (bankTransfersMethod.bankName.contains("ING")){

        } else if (bankTransfersMethod.bankName.contains("Millenium")){

        } else if (bankTransfersMethod.bankName.contains("Credit Agricole")){

        } else if (bankTransfersMethod.bankName.contains("West bank")){

        }
        return result;
    }

    private double transferCost(double transferValue, double percentValue, double swiftValue, double foreignBankFee){
        result = (transferValue*percentValue) + swiftValue + foreignBankFee;
        return result;
    }
}
