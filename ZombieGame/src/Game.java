import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import javax.swing.*;

public class Game {

    private static int Points = 0;
    private static String reword;

    private static JTextArea ta, ta1 , hp , dmg, hpZM , dmgZM, nameZM;
    private static JTextArea name;
    private static JTextField enterName;

    private static int PlayerHP = 20;
    private static int PlayerDMG = 5;

    private int ZombieHP;
    private String ZombieNM;
    private int ZombieDMG;
    private int ZombieLV;

    private static JButton FIRST;
    private static JButton SECOND;
    private static JButton THIRD;
    private static JButton FOURTH;
    private static JButton RESTART;
    private static JButton MAP;


    private JFrame frameStart, frameGame;
    private Container conStart, conGame;
    private static JPanel titleNamePanel, startButtonPanel, GamePanelFoot, GamePanelMain1, GamePanelMain2,
            GamePanelButtons, GamePanelMain3, GamePanelMAP;
    private JLabel titleNameLabel;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    private JButton startButton, LinkinButton, GithubButton, WebsiteButton;

    ScreenHandler StartButton = new ScreenHandler();
    ScreenHandlerMAP mapper = new ScreenHandlerMAP();
    GithubButtonAction GitButton = new GithubButtonAction();
    WebsiteButtonAction WebButton = new WebsiteButtonAction();
    LinkInButtonAction LinButton = new LinkInButtonAction();

