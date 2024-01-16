import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Task1();
        Task2();
    }

    public static void Task1(){
        // Skapar scannern
        Scanner scan = new Scanner(System.in);

        while (true){
            int a0 = 0;

            // Tar en input och testar om det är ett heltal som är större eller likamed 0
            try {
                System.out.print("Skriv in ett heltal större än noll: ");
                a0 = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Fel: Ej ett heltal > 0");
            }
            if(a0 == 0){
                System.out.println("Avslutar programmet");
                break;
            }

            a0 = LifeLength.f1(a0);
            System.out.println(a0);


        }
        scan.close();
    }

    public static void Task2(){
        Scanner scan = new Scanner(System.in);
        while (true){
            int a0 = 0;

            // Tar en input och testar om det är ett heltal som är större eller likamed 0
            try {
                System.out.print("Skriv in ett heltal större än noll: ");
                a0 = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Fel: Ej ett heltal > 0");
            }
            if(a0 == 0){
                System.out.println("Avslutar programmet");
                break;
            }


            int f2= LifeLength.f2(a0);
            int f4= LifeLength.f4(a0);
            int f8= LifeLength.f8(a0);
            int f16= LifeLength.f16(a0);
            int f32= LifeLength.f32(a0);
            System.out.print("f1=" + a0 + "\t");
            System.out.print("f2=" + f2+ "\t");
            System.out.print("f4=" + f4+ "\t");
            System.out.print("f8=" + f8+ "\t");
            System.out.print("f16=" + f16+ "\t");
            System.out.println("f32=" + f32);

        }
        scan.close();
    }
}