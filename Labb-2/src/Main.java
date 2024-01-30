import java.util.*;
public class Main {

    public static void main(String[] args) {
        Test hej = new Test();
        System.out.println(hej.pubInt);
        Test hej2 = new Test(4);
        System.out.println(hej2.pubInt);

        hej.Setint(5);
        System.out.println(hej.pubInt);
        System.out.println(hej2.pubInt);
        Test hej3 = new Test("thjabba");
        System.out.println(hej3.pubInt);
        int ret = hej.getHej();
        int ret2 = hej2.getHej();
        int ret3 = hej3.getHej();
        System.out.println(ret);
        System.out.println(ret2);
        System.out.println(ret3);
/*        Imptest imps = new Imptest();
        int impsHej = imps.getHej();
        System.out.println(impsHej);*/
    }

}
