package DewanSir.tictactoeAI;

import java.awt.*;
import java.awt.event.*;
class Sleep extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class TicTacToe implements ActionListener, WindowListener {
    static int count = 9;
    static int win = 0;
    Frame frame = new Frame();
    Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Java\\Java Workshop\\src\\DewanSir\\tictactoe\\icon.png");
    Button []buttons = new Button[9];
    Button reset = new Button("Reset Game");
    Label name = new Label("Tic-Tac-Toe");
    Panel panel = new Panel();
    Label player1 = new Label("You:  (X)");
    Label player2 = new Label("Computer:  (O)");
    Label move = new Label("Your move (X)");
    Label winner = new Label("");
    public TicTacToe(){
        frame.setLocation(400,50);
        frame.setSize(600,700);
        frame.setTitle("Tic-Tac-Toe");
        frame.setResizable(false);
        frame.setBackground(Color.decode("#2EFEC8"));
        frame.setIconImage(icon);
        for(int i = 0; i < 9; i++){
            buttons[i] = new Button();
        }
        buttons[0].setBounds(150,200,100,100);
        buttons[1].setBounds(250,200,100,100);
        buttons[2].setBounds(350,200,100,100);
        buttons[3].setBounds(150,300,100,100);
        buttons[4].setBounds(250,300,100,100);
        buttons[5].setBounds(350,300,100,100);
        buttons[6].setBounds(150,400,100,100);
        buttons[7].setBounds(250,400,100,100);
        buttons[8].setBounds(350,400,100,100);
        for(int i = 0; i < 9; i++){
            buttons[i].setBackground(Color.darkGray);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].addActionListener(this::actionPerformed);
            frame.add(buttons[i]);
            buttons[i].setFocusable(false);
        }
        player1.setBounds(170,100,170,25);
        player2.setBounds(350,100,300,25);
        move.setBounds(220,150,230,30);
        player1.setFont(new Font("Times New Roman",Font.BOLD,18));
        player2.setFont(new Font("Times New Roman",Font.BOLD,18));
        move.setFont(new Font("Times New Roman",Font.BOLD,25));

        winner.setBounds(230,520,200,50);
        winner.setFont(new Font("Times New Roman",Font.BOLD,25));
        reset.setBounds(210,580,180,50);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);

        reset.setFocusable(false);
        reset.setFont(new Font("Times New Roman",Font.BOLD,20));
        reset.addActionListener(this::actionPerformed);
        name.setBounds(200,15,300,100);
        name.setFont(new Font("Times New Roman",Font.BOLD,40));

        panel.setFocusable(false);
        frame.add(reset);
        frame.add(player1);
        frame.add(player2);
        frame.add(move);
        frame.add(winner);
        frame.add(panel);
        frame.add(name);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.addWindowListener(this);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        DoesItMatch doesItMatch = new DoesItMatch();
        Computer computer = new Computer();
        Sleep sleep = new Sleep();
        for (int i = 0; i < 9; i++){
            if(e.getSource() == reset){
                reset.setLabel("Reset Game");
                for(int j = 0; j < 9; j++) {
                    buttons[j].setLabel("");
                    buttons[j].setBackground(Color.darkGray);
                    buttons[i].setForeground(Color.WHITE);
                }
                Computer.storeValue.clear();
                winner.setText("");
                win = 0;
                count = 9;
                move.setText("Your move (X)");
            }
            else if (e.getSource() != reset && win!=1){
                if(e.getSource() == buttons[i] && buttons[i].getLabel() == "" && count%2 != 0){
                    buttons[i].setFont(new Font("Sans",Font.PLAIN,50));
                    buttons[i].setLabel("X");
                    count--;
                    move.setBounds(180,150,300,30);
                    move.setText("Computer's move (O)");
                    sleep.run();
                    computer.play(this, i);
                    if(doesItMatch.check(this) == true && DoesItMatch.flag == 1){
                        winner.setBounds(230,520,200,50);
                        winner.setText("You (X) win!");
                        reset.setLabel("New Game");
                        win = 1;
                        count = 9;
                        DoesItMatch.flag = 0;
                        break;
                    }
                    else if(doesItMatch.check(this) == true && DoesItMatch.flag == 0){
                        winner.setBounds(190,520,300,50);
                        winner.setText("Computer (O) win!");
                        reset.setLabel("New Game");
                        win = 1;
                        count = 9;
                        DoesItMatch.flag = 0;
                        break;
                    }
                }
            }
        }
        if(win == 0 && count==0){
            winner.setBounds(270,520,200,50);
            winner.setText("Draw!");
            reset.setLabel("New Game");
        }
    }


    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}

public class Main {
    public static void main(String[] args) {
        new TicTacToe();
    }
}