public class Såg {
    public static void main(String[] args){
        //triangle(4);
        sågtand(3, 2);
    }
    static void triangle(int a){
        for(int i = 1; i <= a; i++){
            for(int j = 1; j < i; j++){
                System.out.print("*");
            }
            System.out.println("\\");
        }
    }
    static void sågtand(int a, int b){
        for(int i = 0; i < b; i++){
            triangle(a);
        }
    }
}
