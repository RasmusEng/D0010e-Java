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

    public static int f1t2(int a0, int n) {
        if (n == 0){
            return a0;
        }else{
            if (a0 == 1) {
                return f1t2(a0, n-1);
            }
            if (a0 % 2 == 0) {
                return f1t2(a0 / 2, n-1);
            } else {
                return f1t2((a0 * 3 + 1), n-1);
            }
        }
    }
    public static int f2(int a0){
        return f1t2(a0, 2);
    }
    public static int f4(int a0){
        return f1t2(a0, 4);
    }
    public static int f8(int a0){
        return f1t2(a0, 8);
    }
    public static int f16(int a0){
        return f1t2(a0, 16);
    }public static int f32(int a0){
        return f1t2(a0, 32);
    }public static int f64(int a0){
        return f1t2(a0, 64);
    }
    public static int f128(int a0){
        return f1t2(a0, 64);
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

    public static int recLifeLength(int a0){
        if (a0 <= 1){
            return 0;
        }
        else {
            return 1 + recLifeLength(f1(a0));
        }
    }
}

