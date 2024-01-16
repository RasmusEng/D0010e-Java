import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

            int count = 0; // Räknar antalet varv i loopen till a0 når 1
            // Kör loopen en gång innan vi kollar while kravet.
            do {
            a0 = LifeLength.f1(a0);
            //System.out.println(a0);
            count++;
            } while(a0 != 1);
            System.out.println(count);

        }
        scan.close();
    }
}