package Model;

import javax.lang.model.element.Name;
import java.util.StringJoiner;

public class Student {
    private String index;
    private String fName;
    private String lName;
    private int mark;

    public Student(String index, String fName, String lName, int mark) {
        this.index = index;
        this.fName = fName;
        this.lName = lName;
        this.mark = mark;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return  index + " " + fName+ " " + lName+ " " +  mark;
    }
}
