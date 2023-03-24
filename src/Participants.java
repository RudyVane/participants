import javax.swing.*;
import java.awt.*;

public class Participants extends JFrame {
    private JPanel panel1;
    //private JPanel panel2;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel hoursLabel;
    private JSpinner hoursSpinner;
    private JLabel minutesLabel;
    private JSpinner minutesSpinner;
    private JButton addButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JLabel timeslotLabel;

    public Participants() {
        createUIComponents();

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 2));
        panel1.add(nameLabel);
        panel1.add(nameTextField);
        panel1.add(hoursLabel);
        panel1.add(hoursSpinner);
        panel1.add(minutesLabel);
        panel1.add(minutesSpinner);
        panel1.add(addButton);
        panel1.add(textArea1);
        panel1.add(textArea2);
        panel1.add(timeslotLabel);
        //add(panel1, BorderLayout.CENTER);


        addButton.addActionListener(e -> {
            String name = nameTextField.getText();
            int hours = (int) hoursSpinner.getValue();
            int minutes = (int) minutesSpinner.getValue();
            String time = String.format("%02d:%02d", hours, minutes);
            textArea1.append(name + " " + time + "\n");
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void createUIComponents() {
        panel1 = new JPanel();
        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField(20);
        timeslotLabel = new JLabel("Timeslot:");
        hoursLabel = new JLabel("Hours:");
        hoursSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
        minutesLabel = new JLabel("Minutes:");
        minutesSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        addButton = new JButton("Add participants");
        textArea1 = new JTextArea(10, 20);
        textArea2 = new JTextArea(10, 20);
    }

    public static void main(String[] args) {
        new Participants();
    }

    public void setData(Participants data) {
    }

    public void getData(Participants data) {
    }

    public boolean isModified(Participants data) {
        return false;
    }
}