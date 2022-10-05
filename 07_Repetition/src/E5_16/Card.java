package E5_16;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private final String notation;
    private final Map<Character, String> facedCards = new HashMap<>();

    public Card(String notation) {
        this.notation = notation;
        facedCards.put('A',"Ace");
        facedCards.put('J',"Jack");
        facedCards.put('Q',"Queen");
        facedCards.put('K',"King");
        facedCards.put('D',"Diamonds");
        facedCards.put('H',"Hearts");
        facedCards.put('S',"Spades");
        facedCards.put('C',"Clubs");
    }

    public String getDescription() {
        if(notation.length() != 2) { return "Unknown"; }

        char valueChar = notation.charAt(0);
        char suitChar = notation.charAt(1);

        String suit = facedCards.get(suitChar);
        if(suit == null) {
            return "Unknown";
        }

        String value = "" + valueChar;
        if(!Character.isDigit(valueChar)) {
            value = facedCards.get(valueChar);
            if(value == null) {
                return "Unknown";
            }
        }


        return value + " of " + suit;
    }
}
