package package1;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static LinkedList<Student> students = new LinkedList<>();

    public static void main(String[] args) {
    	System.out.println("Student Report System");
        boolean success = readFile("studentdata.txt");

        if (success) {
            displayMenu();
        } else {
            System.out.println("Failed to read student data from the file.");
        }
    }

    public static boolean readFile(String filename) {
        File file = new File(filename);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                int id = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                int mathMark1 = Integer.parseInt(data[3]);
                int mathMark2 = Integer.parseInt(data[4]);
                int mathMark3 = Integer.parseInt(data[5]);
                int englishMark1 = Integer.parseInt(data[6]);
                int englishMark2 = Integer.parseInt(data[7]);
                int englishMark3 = Integer.parseInt(data[8]);

                addStudent(id, firstName, lastName, mathMark1, mathMark2, mathMark3, englishMark1, englishMark2, englishMark3);
            }

            scanner.close();
            return true;
        } catch (IOException e) {
            System.out.println("Failed to read file: " + filename);
            return false;
        }
    }

    private static void addStudent(int id, String firstName, String lastName, int mathMark1, int mathMark2, int mathMark3, int englishMark1, int englishMark2, int englishMark3) {
        Student student = new Student(id, firstName, lastName);
        
        // Set math marks
        student.getMathMarks().setMark(1, mathMark1);
        student.getMathMarks().setMark(2, mathMark2);
        student.getMathMarks().setMark(3, mathMark3);
        
        // Set English marks
        student.getEnglishMarks().setMark(1, englishMark1);
        student.getEnglishMarks().setMark(2, englishMark2);
        student.getEnglishMarks().setMark(3, englishMark3);

        students.add(student);
    }

    private static void displayReportByMarks() {
        // Implement code to display student marks
        for (Student student : students) {
            System.out.println("Student: " + student.getFullName());
            System.out.println("Math Marks: " + student.getMathMarks().getMark(1) + ", " + student.getMathMarks().getMark(2) + ", " + student.getMathMarks().getMark(3));
            System.out.println("English Marks: " + student.getEnglishMarks().getMark(1) + ", " + student.getEnglishMarks().getMark(2) + ", " + student.getEnglishMarks().getMark(3));
            System.out.println("--------------------------------------");
        }
    }

    private static void displayReportByGrades() {
        // Implement code to display student grades
        for (Student student : students) {
            System.out.println("Student: " + student.getFullName());
            System.out.println("Math Grade: " + student.getMathMarks().getAverageGrade());
            System.out.println("English Grade: " + student.getEnglishMarks().getAverageGrade());
            System.out.println("--------------------------------------");
        }
    }

    private static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 8) {
            System.out.println("Menu:");
            System.out.println("1. Display student marks");
            System.out.println("2. Display student grades");
            System.out.println("3. Add new student");
            System.out.println("4. Remove student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayReportByMarks();
                    break;
                case 2:
                    displayReportByGrades();
                    break;
                case 3:
                    addNewStudent();
                    break;
                case 4:
                    removeStudent(choice);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

   private static int selectMenuOption() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        scanner.close();
        return choice;
    }

   private static void addNewStudent() {
	   Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter student ID: ");
	    int id = scanner.nextInt();

	    // Check if the ID is unique
	    
	    boolean idExists = students.stream().allMatch(student -> student.getId() == id);
	    if (idExists) {
	        System.out.println("Student with ID " + id + " already exists. Please enter a unique ID.");
	        return;
	    }

	    System.out.print("Enter student first name: ");
	    String firstName = scanner.next();
	    
	    System.out.print("Enter student last name: ");
	    String lastName = scanner.next();

	    // You can add similar validation for marks as well
	    System.out.print("Enter Math Marks (3 values, separated by spaces): ");
	    int mathMark1 = scanner.nextInt();
	    int mathMark2 = scanner.nextInt();
	    int mathMark3 = scanner.nextInt();

	    // Add similar validation for English marks

	    // Create and add the new student if input is valid
	    addStudent(id, firstName, lastName, mathMark1, mathMark2, mathMark3, 0, 0, 0); // Assuming English marks are initially set to 0

	    System.out.println("Student added successfully.");
	{}

   
    }

    private static void removeStudent(int studentIndex) {
        if (studentIndex >= 0 && studentIndex < students.size()) {
            Student removedStudent = students.remove(studentIndex);
            System.out.println("Student with ID " + removedStudent.getId() + " has been removed.");
        } else {
            System.out.println("Invalid student index. No student removed.");
        }
    }

    }


