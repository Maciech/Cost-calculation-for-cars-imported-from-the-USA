import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataReader {
    int transportUSA = 0;
    int transportEU = 0;
    double carBid = 0;
    public int customClearanceUSA = 0;
    public int customClearanceEU = 0;
    public boolean over2l;

    public CarProperties readData() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Name the price for the car you want to pay in $: ");

            carBid = Double.parseDouble(reader.readLine());
        System.out.println("Name the price of transport over USA: ");
            transportUSA = Integer.parseInt(reader.readLine());
        System.out.println("Name the price of transport to EU: ");
            transportEU = Integer.parseInt(reader.readLine());
        System.out.println("Name the price of transport over USA: ");
            customClearanceUSA = Integer.parseInt(reader.readLine());
        System.out.println("Name the price of transport over USA: ");
            customClearanceEU = Integer.parseInt(reader.readLine());
        System.out.println("Name the price of transport over USA: ");
            over2l = Boolean.parseBoolean(reader.readLine());
        if (transportUSA == 0){

        }
        if (over2l){

        }


        CarProperties carProperties = new CarProperties(transportUSA,transportEU,carBid);

        return carProperties;
    }

}
