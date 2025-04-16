package LAB3;

public class Group implements AbstractFigure{
    private Polygon[] polygons;

    public Polygon[] getPolygons() {
        return this.polygons;
    }

    @Override
    public void move(double dx, double dy) {
        for (Polygon polygon : polygons) {
            polygon.move(dx, dy);
        }
    }

    @Override
    public void flip() {
        for (Polygon polygon : polygons) {
            polygon.flip();
        }
    }

    @Override
    public void rotate(double x) {
        for (Polygon polygon : polygons) {
            polygon.rotate(x);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("< ");
        for (Polygon polygon : polygons) {
            builder.append(polygon.toString());
        }
        builder.append(" >");
        return builder.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) { return false; }

        Group O = (Group) o;
        Polygon[] Opolygons = O.getPolygons();

        boolean equals = true;

        for (int i = 0; i < this.polygons.length; i++) {
            if (!this.polygons[i].equals(Opolygons[i])) {
                equals = false;
                break;
            }
        }

        return equals;
    }

    public Group(Polygon[] polygons) {
        this.polygons = polygons;
    }
}
