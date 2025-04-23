import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class swingApplet extends Applet implements ActionListener {

    private JLabel num1Label, num2Label, sumLabel;
    private JTextField num1TextField, num2TextField, sumTextField;
    private JButton addButton;

    public void init() {
        // Set the layout for the applet
        setLayout(new FlowLayout());

        // Create labels
        num1Label = new JLabel("Number 1:");
        num2Label = new JLabel("Number 2:");
        sumLabel = new JLabel("Sum:");

        // Create text fields
        num1TextField = new JTextField(10);
        num2TextField = new JTextField(10);
        sumTextField = new JTextField(10);
        sumTextField.setEditable(false); // Make the sum text field read-only

        // Create the button
        addButton = new JButton("Add");
        addButton.addActionListener(this); // Register the button to listen for actions

        // Add components to the applet
        add(num1Label);
        add(num1TextField);
        add(num2Label);
        add(num2TextField);
        add(addButton);
        add(sumLabel);
        add(sumTextField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                // Get the numbers from the text fields
                String num1Str = num1TextField.getText();
                String num2Str = num2TextField.getText();

                // Convert the strings to doubles
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);

                // Calculate the sum
                double sum = num1 + num2;

                // Display the sum in the result text field
                sumTextField.setText(String.valueOf(sum));
            } catch (NumberFormatException ex) {
                // Handle the case where the user enters non-numeric input
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
                num1TextField.setText("");
                num2TextField.setText("");
                sumTextField.setText("");
            }
        }
    }
}
