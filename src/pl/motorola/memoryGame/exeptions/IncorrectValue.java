package pl.motorola.memoryGame.exeptions;

public class IncorrectValue extends RuntimeException{
    public IncorrectValue(){
        System.out.println("Incorrect value. Press 1 or 2!");
    }
}
