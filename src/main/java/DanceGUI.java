import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.*;
import javax.swing.Timer;

/**
 * Created by Dmitry on 19.09.2017.
 */
public class DanceGUI extends JFrame {

    private int cnt;
    private JLabel soundLabel;
    private Timer timer;

    private ArrayList <JLabel> info = new ArrayList<JLabel>();
    private JPanel grid = new JPanel(new GridLayout(10, 0, 10, 10));
    private JLabel pleerLabel;

    private ImageIcon imageIconFemale = new ImageIcon("src/main/resources/female.png");
    private ImageIcon imageIconMale = new ImageIcon("src/main/resources/male.png");
    private ImageIcon imageIconPleer = new ImageIcon("src/main/resources/pleer.png");



    private String [] sex = {"male","female"};
    private String [] skill = {"hip-hop","rnb","electrodance","pop"};
    private String [] genre = {"Rnb","Electrohuse","pop-music"};
    private Random randomSex = new Random();
    private Random randomSkill = new Random();
    private Random randomGenre = new Random();

    private int selectSex;
    private int selectSkill;

    private ArrayList<Person> persons = new ArrayList<Person>();
    //create new label
    public JLabel createLabel(ImageIcon labelImage, String inf){
        JLabel label = new JLabel(labelImage);
        label.setText(inf);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        return label;

    }
    //update label
    public void updateLabel(int index, String act){
        JLabel upLabel = info.get(index);
        upLabel.setText(persons.get(index).getSkill()+" act:"+act);
        upLabel.setHorizontalTextPosition(JLabel.CENTER);
        upLabel.setVerticalTextPosition(JLabel.BOTTOM);
        info.set(index,upLabel);

    }
    //update music
    public JLabel updateSound(JLabel upLabel, String inf){

        upLabel.setText(inf);
        upLabel.setHorizontalTextPosition(JLabel.CENTER);
        upLabel.setVerticalTextPosition(JLabel.BOTTOM);

        return upLabel;

    }

    //create persons
    public void createPersons(int count){



        for (int i=0; i<count;i++){

            selectSex = randomSex.nextInt(sex.length);
            selectSkill = randomSkill.nextInt(skill.length);

            Person rndPerson = new Person(sex[selectSex],skill[selectSkill]);
            persons.add(rndPerson);
            if(rndPerson.getSex().equals("female")) {

                JLabel manLabel = this.createLabel(imageIconFemale, skill[selectSkill]);
                info.add(manLabel);
            }
            else
            {
                JLabel womanLabel = this.createLabel(imageIconMale, skill[selectSkill]);
                info.add(womanLabel);
            }

        }


    }
//listener of timer
    ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(!DanceGUI.this.isShowing()) {
                timer.stop();
            }else {

                actionDance(cnt);
            }


        }
    };


    public DanceGUI(int count) {
        super("Dance");
        this.createPersons(count);
        pleerLabel = createLabel(imageIconPleer,"");

        this.cnt = count;

        for (int i = 0; i < count; i++) {
            grid.add(info.get(i));
        }
        grid.add(pleerLabel);
        Container container = getContentPane();
        container.add(grid, BorderLayout.WEST);
        //pack();
        setSize(1920,1080);
        setVisible(true);
        timer = new Timer(5000, listener);
        timer.start();
    }


    public void actionDance(int count) {

        int selectGenre = randomGenre.nextInt(genre.length);

        if (genre[selectGenre].equals("Rnb") ) {
            for (int i = 0; i < count; i++) {
                if (persons.get(i).getSkill().equals("rnb")  || persons.get(i).getSkill().equals("hip-hop") ) {
                    updateLabel(i, "Dance");
                } else {
                    updateLabel(i, "Drink");
                }
            }

        }

        if (genre[selectGenre].equals("Electrohuse") ) {

            for (int i = 0; i < count; i++) {
                if (persons.get(i).getSkill().equals("electrodance") ) {
                    updateLabel(i, "Dance");
                } else {
                    updateLabel(i, "Drink");
                }
            }

        }

        if (genre[selectGenre].equals("pop-music") ) {
            for (int i = 0; i < count; i++) {
                if (persons.get(i).getSkill().equals("pop") ) {
                    updateLabel(i, "Dance");
                } else {
                    updateLabel(i, "Drink");
                }
            }

        }

        for (int i = 0; i < count; i++) {
            grid.add(info.get(i));
        }
        soundLabel = updateSound(pleerLabel, genre[selectGenre]);
        grid.add(soundLabel);
        Container container = getContentPane();
        container.add(grid, BorderLayout.WEST);
        setVisible(true);
    }
}
