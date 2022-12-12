package wordguesser;

import java.util.Scanner;

public class WordGuesserTerminal {
    private final WordGuesser wordGuesser;
    private final Scanner scanner;

    public WordGuesserTerminal() {
        wordGuesser = new WordGuesser();
        scanner = new Scanner(System.in);
    }


    private void guess() {
        StringBuilder sb = new StringBuilder();
        char[] charArray = wordGuesser.getSelectedWord();
        for (char c : charArray) {
            sb.append(wordGuesser.isCharGuessed(c) ? c : "*");
        }
        sb.append("    Used " + wordGuesser.getCharactersGuessed() + ".");
        sb.append(" Guess: ");
        System.out.print(sb);

        String guess = scanner.next();
        if (guess.length() > 1) {
            wordGuesser.guessWholeWord(guess);
        } else {
            char c = guess.charAt(0);
            wordGuesser.guess(c);
        }
    }

    public void start() {
        System.out.println("Welcome to Word Guesser!");

        boolean done = false;
        while (!done) {
            System.out.println("The length of the word is " + wordGuesser.getWordLength());
            while (!wordGuesser.finished()) {
                guess();
            }
            System.out.println();
            System.out.print("You guessed " + wordGuesser.getWholeWord().toUpperCase() + " with " + wordGuesser.getGuesses() + " guesses. Do you want to play again? ");

            scanner.nextLine();
            String response = scanner.nextLine();
            if (response.equals("no")) {
                done = true;
            } else {
                wordGuesser.reset();
                System.out.println();
            }
        }
    }
}
