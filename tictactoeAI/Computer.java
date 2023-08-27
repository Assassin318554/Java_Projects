package DewanSir.tictactoeAI;

import java.awt.*;
import java.util.ArrayList;

public class Computer {
    static ArrayList<Integer> storeValue = new ArrayList<>();

    void play(TicTacToe ticTacToe, int index){
        // After player move 1 time
        storeValue.add(index);
        if(TicTacToe.count == 8){
            // Case 1
            if(index == 1){
                ticTacToe.buttons[2].setFont(new Font("Sans",Font.PLAIN,50));
                ticTacToe.buttons[2].setLabel("O");
            }
            // Case 2
            else if(index == 3){
                ticTacToe.buttons[6].setFont(new Font("Sans",Font.PLAIN,50));
                ticTacToe.buttons[6].setLabel("O");
            }
            // Case 3
            else if(index == 5 || index == 7){
                ticTacToe.buttons[8].setFont(new Font("Sans",Font.PLAIN,50));
                ticTacToe.buttons[8].setLabel("O");
            }
            // Case 4
            else if(index == 0 || index == 2 || index == 6 || index == 8){
                ticTacToe.buttons[4].setFont(new Font("Sans",Font.PLAIN,50));
                ticTacToe.buttons[4].setLabel("O");
            }
            // Case 5
            else if (index == 4) {
                ticTacToe.buttons[0].setFont(new Font("Sans",Font.PLAIN,50));
                ticTacToe.buttons[0].setLabel("O");
            }
            TicTacToe.count--;
            ticTacToe.move.setBounds(220,150,230,30);
            ticTacToe.move.setText("Your move (X)");
        }


        // After player move 2 time
        else if(TicTacToe.count == 6){
            storeValue.add(index);
            // Case 1
            if(storeValue.get(0) == 4 && storeValue.get(1) == 8){
                ticTacToe.buttons[6].setFont(new Font("Sans",Font.PLAIN,50));
                ticTacToe.buttons[6].setLabel("O");
            }
            else if(storeValue.get(0) == 4 && storeValue.get(1) != 8){
                ticTacToe.buttons[9 - index - 1].setFont(new Font("Sans",Font.PLAIN,50));
                ticTacToe.buttons[9 - index - 1].setLabel("O");
            }
            // Case 2
            else if(storeValue.get(0) == 1){
                if(storeValue.get(1) == 0 || storeValue.get(1) == 3 || storeValue.get(1) == 6){
                    ticTacToe.buttons[8].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[8].setLabel("O");
                }
                else if(storeValue.get(1) == 5 || storeValue.get(1) == 7){
                    ticTacToe.buttons[4].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[4].setLabel("O");
                }
                else if(storeValue.get(1) == 8 || storeValue.get(1) == 4){
                    ticTacToe.buttons[7].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[7].setLabel("O");
                }
            }
            // Case 3
            else if(storeValue.get(0) == 7){
                if(storeValue.get(1) == 0 || storeValue.get(1) == 3 || storeValue.get(1) == 6){
                    ticTacToe.buttons[2].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[2].setLabel("O");
                }
                else if(storeValue.get(1) == 1 || storeValue.get(1) == 5){
                    ticTacToe.buttons[4].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[4].setLabel("O");
                }
                else if(storeValue.get(1) == 2 || storeValue.get(1) == 4){
                    ticTacToe.buttons[1].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[1].setLabel("O");
                }
            }
            // Case 4
            else if(storeValue.get(0) == 3){
                if(storeValue.get(1) == 0 || storeValue.get(1) == 1 || storeValue.get(1) == 2){
                    ticTacToe.buttons[8].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[8].setLabel("O");
                }
                else if(storeValue.get(1) == 5 || storeValue.get(1) == 7){
                    ticTacToe.buttons[4].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[4].setLabel("O");
                }
                else if(storeValue.get(1) == 8 || storeValue.get(1) == 4){
                    ticTacToe.buttons[5].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[5].setLabel("O");
                }
            }
            // Case 5
            else if(storeValue.get(0) == 5){
                if(storeValue.get(1) == 0 || storeValue.get(1) == 1 || storeValue.get(1) == 2){
                    ticTacToe.buttons[6].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[6].setLabel("O");
                }
                else if(storeValue.get(1) == 3 || storeValue.get(1) == 7){
                    ticTacToe.buttons[4].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[4].setLabel("O");
                }
                else if(storeValue.get(1) == 6 || storeValue.get(1) == 4){
                    ticTacToe.buttons[5].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[5].setLabel("O");
                }
            }
            // Case 6
            else if(storeValue.get(0) == 0){
                if(storeValue.get(1) == 1){
                    ticTacToe.buttons[2].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[2].setLabel("O");
                }
                else if(storeValue.get(1) == 2){
                    ticTacToe.buttons[1].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[1].setLabel("O");
                }
                else if(storeValue.get(1) == 3){
                    ticTacToe.buttons[6].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[6].setLabel("O");
                }
                else if(storeValue.get(1) == 6 || storeValue.get(1) == 8){
                    ticTacToe.buttons[3].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[3].setLabel("O");
                }
                else if(storeValue.get(1) == 5){
                    ticTacToe.buttons[7].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[7].setLabel("O");
                }
                else if(storeValue.get(1) == 7){
                    ticTacToe.buttons[5].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[5].setLabel("O");
                }
            }
            // Case 7
            else if(storeValue.get(0) == 2){
                if(storeValue.get(1) == 1){
                    ticTacToe.buttons[0].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[0].setLabel("O");
                }
                else if(storeValue.get(1) == 0 || storeValue.get(1) == 3 || storeValue.get(1) == 6){
                    ticTacToe.buttons[1].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[1].setLabel("O");
                }
                else if(storeValue.get(1) == 8){
                    ticTacToe.buttons[3].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[3].setLabel("O");
                }
                else if(storeValue.get(1) == 5){
                    ticTacToe.buttons[8].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[8].setLabel("O");
                }
                else if(storeValue.get(1) == 7){
                    ticTacToe.buttons[5].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[5].setLabel("O");
                }
            }
            // Case 8
            else if(storeValue.get(0) == 6){
                if(storeValue.get(1) == 0 || storeValue.get(1) == 1){
                    ticTacToe.buttons[3].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[3].setLabel("O");
                }
                else if(storeValue.get(1) == 2){
                    ticTacToe.buttons[1].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[1].setLabel("O");
                }
                else if(storeValue.get(1) == 3){
                    ticTacToe.buttons[0].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[0].setLabel("O");
                }
                else if(storeValue.get(1) == 5 || storeValue.get(1) == 8){
                    ticTacToe.buttons[7].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[7].setLabel("O");
                }
                else if(storeValue.get(1) == 7){
                    ticTacToe.buttons[8].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[8].setLabel("O");
                }
            }
            // Case 8
            else if(storeValue.get(0) == 8){
                if(storeValue.get(1) == 0){
                    ticTacToe.buttons[1].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[1].setLabel("O");
                }
                else if(storeValue.get(1) == 1 || storeValue.get(1) == 2){
                    ticTacToe.buttons[5].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[5].setLabel("O");
                }
                else if(storeValue.get(1) == 3 || storeValue.get(1) == 6){
                    ticTacToe.buttons[7].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[7].setLabel("O");
                }
                else if(storeValue.get(1) == 5){
                    ticTacToe.buttons[2].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[2].setLabel("O");
                }
                else if(storeValue.get(1) == 7){
                    ticTacToe.buttons[6].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[6].setLabel("O");
                }
            }
            TicTacToe.count--;
            ticTacToe.move.setBounds(220,150,230,30);
            ticTacToe.move.setText("Your move (X)");
        }















        // After player move 3 time
        else if(TicTacToe.count == 4){
            storeValue.add(index);
            // Case 1
            if(storeValue.get(0) == 4 && storeValue.get(1) == 8){
                if(storeValue.get(2) == 4){
                    ticTacToe.buttons[6].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[6].setLabel("O");
                }
                else if(storeValue.get(2) == 4){
                    ticTacToe.buttons[6].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[6].setLabel("O");
                }
            }
            else if(storeValue.get(0) == 4 && storeValue.get(1) != 8){
                ticTacToe.buttons[9 - index - 1].setFont(new Font("Sans",Font.PLAIN,50));
                ticTacToe.buttons[9 - index - 1].setLabel("O");
            }
            // Case 2
            else if(storeValue.get(0) == 1){
                if(storeValue.get(1) == 0 || storeValue.get(1) == 3 || storeValue.get(1) == 6){
                    ticTacToe.buttons[8].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[8].setLabel("O");
                }
                else if(storeValue.get(1) == 5 || storeValue.get(1) == 7){
                    ticTacToe.buttons[4].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[4].setLabel("O");
                }
                else if(storeValue.get(1) == 8 || storeValue.get(1) == 4){
                    ticTacToe.buttons[7].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[7].setLabel("O");
                }
            }
            // Case 3
            else if(storeValue.get(0) == 7){
                if(storeValue.get(1) == 0 || storeValue.get(1) == 3 || storeValue.get(1) == 6){
                    ticTacToe.buttons[2].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[2].setLabel("O");
                }
                else if(storeValue.get(1) == 1 || storeValue.get(1) == 5){
                    ticTacToe.buttons[4].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[4].setLabel("O");
                }
                else if(storeValue.get(1) == 2 || storeValue.get(1) == 4){
                    ticTacToe.buttons[1].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[1].setLabel("O");
                }
            }
            // Case 4
            else if(storeValue.get(0) == 3){
                if(storeValue.get(1) == 0 || storeValue.get(1) == 1 || storeValue.get(1) == 2){
                    ticTacToe.buttons[8].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[8].setLabel("O");
                }
                else if(storeValue.get(1) == 5 || storeValue.get(1) == 7){
                    ticTacToe.buttons[4].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[4].setLabel("O");
                }
                else if(storeValue.get(1) == 8 || storeValue.get(1) == 4){
                    ticTacToe.buttons[5].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[5].setLabel("O");
                }
            }
            // Case 5
            else if(storeValue.get(0) == 5){
                if(storeValue.get(1) == 0 || storeValue.get(1) == 1 || storeValue.get(1) == 2){
                    ticTacToe.buttons[6].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[6].setLabel("O");
                }
                else if(storeValue.get(1) == 3 || storeValue.get(1) == 7){
                    ticTacToe.buttons[4].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[4].setLabel("O");
                }
                else if(storeValue.get(1) == 6 || storeValue.get(1) == 4){
                    ticTacToe.buttons[5].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[5].setLabel("O");
                }
            }
            // Case 6
            else if(storeValue.get(0) == 0){
                if(storeValue.get(1) == 1){
                    ticTacToe.buttons[2].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[2].setLabel("O");
                }
                else if(storeValue.get(1) == 2){
                    ticTacToe.buttons[1].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[1].setLabel("O");
                }
                else if(storeValue.get(1) == 3){
                    ticTacToe.buttons[6].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[6].setLabel("O");
                }
                else if(storeValue.get(1) == 6 || storeValue.get(1) == 8){
                    ticTacToe.buttons[3].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[3].setLabel("O");
                }
                else if(storeValue.get(1) == 5){
                    ticTacToe.buttons[7].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[7].setLabel("O");
                }
                else if(storeValue.get(1) == 7){
                    ticTacToe.buttons[5].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[5].setLabel("O");
                }
            }
            // Case 7
            else if(storeValue.get(0) == 2){
                if(storeValue.get(1) == 1){
                    ticTacToe.buttons[0].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[0].setLabel("O");
                }
                else if(storeValue.get(1) == 0 || storeValue.get(1) == 3 || storeValue.get(1) == 6){
                    ticTacToe.buttons[1].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[1].setLabel("O");
                }
                else if(storeValue.get(1) == 8){
                    ticTacToe.buttons[3].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[3].setLabel("O");
                }
                else if(storeValue.get(1) == 5){
                    ticTacToe.buttons[8].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[8].setLabel("O");
                }
                else if(storeValue.get(1) == 7){
                    ticTacToe.buttons[5].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[5].setLabel("O");
                }
            }
            // Case 8
            else if(storeValue.get(0) == 6){
                if(storeValue.get(1) == 0 || storeValue.get(1) == 1){
                    ticTacToe.buttons[3].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[3].setLabel("O");
                }
                else if(storeValue.get(1) == 2){
                    ticTacToe.buttons[1].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[1].setLabel("O");
                }
                else if(storeValue.get(1) == 3){
                    ticTacToe.buttons[0].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[0].setLabel("O");
                }
                else if(storeValue.get(1) == 5 || storeValue.get(1) == 8){
                    ticTacToe.buttons[7].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[7].setLabel("O");
                }
                else if(storeValue.get(1) == 7){
                    ticTacToe.buttons[8].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[8].setLabel("O");
                }
            }
            // Case 8
            else if(storeValue.get(0) == 8){
                if(storeValue.get(1) == 0){
                    ticTacToe.buttons[1].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[1].setLabel("O");
                }
                else if(storeValue.get(1) == 1 || storeValue.get(1) == 2){
                    ticTacToe.buttons[5].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[5].setLabel("O");
                }
                else if(storeValue.get(1) == 3 || storeValue.get(1) == 6){
                    ticTacToe.buttons[7].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[7].setLabel("O");
                }
                else if(storeValue.get(1) == 5){
                    ticTacToe.buttons[2].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[2].setLabel("O");
                }
                else if(storeValue.get(1) == 7){
                    ticTacToe.buttons[6].setFont(new Font("Sans",Font.PLAIN,50));
                    ticTacToe.buttons[6].setLabel("O");
                }
            }
            storeValue.add(index);
            TicTacToe.count--;
            ticTacToe.move.setBounds(220,150,230,30);
            ticTacToe.move.setText("Your move (X)");
        }
//
//
//        // After player move 4 time
//        else if(TicTacToe.count == 2){
//
//            storeValue.add(index);
//            TicTacToe.count--;
//            ticTacToe.move.setBounds(220,150,230,30);
//            ticTacToe.move.setText("Your move (X)");
//        }
    }
}