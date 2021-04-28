import Model.Student;

public class Main {

    public static Student[] students = new Student[5];

    public static void main(String[] args) {
        students[0] = new Student("260366", "Jakub", "Radzik", 5);
        students[1] = new Student("123345", "Andrzej", "Patalas", 2);
        students[2] = new Student("123456", "Jakub", "Oleszczuk", 2);
        students[3] = new Student("111222", "Paweł", "Nowak", 3);
        students[4] = new Student("232311", "Karol", "Krawczyk", 4);


        System.out.println("1B");
        Operations.changeMarkForIndex1b(students, "260366", 3);
        Operations.displayAll1b(students);
        System.out.println("avg: "+Operations.avgForPositive1b(students));
        System.out.println("nie zdali");
        Operations.displayNegativeStudent1b(students);
        Operations.divideStudents1b(students);
    }
}
