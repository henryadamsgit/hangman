import java.util.Scanner;

public class Game {

    private String word;
    private int lives;

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

    public static void main(String[] args) {
        // create an instance of Game
        Game game = new Game();

        // create an instance of WordList
        WordList wordList = new WordList();

        // initialize the game variables
        game.setWord(wordList.randomWord());
        game.setLives(5);

        DisplayManager displayManager = new DisplayManager();
        displayManager.setGeneratedWord(game.getWord());
        displayManager.initializeUnderscores();

        // game loop
        while (game.endGame(displayManager.getGeneratedWord(), displayManager.getUnderscores(), game.getLives())) {
            System.out.println("Enter a letter (a-z) to guess...");
            Scanner userInput = new Scanner(System.in);
            String guessedLetter = userInput.nextLine().toLowerCase();

            // update the game state and display
            // the guessed letter and current status
            displayManager.setGuessedLetter(guessedLetter);
            displayManager.updateGame();

            displayManager.displayStatus();

            // check if the guessed letter is correct
            if (!displayManager.isGuessCorrect()) {
                game.setLives(game.getLives() - 1);
                System.out.println("Incorrect! Lives remaining: " + game.getLives());
            }
        }

        // game over
        if (displayManager.getGeneratedWord().equals(displayManager.getUnderscores())) {
            System.out.println("Congratulations, you guessed the word " + displayManager.getGeneratedWord() + " correctly!");
        } else {
            System.out.println("Game Over!");
        }
    }

    public boolean endGame(String generatedWord, String underscores, int lives) {
        return lives > 0 && !generatedWord.equals(underscores);
    }
}
