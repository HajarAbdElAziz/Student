import java.util.Scanner;

class Student {
	String name;
	String email;
	String faculty;
	Grade grade[];
	static int counter = 0;

	Student() {
		this("", "", "", new Grade[0]);
	}

	Student(String newName) {
		this(newName, "", "", new Grade[0]);
	}

	Student(String newName, String newEmail) {
		this(newName, newEmail, "", new Grade[0]);
	}

	Student(String newName, String newEmail, String newFaculty) {
		this(newName, newEmail, newFaculty, new Grade[0]);
	}

	Student(String newName, String newEmail, String newFaculty, Grade[] newGrade) {
		name = newName;
		email = newEmail;
		faculty = newFaculty;
		grade = newGrade;
		counter++;
	}

}

class Grade {
	String name;
	double mark;

	Grade() {
		this("", 0);
	}

	Grade(String newName) {
		this(newName, 0);
	}

	Grade(String newName, double newMark) {
		name = newName;
		mark = newMark;
	}

}

public class Main {
	public static void main(String[] args) {
		int studNum;
		int gradesNums;
		Scanner in = new Scanner(System.in);
		System.out.println("Hey, Can u please enter the number of students: ");
		studNum = in.nextInt();
		Student studArray[] = new Student[studNum];
		for (int i = 0; i < studNum; i++) {
			System.out.println("Please enter data of stdent # " + i);
			System.out.println("Please enter name");
			String studName = in.next();
			System.out.println("Please enter " + studName + " email:");
			String studEmail = in.next();
			System.out.println("Please enter " + studName + " faculty:");
			String studFaculty = in.next();
			System.out.println("Please enter the grades number of " + studName);
			gradesNums = in.nextInt();
			Grade gradeArray[] = new Grade[gradesNums];
			for (int j = 0; j < gradesNums; j++) {
				System.out.println("Please enter data of grade # " + j);
				System.out.println("Please enter grade name");
				String gradeName = in.next();
				System.out.println("Please enter mark for grade " + gradeName);
				double gradeMark = in.nextDouble();
				Grade g = new Grade(gradeName, gradeMark);
				gradeArray[j] = g;
			}
			Student s = new Student(studName, studEmail, studFaculty, gradeArray);
			studArray[i] = s;
		}

		for (int i = 0; i < studNum; i++) {
			System.out.println("Hello, Here is student# " + i + " data:");
			System.out.println("Name: " + studArray[i].name);
			System.out.println("Email: " + studArray[i].email);
			System.out.println("Faculty: " + studArray[i].faculty);
			for (int j = 0; j < studArray[i].grade.length; j++) {
				System.out.println("Name of grade# " + j + " " + studArray[i].grade[j].name);
				if (studArray[i].grade[j].mark > 75) {
					System.out.println("Mark of grade# " + j + " " + studArray[i].grade[j].mark + " Very Good Mark");
				} else {
					System.out.println("Mark of grade# " + j + " " + studArray[i].grade[j].mark);
				}
			}
		}
		
		int highestStudent = 0;
		double highestSum = 0;
		for (int i = 0; i < studNum; i++) {
			double sum=0;
			for (int j = 0; j < studArray[i].grade.length; j++) {
				sum+=studArray[i].grade[j].mark;
			}
			if (sum > highestSum) {
				highestStudent = i;
				highestSum = sum;
			}
		}
		
		System.out.println("Student with highest marks: #" +highestStudent + " " + studArray[highestStudent].name + " marks: " + highestSum);
		System.out.println("Total students: " + Student.counter);
	}
}