    public class ScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            NodeMap map = new NodeMap();
            if(map.currentNode() == null) { return;}
            StartGame(map);
        }
    }

    public class ScreenHandlerMAP implements ActionListener{
        public void actionPerformed(ActionEvent event){
            MAPWindow();
        }
    }


    public void MAPWindow(){
        JFrame mf = new JFrame("MAP Window");
        mf.setSize(1500,950);
        mf.setLocationRelativeTo(null);
        mf.setResizable(false);
        mf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mf.getContentPane().setBackground(Color.black);
        mf.setVisible(true);
        mf.setLayout(new BorderLayout());
        mf.setContentPane(new JLabel(new ImageIcon("src/Map/MapDone.png")));
        //mf.setContentPane(new JLabel(new ImageIcon("C:\\Users\\44790\\Desktop\\Mali\\IMG\\AS\\MapDone.png")));
        mf.setLayout(new FlowLayout());
    }


    public Game(){
        frameStart = new JFrame("Maliq 'UP962567' Dyrma");
        frameStart.setSize(800, 600);
        frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStart.getContentPane().setBackground(Color.black);
        frameStart.setLayout(null);
        frameStart.setResizable(false);
        frameStart.setLocationRelativeTo(null);
        conStart = frameStart.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Zombie Game!");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 350, 200, 100);
        startButtonPanel.setLayout(new GridLayout(2,1));
        startButtonPanel.setBackground(Color.black);
        enterName = new JTextField("Player1");
        enterName.setBackground(Color.black);
        enterName.setForeground(Color.white);
        enterName.setFont(normalFont);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(StartButton);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(enterName);
        startButtonPanel.add(startButton);

        conStart.add(titleNamePanel);
        conStart.add(startButtonPanel);

        frameStart.setVisible(true);
    }
    public Game(NodeMap map) {StartGame(map);nodeDisplay(map);}
    private void StartGame(NodeMap map) {
        frameStart.setVisible(false);

        // Frame
        frameGame = new JFrame("Maliq 'UP962567' Dyrma");
        frameGame.setSize(800, 600);
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.getContentPane().setBackground(Color.black);
        frameGame.setLayout(null);
        frameGame.setResizable(false);
        frameGame.setLocationRelativeTo(null);

        conGame = frameGame.getContentPane();
        //
        createButtons(map);
//        createTextArea();
        // Foot Panel
        GamePanelFoot = new JPanel();
        GamePanelFoot.setBackground(Color.black);
        GamePanelFoot.setBounds(0, 500, 785, 40);
        GamePanelFoot.setLayout(new GridLayout(1,4));
        // Buttons Foot
        LinkinButton = new JButton("LinkIn");
        LinkinButton.setBackground(Color.black);
        LinkinButton.setForeground(Color.white);
        LinkinButton.setFont(normalFont);
        LinkinButton.addActionListener(LinButton);
        LinkinButton.setFocusPainted(false);
        GithubButton = new JButton("GitHub");
        GithubButton.setBackground(Color.black);
        GithubButton.setForeground(Color.white);
        GithubButton.setFont(normalFont);
        GithubButton.addActionListener(GitButton);
        GithubButton.setFocusPainted(false);
        WebsiteButton = new JButton("WebSite");
        WebsiteButton.setBackground(Color.black);
        WebsiteButton.setForeground(Color.white);
        WebsiteButton.setFont(normalFont);
        WebsiteButton.addActionListener(WebButton);
        WebsiteButton.setFocusPainted(false);
        GamePanelFoot.add(LinkinButton);
        GamePanelFoot.add(WebsiteButton);
        GamePanelFoot.add(GithubButton);


        // Main Panels
        GamePanelMain1 = new JPanel();
        GamePanelMain1.setBackground(Color.black);
        GamePanelMain1.setBounds(150,150,500,200);
        ta = new JTextArea("          Welcome!" +
                "\n I hope you are ready for this task!" +
                "\n To see that you understand how to use the game " +
                "\n Press anything to start it!");
        ta.setBounds(150,150,500,200);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setEditable(false);
        ta.setFont(createFont(20));
        ta.setBackground(Color.BLACK);
        ta.setForeground(Color.white);
        GamePanelMain1.add(ta);

        GamePanelMain2 = new JPanel();
        GamePanelMain2.setBackground(Color.black);
        GamePanelMain2.setBounds(50,20,680,50);
        GamePanelMain2.setLayout(new GridLayout(1, 4));
        GamePanelMain2.setVisible(true);
        name = new JTextArea("Player: " + enterName.getText());
        name.setLineWrap(true);
        name.setWrapStyleWord(true);
        name.setEditable(false);
        name.setFont(createFont(15));
        name.setBackground(Color.BLACK);
        name.setForeground(Color.green);
        GamePanelMain2.add(name);

        hp = new JTextArea("Player HP: " + PlayerHP);
        hp.setLineWrap(true);
        hp.setWrapStyleWord(true);
        hp.setEditable(false);
        hp.setFont(createFont(15));
        hp.setBackground(Color.BLACK);
        hp.setForeground(Color.green);
        GamePanelMain2.add(hp);

        dmg = new JTextArea("Attack: " + PlayerDMG);
        dmg.setLineWrap(true);
        dmg.setWrapStyleWord(true);
        dmg.setEditable(false);
        dmg.setFont(createFont(15));
        dmg.setBackground(Color.BLACK);
        dmg.setForeground(Color.green);
        GamePanelMain2.add(dmg);

        ta1 = new JTextArea("Your Level: 0");
        ta1.setLineWrap(true);
        ta1.setWrapStyleWord(true);
        ta1.setEditable(false);
        ta1.setFont(createFont(15));
        ta1.setBackground(Color.BLACK);
        ta1.setForeground(Color.green);
        GamePanelMain2.add(ta1);



        GamePanelMain3 = new JPanel();
        GamePanelMain3.setBackground(Color.black);
        GamePanelMain3.setBounds(50,70,680,50);
        GamePanelMain3.setLayout(new GridLayout(1, 3));
        GamePanelMain3.setVisible(false);
        nameZM = new JTextArea("Zombie: " + ZombieNM);
        nameZM.setLineWrap(true);
        nameZM.setWrapStyleWord(true);
        nameZM.setEditable(false);
        nameZM.setFont(createFont(15));
        nameZM.setBackground(Color.BLACK);
        nameZM.setForeground(Color.red);
        GamePanelMain3.add(nameZM);

        hpZM = new JTextArea("Zombie HP: " + ZombieHP);
        hpZM.setLineWrap(true);
        hpZM.setWrapStyleWord(true);
        hpZM.setEditable(false);
        hpZM.setFont(createFont(15));
        hpZM.setBackground(Color.BLACK);
        hpZM.setForeground(Color.red);
        GamePanelMain3.add(hpZM);

        dmgZM = new JTextArea("Attack: " + ZombieDMG);
        dmgZM.setLineWrap(true);
        dmgZM.setWrapStyleWord(true);
        dmgZM.setEditable(false);
        dmgZM.setFont(createFont(15));
        dmgZM.setBackground(Color.BLACK);
        dmgZM.setForeground(Color.red);
        GamePanelMain3.add(dmgZM);


        GamePanelMAP = new JPanel();
        GamePanelMAP.setBackground(Color.green);
        GamePanelMAP.setBounds(25,350,150,140);
        GamePanelMAP.setLayout(new GridLayout(1,1));
        MAP = new JButton("MAP");
        MAP.setBackground(Color.black);
        MAP.setForeground(Color.green);
        MAP.setFont(normalFont);
        MAP.addActionListener(mapper);
        MAP.setFocusPainted(false);
        GamePanelMAP.add(MAP);


        // Game Button Panel
        GamePanelButtons = new JPanel();
        GamePanelButtons.setBackground(Color.black);
        GamePanelButtons.setBounds(200,350,400,150);
        GamePanelButtons.setLayout(new GridLayout(5, 1));

        // Game Buttons
        GamePanelButtons.add(FIRST);
        GamePanelButtons.add(SECOND);
        GamePanelButtons.add(THIRD);
        GamePanelButtons.add(FOURTH);
        GamePanelButtons.add(RESTART);

        // To add in Frame


        conGame.add(GamePanelButtons);
        conGame.add(GamePanelMain2);
        conGame.add(GamePanelMain3);
        conGame.add(GamePanelMain1);
        conGame.add(GamePanelMAP);
        conGame.add(GamePanelFoot);
        frameGame.setVisible(true);
    }
    // More Futures

    // Default
    private void createButtons(NodeMap map){
        FIRST = new JButton("FIRST");
        FIRST.setFont(createFont(25));
        FIRST.setBackground(Color.black);
        FIRST.setForeground(Color.white);
        FIRST.addActionListener((ActionEvent e) -> {
            move(map,1);
            nodeDisplay(map);
        });;

        SECOND = new JButton("SECOND");
        SECOND.setFont(createFont(25));
        SECOND.setBackground(Color.black);
        SECOND.setForeground(Color.white);
        SECOND.addActionListener((ActionEvent e) -> {
            move(map,2);
            nodeDisplay(map);
        });

        THIRD = new JButton("THIRD");
        THIRD.setFont(createFont(25));
        THIRD.setBackground(Color.black);
        THIRD.setForeground(Color.white);
        THIRD.addActionListener((ActionEvent e) -> {
            move(map,3);
            nodeDisplay(map);
        });

        FOURTH = new JButton("FOURTH");
        FOURTH.setFont(createFont(25));
        FOURTH.setBackground(Color.black);
        FOURTH.setForeground(Color.white);
        FOURTH.addActionListener((ActionEvent e) -> {
            move(map,4);
            nodeDisplay(map);
        });

        RESTART = new JButton("FOURTH");
        RESTART.setFont(createFont(25));
        RESTART.setBackground(Color.black);
        RESTART.setForeground(Color.white);
        RESTART.setVisible(false);
        RESTART.addActionListener((ActionEvent e) -> {
            frameGame.setVisible(false);
            new Game();
        });
    }
