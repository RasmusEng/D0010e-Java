public class GCD {
    public static void main(String[] args){
        int b = 9;
        for(int i = 11; i <19; i++){
            int res = gcd(i, b);
            if (res == 1){
                System.out.println("gcd(" + i + "," + b + ") = " + res);
            }
            b--;
        }
    }
    static int gcd(int a, int b) {
        int rest;
        do {
            rest = a % b;
            a = b;
            b = rest;
        } while (rest != 0);
        return a;


    }
}
