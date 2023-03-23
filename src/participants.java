import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class test extends JFrame {

    private JLabel nameLabel;
    private JTextField nameTextfield;
    private JLabel hoursLabel;
    private JSpinner hoursSpinner;
    private JLabel minutesLabel;
    private JSpinner minutesSpinner;
    private JButton addButton;
    private JTextArea textArea1;
    private JTextArea textArea2;


    public test() {
        super("participants");

        // create form elements
        nameLabel = new JLabel("Name:");
        nameTextfield= new JTextField(20);
        hoursLabel = new JLabel("h");
        hoursSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
        minutesLabel = new JLabel("m");
        minutesSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        addButton = new JButton("Add participants");
        textArea1 = new JTextArea(10, 20);
        textArea2 = new JTextArea(10, 20);

        // add elements to lay-out
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(nameLabel);
        contentPane.add(nameTextfield);
        contentPane.add(hoursLabel);
        contentPane.add(hoursSpinner);
        contentPane.add(minutesLabel);
        contentPane.add(minutesSpinner);
        contentPane.add(addButton);
        contentPane.add(new JScrollPane(textArea1));
        contentPane.add(new JScrollPane(textArea2));

        // add listener to button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextfield.getText();
                int hours = (int) hoursSpinner.getValue();
                int minutes = (int) minutesSpinner.getValue();
                String time = String.format("%02d:%02d", hours, minutes);
                textArea1.append(name + " " + time + "\n");
            }
        });

        // set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new test();
    }

}