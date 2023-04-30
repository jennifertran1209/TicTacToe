import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.AbstractButton;
import javax.swing.JPanel;

/**
 * Author: Jennifer Tran
 * Description: Coding practice on making a TicTacToe Game that
 * implements a class called ActionListener.
 */

public class TicToeGame implements ActionListener {
    Random rand = new Random();
    JFrame screen = new JFrame();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean p1Turn;

    // Construtor for TicTacToe Game and creates a screen and buttons to play on.
    TicToeGame() {
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setSize(800, 800);
        screen.getContentPane().setBackground(new Color(35, 50, 70));
        screen.setLayout(new BorderLayout());
        screen.setVisible(true);

        text.setBackground(new Color(25, 25, 25));
        text.setForeground(new Color(25, 255, 0));
        text.setFont(new Font("Ink Free", Font.BOLD, 75));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("The Tic-Tac-Toe Game");
        text.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0, 0, 800, 100);

        button.setLayout(new GridLayout(3, 3));
        button.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title.add(text);
        screen.add(title, BorderLayout.NORTH);
        screen.add(button);

        firstTurn();

    }

    /*
     * Gets player 1 and 2's input and outputs p1 as X and p2 as O.
     * Also allows p1 and p2 to take turns.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (p1Turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        p1Turn = false;
                        text.setText("P2 Turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        p1Turn = true;
                        text.setText("P1 Turn");
                        check();
                    }
                }
            }
        }
    }

    // Randomizes which player gets the first turn at the start of the game.
    public void firstTurn() {
        if (rand.nextInt(2) == 0) {
            p1Turn = true;
            text.setText("P1 turn");
        } else {
            p1Turn = false;
            text.setText("P2 turn");
        }
    }

    // Method that checks player 1 & 2 win condition and shows who wins.
    // Uses two other methods called p1Wins and p2Wins which show who won.
    public void check() {
        // Checks P1 Win Condition
        if (buttons[0].getText() == "X" &&
                buttons[1].getText() == "X" &&
                buttons[2].getText() == "X") {
            p1Wins(0, 1, 2);
        }
        if (buttons[3].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[5].getText() == "X") {
            p1Wins(3, 4, 5);
        }
        if (buttons[6].getText() == "X" &&
                buttons[7].getText() == "X" &&
                buttons[8].getText() == "X") {
            p1Wins(6, 7, 8);
        }
        if (buttons[0].getText() == "X" &&
                buttons[3].getText() == "X" &&
                buttons[6].getText() == "X") {
            p1Wins(0, 3, 6);
        }
        if (buttons[1].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[7].getText() == "X") {
            p1Wins(1, 4, 7);
        }
        if (buttons[2].getText() == "X" &&
                buttons[5].getText() == "X" &&
                buttons[8].getText() == "X") {
            p1Wins(2, 5, 8);
        }
        if (buttons[0].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[8].getText() == "X") {
            p1Wins(0, 4, 8);
        }
        if (buttons[2].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[6].getText() == "X") {
            p1Wins(0, 4, 8);
        }

        // Checks P2 Win Condition
        if (buttons[0].getText() == "O" &&
                buttons[1].getText() == "O" &&
                buttons[2].getText() == "O") {
            p2Wins(0, 1, 2);
        }
        if (buttons[3].getText() == "O" &&
                buttons[4].getText() == "O" &&
                buttons[5].getText() == "O") {
            p2Wins(3, 4, 5);
        }
        if (buttons[6].getText() == "O" &&
                buttons[7].getText() == "O" &&
                buttons[8].getText() == "O") {
            p2Wins(6, 7, 8);
        }
        if (buttons[0].getText() == "O" &&
                buttons[3].getText() == "O" &&
                buttons[6].getText() == "O") {
            p2Wins(0, 3, 6);
        }
        if (buttons[1].getText() == "O" &&
                buttons[4].getText() == "O" &&
                buttons[7].getText() == "O") {
            p2Wins(1, 4, 7);
        }
        if (buttons[2].getText() == "O" &&
                buttons[5].getText() == "O" &&
                buttons[8].getText() == "O") {
            p2Wins(2, 5, 8);
        }
        if (buttons[0].getText() == "O" &&
                buttons[4].getText() == "O" &&
                buttons[8].getText() == "O") {
            p2Wins(0, 4, 8);
        }
        if (buttons[2].getText() == "O" &&
                buttons[4].getText() == "O" &&
                buttons[6].getText() == "O") {
            p2Wins(2, 4, 6);
        } else {

        }
    }

    // Shows which button was the winning move and shows that p1 won.
    public void p1Wins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("P1 Wins");
    }

    // Shows which button was the winning move and shows that p2 won.
    public void p2Wins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("P2 Wins");
    }
}