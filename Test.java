import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {

        // Create a new JFrame
        JFrame frame = new JFrame("Window with Buttons");
        frame.setLayout(new BorderLayout());

        
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(0, 100));
        textField.setEditable(false);
        frame.add(textField, BorderLayout.NORTH); // Add the text field to the NORTH

        // Set the layout for the center to a 3x3 grid
        JPanel panel = new JPanel(new GridLayout(3, 3));
        frame.add(panel, BorderLayout.CENTER);

        // Create and add buttons from 1 to 9
        for (int i = 1; i <= 9; i++) {
            final int finalI = i; // Create a final copy of i
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + finalI);
                }
            });
            panel.add(button); // Add the buttons to the panel
        }

        // Set the size of the frame
        frame.setSize(700, 700);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        frame.setVisible(true);
    }
    
}