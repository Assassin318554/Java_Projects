package DewanSir.normalcalculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


class Calculator implements ActionListener, WindowListener {
    public String postNumberString = "";
    public String preNumberString = "";
    public String signString1 = "";
    public String signString2 = "";
    public double value1 = 0;
    public double value2 = 0;
    public double finalResult = 0;
    public static int count = 0;
    public static int flag = 0;
    public static int iHaveNoSignResult = 1;

    Frame frame = new Frame();
    Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Java\\Java Workshop\\src\\DewanSir\\normalcalculator\\calculatorIcon.png");
    Button []number = new Button[10];
    Button []sign = new Button[5];
    Button reset = new Button("AC");
    Button getResult = new Button("=");
    Label answerField = new Label("0");
    Panel paneltop = new Panel();
    Panel paneltop1 = new Panel();
    Panel paneltop2 = new Panel();
    Panel paneltop3 = new Panel();
    Panel paneltop4 = new Panel();
    Panel paneltop5 = new Panel();
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
        paneltop.setLayout(new BorderLayout());
        paneltop.setPreferredSize(new Dimension(0, 100));
        answerField.setPreferredSize(new Dimension(380, 90));
        answerField.setFont(new Font("Cascadia Code",Font.PLAIN,40));
        answerField.setForeground(Color.black);
        answerField.setBackground(Color.lightGray);
        paneltop.add(paneltop1, BorderLayout.SOUTH);
        paneltop.add(paneltop2, BorderLayout.WEST);
        paneltop.add(paneltop3, BorderLayout.CENTER);
        paneltop.add(paneltop4, BorderLayout.EAST);
        paneltop.add(paneltop5, BorderLayout.NORTH);
        paneltop1.setBackground(Color.black);
        paneltop2.setBackground(Color.black);
        paneltop3.setBackground(Color.black);
        paneltop4.setBackground(Color.black);
        paneltop3.setBackground(Color.black);
        paneltop1.setPreferredSize(new Dimension(0, 12));
        paneltop2.setPreferredSize(new Dimension(18, 0));
        paneltop4.setPreferredSize(new Dimension(18, 0));
        paneltop5.setPreferredSize(new Dimension(0, 12));

        //answerField.setBackground(Color.lightGray);



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
        reset.setFocusable(false);
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
            postNumberString = "";
            preNumberString = "";
            signString1 = "";
            signString2 = "";
            value1 = 0.0;
            value2 = 0.0;
            finalResult = 0.0;
            flag = 0;
            count = 0;
            answerField.setText("0");
        }
        else if(e.getSource() == getResult && count != 0){
            value1 = Double.parseDouble(preNumberString);
            value2 = Double.parseDouble(postNumberString);
            finalResult = sum.DO(this);
            preNumberString = Double.toString(finalResult);
            answerField.setText(preNumberString);
            signString1 = "";
            signString2 = "";
            postNumberString = "";
            count = 0;
            flag = 1;
            iHaveNoSignResult = 1;
        }
        else if(e.getSource() == getResult && count == 0){
            postNumberString = "";
            preNumberString = "";
            signString1 = "";
            signString2 = "";
            value1 = 0.0;
            value2 = 0.0;
            finalResult = 0.0;
            flag = 0;
            count = 0;
            iHaveNoSignResult = 1;
            answerField.setText("0");
        }
        else{
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == number[i] && signString1 == "" && iHaveNoSignResult == 1) {
                    postNumberString += number[i].getLabel();
                    answerField.setText(postNumberString);
                }
                else if (e.getSource() == number[i] && signString1 != "" && iHaveNoSignResult == 1) {
                    postNumberString += number[i].getLabel();
                    answerField.setText(preNumberString + signString1 + postNumberString);
                }
                else if (e.getSource() == number[i] && iHaveNoSignResult == 0 && flag == 1) {
                    postNumberString = "";
                    preNumberString = "";
                    signString1 = "";
                    signString2 = "";
                    value1 = 0.0;
                    value2 = 0.0;
                    finalResult = 0.0;
                    count = 0;
                    iHaveNoSignResult = 1;
                    flag = 0;
                    postNumberString += number[i].getLabel();
                    answerField.setText(postNumberString);
                }

            }
            for (int i = 0; i < 5; i++) {
                if (e.getSource() == sign[i] && count == 0 && flag == 0 && postNumberString != "") {
                    signString1 = sign[i].getLabel();
                    answerField.setText(postNumberString + signString1);
                    preNumberString = postNumberString;
                    postNumberString = "";
                    count++;
                }
                else if (e.getSource() == sign[i] && count == 0 && flag == 1 && postNumberString != "") {
                    signString1 = sign[i].getLabel();
                    answerField.setText(preNumberString + signString1);
                    count++;
                    flag = 0;
                }
                else if (e.getSource() == sign[i] && postNumberString == "") {
                    signString1 = sign[i].getLabel();
                    answerField.setText(preNumberString + signString1);
                    count++;
                }
                else if (e.getSource() == sign[i] && count != 0) {
                    signString2 = sign[i].getLabel();
                    value1 = Double.parseDouble(preNumberString);
                    value2 = Double.parseDouble(postNumberString);
                    finalResult = sum.DO(this);
                    preNumberString = Double.toString(finalResult);
                    answerField.setText(preNumberString + signString2);
                    signString1 = signString2;
                    postNumberString = "";
                    count++;
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
