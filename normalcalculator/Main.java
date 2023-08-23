package DewanSir.normalcalculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;


class Calculator implements ActionListener, WindowListener {
    public ArrayList<String> stringArrayList = new ArrayList<>();
    public ArrayList<Integer> intArrayList = new ArrayList<>();
    public static String string = "";
    String str;
    Frame frame = new Frame();
    Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Java\\Java Workshop\\src\\DewanSir\\normalcalculator\\icon.png");
    Button []number = new Button[10];
    Button []sign = new Button[5];
    Button reset = new Button("AC");
    Button getResult = new Button("=");
    Label answerField = new Label();
    Panel paneltop = new Panel();
    Panel panelcenter = new Panel();
    Panel panelright = new Panel();
    Panel panelleft = new Panel();
    Panel panelbottom = new Panel();
    Panel panelbottom1 = new Panel();
    Panel panelbottom2 = new Panel();
    Panel panelbottom3 = new Panel();
    Panel panelbottom4 = new Panel();

    public Calculator(){
        // Work of Main Frame
        frame.setLocation(50,50);
        frame.setSize(400,500);
        frame.setTitle("Calculator");
        frame.setResizable(false);
        frame.setBackground(Color.darkGray);
        frame.setIconImage(icon);
        frame.setLayout(new BorderLayout(20,20));
        frame.add(paneltop, BorderLayout.NORTH);
        frame.add(panelcenter, BorderLayout.CENTER);
        frame.add(panelright, BorderLayout.EAST);
        frame.add(panelleft, BorderLayout.WEST);
        frame.add(panelbottom, BorderLayout.SOUTH);


        // Work of Top Panel
        paneltop.setBackground(Color.black);
        paneltop.setLayout(new FlowLayout());
        paneltop.setPreferredSize(new Dimension(0, 100));
        answerField.setPreferredSize(new Dimension(380, 90));
        answerField.setFont(new Font("Cascadia Code",Font.BOLD,40));
        answerField.setForeground(Color.WHITE);
        answerField.setBackground(Color.BLACK);


        // Work of Center Panel
        panelcenter.setBackground(Color.darkGray);
        panelright.setBackground(Color.darkGray);
        panelleft.setBackground(Color.darkGray);
        panelcenter.setLayout(new GridLayout(3,5,15,15));
        panelleft.setPreferredSize(new Dimension(0, 700));
        panelright.setPreferredSize(new Dimension(0, 700));

        for(int i = 0; i < 10; i++){
            number[i] = new Button();
            number[i].setBackground(Color.black);
            number[i].setForeground(Color.WHITE);
            number[i].setFont(new Font("Cascadia Code",Font.BOLD,40));
            number[i].setLabel(""+i+"");
            number[i].addActionListener(this::actionPerformed);
            panelcenter.add(number[i]);
            number[i].setFocusable(false);
        }
        for(int i = 0; i < 5; i++){
            sign[i] = new Button();
            sign[i].setBackground(Color.decode("#f18d0e"));
            sign[i].setForeground(Color.WHITE);
            sign[i].setFont(new Font("Cascadia Code",Font.BOLD,40));
            sign[i].addActionListener(this::actionPerformed);
            panelcenter.add(sign[i]);
            sign[i].setFocusable(false);
        }
        sign[0].setLabel("+");
        sign[1].setLabel("-");
        sign[2].setLabel("x");
        sign[3].setLabel("÷");
        sign[4].setLabel("%");


        // Work of Bottom Panel
        panelbottom.setBackground(Color.darkGray);
        reset.setBackground(Color.decode("#36faa1"));
        reset.setFont(new Font("Cascadia Code",Font.BOLD,40));
        getResult.setBackground(Color.decode("#a743fc"));
        getResult.setFont(new Font("Cascadia Code",Font.BOLD,40));

        panelbottom.setPreferredSize(new Dimension(0, 70));
        panelbottom1.setPreferredSize(new Dimension(0, 100));
        panelbottom2.setPreferredSize(new Dimension(0, 0));
        panelbottom1.setLayout(new GridLayout(1,2,20,20));
        panelbottom.setLayout(new BorderLayout(10,10));
        panelbottom.add(panelbottom1, BorderLayout.CENTER);
        panelbottom.add(panelbottom2, BorderLayout.SOUTH);
        panelbottom.add(panelbottom3, BorderLayout.EAST);
        panelbottom.add(panelbottom4, BorderLayout.WEST);
        reset.addActionListener(this::actionPerformed);
        getResult.addActionListener(this::actionPerformed);

        // Lastly
        paneltop.add(answerField);
        panelbottom1.add(reset);
        panelbottom1.add(getResult);
        frame.setResizable(false);
        frame.addWindowListener(this);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        Sum sum = new Sum();
        if(e.getSource() == reset){
            str = " ";
            string = "";
            stringArrayList.clear();
            answerField.setText(str);
        }
        else if(e.getSource() == getResult){
            int ans = sum.DO(this);
            str = Integer.toString(ans);
            answerField.setText(str);
        }
        else{
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == number[i]) {
                    stringArrayList.add(number[i].getLabel());
                    string += number[i].getLabel();
                    answerField.setText(string);
                }
            }
            for (int i = 0; i < 5; i++) {
                if (e.getSource() == sign[i]) {
                    stringArrayList.add(sign[i].getLabel());
                    string += sign[i].getLabel();
                    answerField.setText(string);
                }
            }
        }
    }
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowOpened(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}
public class Main {
    public static void main(String[] args) {
        new Calculator();
    }
}
