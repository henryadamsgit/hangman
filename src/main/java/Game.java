import java.util.Scanner;

public class Game {

    private String word;
    private int lives;
    private boolean isCorrect;

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

    public static void main(String[] args) {
        // create an instance of Game
        Game game = new Game();

        // initialize the game variables
        game.setWord("apple");
        game.setLives(3);

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
        System.out.println("Game Over!");
    }

    public boolean endGame(String generatedWord, String underscores, int lives) {
        return lives > 0 && !generatedWord.equals(underscores);
    }
}
