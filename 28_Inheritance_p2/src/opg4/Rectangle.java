package opg4;

public class Rectangle extends GeometricFigure {
    private int s1;
    private int s2;

    public Rectangle(int x, int y, int s1, int s2) {
        super(x, y);
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public double getArea() {
        return s1 * s2;
    }
}
