package package1;

public class AssignmentMarks {
	private String courseName;
	private int assignment1;
	private int assignment2;
	private int assignment3;
	
	public AssignmentMarks(String courseName, int assignment1, int assignment2, int assignment3){
		this.courseName = courseName;
		this.assignment1 = assignment1;
		this.assignment2 = assignment2;
		this.assignment3 = assignment3;
	}
	
	public void setMark(int assignmentNumber, int mark) {
		if (assignmentNumber == 1) {
			assignment1 = mark;
		} else if (assignmentNumber ==2) {
			assignment2 = mark;
		} else if (assignmentNumber ==3) {
			assignment3 = mark;
		}
	}

	public int getMark(int assignmentNumber) {
	    if (assignmentNumber == 1) {
	        return assignment1;
	    } else if (assignmentNumber == 2) {
	        return assignment2;
	    } else if (assignmentNumber == 3) {
	        return assignment3;
	    }
	    return -1; //Or throw an exception indicating invalid assignment number
	}

	
	public int getAverageMark() {
		return (assignment1 + assignment2 + assignment3) / 3;
	}
	 public String getGrade(int assignmentNumber) {
	        int mark = getMark(assignmentNumber);
	        return markToGrade(mark);
	    }

	    public String getAverageGrade() {
	        int averageMark = getAverageMark();
	        return markToGrade(averageMark);
	    }
	
	public String markToGrade(int mark) {
		if (mark >= 95) {
			return "A+";
		}else if (mark >= 85) {
            return "A-";
        } else if (mark >= 80) {
            return "B+";
        } else if (mark >= 75) {
            return "B";
        } else if (mark >= 70) {
            return "B-";
        } else if (mark >= 60) {
            return "C+";
        } else if (mark >= 50) {
            return "C";
        } else if (mark >= 41) {
            return "C-";
        } else {
            return "D";
        }
    }

    public void setCourseName(String name) {
         this.courseName = name;
    }

    public String getCourseName() {
        return courseName;
    }
}