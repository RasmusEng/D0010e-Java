public class riktigaTriangel {
    public static void main(String[] args){
        for(int a = 1; a <= 5; a++){
            for(int b = 1; b<= 5; b++){
                for(int c = 1; c<= 5; c++) {
                    System.out.println("("+ a + "," + b + "," + c + "): " + riktigaTriangle(a, b, c));
                }
            }
        }
    }
    static boolean riktigaTriangle(double a, double b, double c){
        if( b + c >= a){
            return true;
        }else {
            return false;
        }
    }
}
