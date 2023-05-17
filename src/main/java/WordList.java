import java.lang.reflect.Array;

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
        return wordsArr[(int)(Math.random() * wordsArr.length)];
    }
}
