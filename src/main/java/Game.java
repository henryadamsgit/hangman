import java.util.Scanner;

public class Game {
    private String word;
    private int lives;

    public Game() {
        this.lives = 5;
        WordList wordList = new WordList();
        this.word = wordList.randomWord();
    }

    public String getWord() {
        return word;
    }

    public int getLives() {
        return lives;
    }

    public static void main(String[] args) {
        Game game = new Game();
        UserInteraction interactions = new UserInteraction();
        interactions.setGeneratedWord(game.getWord());
        interactions.initializeUnderscores();

        // Game loop
        while (game.endGame(interactions.getGeneratedWord(), interactions.getUnderscores(), game.getLives())) {
            System.out.println("Enter a letter (a-z) to guess...");
            Scanner userInput = new Scanner(System.in);
            String guessedLetter = userInput.nextLine().toLowerCase();

            interactions.setGuessedLetter(guessedLetter);
            interactions.updateGame();

            interactions.displayStatus();

            if (interactions.isGuessCorrect()) {
                System.out.println("Correct!");
            } else {
                game.lives--;
                System.out.println("Incorrect! You have " + game.getLives() + " lives remaining!");
            }
        }

        // Game over
        if (interactions.getGeneratedWord().equals(interactions.getUnderscores())) {
            System.out.println("Congratulations, you guessed the word: " + interactions.getGeneratedWord() + ", correctly!");
        } else {
            System.out.println("Game Over!");
            System.out.println("The word was: " + interactions.getGeneratedWord());
        }
    }

    public boolean endGame(String generatedWord, String underscores, int lives) {
        return lives > 0 && !generatedWord.equals(underscores);
    }
}
