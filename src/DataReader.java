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

        CarProperties carProperties = new CarProperties(transportUSA, carBid);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        System.out.println("Name the price for the car you want to pay in $: ");
        line = reader.readLine();
        if (!line.isEmpty()) {
            carBid = Double.parseDouble(line);
            carProperties.carBid = carBid;

            System.out.println("Name the price of transport over USA: ");
            line = reader.readLine();
            if (!line.isEmpty()) {
                transportUSA = Integer.parseInt(line);
                carProperties.transportUSA = transportUSA;
            }
            System.out.println("Name the price of transport to EU: ");
            line = reader.readLine();
            if (!line.isEmpty()) {
                transportEU = Integer.parseInt(line);
                carProperties.transportEU = transportEU;
            }
            System.out.println("Name the price of custom clearance USA: ");
            line = reader.readLine();
            if (!line.isEmpty()) {
                customClearanceUSA = Integer.parseInt(line);
                carProperties.customClearanceUSA = customClearanceUSA;
            }
            System.out.println("Name the price of custom clearance EU: ");
            line = reader.readLine();
            if (!line.isEmpty()) {
                customClearanceEU = Integer.parseInt(line);
                carProperties.customClearanceEU = customClearanceEU;
            }
            System.out.println("Is engine over 2l capacity? ");
            line = reader.readLine();
            if (line.equals("yes")){
                over2l = true;
                carProperties.over2l = over2l;
            }
        }
        return carProperties;
    }

}
