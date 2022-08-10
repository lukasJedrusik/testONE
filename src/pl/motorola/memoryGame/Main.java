package pl.motorola.memoryGame;

import pl.motorola.memoryGame.exeptions.IncorrectValue;
import pl.motorola.memoryGame.gui.ShowTime;
import pl.motorola.memoryGame.model.SingleWorld;

import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Words words = new Words();

        boolean flag = true;
        boolean runing = true;
        int difficultyLevel = 0;
        int counter = 0;
        Scanner scaner = new Scanner(System.in);

        while(runing) {

            while (flag) {
                System.out.println("Choose difficulty level: EASY press 1 or HARD press 2");
                try {
                    difficultyLevel = ShowTime.chooseLevel(scaner);
                    flag = false;
                } catch (IncorrectValue e) {
                }
                System.out.println();
            }

            ArrayList<SingleWorld> list = words.randomlySelected(difficultyLevel);
            ArrayList<SingleWorld> duplicate = new ArrayList<SingleWorld>(words.randomlySelectedDuplicate(list));
            Collections.shuffle(duplicate);

            int chances = 0;
            if (difficultyLevel == 4) {
                chances = 10;
            } else {
                chances = 15;
            }

            int positionA = 0;
            int positionB = 0;
            while (chances > 0) {
                ShowTime.showGame(list, duplicate, chances);
                System.out.println();


                boolean correctPosition = true;
                while (correctPosition) {
                    System.out.println("Chose position from A:");
                    try {
                        positionA = scaner.nextInt() - 1;
                        list.get(positionA).setVisibility(true);
                        ShowTime.showGame(list, duplicate, chances);
                        correctPosition = false;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Wrong index number!!");
                        //System.out.println();
                        ShowTime.showGame(list, duplicate, chances);
                    }

                }

                boolean correctPosition1 = true;
                while (correctPosition1) {
                    System.out.println("Chose position from B:");
                    try {
                        positionB = scaner.nextInt() - 1;
                        duplicate.get(positionB).setVisibility(true);
                        ShowTime.showGame(list, duplicate, chances);
                        correctPosition1 = false;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Wrong index number!!");
                        //System.out.println();
                        ShowTime.showGame(list, duplicate, chances);
                    }

                }


                if (!list.get(positionA).getName().equals(duplicate.get(positionB).getName())) {
                    list.get(positionA).setVisibility(false);
                    duplicate.get(positionB).setVisibility(false);
                    chances--;
                    Thread.sleep(3000);
                    ShowTime.clearGUI();
                } else {
                    counter++;
                    ShowTime.clearGUI();
                }
                if (counter == difficultyLevel) {
                    ShowTime.clearGUI();
                    break;
                }
            }
            ;


            if (counter == difficultyLevel) {
                System.out.println("You WIN!!!");
            } else {
                System.out.println("You LOST");
            }

            System.out.println("Press 1 - restart game or 0 button to quit");
            int check = scaner.nextInt();
            if(check != 1){
                runing = false;
            } else {
                flag = true;
                counter = 0;
                Words.setVisibilityFalse(list);
                Words.setVisibilityFalse(duplicate);
            }


        }
    }
}
