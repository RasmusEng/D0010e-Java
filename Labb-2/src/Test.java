public class Test {
    private int hej;
    protected int hejsan;
    public static int pubInt;
    public Test(){
        hej = 0;
        pubInt = 1;
    }
   public Test(int testHej){
       hej = testHej;
   }
   public Test(String testHej){
       hej = 76;
   }
   public int getHej(){
        return hej;
    }

    public void Setint(int change){
        pubInt = change;
    }
}

