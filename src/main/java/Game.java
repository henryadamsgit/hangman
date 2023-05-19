import java.util.Scanner;

public class Game {
    private String word;
    private int numberOfLives;

    public Game() {
        WordList wordList = new WordList();
        this.word = wordList.randomWord();
        this.numberOfLives = 5;
    }

    public String getWord() {
        return word;
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    private void chooseLives() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your difficulty level:");
        System.out.println("1. Easy (5 lives)");
        System.out.println("2. Hard (3 lives)");
        System.out.println("3. Impossible (1 life)");
        System.out.print("Enter the corresponding number: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                numberOfLives = 5;
                break;
            case 2:
                numberOfLives = 3;
                break;
            case 3:
                numberOfLives = 1;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to easy difficulty (5 lives).");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        UserInteraction interactions = new UserInteraction();
        interactions.setGeneratedWord(game.getWord());
        interactions.initializeUnderscores();

        game.chooseLives();

        // Game loop
        while (game.endGame(interactions.getGeneratedWord(), interactions.getUnderscores(), game.getNumberOfLives())) {
            System.out.println("Enter a letter (a-z) to guess...");
            Scanner userInput = new Scanner(System.in);
            String guessedLetter = userInput.nextLine().toLowerCase();

            interactions.setGuessedLetter(guessedLetter);
            interactions.updateGame();

            interactions.displayStatus();

            if (interactions.isGuessCorrect()) {
                System.out.println("Correct!");
            } else {
                game.numberOfLives--;
                System.out.println("Incorrect! You have " + game.getNumberOfLives() + " lives remaining!");
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

    public boolean endGame(String generatedWord, String underscores, int numberOfLives) {
        return numberOfLives > 0 && !generatedWord.equals(underscores);
    }
}
