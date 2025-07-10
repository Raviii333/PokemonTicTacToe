//By: Ravishan Thanarajah


// Import necessary Java packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.sound.sampled.*;
import java.net.URL;

// Main class that creates a GUI Tic Tac Toe game
public class TicTacToeApp extends JFrame implements ActionListener {

    // Layout manager and main panel to switch between different screens
    private final CardLayout cdLayout = new CardLayout();
    private final JPanel p_card = new JPanel(cdLayout);
    private JPanel card1, card2, card3, card4;

    // Game UI components
    private JLabel turnPic, playerturn;
    private JButton a, b, c, d, ee, f, g, h, i;
    private final int[][] board = new int[3][3]; // 3x3 game board matrix
    private int winner = 0; // stores winner value
    private char turn = 'x'; // current player turn
    private String n1 = "", n2 = ""; // player names
    private JTextField choice, name;

    // Music playback
    private Clip musicClip;
    private boolean musicPlaying = true;

    // Confetti animation overlay
    private ConfettiPanel confettiPanel;

    // Styling variables
    private final Color backgroundColour = new Color(84, 110, 145);
    private final Color buttonColour = new Color(246, 248, 210);
    private final Color buttonText = new Color(58, 75, 99);
    private final Font titleFont = new Font("Consolas", Font.PLAIN, 40);
    private final Color titleColour = new Color(0, 0, 0);
    private final Font promptFont = new Font("Segoe UI Black", Font.PLAIN, 15);
    private final Dimension boardSquare = new Dimension(90, 90);
    private final Dimension standardButtonSize = new Dimension(150, 50); // uniform button sizing
    private final Dimension smallButtonSize = new Dimension(100, 35);

