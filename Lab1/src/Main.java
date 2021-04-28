import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Student> students = new ArrayList<>();

    public static void readStudents(String fileName){
            try {
                String[] objectFromFile;
                File myObj = new File(fileName);
                Scanner myReader = new Scanner(myObj);
                myReader.nextLine(); //skip first line
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    objectFromFile = data.split(" ");
                    Student newStudent = new Student(objectFromFile[0], objectFromFile[1], objectFromFile[2], Integer.parseInt(objectFromFile[3]));
                    students.add(newStudent);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Nie ma takiego pliku");
                e.printStackTrace();
            }
    }
    //wyswietlanie informacji iteratorem
    public static void displayStudents(){
        Iterator<Student> itr = students.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    //zmiany ocen
    public static void changeMark(String fName, String lName, int markToSet){
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()){
            Student student = itr.next();
            if(student.getfName().equals(fName) && student.getlName().equals(lName)){
                student.setMark(markToSet);
            }
        }
    }

    //wyliczanie i wywsietlanie sredniej pozytywnych ocen
    public static void positiveAvg(){
        Iterator<Student> itr = students.iterator();
        double sum = 0;
        double count = 0;
        double avg;
        while (itr.hasNext()){
            Student student = itr.next();
            if(student.getMark()>2){
                sum+=student.getMark();
                count+=1;
            }
        }
        avg = Math.round(sum/count * 100.0) / 100.0;
        System.out.println("Srednia ocen pozytywnych to: "+ avg);
    }

    //studenci którzy nie zdali
    public static void displayStudentsWhichDidNotPass(){
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()){
            Student student = itr.next();
            if(student.getMark()<3){
                System.out.println(student);
            }
        }
    }

    //zapis danych
    public static void saveFile(String fileName){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            Iterator<Student> itr = students.iterator();
            myWriter.write("Indeks Nazwisko Imie OcenaAiSD\n");
            while (itr.hasNext()){
                Student student = itr.next();
                myWriter.write(student.getIndex()+" "+student.getlName()+" "+student.getfName()+" "+student.getMark()+"\n");
            }
            myWriter.close();
            System.out.println("Koniec zapisu pliku");
        } catch (IOException e) {
            System.out.println("Coś poszło nie tak");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        readStudents("studenci.txt");

        System.out.println("Dane po wczytaniu:");
        displayStudents();

        changeMark("Jakub", "Radzik", 2);
        changeMark("Piotr", "Radzik", 3);
        changeMark("Urszula", "Nowak", 2);

        System.out.println("Dane po zmianie ocen:");
        displayStudents();

        positiveAvg();

        System.out.println("Nie zdali:");
        displayStudentsWhichDidNotPass();

        saveFile("studenci1.txt");
    }
}
