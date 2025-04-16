package LAB3;

public class Polygon implements AbstractFigure {
    private Line[] lines;

    public Line[] getLines() { return this.lines; }

    @Override
    public void move(double dx, double dy) {
        for (Line line : this.lines) {
            line.move(dx, dy);
        }
    }

    @Override
    public void flip() {
        for (Line line : this.lines) {
            line.flip();
        }
    }

    @Override
    public void rotate(double x) {
        for (Line line : this.lines) {
            line.rotate(x);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        for (Line line : this.lines) {
            builder.append(line);
        }
        builder.append(" }");
        return builder.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) { return false; }

        Polygon O = (Polygon) o;
        Line[] Olines = O.getLines();

        boolean equals = true;

        for (int i = 0; i < this.lines.length; i++) {
            if (!this.lines[i].equals(Olines[i])) {
                equals = false;
                break;
            }
        }

        return equals;
    }

    Polygon(Line[] lines) {
        this.lines = lines;
    }
}
