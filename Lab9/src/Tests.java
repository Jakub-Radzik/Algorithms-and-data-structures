import java.util.Random;

public class Tests {
        private static final int SIZE = 2000;
        private double[] alfa = {0.7,0.8,0.9};
        int[] data;
        int[] search;

    public Tests() {
        data = new int[SIZE];
        search = new int[100];
        Random r = new Random(SIZE);

        for (int i = 0; i < search.length; i++) {
            search[i] = r.nextInt(SIZE);
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = r.nextInt(SIZE);
        }
        TestStart();
    }

    public void TestStart(){
        ArrayWithLineHash line = new ArrayWithLineHash(SIZE);
        ArrayWithQuadraticHash quad = new ArrayWithQuadraticHash(SIZE);
        ArrayWithDoubleHash dual = new ArrayWithDoubleHash(SIZE);

        for (int i = 0; i < alfa.length; i++) {
            System.out.println("TEST DLA ZAPELNIENIA alfa = "+alfa[i]);
            System.out.println("Linear Hashing: "+ result(line, alfa[i]));
            System.out.println("Quadratic Hashing: "+ result(quad, alfa[i]));
            System.out.println("Double Hashing: "+ result(dual, alfa[i]));
            System.out.println("===========================================");
        }
    }
    //COUNT SECTION=======================================================
    private int tries;
    private int success_tries;
    private int fail_tries;
    public String result(ArrayWithHashing ah, double alfa){

        try{
            tries = 0;
            success_tries = 0;
            fail_tries = 0;

            for (int i = 0; i < (int)(data.length*alfa); i++) {
                ah.put(data[i], data[i]*10);
            }

            for (int i = 0; i < search.length; i++) {
                int find = ah.get(search[i]);
                tries+= ah.getTries();

                if(find==-1){
                    fail_tries += ah.getTries();
                } else{
                    success_tries += ah.getTries();
                }
                ah.setTries(0);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return "ALL: "+(tries/(double)search.length)+" S:"+(success_tries/(double)search.length)+" F:"+(fail_tries/(double)search.length);
    }
}
