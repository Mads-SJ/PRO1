package wordguesser;

import java.util.ArrayList;

public class WordGuesser {
    private final ArrayList<String> words;
    private final ArrayList<Character> charactersGuessed;
    private char[] selectedWord;
    private int guesses;

    public WordGuesser() {
        words = new ArrayList<>();
        initWords();
        selectedWord = getRandomWord();
        charactersGuessed = new ArrayList<>();
        guesses = 0;
    }

    private char[] getRandomWord() {
        int randNum = (int) ((Math.random() * words.size()));
        return words.get(randNum).toCharArray();
    }

    private void initWords() {
        words.add("programmering");
        words.add("gobsmacked");
        words.add("flabbergasted");
        words.add("datamatiker");
        words.add("bogosort");
        words.add("hangman");
    }

    public int getGuesses() {
        return guesses;
    }

    public char[] getSelectedWord() {
        return selectedWord;
    }

    public String getWholeWord() {
        return new String(selectedWord);
    }

    public ArrayList<Character> getCharactersGuessed() {
        return charactersGuessed;
    }

    public boolean isCharGuessed(char c) {
        return charactersGuessed.contains(c);
    }

    public void guess(char c) {
        if (!charactersGuessed.contains(c)) {
            charactersGuessed.add(c);
        }
        guesses++;
    }

    public void guessWholeWord(String guess) {
        if (guess.equals(getWholeWord())) {
            for (char c : selectedWord) {
                if (!charactersGuessed.contains(c)) {
                    charactersGuessed.add(c);
                }
            }
        }
        guesses++;
    }

    public int getWordLength() {
        return selectedWord.length;
    }

    public boolean finished() {
        boolean finished = true;
        int i = 0;
        while (finished && i < selectedWord.length) {
            if (!isCharGuessed(selectedWord[i])) {
                finished = false;
            }
            i++;
        }
        return finished;
    }

    public void reset() {
        selectedWord = getRandomWord();
        charactersGuessed.clear();
        guesses = 0;
    }
}