    // Constructor - initializes game window and panels
    public TicTacToeApp() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 600);
        setLocationRelativeTo(null);
        System.setProperty("sun.java2d.uiScale", "1.0");

        initScreens(); // build UI screens
        add(p_card);
        setVisible(true);

        confettiPanel = new ConfettiPanel(); // animation panel
        setGlassPane(confettiPanel);         // overlay animation
    }

    // Builds each game screen (opening, instructions, settings, game)
    private void initScreens() {
        opening();
        instructions();
        settings();
        gameScreen();
    }

    // First screen - shows title and entry button
    private void opening() {
        playMusic("/poke.wav");

        card1 = new JPanel();
        card1.setBackground(backgroundColour);
        card1.setLayout(new BoxLayout(card1, BoxLayout.Y_AXIS));

        JLabel title1 = new JLabel(createImageIcon("startcard1.png"));
        title1.setFont(titleFont);
        title1.setForeground(titleColour);
        title1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton next = createButton("Enter", "2");
        next.setAlignmentX(Component.CENTER_ALIGNMENT);

        card1.add(title1);
        card1.add(next);
        p_card.add(card1, "1");
    }

    // Instruction screen with buttons to go to settings or game
    private void instructions() {
        card2 = new JPanel();
        card2.setBackground(backgroundColour);
        card2.setLayout(new BoxLayout(card2, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(createImageIcon("Instructions.png"));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(promptFont);
        title.setForeground(Color.WHITE);
        card2.add(title);

        JPanel p = new JPanel();
        p.setBackground(backgroundColour);
        p.add(createButton("Settings", "3"));
        p.add(createButton("Game", "4"));

        card2.add(p);
        p_card.add(card2, "2");
    }

    // Settings screen - players enter names, toggle music, go to game
    private void settings() {
        card3 = new JPanel();
        card3.setBackground(backgroundColour);
        card3.setLayout(new BoxLayout(card3, BoxLayout.Y_AXIS));

        JLabel settingLabel = new JLabel("Choose your settings:");
        settingLabel.setFont(promptFont);
        settingLabel.setForeground(Color.WHITE);
        settingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Player 1 setup
        JLabel player1Label = new JLabel("Player 1:", SwingConstants.CENTER);
        player1Label.setFont(promptFont);
        player1Label.setForeground(Color.WHITE);

        ImageIcon oIcon = createImageIcon("oturn.png");
        Image oImg = oIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel player1Icon = new JLabel(new ImageIcon(oImg), SwingConstants.CENTER);

        name = new JTextField(5);
        name.setHorizontalAlignment(JTextField.CENTER);
        name.setFont(promptFont);
        name.setMaximumSize(new Dimension(240, 30));
        name.setPreferredSize(new Dimension(240, 30));

        JPanel player1Col = new JPanel();
        player1Col.setLayout(new BoxLayout(player1Col, BoxLayout.Y_AXIS));
        player1Col.setBackground(backgroundColour);
        player1Col.add(player1Label);
        player1Col.add(Box.createVerticalStrut(10));
        player1Col.add(player1Icon);
        player1Col.add(Box.createVerticalStrut(10));
        player1Col.add(name);

        // Player 2 setup
        JLabel player2Label = new JLabel("Player 2:", SwingConstants.CENTER);
        player2Label.setFont(promptFont);
        player2Label.setForeground(Color.WHITE);

        ImageIcon xIcon = createImageIcon("xturn.png");
        Image xImg = xIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel player2Icon = new JLabel(new ImageIcon(xImg), SwingConstants.CENTER);

        choice = new JTextField(5);
        choice.setHorizontalAlignment(JTextField.CENTER);
        choice.setFont(promptFont);
        choice.setMaximumSize(new Dimension(240, 30));
        choice.setPreferredSize(new Dimension(240, 30));

        JPanel player2Col = new JPanel();
        player2Col.setLayout(new BoxLayout(player2Col, BoxLayout.Y_AXIS));
        player2Col.setBackground(backgroundColour);
        player2Col.add(player2Label);
        player2Col.add(Box.createVerticalStrut(10));
        player2Col.add(player2Icon);
        player2Col.add(Box.createVerticalStrut(10));
        player2Col.add(choice);

        // Combine both players in one row
        JPanel playerRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        playerRow.setBackground(backgroundColour);
        playerRow.add(player1Col);
        playerRow.add(player2Col);

        // Optional image/branding
        JLabel settingExtra = new JLabel(createImageIcon("settingextra.png"));
        settingExtra.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingExtra.setFont(promptFont);
        settingExtra.setForeground(Color.WHITE);

        // Music + game button
        JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        buttonRow.setBackground(backgroundColour);

        JButton toggleMusicBtn = new JButton("Toggle Music");
        toggleMusicBtn.setPreferredSize(standardButtonSize);
        toggleMusicBtn.setBackground(buttonColour);
        toggleMusicBtn.setForeground(buttonText);
        toggleMusicBtn.addActionListener(_ -> toggleMusic(toggleMusicBtn));

        JButton toGameBtn = createButton("To The Game", "4");
        toGameBtn.setPreferredSize(standardButtonSize);

        buttonRow.add(toggleMusicBtn);
        buttonRow.add(toGameBtn);

        // Final assembly
        card3.add(Box.createVerticalStrut(20));
        card3.add(settingLabel);
        card3.add(settingExtra);
        card3.add(Box.createVerticalStrut(10));
        card3.add(playerRow);
        card3.add(Box.createVerticalStrut(20));
        card3.add(buttonRow);

        p_card.add(card3, "3");
    }

    // Game screen: turn display, 3x3 grid, and bottom buttons
    private void gameScreen() {
        card4 = new JPanel();
        card4.setBackground(backgroundColour);
        card4.setLayout(new BoxLayout(card4, BoxLayout.Y_AXIS));

        // Current turn display panel
        JPanel p = new JPanel();
        p.setBackground(backgroundColour);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        JLabel currTurn = new JLabel("Current Turn:");
        currTurn.setFont(promptFont);
        currTurn.setForeground(Color.WHITE);
        currTurn.setAlignmentX(Component.CENTER_ALIGNMENT);

        turnPic = new JLabel(createImageIcon("xturn.png"));
        turnPic.setAlignmentX(Component.CENTER_ALIGNMENT);

        playerturn = new JLabel("Player 1 Name");
        playerturn.setFont(promptFont);
        playerturn.setForeground(Color.WHITE);
        playerturn.setAlignmentX(Component.CENTER_ALIGNMENT);

        p.add(Box.createRigidArea(new Dimension(0, 10)));
        p.add(currTurn);
        p.add(Box.createRigidArea(new Dimension(0, 10)));
        p.add(turnPic);
        p.add(Box.createRigidArea(new Dimension(0, 10)));
        p.add(playerturn);
        p.add(Box.createRigidArea(new Dimension(0, 10)));

        // Game grid (3x3 board)
        JPanel grid = new JPanel(new GridLayout(3, 3, 2, 2));
        grid.setBackground(backgroundColour);
        grid.setMaximumSize(new Dimension(230, 230));

        a = createGridButton("a", grid);
        b = createGridButton("b", grid);
        c = createGridButton("c", grid);
        d = createGridButton("d", grid);
        ee = createGridButton("ee", grid);
        f = createGridButton("f", grid);
        g = createGridButton("g", grid);
        h = createGridButton("h", grid);
        i = createGridButton("i", grid);

        JPanel gridWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        gridWrapper.setBackground(backgroundColour);
        gridWrapper.add(grid);

        // Bottom control buttons
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        p3.setBackground(backgroundColour);

        JButton againBtn = createButton("Again", "reset");
        againBtn.setPreferredSize(smallButtonSize);

        JButton instrBtn = createButton("How To", "2");
        instrBtn.setPreferredSize(smallButtonSize);

        JButton settingsBtn = createButton("Settings", "3");
        settingsBtn.setPreferredSize(smallButtonSize);

        p3.add(againBtn);
        p3.add(instrBtn);
        p3.add(settingsBtn);

        // Assemble game screen
        card4.add(p);
        card4.add(Box.createRigidArea(new Dimension(0, 10)));
        card4.add(gridWrapper);
        card4.add(Box.createRigidArea(new Dimension(0, 10)));
        card4.add(p3);

        p_card.add(card4, "4");
    }

    // Helper to create styled buttons with commands
    private JButton createButton(String text, String command) {
        JButton btn = new JButton(text);
        btn.setActionCommand(command);
        btn.addActionListener(this);
        btn.setBackground(buttonColour);
        btn.setForeground(buttonText);
        btn.setPreferredSize(standardButtonSize);
        return btn;
    }

    // Helper to create a board square button
    private JButton createGridButton(String cmd, JPanel panel) {
        JButton btn = new JButton(createImageIcon("b.png"));
        btn.setActionCommand(cmd);
        btn.setBackground(backgroundColour);
        btn.setPreferredSize(boardSquare);
        btn.addActionListener(this);
        panel.add(btn);
        return btn;
    }

    // Changes turn between X and O, updates UI
    private void flipTurn() {
        if (turnPic == null || playerturn == null) return;

        n1 = name != null ? name.getText() : "Player 1";
        n2 = choice != null ? choice.getText() : "Player 2";

        if (turn == 'x') {
            turn = 'o';
            turnPic.setIcon(createImageIcon("oturn.png"));
            playerturn.setText(n2);
        } else {
            turn = 'x';
            turnPic.setIcon(createImageIcon("xturn.png"));
            playerturn.setText(n1);
        }
    }

    // Updates a board square and advances turn
    private void updateSquare(int x, int y, JButton square) {
        int m = new Random().nextInt(6) + 1;
        board[x][y] = m;
        square.setIcon(createImageIcon(m + ".png"));
        playSoundEffect("/click.wav");
        flipTurn();
    }

    // Resets the board and turn
    private void reset() {
        JButton[] buttons = {a, b, c, d, ee, f, g, h, i};
        for (JButton btn : buttons) btn.setIcon(createImageIcon("b.png"));
        for (int[] row : board) java.util.Arrays.fill(row, 0);
        winner = 0;
        turn = 'x';
    }

    // Checks for winning conditions and announces winner
    private void win() {
        winner = 0;
        for (int i = 0; i < 3; i++)
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2])
                winner = board[i][0];
        for (int j = 0; j < 3; j++)
            if (board[0][j] != 0 && board[0][j] == board[1][j] && board[0][j] == board[2][j])
                winner = board[0][j];
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2])
            winner = board[0][0];
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[0][2] == board[2][0])
            winner = board[0][2];

        if (winner != 0) {
            String winnerName = (turn == 'x') ? n2 : n1;
            confettiPanel.setVisible(true);
            confettiPanel.start(); // triggers animation
            JOptionPane.showMessageDialog(this, winnerName + " wins!");
        }
    }

    // Plays background music
    private void playMusic(String filename) {
        try {
            if (musicClip != null && musicClip.isOpen()) {
                musicClip.stop();
                musicClip.close();
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getResource(filename));
            musicClip = AudioSystem.getClip();
            musicClip.open(audioStream);
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.err.println("Failed to play music: " + filename);
            e.printStackTrace();
        }
    }

    // Toggles background music on/off
    private void toggleMusic(JButton toggleButton) {
        if (musicPlaying) {
            if (musicClip != null && musicClip.isRunning()) {
                musicClip.stop();
                musicClip.close();
            }
            toggleButton.setText("Play Music");
            musicPlaying = false;
        } else {
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getResource("/poke.wav"));
                musicClip = AudioSystem.getClip();
                musicClip.open(audioStream);
                musicClip.loop(Clip.LOOP_CONTINUOUSLY);
                toggleButton.setText("Stop Music");
                musicPlaying = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Plays a sound effect once
    private void playSoundEffect(String fileName) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getResource(fileName));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.err.println("Sound effect failed: " + fileName);
            e.printStackTrace();
        }
    }

    // Loads an image from resource path
    private ImageIcon createImageIcon(String path) {
        URL imgURL = getClass().getResource("/" + path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find image: " + path);
            return new ImageIcon(); // blank
        }
    }

    // Handles all button actions from all screens
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "1" -> cdLayout.show(p_card, "1");
            case "2" -> cdLayout.show(p_card, "2");
            case "3" -> cdLayout.show(p_card, "3");
            case "4" -> {
                n1 = name.getText();
                n2 = choice.getText();
                playerturn.setText(n1);
                cdLayout.show(p_card, "4");
            }
            case "reset" -> reset();
            case "a" -> updateSquare(0, 0, a);
            case "b" -> updateSquare(0, 1, b);
            case "c" -> updateSquare(0, 2, c);
            case "d" -> updateSquare(1, 0, d);
            case "ee" -> updateSquare(1, 1, ee);
            case "f" -> updateSquare(1, 2, f);
            case "g" -> updateSquare(2, 0, g);
            case "h" -> updateSquare(2, 1, h);
            case "i" -> updateSquare(2, 2, i);
        }
        win();
    }

    // Main entry point
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToeApp::new);
    }
}
