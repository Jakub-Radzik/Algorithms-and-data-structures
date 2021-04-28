import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person[] tab = new Person[8];
        tab[0] = new Person("Jakub", "Radzik", 2000);
        tab[1] = new Person("Piotr", "Puchała", 2003);
        tab[2] = new Person("Andrzej", "Gębura", 2004);
        tab[3] = new Person("Kamil", "Herbetko", 2012);
        tab[4] = new Person("Ernest", "Cheresnie", 3000);
        tab[5] = new Person("Jan", "Radzik", 1203);
        tab[6] = new Person("Jakub", "Radzikowski", 1203);
        tab[7] = new Person("Jakub", "Radzik", 2222);


        System.out.println("TABLICA PRZED SORTOWANIEM");
        Arrays.stream(tab).forEach(System.out::println);
        //REALIZACJA ZADANIA a,b
        //BUBBLE SORT
        SortMethods.bubbleSort(tab, Person.fNameComparator);
        System.out.println("\na)TABLICA PO SORTOWANIU PO IMIENIU - BUBBLE SORT");
        Arrays.stream(tab).forEach(System.out::println);

        SortMethods.bubbleSort(tab, Person.lNameComparator);
        System.out.println("\na)TABLICA PO SORTOWANIU PO NAZWISKU - BUBBLE SORT");
        Arrays.stream(tab).forEach(System.out::println);

        SortMethods.bubbleSort(tab, Person.yearOfBirthComparator);
        System.out.println("\na)TABLICA PO SORTOWANIU PO ROKU - BUBBLE SORT");
        Arrays.stream(tab).forEach(System.out::println);

        SortMethods.bubbleSort(tab, Person.allComparator);
        System.out.println("\nb)TABLICA PO SORTOWANIU PO IMIENIU NAZWISKU I ROKU - BUBBLE SORT");
        Arrays.stream(tab).forEach(System.out::println);

        SortMethods.bubbleSort(tab, Person.nameComparator);
        System.out.println("\nc)TABLICA PO SORTOWANIU PO NAZWISKU I IMIENIU - BUBBLE SORT");
        Arrays.stream(tab).forEach(System.out::println);
        //INSERTION SORT
        SortMethods.insertionSort(tab, Person.fNameComparator);
        System.out.println("\na)TABLICA PO SORTOWANIU PO IMIENIU - INSERTION SORT");
        Arrays.stream(tab).forEach(System.out::println);

        SortMethods.insertionSort(tab, Person.lNameComparator);
        System.out.println("\na)TABLICA PO SORTOWANIU PO NAZWISKU - INSERTION SORT");
        Arrays.stream(tab).forEach(System.out::println);

        SortMethods.insertionSort(tab, Person.yearOfBirthComparator);
        System.out.println("\na)TABLICA PO SORTOWANIU PO ROKU - INSERTION SORT");
        Arrays.stream(tab).forEach(System.out::println);

        SortMethods.insertionSort(tab, Person.allComparator);
        System.out.println("\nb)TABLICA PO SORTOWANIU PO IMIENIU NAZWISKU I ROKU - INSERTION SORT");
        Arrays.stream(tab).forEach(System.out::println);

        SortMethods.insertionSort(tab, Person.nameComparator);
        System.out.println("\nc)TABLICA PO SORTOWANIU PO NAZWISKU I IMIENIU - INSERTION SORT");
        Arrays.stream(tab).forEach(System.out::println);

        //SELECTION SORT
        SortMethods.selectionSort(tab, Person.fNameComparator);
        System.out.println("\na)TABLICA PO SORTOWANIU PO IMIENIU - SELECTION SORT");
        Arrays.stream(tab).forEach(System.out::println);

        SortMethods.selectionSort(tab, Person.lNameComparator);
        System.out.println("\na)TABLICA PO SORTOWANIU PO NAZWISKU - SELECTION SORT");
        Arrays.stream(tab).forEach(System.out::println);

        SortMethods.selectionSort(tab, Person.yearOfBirthComparator);
        System.out.println("\na)TABLICA PO SORTOWANIU PO ROKU - SELECTION SORT");
        Arrays.stream(tab).forEach(System.out::println);

        SortMethods.selectionSort(tab, Person.allComparator);
        System.out.println("\nb)TABLICA PO SORTOWANIU PO IMIENIU NAZWISKU I ROKU - SELECTION SORT");
        Arrays.stream(tab).forEach(System.out::println);

        SortMethods.selectionSort(tab, Person.nameComparator);
        System.out.println("\nc)TABLICA PO SORTOWANIU PO NAZWISKU I IMIENIU - SELECTION SORT");
        Arrays.stream(tab).forEach(System.out::println);

    }
}
