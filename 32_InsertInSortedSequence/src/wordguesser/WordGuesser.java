package wordguesser;

import java.util.ArrayList;
import java.util.Scanner;

public class WordGuesser {
    private ArrayList<String> words;
    private ArrayList<Character> charactersGuessed;
    private boolean[] isCharactersGuessed;
    private String selectedWord;
    private int guesses;
    private Scanner scanner;

    public WordGuesser() {
        words = new ArrayList<>();
        initWords();
        selectedWord = null;
        scanner = new Scanner(System.in);
    }

    private String getRandomWord() {
        int randNum = (int) ((Math.random() * words.size()));
        return words.get(randNum);
    }

    private void initWords() {
        words.add("programmering");
        words.add("gobsmacked");
        words.add("flabbergasted");
    }

    private void initGame() {
        charactersGuessed = new ArrayList<>();
        guesses = 0;
        selectedWord = getRandomWord();
        isCharactersGuessed = new boolean[selectedWord.length()];
    }

    private void takeTurn() {
        StringBuilder word = new StringBuilder();
        char[] charArray = selectedWord.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            word.append(isCharactersGuessed[i] ? charArray[i] : "*");
        }
        System.out.println(word);
    }

    public void start() {
        initGame();
        System.out.println("Welcome to Word Guesser!");
        System.out.println("The length of the word is " + selectedWord.length());
        takeTurn();
    }
}
