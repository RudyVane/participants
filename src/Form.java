import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel nameLabel, timeslotLabel, hoursLabel, minutesLabel;
    private JTextField name;
    private JSpinner spinner1, spinner2;
    private JTextArea textArea1, textArea2;
    private JButton addButton;
    private String[] participantNames;
    private String[] participantTimes;
    private int participantCount;

    public Form() {
        participantNames = new String[10];// to store names
        participantTimes = new String[10];// to store times
        participantCount = 0; //makes index for arrays
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //what to do on buttonclick
                String name1 = name.getText(); // Get the value of the text field 'name'
                int hours = (int) spinner1.getValue(); // Get the value of the spinner 'hours'
                int minutes = (int) spinner2.getValue(); // Get the value of the spinner 'minutes'
                if (!name1.matches("[a-zA-Z]+")) { //check if input is only letter
                    textArea1.append("Name participant not valid!\n");
                    return;// back to start
                } // the next part can be in a new method, but I think there is need here
                String time = String.format("%02d:%02d", hours, minutes); // put hours and minutes in one string
                participantNames[participantCount] = name1; //stores the name
                participantTimes[participantCount] = time; // stores the time
                participantCount++;// counts the number of participants and is the index in the arrays
                textArea2.append(name1 + " " + time + "\n");// show name and time in textarea 2
                textArea1.append("Participant added\n");// show message in textarea1
                textArea1.append("Total participants:" + participantCount + "\n");// I added a line for the totals
            }
        });
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
}
