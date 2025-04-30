package LAB3;

public class Group implements Figure {
    private Figure[] figures;

    public Figure[] getFigures() {
        return this.figures;
    }

    @Override
    public void move(double dx, double dy) {
        for (Figure figure : figures) {
            figure.move(dx, dy);
        }
    }

    @Override
    public void flip() {
        for (Figure figure : figures) {
            figure.flip();
        }
    }

    @Override
    public void rotate(double x) {
        for (Figure figure : figures) {
            figure.rotate(x);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("< ");
        for (Figure figure : figures) {
            builder.append(figure.toString());
        }
        builder.append(" >");
        return builder.toString();
    }

    @Override
    public Figure clone() {
        return new Group(this.figures);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) { return false; }

        Group O = (Group) o;
        Figure[] Ofigures = O.getFigures();

        boolean equals = true;

        for (int i = 0; i < this.figures.length; i++) {
            if (!this.figures[i].equals(Ofigures[i])) {
                equals = false;
                break;
            }
        }

        return equals;
    }

    public Group(Figure[] figures) {
        this.figures = figures;
    }

    // TODO ?static? group(figures) { return as group }
    // TODO clone() do każdej klasy
    // TODO po 3 testy do każdej metody klasy
    // Zmienić kompozucję Polygon <- Point -> Line
}
