public class Main {
    public static void main(String[] args) {
        double a = 3.0;
        double b = 4.0;
        double c = 5.0;
        if (!riktigaTriangel.riktigaTriangle(a, b, c)) {
            throw new IllegalArgumentException("Ej sidor på en triangle");
        } else {
            System.out.println(Area.triangleArea(a, b, c));
        }
    }
}