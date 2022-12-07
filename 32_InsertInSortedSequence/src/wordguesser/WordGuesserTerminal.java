package wordguesser;

import java.util.Scanner;

public class WordGuesserTerminal {
    private WordGuesser wordGuesser;
    private Scanner scanner;

    public WordGuesserTerminal() {
        wordGuesser = new WordGuesser();
        scanner = new Scanner(System.in);
    }


    private void guess() {
        StringBuilder sb = new StringBuilder();
        char[] charArray = wordGuesser.getSelectedWord();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            sb.append(wordGuesser.isCharGuessed(c) ? c : "*");
        }
        sb.append("    Used " + wordGuesser.getCharactersGuessed() + ".");
        sb.append(" Guess: ");
        System.out.print(sb);

        char c = scanner.next().charAt(0);
        wordGuesser.guess(c);
    }

    public void start() {
        System.out.println("Welcome to Word Guesser!");
        System.out.println("The length of the word is " + wordGuesser.getWordLength());
        while (!wordGuesser.finished()) {
            guess();
        }
        System.out.println();
        System.out.println("You guessed " + wordGuesser.getWholeWord().toUpperCase() + " with " + wordGuesser.getGuesses() + " guesses.");
    }
}
