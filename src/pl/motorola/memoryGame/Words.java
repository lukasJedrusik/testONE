package pl.motorola.memoryGame;

import pl.motorola.memoryGame.model.SingleWorld;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Words {
    private List<SingleWorld> words = new ArrayList<>();


    public Words()  {
        File file = new File("Words.txt");
        Scanner scan;
        try {
             scan = new Scanner(file);
             while (scan.hasNext()){
                words.add(new SingleWorld(scan.next()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie ma takiego pliku");
        }

    }

    public List<SingleWorld> getWords() {
        return words;
    }

    public void setWords(List<SingleWorld> words) {
        this.words = words;
    }


    public ArrayList<SingleWorld> randomlySelected(int difficultyLevel){
        ArrayList<SingleWorld> selectedList = new ArrayList<>(difficultyLevel);
        Random random = new Random();
        int randomIndex ;
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < difficultyLevel; i++){
            randomIndex = random.nextInt(words.size() - 1);
            if(!indexes.contains(randomIndex)) {
                    indexes.add(randomIndex);
                    selectedList.add(words.get(randomIndex));
                }else {
                i--;
            }
        }

        return selectedList;

    }



    public ArrayList<SingleWorld> randomlySelectedDuplicate(ArrayList<SingleWorld> duplicate){
        ArrayList<SingleWorld> selectedList = new ArrayList<>();

        for (int i = 0; i < duplicate.size(); i++){
            selectedList.add(new SingleWorld(duplicate.get(i).getName()));
        }



        return selectedList;
    }

    public static void setVisibilityFalse(ArrayList<SingleWorld> list){
        for(SingleWorld e : list){
            e.setVisibility(false);
        }
    }




}
