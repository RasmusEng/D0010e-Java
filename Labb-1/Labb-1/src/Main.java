import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        // Skapar scannern
        Scanner scan = new Scanner(System.in);
        int n = -1;
        while (n != 0) {
            // Tar en input och lagrar svaret i n
            try {
                System.out.print("Skriv in ett av heltalen {1,2,3,4,6,9}, skriv 0 för att avsluta: ");
                n = scan.nextInt();   // Om n inte kan "intas" får vi ett felmedelande som vi fångar
            } catch (Exception e) {
                System.out.println("Fel: Ej inte en task");
                scan.nextLine();
                n = -1;
            }
            while (true){
                try {
                    switch (n) {
                        case 0:
                            System.out.println("Programmet avslutas");
                            throw new NullPointerException();
                        case 1:
                            Task1(numbInput(scan));
                            break;
                        case 2:
                            Task2(numbInput(scan));
                            break;
                        case 3:
                            List<Integer> returns = new ArrayList<>();
                            // Får tillbaka värderna från listan
                            returns = twoNumbInput(scan);
                            Task3(returns.get(0), returns.get(1));
                            break;
                        case 4:
                            Task4();
                            throw new NullPointerException();
                        case 6:
                            Task6();
                            throw new NullPointerException();
                        case 9:
                            Task9();
                            throw new NullPointerException();
                        case -1:
                            // OM man skriver inte en eller flera bokstäver
                            // om man intar en bokstav blir värdet på n = -1
                            break;
                        default:
                            System.out.println(n + " Är inte en task");
                    }
                }catch (NullPointerException e){
                    break;
                }catch (EmptyStackException e){
                    System.out.println("Inte ett positivt tal");
                    scan.nextLine();
                } catch (Exception e){
                    System.out.println("Inte ett giltigt tal");
                    scan.nextLine();
                }
            }

        }
        scan.close();
    }

    private static int numbInput(Scanner scan) {
        int a0 = 0;
        // Tar en input och testar om det är ett heltal som är större eller likamed 0
        System.out.print("Skriv in ett heltal > 0: ");
        a0 = scan.nextInt();
        if(a0 < 0){
            // Skulle vilja skapa en egen exception, men behöver en till call isåfall som ärver exception
            throw new EmptyStackException();
        }
        if(a0 == 0){
            // Skulle vilja skapa en egen exception, men behöver en till call isåfall som ärver exception
            throw new NullPointerException();
        }
        return a0;

    }
    private static List<Integer> twoNumbInput(Scanner scan) {
        int a0 = 0;
        int n = 0;
        // Tar en input och testar om det är ett heltal som är större eller likamed 0
        List<Integer> an = new ArrayList<>();
        System.out.print("Skriv in ett heltal > 0: ");
        a0 = scan.nextInt();

        System.out.print("Skriv in antal steg: ");
        n = scan.nextInt();
        if(a0 < 0 || n < 0){ // För ett negativt tal
            throw new NullPointerException();
        }
        if(a0 == 0 || n == 0){
            // Skulle vilja skapa en egen exception, men behöver en till call isåfall som ärver exception
            throw new NullPointerException();
        }
        an.add(a0);
        an.add(n);
        return an;
    }

    private static void Task1(int a0) {
        // Skriver ut tal till och med att det blir en 1:a
        a0 = LifeLength.f1(a0);
        System.out.println(a0);
    }

    private static void Task2(int a0) {
        int f1 = LifeLength.f1(a0);
        int f2 = LifeLength.f2(a0);
        int f4 = LifeLength.f4(a0);
        int f8 = LifeLength.f8(a0);
        int f16 = LifeLength.f16(a0);
        int f32 = LifeLength.f32(a0);
        int f64 = LifeLength.f64(a0);
        int f128 = LifeLength.f128(a0);
        System.out.print("f1=" + f1 + "\t");
        System.out.print("f2=" + f2 + "\t");
        System.out.print("f4=" + f4 + "\t");
        System.out.print("f8=" + f8 + "\t");
        System.out.print("f16=" + f16 + "\t");
        System.out.print("f32=" + f32 + "\t");
        System.out.print("f64=" + f64 + "\t");
        System.out.println("f128=" + f128);
    }

    private static void Task3(int a0, int n) {
        a0 = LifeLength.iteradeF(a0, n);
        System.out.println("Vid steg " + n + " är värdet = " + a0);
    }

    private static void Task4() {
        for(int i = 1; i <= 15; i++){
            int steps = LifeLength.iterLifeLength(i);
            System.out.println(LifeLength.intsToString(i, steps));
        }
    }

    private static void Task6() {
        for(int i = 1; i <= 15; i++){
            int rSteps = LifeLength.recLifeLength(i);
            int iSteps = LifeLength.iterLifeLength(i);

            System.out.println("Iter = " + iSteps + "\t Rec = " + rSteps);
        }
    }
    private static void Task9() {
        double x = 1.0005;

        for(int k = 1; k <= 100000; k++){
            //System.out.print(Raise.recRaiseHalf(x, k) + "\t");
            //System.out.print(k+ "\t");
            Raise.recRaiseHalf(x, k);
            System.out.print(Raise.count + "\t");
            Raise.count = -1;
            Raise.recRaiseOne(x, k);
            System.out.println(Raise.count);
            Raise.count = -1;
            //System.out.println("Iter = " + Raise.iterRaise(x, k));
        }
    }

}