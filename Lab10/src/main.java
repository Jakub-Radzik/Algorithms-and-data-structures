import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        BST tree = new BST();
        Scanner scanner = new Scanner(System.in);
        int n;
        while(true){
            System.out.println("\n\nOPERACJE:");
            System.out.println("1 - Wstaw węzeł o danym kluczu");
            System.out.println("2 - Wyświetl inorder");
            System.out.println("3 - Wyświetl postorder");
            System.out.println("4 - Wyświetl preorder");
            System.out.println("5 - Znajdź węzeł o danym kluczu");
            System.out.println("6 - Wyświetl parametry całego drzewa");
            System.out.println("7 - Wyświetl klucze poziomami");
            System.out.println("8 - Wyznacz następnika danego węzła");
            System.out.println("9 - Wyznacz poprzednika danego węzła");
            System.out.println("10 - Usuń węzeł o podanym kluczu");
            System.out.println("11 - Narysuj drzewo");
            System.out.println("12 - GENEROWANIE DRZEWA Z GOTOWYMI WARTOSCIAMI");
            System.out.println("20 - Opuść menu");
            System.out.println("WYBÓR:");
            n = scanner.nextInt();

            switch (n) {
                case 1 -> {
                    System.out.println("Podaj klucz:");
                    n = scanner.nextInt();
                    tree.insert(n);
                }
                case 2 -> tree.inorder();
                case 3 -> tree.postorder();
                case 4 -> tree.preorder();
                case 5 -> {
                    System.out.println("Podaj klucz:");
                    n = scanner.nextInt();
                    System.out.println(tree.findKey(n).toString());
                }
                case 6 -> {
                    System.out.println("Wysokość: "+tree.height());
                    System.out.println("Liczba węzłów: "+tree.nodesCount());
                    System.out.println("Liczba liści: "+tree.leavesCount());
                }
                case 7 -> tree.displayLevels();
                case 8 -> {
                    System.out.println("Podaj klucz:");
                    n = scanner.nextInt();
                    try{
                        if(tree.successor(n)!=null){
                            System.out.println(tree.successor(n));
                        }else{
                            System.out.println("Brak następnika dla podanego klucza");
                        }
                    }catch (Exception ex){
                        System.out.println("Brak następnika dla podanego klucza");
                    }
                }
                case 9 -> {
                    System.out.println("Podaj klucz:");
                    n = scanner.nextInt();
                    try{
                        if(tree.ancestor(n)!=null){
                            System.out.println(tree.ancestor(n));
                        }else{
                            System.out.println("Brak poprzednika dla podanego klucza");
                        }
                    }catch (Exception ex){
                        System.out.println("Brak poprzednika dla podanego klucza");
                    }
                }
                case 10 -> {
                    System.out.println("Podaj klucz:");
                    n = scanner.nextInt();
                    tree.delete(n);
                }
                case 11 -> tree.displayTree();
                case 12 -> {
                    tree.insert(40);
                    tree.insert(70);
                    tree.insert(10);
                    tree.insert(20);
                    tree.insert(80);
                    tree.insert(100);
                    tree.insert(6);
                    tree.insert(5);
                    tree.insert(110);
                    tree.insert(200);
                }
                case 20 -> {
                    return;
                }
            }

        }
    }
}
