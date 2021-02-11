import javax.swing.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.TimerTask;

public class MainMenu extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private int mouseX, mouseY;
    private int mouseXOnBoard, mouseYOnBoard;
    private int turnPlayer;
    private Piece nullPiece = new Piece(0,0,"",0, 0);
    private Piece[][] board = new Piece[][]
        {{nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece},
        {nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece},
        {nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece},
        {nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece},
        {nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece},
        {nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece},
        {nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece},
        {nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece},
        {nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece}};

    private ImageIcon localButtonImage = new ImageIcon(Main.class.getResource("./img/localbutton.png"));
    private ImageIcon localButtonOnImage = new ImageIcon(Main.class.getResource("./img/localbutton2.png"));
    private ImageIcon multiButtonImage = new ImageIcon(Main.class.getResource("./img/multibutton.png"));
    private ImageIcon multiButtonOnImage = new ImageIcon(Main.class.getResource("./img/multibutton2.png"));
    private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("./img/exitbutton.png"));
    private ImageIcon exitButtonOnImage = new ImageIcon(Main.class.getResource("./img/exitbutton2.png"));
    private ImageIcon startButtonImage = new ImageIcon(Main.class.getResource("./img/startbutton.png"));
    private ImageIcon startButtonOnImage = new ImageIcon(Main.class.getResource("./img/startbutton2.png"));
    private Image background  = new ImageIcon(Main.class.getResource("./img/mainbackground.png")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("./img/menubar.png")));
    private JLabel boardLabel = new JLabel(new ImageIcon(Main.class.getResource("./img/Board.png")));
    private JLabel check = new JLabel(new ImageIcon(Main.class.getResource("./img/check.png")));
    private JLabel white_player = new JLabel(new ImageIcon(Main.class.getResource("./img/white_player.png")));
    private JLabel black_player = new JLabel(new ImageIcon(Main.class.getResource("./img/black_player.png")));
    private JLabel lostPiece = new JLabel(new ImageIcon(Main.class.getResource("./img/lost.png")));
    private JLabel white_lost = new JLabel(new ImageIcon(Main.class.getResource("./img/white_lost.png")));
    private JLabel black_lost = new JLabel(new ImageIcon(Main.class.getResource("./img/black_lost.png")));

    private JTextArea p1 = new JTextArea("Player 1");
    private JTextArea p2 = new JTextArea("Player 2");

    private JButton localButton = new JButton(localButtonImage);
    private JButton multiButton = new JButton(multiButtonImage);
    private JButton exitButton = new JButton(exitButtonImage);
    private JButton startButton = new JButton(startButtonImage);
    private JButton returnButton = new JButton(exitButtonImage);

    private ImageIcon blackKingImage = new ImageIcon(Main.class.getResource("./img/BK.png"));
    private ImageIcon blackQueenImage = new ImageIcon(Main.class.getResource("./img/BQ.png"));
    private ImageIcon blackKnightImage = new ImageIcon(Main.class.getResource("./img/BN.png"));
    private ImageIcon blackBishopImage = new ImageIcon(Main.class.getResource("./img/BB.png"));
    private ImageIcon blackRookImage = new ImageIcon(Main.class.getResource("./img/BR.png"));
    private ImageIcon blackPawnImage = new ImageIcon(Main.class.getResource("./img/BP.png"));
    private ImageIcon whiteKingImage = new ImageIcon(Main.class.getResource("./img/WK.png"));
    private ImageIcon whiteQueenImage = new ImageIcon(Main.class.getResource("./img/WQ.png"));
    private ImageIcon whiteKnightImage = new ImageIcon(Main.class.getResource("./img/WN.png"));
    private ImageIcon whiteBishopImage = new ImageIcon(Main.class.getResource("./img/WB.png"));
    private ImageIcon whiteRookImage = new ImageIcon(Main.class.getResource("./img/WR.png"));
    private ImageIcon whitePawnImage = new ImageIcon(Main.class.getResource("./img/WP.png"));

    private JButton[] p1bt = new JButton[16];
    private JButton[] p2bt = new JButton[16];

    Player player1;
    Player player2;

    public MainMenu() {
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

        boardLabel.setBounds(50, 60, 600, 600);
        boardLabel.setVisible(false);

        check.setBounds(160, 240, 400, 200);
        check.setVisible(false);
        add(check);

        black_player.setBounds(700, 100, 76, 76);
        black_player.setVisible(false);
        add(black_player);
        white_player.setBounds(700, 200, 76, 76);
        white_player.setVisible(false);
        add(white_player);


        lostPiece.setBounds(720, 50, 500, 150);
        lostPiece.setVisible(false);
        add(lostPiece);

        black_lost.setBounds(670, 200, 600, 150);
        black_lost.setVisible(false);
        add(black_lost);
        white_lost.setBounds(670, 400, 600, 150);
        white_lost.setVisible(false);
        add(white_lost);

        p1.setBounds(800, 100, 300, 80);
        p2.setBounds(800, 200, 300, 80);
        add(p1);
        add(p2);
        p1.setFont(new Font("돋움체", Font.CENTER_BASELINE, 65));
        p2.setFont(new Font("돋움체", Font.CENTER_BASELINE, 65));
        p1.setVisible(false);
        p2.setVisible(false);
        localButton.setBounds(50, 400, 300, 100);
        localButton.setBorderPainted(false);
        localButton.setContentAreaFilled(false);
        localButton.setFocusPainted(false);
        localButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                localButton.setVisible(false);
                exitButton.setVisible(false);
                multiButton.setVisible(false);
                background = new ImageIcon(Main.class.getResource("./img/gamebackground.png")).getImage();
                startButton.setVisible(true);
                boardLabel.setVisible(true);
                p1.setVisible(true);
                p2.setVisible(true);
                white_player.setVisible(true);
                black_player.setVisible(true);
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

        startButton.setBounds(800, 500, 300, 100);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                LocalGame();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButtonOnImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        add(startButton);
        startButton.setVisible(false);

        returnButton.setBounds(820, 600, 300, 100);
        returnButton.setBorderPainted(false);
        returnButton.setContentAreaFilled(false);
        returnButton.setFocusPainted(false);
        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                localButton.setVisible(true);
                exitButton.setVisible(true);
                multiButton.setVisible(true);
                background = new ImageIcon(Main.class.getResource("./img/mainbackground.png")).getImage();
                boardLabel.setVisible(false);
                for (int i = 0 ; i < 16 ; i ++)
                {
                    p1bt[i].setVisible(false);
                    p2bt[i].setVisible(false);
                }
                returnButton.setVisible(false);
                lostPiece.setVisible(false);
                black_lost.setVisible(false);
                white_lost.setVisible(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                returnButton.setIcon(exitButtonOnImage);
                returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                returnButton.setIcon(exitButtonImage);
                returnButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        returnButton.setVisible(false);
        add(returnButton);

        p1bt[0] = new JButton(blackKingImage);
        p1bt[1] = new JButton(blackQueenImage);
        p1bt[2] = new JButton(blackKnightImage);
        p1bt[3] = new JButton(blackKnightImage);
        p1bt[4] = new JButton(blackBishopImage);
        p1bt[5] = new JButton(blackBishopImage);
        p1bt[6] = new JButton(blackRookImage);
        p1bt[7] = new JButton(blackRookImage);
        for (int i = 8 ; i <= 15 ; i++) {
            p1bt[i] = new JButton(blackPawnImage);
        }

        p2bt[0] = new JButton(whiteKingImage);
        p2bt[1] = new JButton(whiteQueenImage);
        p2bt[2] = new JButton(whiteKnightImage);
        p2bt[3] = new JButton(whiteKnightImage);
        p2bt[4] = new JButton(whiteBishopImage);
        p2bt[5] = new JButton(whiteBishopImage);
        p2bt[6] = new JButton(whiteRookImage);
        p2bt[7] = new JButton(whiteRookImage);
        for (int i = 8 ; i <= 15 ; i++) {
            p2bt[i] =new JButton(whitePawnImage);
        }

        // 말 움직임 이벤트
        for (int i = 0 ; i < 16 ; i++) {
            final int temp = i;
            p1bt[i].addMouseListener(new MouseAdapter() {
                int previous_x;
                int previous_y;
                @Override
                public void mousePressed(MouseEvent e) {
                    previous_x = (23 + (e.getXOnScreen() - getLocation().x)) / 75;
                    previous_y = (15 + (e.getYOnScreen() - getLocation().y)) / 75;
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    p1bt[temp].setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    p1bt[temp].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    mouseXOnBoard = (23 + (e.getXOnScreen() - getLocation().x)) / 75;
                    mouseYOnBoard = (15 + (e.getYOnScreen() - getLocation().y)) / 75;
                    if (movable(board[previous_y][previous_x], previous_x, previous_y, mouseXOnBoard, mouseYOnBoard)) {
                        if (board[previous_y][previous_x].getName().equals("Pawn")) {
                            board[previous_y][previous_x].setFirstMove(true);
                        }
                        if (board[mouseYOnBoard][mouseXOnBoard].getTurn() == 2) {
                            board[mouseYOnBoard][mouseXOnBoard].setLife(false);
                            p2bt[board[mouseYOnBoard][mouseXOnBoard].getNo()].setVisible(false);
                        }
                        board[previous_y][previous_x].setPos_y(mouseYOnBoard);
                        board[previous_y][previous_x].setPos_x(mouseXOnBoard);
                        board[mouseYOnBoard][mouseXOnBoard] = board[previous_y][previous_x];
                        board[previous_y][previous_x] = nullPiece;
                        if (!player2.getPieces()[0].isLife())
                            System.out.println("플레이어1 승리");
                        checkKing();
                        changeTurn(2);
                    }
                    drawBoard();
                }
            });
            p1bt[i].addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {

                    int x = e.getXOnScreen() - getLocation().x;
                    int y = e.getYOnScreen() - getLocation().y;
                    p1bt[temp].setBounds(x - 37, y - 37, 75, 75);
                }
            });
            p2bt[i].addMouseListener(new MouseAdapter() {
                int previous_x;
                int previous_y;
                @Override
                public void mousePressed(MouseEvent e) {
                    previous_x = (23 + (e.getXOnScreen() - getLocation().x)) / 75;
                    previous_y = (15 + (e.getYOnScreen() - getLocation().y)) / 75;
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    p2bt[temp].setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    p2bt[temp].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    mouseXOnBoard = (23 + (e.getXOnScreen() - getLocation().x)) / 75;
                    mouseYOnBoard = (15 + (e.getYOnScreen() - getLocation().y)) / 75;
                    if (movable(board[previous_y][previous_x], previous_x, previous_y, mouseXOnBoard, mouseYOnBoard)) {
                        if (board[previous_y][previous_x].getName().equals("Pawn")) {
                            board[previous_y][previous_x].setFirstMove(true);
                        }
                        if (board[mouseYOnBoard][mouseXOnBoard].getTurn() == 1) {
                            board[mouseYOnBoard][mouseXOnBoard].setLife(false);
                            p1bt[board[mouseYOnBoard][mouseXOnBoard].getNo()].setVisible(false);
                        }
                        board[previous_y][previous_x].setPos_y(mouseYOnBoard);
                        board[previous_y][previous_x].setPos_x(mouseXOnBoard);
                        board[mouseYOnBoard][mouseXOnBoard] = board[previous_y][previous_x];
                        board[previous_y][previous_x] = nullPiece;
                        if(!player2.getPieces()[0].isLife())
                            System.out.println("플레이어2 승리");
                        checkKing();
                        changeTurn(1);
                    }
                    drawBoard();
                }
            });
            p2bt[i].addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {

                    int x = e.getXOnScreen() - getLocation().x;
                    int y = e.getYOnScreen() - getLocation().y;
                    p2bt[temp].setBounds(x - 37, y - 37, 75, 75);
                }
            });
            add(p1bt[i]);
            add(p2bt[i]);
            p1bt[i].setVisible(false);
            p1bt[i].setBorderPainted(false);
            p1bt[i].setContentAreaFilled(false);
            p1bt[i].setFocusPainted(false);
            p2bt[i].setVisible(false);
            p2bt[i].setBorderPainted(false);
            p2bt[i].setContentAreaFilled(false);
            p2bt[i].setFocusPainted(false);
        }
        add(boardLabel);
    }

    public void LocalGame() {
        player1 = new Player(p1.getName(), 1);
        player2 = new Player(p2.getName(), 2);
        turnPlayer = 1;
        changeTurn(1);
        setBoard();
        drawBoard();
        for (int i = 0 ; i < 16 ; i++) {
            p1bt[i].setVisible(true);
            p2bt[i].setVisible(true);
        }
        p1.setVisible(false);
        p2.setVisible(false);
        startButton.setVisible(false);
        white_player.setVisible(false);
        black_player.setVisible(false);
        returnButton.setVisible(true);
        lostPiece.setVisible(true);
        black_lost.setVisible(true);
        white_lost.setVisible(true);
    }

    public void changeTurn(int turn) {
        if (turn == 1) {
            for (int i = 0 ; i < 16 ; i++) {
                p1bt[i].addNotify();
                p2bt[i].removeNotify();
            }
            turnPlayer = 1;
        } else {
            for (int i = 0 ; i < 16 ; i++) {
                p2bt[i].addNotify();
                p1bt[i].removeNotify();
            }
            turnPlayer = 2;
        }
    }

    public void checkKing() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                check.setVisible(false);
            }
        };
        if (turnPlayer == 1) {
            for (int i = 0; i < 16; i++) {
                if(movable(player1.getPieces()[i], player1.getPieces()[i].getPos_x(), player1.getPieces()[i].getPos_y(), player2.getPieces()[0].getPos_x(), player2.getPieces()[0].getPos_y())) {
                    check.setVisible(true);
                    timer.schedule(timerTask, 1000);
                    break;
                }
            }
        } else {
            for (int i = 0; i < 16; i++) {
                if(movable(player2.getPieces()[i], player2.getPieces()[i].getPos_x(), player2.getPieces()[i].getPos_y(), player1.getPieces()[0].getPos_x(), player1.getPieces()[0].getPos_y())) {
                    check.setVisible(true);
                    timer.schedule(timerTask, 1000);
                    break;
                }
            }
        }
    }

    public void setBoard() {
        for (int i = 1 ; i <= 8 ; i++)
            for (int j = 1 ; j <= 8 ; j++)
                board[i][j] = nullPiece;
        for (int i = 0 ; i < 16 ; i++) {
            board[player1.getPieces()[i].getPos_y()][player1.getPieces()[i].getPos_x()] = player1.getPieces()[i];
            board[player2.getPieces()[i].getPos_y()][player2.getPieces()[i].getPos_x()] = player2.getPieces()[i];
        }
    }

    public void drawBoard() {
        for (int i = 0 ; i < 16 ; i++) {
            if (player1.getPieces()[i].isLife()) {
                p1bt[i].setBounds(-23 + 75 * player1.getPieces()[i].getPos_x(), -15 + 75 * player1.getPieces()[i].getPos_y(), 75, 75);
            }
            if (player2.getPieces()[i].isLife()) {
                p2bt[i].setBounds(-23 + 75 * player2.getPieces()[i].getPos_x(), -15 + 75 * player2.getPieces()[i].getPos_y(), 75, 75);
            }
        }
    }

    public boolean movable(Piece piece, int previous_x, int previous_y, int mouseXOnBoard, int mouseYOnBoard) {
        if (mouseXOnBoard < 1 || mouseXOnBoard > 8 || mouseYOnBoard < 1 || mouseYOnBoard > 8) return false;
        if (previous_x == mouseXOnBoard && previous_y == mouseYOnBoard) return false;
        if (board[mouseYOnBoard][mouseXOnBoard].getTurn() == turnPlayer) return false;
        if (piece.getName().equals("King")) {
            if (mouseXOnBoard >= previous_x - 1 && mouseXOnBoard <= previous_x + 1 && mouseYOnBoard >= previous_y - 1 && mouseYOnBoard <= previous_y + 1) return true;
            else return false;
        } else if (piece.getName().equals("Queen")) {
            if (previous_x == mouseXOnBoard) {
                if (previous_y < mouseYOnBoard) {
                    for (int i = previous_y + 1 ; i < mouseYOnBoard ; i++) {
                        if (board[i][previous_x] != nullPiece) return false;
                    }
                } else {
                    for (int i = previous_y - 1 ; i > mouseYOnBoard ; i--) {
                        if (board[i][previous_x] != nullPiece) return false;
                    }
                }
            } else if (previous_y == mouseYOnBoard) {
                if (previous_x < mouseXOnBoard) {
                    for (int i = previous_x + 1 ; i < mouseXOnBoard ; i++) {
                        if (board[previous_x][i] != nullPiece) return false;
                    }
                } else {
                    for (int i = previous_x - 1 ; i > mouseXOnBoard ; i--) {
                        if (board[previous_x][i] != nullPiece) return false;
                    }
                }
            } else if (previous_y - mouseYOnBoard == previous_x - mouseXOnBoard){
                if (previous_y < mouseYOnBoard) {
                    for (int i = previous_y + 1, j = previous_x + 1 ; i < mouseYOnBoard && j < mouseXOnBoard ; i++, j++) {
                        if (board[i][j] != nullPiece) return false;
                    }
                } else {
                    for (int i = previous_y - 1, j = previous_x - 1 ; i > mouseYOnBoard && j > mouseXOnBoard ; i--, j--) {
                        if (board[i][j] != nullPiece) return false;
                    }
                }
            } else if (previous_y - mouseYOnBoard == -(previous_x - mouseXOnBoard)) {
                if (previous_y < mouseYOnBoard) {
                    for (int i = previous_y + 1, j = previous_x - 1; i < mouseYOnBoard && j > mouseXOnBoard ; i++, j--) {
                        if (board[i][j] != nullPiece) return false;
                    }
                } else {
                    for (int i = previous_y - 1 , j = previous_x + 1 ; i > mouseYOnBoard && j < mouseXOnBoard ; i--, j++) {
                        if (board[i][j] != nullPiece) return false;
                    }
                }
            } else {
                return false;
            }
        } else if (piece.getName().equals("Knight")) {
            if (previous_x + 1 == mouseXOnBoard && previous_y + 2 == mouseYOnBoard) return true;
            if (previous_x + 2 == mouseXOnBoard && previous_y + 1 == mouseYOnBoard) return true;
            if (previous_x + 2 == mouseXOnBoard && previous_y - 1 == mouseYOnBoard) return true;
            if (previous_x + 1 == mouseXOnBoard && previous_y - 2 == mouseYOnBoard) return true;
            if (previous_x - 1 == mouseXOnBoard && previous_y - 2 == mouseYOnBoard) return true;
            if (previous_x - 2 == mouseXOnBoard && previous_y - 1 == mouseYOnBoard) return true;
            if (previous_x - 2 == mouseXOnBoard && previous_y + 1 == mouseYOnBoard) return true;
            if (previous_x - 1 == mouseXOnBoard && previous_y + 2 == mouseYOnBoard) return true;
            return false;
        } else if (piece.getName().equals("Bishop")) {
            if (previous_y - mouseYOnBoard == previous_x - mouseXOnBoard){
                if (previous_y < mouseYOnBoard) {
                    for (int i = previous_y + 1, j = previous_x + 1 ; i < mouseYOnBoard && j < mouseXOnBoard ; i++, j++) {
                        if (board[i][j] != nullPiece) return false;
                    }
                } else {
                    for (int i = previous_y - 1, j = previous_x - 1 ; i > mouseYOnBoard && j > mouseXOnBoard ; i--, j--) {
                        if (board[i][j] != nullPiece) return false;
                    }
                }
            } else if (previous_y - mouseYOnBoard ==  -(previous_x - mouseXOnBoard)) {
                if (previous_y < mouseYOnBoard) {
                    for (int i = previous_y + 1, j = previous_x - 1; i < mouseYOnBoard && j > mouseXOnBoard; i++, j--) {
                        if (board[i][j] != nullPiece) return false;
                    }
                } else {
                    for (int i = previous_y - 1, j = previous_x + 1; i > mouseYOnBoard && j < mouseXOnBoard; i--, j++) {
                        if (board[i][j] != nullPiece) return false;
                    }
                }
            } else return false;
        } else if (piece.getName().equals("Rook")) {
            if (previous_x == mouseXOnBoard) {
                if (previous_y < mouseYOnBoard) {
                    for (int i = previous_y + 1 ; i < mouseYOnBoard ; i++) {
                        if (board[i][previous_x] != nullPiece) return false;
                    }
                } else {
                    for (int i = previous_y - 1 ; i > mouseYOnBoard ; i--) {
                        if (board[i][previous_x] != nullPiece) return false;
                    }
                }
            } else if (previous_y == mouseYOnBoard) {
                if (previous_x < mouseXOnBoard) {
                    for (int i = previous_x + 1 ; i < mouseXOnBoard ; i++) {
                        if (board[previous_x][i] != nullPiece) return false;
                    }
                } else {
                    for (int i = previous_x - 1 ; i > mouseXOnBoard ; i--) {
                        if (board[previous_x][i] != nullPiece) return false;
                    }
                }
            } else return false;
        } else if (piece.getName().equals("Pawn")) {
            if (!piece.isFirstMove()) {
                if (turnPlayer == 1) {
                    if (previous_x == mouseXOnBoard && previous_y - 2 == mouseYOnBoard &&
                            board[previous_y - 1][previous_x] == nullPiece && board[previous_y - 2][previous_x] == nullPiece) return true;
                } else if (turnPlayer == 2) {
                    if (previous_x == mouseXOnBoard && previous_y + 2 == mouseYOnBoard &&
                            board[previous_y + 1][previous_x] == nullPiece && board[previous_y + 2][previous_x] == nullPiece) return true;
                }
            }
            if (turnPlayer == 1) {
                if (previous_x == mouseXOnBoard && previous_y - 1 == mouseYOnBoard && board[previous_y - 1][previous_x] == nullPiece) return true;
                if ((previous_x - 1 == mouseXOnBoard || previous_x + 1 == mouseXOnBoard) && previous_y - 1 == mouseYOnBoard &&
                        board[mouseYOnBoard][mouseXOnBoard].getTurn() == 2) return true;
            } else if (turnPlayer == 2) {
                if (previous_x == mouseXOnBoard && previous_y + 1 == mouseYOnBoard && board[previous_y + 1][previous_x] == nullPiece) return true;
                if ((previous_x - 1 == mouseXOnBoard || previous_x + 1 == mouseXOnBoard) && previous_y + 1 == mouseYOnBoard &&
                        board[mouseYOnBoard][mouseXOnBoard].getTurn() == 2) return true;
            }
            return false;
        }

        return true;
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
