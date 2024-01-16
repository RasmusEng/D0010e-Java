public class Area {
    static double triangleArea(double a, double b, double c){
        double s = (a+b+c) / 2;
        System.out.println(s);
        double area = Math.sqrt(s*(s-a)*(a-b)*(s-c));
        System.out.println(area);
        return area;
    }

}