/****************************************************/
/**************      NAVIGATE       *****************/
/****************************************************/
/*** @return*****************************************/
    private static String PointRect(){
        if(Points < 5) {
            reword = "Your need to work more!";
        }
        if (Points >= 5){
            reword = "Your are good! But need some work!";
        }
        if(Points >= 10) {
            reword = "Your are Amazing!";
        }
        if(Points == 15) {
            reword = "Your are a MONSTER in this game!!!!";
        }
        return reword;
    }

    private static void move(NodeMap map, int direction){
        if (map.currentNode().getQuestion().equals("-")) {map.noDecision();}
        else {map.decision(direction);}
    }

    private void PlayerAttack() {

        if(ZombieLV == 1){
            ZombieNM = "Normal";
            ZombieHP = 10;
            ZombieDMG = 2;
            nameZM.setText("Zombie: " + ZombieNM);
            hpZM.setText("Zombie HP: " + ZombieHP);
            dmgZM.setText("Attack: " + ZombieDMG);
        }
        if(ZombieLV == 2){
            ZombieNM = "Killer";
            ZombieHP = 20;
            ZombieDMG = 3;
            nameZM.setText("Zombie: " + ZombieNM);
            hpZM.setText("Zombie HP: " + ZombieHP);
            dmgZM.setText("Attack: " + ZombieDMG);
        }
        if(ZombieLV == 3){
            ZombieNM = "Bomber";
            ZombieHP = 30;
            ZombieDMG = 4;
            nameZM.setText("Zombie: " + ZombieNM);
            hpZM.setText("Zombie HP: " + ZombieHP);
            dmgZM.setText("Attack: " + ZombieDMG);
        }
        if(ZombieLV == 4){
            ZombieNM = "Teller";
            ZombieHP = 10;
            ZombieDMG = 5;
            nameZM.setText("Zombie: " + ZombieNM);
            hpZM.setText("Zombie HP: " + ZombieHP);
            dmgZM.setText("Attack: " + ZombieDMG);
        }

        int i = 0; // tracker
        int n = 1;
        while(n > 0){
            int ZombieHPOld = ZombieHP;
            int PlayerHPOld = PlayerHP;
            PlayerHP -= ZombieDMG;
            System.out.println(ZombieNM + " Zombie attack you with: " + ZombieDMG + " damage!" + "Your HP is: " + PlayerHP + "    :  " + i++);
            ZombieHP -= PlayerDMG;
            System.out.println("You attack zombie with: " + PlayerDMG + " damage!" + "Zombie HP is: " + ZombieHP + "      :  " + i++);
            if(PlayerHP <= 0){
                n = 0;
                ta.setText("You lost the fight!"
                        + "\nZombie Details from fight!"
                        + "\nZombie hp was: " + ZombieHPOld
                        + "\nZombie hp is: " + ZombieHP
                        + "\nZombie Details from fight!"
                        + "\nYour hp was: " + PlayerHPOld
                        + "\nYour hp is: " + PlayerHP);
                RESTART.setText("RESTART");
                RESTART.setVisible(true);
                FIRST.setVisible(false);
                SECOND.setVisible(false);
                THIRD.setVisible(false);
                FOURTH.setVisible(false);
                hp.setText("Player HP: " + PlayerHP);
                hpZM.setText("Zombie HP: " + ZombieHP);
            }
            else if(ZombieHP <= 0){
                n = 0;
                ta.setText("You won the fight!"
                        + "\nZombie Details from fight!"
                        + "\nZombie hp was: " + ZombieHPOld
                        + "\nZombie hp is: " + ZombieHP
                        + "\nZombie Details from fight!"
                        + "\nYour hp was: " + PlayerHPOld
                        + "\nYour hp is: " + PlayerHP);
                FIRST.setVisible(true);
                SECOND.setVisible(true);
                THIRD.setVisible(true);
                FOURTH.setVisible(true);
                hp.setText("Player HP: " + PlayerHP);
                hpZM.setText("Zombie HP : " + ZombieHP);
            }
        }
    }


    private void nodeDisplay(NodeMap map){
        ta.setText( map.currentNode().getDescription() + "\n");
        ta.append(map.currentNode().getQuestion() + "\n");
        if (map.currentNode().getQuestion().equals("*") ){
            FIRST.setText("Continue");
            SECOND.setVisible(false);
            THIRD.setVisible(false);
            FOURTH.setVisible(false);
        }
        else if (map.currentNode().getQuestion().equals("/") ){
            ta.setText( map.currentNode().getDescription()
                    + "\n" + "Your points are: " + Points
                    + "\n" + PointRect());
            FIRST.setVisible(false);
            SECOND.setVisible(false);
            THIRD.setVisible(false);
            FOURTH.setVisible(false);
        }
        else {
            FIRST.setText("FIRST");
            FIRST.setVisible(true);
            SECOND.setText("SECOND");
            SECOND.setVisible(true);
            THIRD.setText("THIRD");
            THIRD.setVisible(true);
            FOURTH.setText("FOURTH");
            FOURTH.setVisible(true);
        }

        if (map.currentNode().getActionID().equals("1")) {
            ZombieLV = 1;
            GamePanelMain3.setVisible(true);
            PlayerAttack();
        }
        else if (map.currentNode().getActionID().equals("2")) {
            ZombieLV = 2;
            GamePanelMain3.setVisible(true);
            PlayerAttack();
        }
        else if (map.currentNode().getActionID().equals("3")) {
            ZombieLV = 3;
            GamePanelMain3.setVisible(true);
            PlayerAttack();
        }
        else if (map.currentNode().getActionID().equals("4")) {
            ZombieLV = 4;
            GamePanelMain3.setVisible(true);
            PlayerAttack();
        }
        else if (map.currentNode().getActionID().equals("=")) {
            GamePanelMain3.setVisible(false);
            Points += 1;
            System.out.println(Points);
            ta1.setText("Your Points: " + Points);
        }

        if (map.currentNode().getZombieID().equals("1")) {
            PlayerHP += 5;
            hp.setText("Player HP: " + PlayerHP);
        }
        else if (map.currentNode().getZombieID().equals("2")) {
            PlayerHP += 15;
            hp.setText("Player HP: " + PlayerHP);
        }
        else if (map.currentNode().getZombieID().equals("3")) {
            PlayerHP += 25;
            hp.setText("Player HP: " + PlayerHP);
        }


    }



    /***************************************************/
    /*                      HELPERS                    */
    /***************************************************/
    private static Font createFont(int size){
        return  new Font("Courier", Font.PLAIN,size);
        //return  new Font("Atlantis International", Font.PLAIN,size);
    }
    // Links

    class GithubButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                String url = "https://github.com/UP962567/";
                Desktop.getDesktop().browse(java.net.URI.create(url));
            } catch (java.io.IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    class WebsiteButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                String url = "https://www.ma-dy.com/";
                Desktop.getDesktop().browse(java.net.URI.create(url));
            } catch (java.io.IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    class LinkInButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                String url = "https://www.linkedin.com/in/maliqdyrma";
                Desktop.getDesktop().browse(java.net.URI.create(url));
            } catch (java.io.IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
