package package1;
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private AssignmentMarks mathMarks;
    private AssignmentMarks englishMarks;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        int assignment1 =0;
        int assignment2 =0;
        int assignment3 =0;
        this.mathMarks = new AssignmentMarks("Mathematics", assignment1, assignment2, assignment3);
        this.englishMarks = new AssignmentMarks("English", assignment1, assignment2, assignment3);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getId() {
        return id;
    }

    public AssignmentMarks getMathMarks() {
        return mathMarks;
    }

    public AssignmentMarks getEnglishMarks() {
        return englishMarks;
    }
}

