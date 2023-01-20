import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Tic_Tac_Toe implements ActionListener {
    JFrame frame = new JFrame();
    JPanel text_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] button = new JButton[9];
    int chance_flag = 0;
    Random random = new Random();
    boolean player1_chance;

    Tic_Tac_Toe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(120, 20, 124));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);

        text_panel.setLayout(new BorderLayout());
        text_panel.setBounds(0,0, 800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150, 150, 150));

        for(int i=0;i<9;i++){
            button[i] = new JButton();
            button_panel.add(button[i]);
            button[i].setFont(new Font("Chaucer", Font.BOLD, 120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }

        text_panel.add(textfield);
        frame.add(text_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        startTheGame();
    }
    public void startTheGame(){
        try {
            textfield.setText("Starting.........");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        int chance = random.nextInt(100);
        if(chance % 2 == 0){
            player1_chance = true;
            textfield.setText("X's TURN!");
        }
        else{
            player1_chance = false;
            textfield.setText("O's TURN!");
        }
    }
    public void gameOver(String s){
        chance_flag = 0;
        Object[] option = {"START AGAIN, EXIT"};
        int n = JOptionPane.showOptionDialog(frame, "GAME OVER\n" +s, "GAME OVER", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(n == 0){
            frame.dispose();
            new Tic_Tac_Toe();
        }
        else{
            frame.dispose();
        }
    }
    
    public void matchCheck() {// In this function we are checking wining condition's using conditional statments
       if ((button[0].getText() == "X") && (button[1].getText() == "X") && (button[2].getText() == "X")) {
           Player1Wins(0, 1, 2);
       }
       else if ((button[0].getText() == "X") && (button[4].getText() == "X") && (button[8].getText() == "X")) {
           Player1Wins(0, 4, 8);
       }
       else if ((button[0].getText() == "X") && (button[3].getText() == "X") && (button[6].getText() == "X")) {
           Player1Wins(0, 3, 6);
       }
       else if ((button[1].getText() == "X") && (button[4].getText() == "X") && (button[7].getText() == "X")) {
           Player1Wins(1, 4, 7);
       }
       else if ((button[2].getText() == "X") && (button[4].getText() == "X") && (button[6].getText() == "X")) {
           Player1Wins(2, 4, 6);
       }
       else if ((button[2].getText() == "X") && (button[5].getText() == "X") && (button[8].getText() == "X")) {
           Player1Wins(2, 5, 8);
       }
      else if ((button[3].getText() == "X") && (button[4].getText() == "X") && (button[5].getText() == "X")) {
           Player1Wins(3, 4, 5);
       }
      else if ((button[6].getText() == "X") && (button[7].getText() == "X") && (button[8].getText() == "X")) {
           Player1Wins(6, 7, 8);
       }
     
       else if ((button[0].getText() == "O") && (button[1].getText() == "O") && (button[2].getText() == "O")) {
           Player2Wins(0, 1, 2);
       }
       else if ((button[0].getText() == "O") && (button[3].getText() == "O") && (button[6].getText() == "O")) {
           Player2Wins(0, 3, 6);
       }
       else if ((button[0].getText() == "O") && (button[4].getText() == "O") && (button[8].getText() == "O")) {
           Player2Wins(0, 4, 8);
       }
       else if ((button[1].getText() == "O") && (button[4].getText() == "O") && (button[7].getText() == "O")) {
           Player2Wins(1, 4, 7);
       }
       else if ((button[2].getText() == "O") && (button[4].getText() == "O") && (button[6].getText() == "O")) {
           Player2Wins(2, 4, 6);
       }
       else if ((button[2].getText() == "O") && (button[5].getText() == "O") && (button[8].getText() == "O")) {
           Player2Wins(2, 5, 8);
       }
       else if ((button[3].getText() == "O") && (button[4].getText() == "O") && (button[5].getText() == "O")) {
           Player2Wins(3, 4, 5);
       } else if ((button[6].getText() == "O") && (button[7].getText() == "O") && (button[8].getText() == "O")) {
           Player2Wins(6, 7, 8);
       }
       else if(chance_flag==9) {
           textfield.setText("Match Tie");
            gameOver("Match Tie");
       }
    }

    public void Player1Wins(int x1, int x2, int x3) {
        button[x1].setBackground(Color.BLUE);
        button[x2].setBackground(Color.BLUE);
        button[x3].setBackground(Color.BLUE);
        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        textfield.setText("X wins");
        gameOver("X Wins");
    }
    public void Player2Wins(int x1, int x2, int x3) {
        button[x1].setBackground(Color.BLUE);
        button[x2].setBackground(Color.BLUE);
        button[x3].setBackground(Color.BLUE);
        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        textfield.setText("O Wins");
        gameOver("O Wins");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == button[i]) {
                if (player1_chance) {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(255, 0, 0));
                        button[i].setText("X");
                        player1_chance = false;
                        textfield.setText("O turn");
                        chance_flag++;
                        matchCheck();
                    }
                } else {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(0, 0, 255));
                        button[i].setText("O");
                        player1_chance = true;
                        textfield.setText("X turn");
                        chance_flag++;
                        matchCheck();
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new Tic_Tac_Toe();
     }
}


    

