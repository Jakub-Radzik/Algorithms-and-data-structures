
public class Student {
    private String index;
    private String lName;
    private String fName;
    private int mark;

    public Student(String index, String lName, String fName, int mark) {
        this.index = index;
        this.lName = lName;
        this.fName = fName;
        this.mark = mark;
    }

    public String getIndex() {
        return index;
    }

    public void setIndeks(String index) {
        this.index = index;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return index +" "+ fName +" "+ lName +" "+ mark;
    }
}
