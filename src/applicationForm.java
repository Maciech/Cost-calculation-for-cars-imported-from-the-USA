import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class applicationForm extends JDialog{
    private JTextField tfCarBid;
    private JTextField tfTransportUsa;
    private JTextField tfCustomUSA;
    private JTextField tfShippingEU;
    private JTextField tfCustomEu;
    private JCheckBox cbCapacity;
    private JButton startCalculationButton;
    private JButton cancelButton;
    private JPanel applicationPanel;
    private JTextField tfResult;
    private JTextField tfResultZl;
    private JTextField tfDisplayAll;
    private JTextField textField1;
    private JTextArea taDisplayAll;
    double dollarCourse = 4.52;

    public applicationForm(JFrame parent){
        super(parent);
        setTitle("Create a new account");
        setContentPane(applicationPanel);
        setMinimumSize(new Dimension(1000, 860));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        startCalculationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                assign();
            }
        });


        setVisible(true);



    }
    public  CarProperties carProperties;
    public void assign(){
        int carBid = Integer.parseInt(tfCarBid.getText());
        int transportUSA = Integer.parseInt(tfTransportUsa.getText());
        int customUSA = Integer.parseInt(tfCustomUSA.getText());
        int shipping = Integer.parseInt(tfShippingEU.getText());
        int customEU = Integer.parseInt(tfCustomEu.getText());
        boolean capacity = Boolean.parseBoolean(String.valueOf(cbCapacity));

        carProperties = new CarProperties(transportUSA,shipping,customUSA,customEU,capacity, carBid);
        if (carBid == 0 || transportUSA == 0 || customUSA == 0 || shipping == 0 || customEU == 0){
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            tfResult.setText(Math.round(Main.sumAllCosts(carProperties, dollarCourse))+" $");
            tfResultZl.setText(Math.round(Main.sumAllCosts(carProperties, dollarCourse)*dollarCourse)+" zł");
            System.out.println(Math.round(Main.sumAllCosts(carProperties, dollarCourse))+" $");
            System.out.println(Math.round(Main.sumAllCosts(carProperties, dollarCourse)*dollarCourse)+" zł");
            taDisplayAll.setText(Main.displayEstimatedValues(carProperties));

        }

    }

}
