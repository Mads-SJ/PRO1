package opg5;

import java.util.ArrayList;

public class Series {
    private String title;
    private ArrayList<String> cast;

    public Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return new ArrayList<>(cast);
    }


}
