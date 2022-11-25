public class CarProperties {
    int transportUSA;
    int transportEU = 780;
    int customClearanceUSA = 150;
    int customClearanceEU = 450;
    double carBid;

    CarProperties(int transportUSA, int transportEU, int customClearanceUSA, int customClearanceEU, int carBid){
        this.transportUSA = transportUSA;
        this.transportEU = transportEU;
        this.customClearanceUSA = customClearanceUSA;
        this.customClearanceEU = customClearanceEU;
        this.carBid = carBid;
    }
    CarProperties(int transportUSA, double carBid){
        this.transportUSA = transportUSA;
        this.carBid = carBid;
    }
    public double sumFees(CarProperties carProperties){
        double result;
        result = carProperties.carBid + carProperties.customClearanceUSA + carProperties.transportUSA + carProperties.transportEU + carProperties.customClearanceEU;
        return result;
    }
}
