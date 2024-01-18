import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Skapar scannern
        Scanner scan = new Scanner(System.in);
        int n = -1;
        while (n != 0) {
            // Tar en input och testar om det är ett heltal som är större eller likamed 0
            try {
                System.out.print("Skriv in ett av heltalen {1,2,3,4,6}, skriv 0 för att avsluta: ");
                n = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Fel: Ej inte en task");
                scan.nextLine();
                n = -1;
            }
            try{
                switch (n) {
                    case 0:
                        System.out.println("Programmet avslutas");
                        break;
                    case 1:
                        Task1(numbInput(scan));
                        break;
                    case 2:
                        Task2(numbInput(scan));
                        break;
                    case 3:
                        List<Integer> returns = new ArrayList<>();
                        returns = twoNumbInput(scan);
                        Task3(returns.get(0), returns.get(1));
                        break;
                    case 4:
                        Task4(numbInput(scan));
                        break;
                    case 6:
                        Task6(numbInput(scan));
                        break;
                    case -1:
                        // OM man skriver inte en eller flera bokstäver
                        break;
                    default:
                        System.out.println(n + " Är inte en task");
            }
            } catch (EmptyStackException e){
                System.out.println("Måste vara ett positivt tal");
                scan.nextLine();
                n = -1;
            }catch (Exception e){
                System.out.println("Inte ett giltigt tal");
                scan.nextLine();
                n = -1;
            }

        }
        scan.close();
    }

    public static int numbInput(Scanner scan) {
        int a0 = 0;
        // Tar en input och testar om det är ett heltal som är större eller likamed 0
        System.out.print("Skriv in ett heltal > 0: ");
        a0 = scan.nextInt();
        if(a0 <= 0){
            // Skulle vilja skapa en egen exception, men behöver en till call isåfall
            // som ärver exception
            throw new EmptyStackException();
        }
        return a0;

    }
    public static List<Integer> twoNumbInput(Scanner scan) {
        int a0 = 0;
        int n = 0;
        // Tar en input och testar om det är ett heltal som är större eller likamed 0
        List<Integer> an = new ArrayList<>();
        System.out.print("Skriv in ett heltal > 0: ");
        a0 = scan.nextInt();

        System.out.print("Skriv in antal steg: ");
        n = scan.nextInt();
        if(a0 <= 0){
            throw new InputMismatchException();
        }
        an.add(a0);
        an.add(n);
        return an;
    }

    public static void Task1(int a0) {
        a0 = LifeLength.f1(a0);
        System.out.println(a0);
    }

    public static void Task2(int a0) {
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

    public static void Task3(int a0, int n) {
        a0 = LifeLength.iteradeF(a0, n);
        System.out.println("Vid steg " + n + " är värdet = " + a0);
    }

    public static void Task4(int a0) {
        int steps = LifeLength.iterLifeLength(a0);
        System.out.println("The life length of " + a0 + " is " + steps + ".");
    }

    public static void Task6(int a0) {
        int steps = LifeLength.recLifeLength(a0);
        System.out.println("Steg = " + steps);
    }

}