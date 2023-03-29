import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame implements ActionListener {
    private JPanel panel;

    private JTextField name;
    private JSpinner spinner1, spinner2;
    private JTextArea textArea1, textArea2;
    private JButton addButton;


    public Form() {

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //what to do on buttonclick
                String name1 = name.getText(); // Get the value of the text field 'name'
                int hours = (int) spinner1.getValue(); // Get the value of the spinner 'hours'
                int minutes = (int) spinner2.getValue(); // Get the value of the spinner 'minutes'
                if (!name1.matches("[a-zA-Z]+")) { //check if input is only letter
                    textArea1.append("Name participant not valid!\n");
                    name.setText("");
                    return;// back to start
                }
                        new ParticipantsCollection(Form.this, name1,hours,minutes);// to new class
                        }
        });

    }
    public void setText(String name1, String time, String message) {
        textArea2.append(name1 + " " + time + "\n");// show name and time in textarea 2
        textArea1.append(message +"\n");// show message in textarea1
        name.setText("");
    }
    @Override
    public void actionPerformed(ActionEvent e) { // information for the listener
        if (e.getSource() == addButton) {
        }
    }
    public static void main(String[] args) { // sets the panel to be visible on the sreen
        JFrame frame = new JFrame("Form");
        Form form = new Form();
        frame.setContentPane(form.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        // set hours and minutes in a range
        spinner1 = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
        spinner2 = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));

    }
}
class ParticipantsCollection extends Form {
    static String[] participantNames;
    static String[] participantTimes;
    static int participantCount;
    static String time;
    static String name2;
    static String message;

    public ParticipantsCollection(Form form, String name1, int hours, int minutes) {
        participantNames = new String[10];
        participantTimes = new String[10];
        participantCount = 0;
        time = String.format("%02d:%02d", hours, minutes);
        name2 = name1;
        if (participantCount != 0) { // iterating through array to see if there a no doubles
            for (int i = 0; i < participantCount; i++) {
                if (participantNames[i].equals(name1) && participantTimes[i].equals(time)) {
                    message = "participant and time already on list!\n";
                    form.setText(name2, time, message); //back to Form class
                    return;
                }
            }
        }
        participantNames[participantCount] = name2;
        participantTimes[participantCount] = time;
        message = "participant added\n";
        form.setText(name2, time, message); //back to Form class
        participantCount++;
    }

    public static void main(String[] args) {

    }
}
