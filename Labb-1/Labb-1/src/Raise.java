public class Raise {
    public static int count = -1;
    public static double recRaiseHalf(double x, int k){
        count++;
        if (k == 0 ){
            return 1;
        }
        double recs = recRaiseHalf(x, (int) Math.floor(k/2));
        if(k %2 == 0){
            return (recs * recs);
        }else {
            return (x * recs * recs);
        }
    }
    public static double recRaiseOne(double x, int k) {
        count++;
        if (k==0) {
            return 1.0;
        } else {
            return x * recRaiseOne (x, k-1);
        }
    }

    public static double iterRaise(double x, int k){
        double res = 1.0;
        while(k != 0){
            res = res * x;
            k--;
        }
        // Metoden kommer köras 1 gång men loopen kommer köras linjärt med antal k
        return res;
    }
    public static double iterRaise2(double x, int k){
        // Samma metod som åvan men med for loop
        double res = 1.0;
        for(int j = 0; j <= k; j++){
            res = res * x;
        }
        // Metoden kommer köras 1 gång men loopen kommer köras linjärt med antal k
        return res;
    }

}
