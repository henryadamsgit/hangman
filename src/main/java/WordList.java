import java.util.Random;

public class WordList{

    public String[] wordsArr = {
            "algorithm",
            "api",
            "array",
            "binary",
            "bug",
            "compiler",
            "computer",
            "data",
            "debugger",
            "function",
            "hardware",
            "ide",
            "interpreter",
            "language",
            "library",
            "loop",
            "memory",
            "method",
            "os",
            "oop",
            "program",
            "random",
            "string",
            "var",
            "website",
            "while"
    };


    public String randomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(wordsArr.length);
        return wordsArr[randomIndex];
    }
}