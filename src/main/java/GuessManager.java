import java.util.ArrayList;
import java.util.Random;

public class GuessManager {

    private String generatedWord;
    private StringBuilder underscoredWord;

    public String getGeneratedWord() {
        return generatedWord;
    }

    public void generateWord() {
        WordList word = new WordList();
        generatedWord = word.randomWord();
        underscoredWord = new StringBuilder();

        for (int i = 0; i < generatedWord.length(); i++) {
            underscoredWord.append('_');
        }
    }

    public String getUnderscore() {
        return underscoredWord.toString();
    }


    public void updateUnderscore(char guessedLetter) {
        for (int i = 0; i < generatedWord.length(); i++) {
            if (generatedWord.charAt(i) == guessedLetter) {
                underscoredWord.setCharAt(i, guessedLetter);
            }
        }
    }

}
