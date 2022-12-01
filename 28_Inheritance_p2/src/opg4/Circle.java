package opg4;

public class Circle extends GeometricFigure {
    private int r;

    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    @Override
    public double getArea() {
        return r * r * Math.PI;
    }
}
