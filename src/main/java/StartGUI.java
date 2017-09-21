import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dmitry on 19.09.2017.
 */
public class StartGUI extends JFrame {
    private JButton buttonStart = new JButton("START");
    private JTextField inputCount = new JTextField("", 5);
    private JLabel label = new JLabel("Input count of person");

    public StartGUI(){
        super("Start");
        this.setBounds(100,100,250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,0,2,2));
        container.add(inputCount);
        container.add(label);

        buttonStart.addActionListener(new ButtonEventListener ());
        container.add(buttonStart);
    }

    class ButtonEventListener implements ActionListener{
        public void actionPerformed (ActionEvent e) {
            try
            {
                DanceGUI d = new DanceGUI(Integer.parseInt(inputCount.getText()));
                d.setVisible(true);
            }
            catch ( NumberFormatException en )
            {
                JOptionPane.showMessageDialog(StartGUI.this, "Error!!!\nPlease input correct value.");
            }
        }
    }

}
