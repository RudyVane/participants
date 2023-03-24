import javax.swing.*;

class Participants extends JFrame {

    private static JLabel nameLabel;
    private static JTextField nameTextfield;
    private static JLabel hoursLabel;
    private static JSpinner hoursSpinner;
    private static JLabel minutesLabel;
    private static JSpinner minutesSpinner;
    private static JButton addButton;
    private static JTextArea textArea1;
    private static JTextArea textArea2;
    private static JLabel timeslotLabel;
    private static JPanel panel1;
    private static JPanel panel2;

    public void main(String[] args) {
        form();
    }

    public void form() {
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        setContentPane(panel1);
        pack();
        addButton.addActionListener(e -> {
            String name = nameTextfield.getText();
            int hours = (int) hoursSpinner.getValue();
            int minutes = (int) minutesSpinner.getValue();
            String time = String.format("%02d:%02d", hours, minutes);
            textArea1.append(name + " " + time + "\n");
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
        private void createUIComponents() {
            // TODO: place custom component creation code here
            // created by clicking custom create in form
            panel1 = new JPanel();
            panel2 = new JPanel();
            nameLabel = new JLabel("Name:");
            nameTextfield = new JTextField(20);
            hoursLabel = new JLabel("h");
            hoursSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
            minutesLabel = new JLabel("m");
            minutesSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
            addButton = new JButton("Add participants");
            textArea1 = new JTextArea(10, 20);
            textArea2 = new JTextArea(10, 20);


        }
    }
