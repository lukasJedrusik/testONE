package pl.motorola.memoryGame.model;

public class SingleWorld {

    private String name;
    private boolean visibility;

    public SingleWorld(String name) {
        this.name = name;
        this.visibility = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String showWord(){
        if (visibility){
           return this.name + "    ";
        } else
        {
            return "*        ";
        }
    }


}
