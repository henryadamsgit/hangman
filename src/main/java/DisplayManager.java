public class DisplayManager {

    private String generatedWord;
    private StringBuilder underscoredWord;
    private String guessedLetter;

    public void setGeneratedWord(String word) {
        generatedWord = word;
    }

    public void initializeUnderscores() {
        underscoredWord = new StringBuilder();

        for (int i = 0; i < generatedWord.length(); i++) {
            underscoredWord.append('_');
        }
    }

    public void updateGame() {
        if (generatedWord.contains(guessedLetter)) {
            StringBuilder updatedUnderscore = new StringBuilder(underscoredWord);

            for (int i = 0; i < generatedWord.length(); i++) {
                if (generatedWord.charAt(i) == guessedLetter.charAt(0)) {
                    updatedUnderscore.setCharAt(i, guessedLetter.charAt(0));
                }
            }

            underscoredWord = updatedUnderscore;
        }
    }

    public void setGuessedLetter(String letter) {
        guessedLetter = letter;
    }

    public String getGeneratedWord() {
        return generatedWord;
    }

    public String getUnderscores() {
        return underscoredWord.toString();
    }

    public void displayStatus() {
        System.out.println("Generated Word: " + generatedWord);
        System.out.println("Underscores: " + underscoredWord);
    }

    public boolean isGuessCorrect() {
        return generatedWord.contains(guessedLetter);
    }
}
