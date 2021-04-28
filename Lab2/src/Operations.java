import Iterators1a.FilterStudentIterator;
import Interfaces.Predicate;
import Iterators1a.StudentsIterator;
import Iterators1b.StudentInteratorFilter1B;
import Iterators1b.StudentIterator1B;
import Model.Student;

import java.util.ArrayList;

public class Operations {

    //1a
    public static void displayAll(Student[] students){
        StudentsIterator itr = new StudentsIterator(students);
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
    public static void changeMarkForIndex(Student[] students, String index, int mark){
        StudentsIterator itr = new StudentsIterator(students);
        Predicate<Student> checkIndex = student -> student.getIndex().equals(index);
        FilterStudentIterator<Student> filter = new FilterStudentIterator<>(itr, checkIndex);
        filter.next().setMark(mark);
    }
    public static double avgForPositive(Student[] students){
        double sum = 0;
        double count = 0;
        StudentsIterator itr = new StudentsIterator(students);
        Predicate<Student> checkMark = student -> student.getMark()>2;
        FilterStudentIterator<Student> filter = new FilterStudentIterator<>(itr, checkMark);
        while(filter.hasNext()){
            sum += filter.next().getMark();
            count++;
        }
        return (double) Math.round((sum/count) * 100) / 100;
    }
    public static void displayNegativeStudent(Student[] students){
        StudentsIterator itr = new StudentsIterator(students);
        Predicate<Student> checkMark = student -> student.getMark()<3;
        FilterStudentIterator<Student> filter = new FilterStudentIterator<>(itr, checkMark);
        while(filter.hasNext()){
            System.out.println(filter.next());
        }
    }
    public static void divideStudents(Student[] students){
        StudentsIterator itr = new StudentsIterator(students);
        ArrayList<Student> negative = new ArrayList<>();
        ArrayList<Student> positive = new ArrayList<>();

        while (itr.hasNext()){
            Student st = itr.next();
            if(st.getMark()>2){
                positive.add(st);
            }else{
                negative.add(st);
            }
        }

        System.out.println("Zdali:");
        positive.forEach(System.out::println);
        System.out.println("Nie zdali:");
        negative.forEach(System.out::println);

    }

    //1b
    public static void displayAll1b(Student[] students){
        StudentIterator1B itr = new StudentIterator1B(students);
        while (!itr.isDone()){
            System.out.println(itr.currentItem());
            itr.next();
        }
    }
    public static void changeMarkForIndex1b(Student[] students, String index, int mark){
        StudentIterator1B itr = new StudentIterator1B(students);
        Predicate<Student> checkIndex = student -> student.getIndex().equals(index);
        StudentInteratorFilter1B<Student> fIter = new StudentInteratorFilter1B<>(itr, checkIndex);
        fIter.findNextValid();
        fIter.currentItem().setMark(mark);
    }
    public static double avgForPositive1b(Student[] students){
        double sum = 0;
        double count = 0;
        StudentIterator1B itr = new StudentIterator1B(students);
        Predicate<Student> checkMark = student -> student.getMark()>2;
        StudentInteratorFilter1B<Student> fIter = new StudentInteratorFilter1B<>(itr, checkMark);

        while(!fIter.isDone()){
            System.out.println(fIter.currentItem());
            sum += fIter.currentItem().getMark();
            count++;
            fIter.findNextValid();
        }

        return (double) Math.round((sum/count) * 100) / 100;
    }
    public static void displayNegativeStudent1b(Student[] students){
        StudentIterator1B itr = new StudentIterator1B(students);
        Predicate<Student> checkMark = student -> student.getMark()<3;
        StudentInteratorFilter1B<Student> fIter = new StudentInteratorFilter1B<>(itr, checkMark);
        fIter.findNextValid();
        while(!fIter.isDone()){
            System.out.println(fIter.currentItem());
            fIter.findNextValid();
        }
    }
    public static void divideStudents1b(Student[] students){
        StudentIterator1B itr = new StudentIterator1B(students);
        ArrayList<Student> negative = new ArrayList<>();
        ArrayList<Student> positive = new ArrayList<>();

        while (!itr.isDone()){
            Student st = itr.currentItem();
            if(st.getMark()>2){
                positive.add(st);
            }else{
                negative.add(st);
            }
            itr.next();
        }

        System.out.println("studenci po podziale");
        System.out.println("Zdali:");
        positive.forEach(System.out::println);
        System.out.println("Nie zdali:");
        negative.forEach(System.out::println);

    }

}
