import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter the number of subjects: ");
        int Subjects = in.nextInt();
        
        int totalMarks = 0;
        for (int i = 1; i <= Subjects; i++) {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            int marks = in.nextInt();
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks entered. Marks should be between 0 and 100.");
                return;
            }
            totalMarks += marks;
        }
        
        double averagePercentage = (double) totalMarks / Subjects;
        
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        
        String grade = calculateGrade(averagePercentage);
        System.out.println("Grade: " + grade);
    }
    
    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else if (averagePercentage >= 50) {
            return "E";
        } else {
            return "F";
        }
    }
}
