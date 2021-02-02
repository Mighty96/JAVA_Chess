import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class SingleGame extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private int mouseX, mouseY;

    private ImageIcon localButtonImage = new ImageIcon(Main.class.getResource("./img/localbutton.png"));
    private ImageIcon localButtonOnImage = new ImageIcon(Main.class.getResource("./img/localbutton2.png"));
    private ImageIcon multiButtonImage = new ImageIcon(Main.class.getResource("./img/multibutton.png"));
    private ImageIcon multiButtonOnImage = new ImageIcon(Main.class.getResource("./img/multibutton2.png"));
    private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("./img/exitbutton.png"));
    private ImageIcon exitButtonOnImage = new ImageIcon(Main.class.getResource("./img/exitbutton2.png"));

    private Image background  = new ImageIcon(Main.class.getResource("./img/mainbackground.png")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("./img/menubar.png")));

    private JButton localButton = new JButton(localButtonImage);
    private JButton multiButton = new JButton(multiButtonImage);
    private JButton exitButton = new JButton(exitButtonImage);


    public SingleGame() {
        setTitle("Chess");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
        setBackground(new Color(0,0,0, 0));
        setLayout(null);

        menuBar.setBounds(0,0,1280,30);
        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });
        add(menuBar);

        localButton.setBounds(50, 400, 300, 100);
        localButton.setBorderPainted(false);
        localButton.setContentAreaFilled(false);
        localButton.setFocusPainted(false);
        localButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //local게임 실행
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                localButton.setIcon(localButtonOnImage);
                localButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                localButton.setIcon(localButtonImage);
                localButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        add(localButton);

        multiButton.setBounds(930, 400, 300, 100);
        multiButton.setBorderPainted(false);
        multiButton.setContentAreaFilled(false);
        multiButton.setFocusPainted(false);
        multiButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //멀티실행
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                multiButton.setIcon(multiButtonOnImage);
                multiButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                multiButton.setIcon(multiButtonImage);
                multiButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        add(multiButton);

        exitButton.setBounds(490, 550, 300, 100);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonOnImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        add(exitButton);
    }

    public void paint(Graphics g) {
        screenImage = createImage(1280, 720);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        paintComponents(g);
        this.repaint();
    }
}
