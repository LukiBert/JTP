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
        Figure[] clonedFigures = new Figure[this.figures.length];
        for (int i = 0; i < this.figures.length; i++) {
            clonedFigures[i] = this.figures[i].clone();
        }
        return new Group(clonedFigures);
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

    public static Group group(Figure... figures) {
        return new Group(figures);
    }
}
