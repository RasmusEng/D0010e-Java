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
}
