public class Game {

    private String word;
    private int lives;
    private boolean isCorrect;

//    public Game(String[] wordsArr) {
//        this.word = wordsArr[(int)(Math.random() * wordsArr.length)];
//        this.lives = 5;
//        this.isCorrect = false;
//    }

//    public void playGame() {
//
//    }


    public static void main(String[] args) {
        WordList word = new WordList();
        String generatedWord  = word.randomWord();
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
