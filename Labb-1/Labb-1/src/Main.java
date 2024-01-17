import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Skapar scannern
        Scanner scan = new Scanner(System.in);

        while (true){
            int a0 = 0;
            int n = 0;

            // Tar en input och testar om det är ett heltal som är större eller likamed 0
            try {
                System.out.print("Skriv in ett heltal större än noll: ");
                a0 = scan.nextInt();

                if(a0 == 0){
                    System.out.println("Avslutar programmet");
                    break;
                }
                //Task 3
               /* System.out.print("Skriv in antal steg: ");
                n = scan.nextInt();*/
            } catch (Exception e) {
                System.out.println("Fel: Ej ett heltal > 0");
            }

            //Task1(a0);
            //Task2(a0);
            //Task3(a0, n);
            //Task4(a0);
            Task6(a0);
        }
        scan.close();
    }

    public static void Task1(int a0){
        a0 = LifeLength.f1(a0);
        System.out.println(a0);
    }
    public static void Task2(int a0){
        int f1= LifeLength.f1t2(a0, 1);
        int f2= LifeLength.f2(a0);
        int f4= LifeLength.f4(a0);
        int f8= LifeLength.f8(a0);
        int f16= LifeLength.f16(a0);
        int f32= LifeLength.f32(a0);
        int f64= LifeLength.f64(a0);
        int f128= LifeLength.f128(a0);
        System.out.print("f1=" + f1 + "\t");
        System.out.print("f2=" + f2+ "\t");
        System.out.print("f4=" + f4+ "\t");
        System.out.print("f8=" + f8+ "\t");
        System.out.print("f16=" + f16+ "\t");
        System.out.print("f32=" + f32 + "\t");
        System.out.print("f64=" + f64 + "\t");
        System.out.println("f128=" + f128);

    }
    public static void Task3(int a0, int n){
        a0 = LifeLength.iteradeF(a0, n);
        System.out.println("Vid steg " + n +" är värdet = " + a0);
    }
    public static void Task4(int a0){
        int steps = LifeLength.iterLifeLength(a0);
        System.out.println("The life length of " + a0 + " is " + steps + ".");
    }

    public static void Task6(int a0){
        int steps = LifeLength.recLifeLength(a0);
        System.out.println("Steg =" + steps);
    }

}