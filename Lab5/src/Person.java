import java.util.Comparator;

public class Person {
    private String fName;
    private String lName;
    private int yearOfBirth;

    //Comparators
    public static Comparator<Person> fNameComparator = new fNameComparator();
    public static Comparator<Person> lNameComparator = new lNameComparator();
    public static Comparator<Person> yearOfBirthComparator = new yearOfBirthComparator();
    public static Comparator<Person> allComparator = new fNameLNameYearOfBirthComparator();
    public static Comparator<Person> nameComparator = new lNamefNameComparator();

    public Person(String fName, String lName, int yearOfBirth) {
        this.fName = fName;
        this.lName = lName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return fName+" "+lName+" "+yearOfBirth;
    }
    //komparatory proste - podpunkt a
    static class fNameComparator implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getfName().compareTo(o2.getfName());
        }
    }
    static class lNameComparator implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getlName().compareTo(o2.getlName());
        }
    }
    static class yearOfBirthComparator implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return Integer.compare(o1.yearOfBirth, o2.yearOfBirth);
        }
    }
    //komparator złożony - podpunkt b
    static class fNameLNameYearOfBirthComparator implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            int firstComparation = Person.fNameComparator.compare(o1,o2);
            int secondComparation = Person.lNameComparator.compare(o1,o2);
            int thirdComparation = Person.yearOfBirthComparator.compare(o1,o2);

            if(firstComparation == 0){
                if(secondComparation==0){
                    return thirdComparation;
                }else {
                    return secondComparation;
                }
            }else{
                return firstComparation;
            }
        }
    }

    //metoda compare złożona - podpunkt c
    static class lNamefNameComparator implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            String t1 = o1.getlName()+o1.getfName();
            String t2 = o2.getlName()+o2.getfName();

            return t1.compareTo(t2);
        }
    }


}
