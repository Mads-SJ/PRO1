package opg4;

public abstract class GeometricFigure {
    int x;
    int y;

    public GeometricFigure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void shift(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public abstract double getArea();
}
