import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class applicationForm extends JDialog{
    private JTextField tfCarBid;
    private JTextField tfTransportUsa;
    private JTextField tfCustomUSA;
    private JTextField textField4tfShippingEU;
    private JTextField tfCustomEu;
    private JCheckBox cbCapacity;
    private JButton startCalculationButton;
    private JButton cancelButton;
    private JTextArea textArea1;
    private JPanel applicationPanel;

    public applicationForm(JFrame parent){
        super(parent);
        setTitle("Create a new account");
        setContentPane(applicationPanel);
        setMinimumSize(new Dimension(620, 660));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
}
