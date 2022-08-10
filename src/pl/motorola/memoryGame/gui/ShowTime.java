package pl.motorola.memoryGame.gui;

import pl.motorola.memoryGame.exeptions.IncorrectValue;
import pl.motorola.memoryGame.model.SingleWorld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ShowTime {
    public static int chooseLevel(Scanner scaner){
        int temp = scaner.nextInt();
        if (temp == 1 ){
            temp = 4;
        } else if(temp == 2){
            temp = 8;
        } else {
            throw new IncorrectValue();
        }
            return temp;
    }

    public static void showGame(ArrayList<SingleWorld> words, ArrayList<SingleWorld> duplicate, int chances){

        System.out.println("Chances: " + chances);

        for(int i = 1; i <= words.size(); i++){
            System.out.print("   " + i + "      ");
        }
        System.out.println();

        System.out.print("A: ");
        for (SingleWorld s : words){
            System.out.print(s.showWord() + " ");
        }
        clearGUI();

        System.out.print("B: ");
        for (SingleWorld sw : duplicate){
            System.out.print(sw.showWord() + " ");
        }
        System.out.println();

    }

    public static void clearGUI(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


    }
}
