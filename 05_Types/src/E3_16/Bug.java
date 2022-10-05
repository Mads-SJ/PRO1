package E3_16;

public class Bug {
    private int position;
    private boolean isGoingRight;

    public Bug() {
        position = 0;
        isGoingRight = true;
    }

    public void turn() {
        isGoingRight = !isGoingRight;
    }

    public void move() {
        if(isGoingRight) {
            position++;
        }
        else {
            position--;
        }
    }

    public int getPosition() {
        return position;
    }
}
