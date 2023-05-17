import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private String word;
    private int lives;
    private boolean isCorrect;

//   public Game() {
//     this.word = randomWord();
//     this.lives = 5;
//     this.isCorrect = false;
//   }

//    public void playGame() {
//
//    }
//    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

    }










    public String getWord() {
        return word;
    }
    public void setWord(String title) {
        this.word = title;
    }
    public int getLives() {
        return lives;
    }
    public void setLives(int lives) {
        this.lives = lives;
    }
    public boolean isCorrect() {
        return isCorrect;
    }
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
