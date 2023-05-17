import java.util.ArrayList;

public class GuessManager {

    String generatedWord;
    ArrayList<Character> charToUnderscoreArr = new ArrayList<>();

    public void generateWord() {
        WordList word = new WordList();
        generatedWord  = word.randomWord();
        System.out.println(generatedWord);
    }

    public String getGeneratedWord() {
        return generatedWord;
    }

    public void createUnderscore() {
        for (int i = 0; i < generatedWord.length(); i++) {
            charToUnderscoreArr.add('_');
        }
    }

    public static void main(String[] args) {
        GuessManager guess = new GuessManager();
        guess.generateWord();
        guess.createUnderscore();
        String underscores = "";
        for (Character c : guess.charToUnderscoreArr) {
            underscores += c;
        }
        System.out.println(underscores);
    }
}


