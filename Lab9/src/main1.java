public class main1 {
    public static void main(String[] args) throws Exception {

        ArrayWithLineHash linear = new ArrayWithLineHash(30);
        ArrayWithQuadraticHash quad = new ArrayWithQuadraticHash(30);
        ArrayWithDoubleHash dual = new ArrayWithDoubleHash(30);

        System.out.println("WRZUCANIE ELEMENTÓW WRAZ Z PODGLĄDEM TABLICY dumb()");
        for (int i = 0; i < 20; i++) {
            linear.put(i,i*10);
            quad.put(i,i*10);
            dual.put(i,i*10);

            System.out.println("i: " + i +" linear_hash(i): "+linear.hash(i));
            System.out.println("LINEAR: ");
            linear.dump();
            System.out.println("QUAD: ");
            quad.dump();
            System.out.println("DUAL: ");
            dual.dump();
            System.out.println("==============================================================================================");
        }

        System.out.println("WYNIKI DLA OPERACJI GET:");
        for (int i = 0; i < 20; i++) {
            System.out.println(linear.get(i)+" "+quad.get(i)+" "+dual.get(i));
        }
        System.out.println(linear.get(22)+" "+quad.get(22)+" "+dual.get(22));

        System.out.println("DALSZE OPERACJE:");
        System.out.println("ROZMIAR:");
        System.out.println(linear.size()+" "+quad.size()+" "+dual.size());
        System.out.println("IS EMPTY:");
        System.out.println(linear.isEmpty()+" "+quad.isEmpty()+" "+dual.isEmpty());
        System.out.println("CONTAINS 99:");
        System.out.println(linear.containsKey(99)+" "+quad.containsKey(99)+" "+dual.containsKey(99));
        System.out.println("RESIZE() na rozmiar 5");
        linear.resize(5);
        quad.resize(5);
        dual.resize(5);
        linear.dump();
        quad.dump();
        dual.dump();
        System.out.println("\n\nTESTY PORÓWNAN: ");
        new Tests();
    }
}
