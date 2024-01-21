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

}
