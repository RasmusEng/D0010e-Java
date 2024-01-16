public class LifeLength {
    public static int f1(int a0){
        if(a0 <= 1){
            return a0;
        }
        if(a0 % 2 == 0){
            return a0/2;
        }
        else{
            return a0*3 +1;
        }
    }

    public static int counter(int a0, int steps){
        int count = 0;
        do{
            a0 = f1(a0);
            count++;
        }while(count < steps);
        return a0;
    }

    public static int f2(int a0){
        int n = 2;
        int step = counter(a0, n);
        return step;
    }
    public static int f4(int a0){
        int n = 4;
        int step = counter(a0, n);
        return step;
    }
    public static int f8(int a0) {
        int n = 8;
        int step = counter(a0, n);
        return step;

    }
    public static int f16(int a0){
        int n = 16;
        int step = counter(a0, n);
        return step;
    }
    public static int f32(int a0){
        int n = 32;
        int step = counter(a0, n);
        return step;
    }

}
