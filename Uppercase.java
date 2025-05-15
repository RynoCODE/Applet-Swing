import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Uppercase extends JPanel implements ActionListener {

    JTextField input, output;
    JButton convert;

    public Uppercase() {  // Changed init() to constructor
        input = new JTextField(20);
        output = new JTextField(20);
        output.setEditable(false);
        convert = new JButton("Convert");

        add(new JLabel("Input:"));
        add(input);
        add(new JLabel("Output:"));
        add(output);
        add(convert);
        convert.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputText = input.getText();
        StringBuilder res = new StringBuilder();
        for(char ch: inputText.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                res.append(Character.toLowerCase(ch));
            } else if(Character.isLowerCase(ch)) {
                res.append(Character.toUpperCase(ch));
            } else {
                res.append(ch);
            }
        }
        output.setText(res.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Case Converter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new Uppercase());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}