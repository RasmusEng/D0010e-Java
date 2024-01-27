import com.sun.source.tree.BreakTree;

public class LifeLength {
    public static int f1(int a0) {
        if (a0 <= 1) {
            return a0;
        }
        if (a0 % 2 == 0) {
            return a0 / 2;
        } else {
            return a0 * 3 + 1;
        }
    }
    public static int f2(int a0){
        return f1(f1(a0));
    }
    public static int f4(int a0){
        return f2(f2(a0));
    }
    public static int f8(int a0){
        return f4(f4(a0));
    }
    public static int f16(int a0){
        return f8(f8(a0));
    }
    public static int f32(int a0){
        return f16(f16(a0));
    }
    public static int f64(int a0){
        return f32(f32(a0));
    }
    public static int f128(int a0){
        return f64(f64(a0));
    }
    public static int iteradeF(int a0, int n) {
        for (int i = 0; i < n; i++) {
           a0 = f1(a0);
        }
        return a0;
    }
    public static int iterLifeLength(int a0){
        int count = 0;
        while(a0 != 1){
            a0 = f1(a0);
            count++;
        }
        return count;
    }

    public static String intsToString(int a0, int steps){
        return "The life length of " + a0 + " is " + steps + ".";
    }

    public static int recLifeLength(int a0){
        if (a0 <= 1){
            return 0;
        }
        else {
            return 1 + recLifeLength(f1(a0));
        }
    }
}

