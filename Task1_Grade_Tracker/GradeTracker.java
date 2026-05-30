import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class GradeTracker{
    public static void main(String[] args){
        ArrayList<Student>students=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Professional Grade Tracker developed by SAGAN GANGWAR");
        while (true){
            System.out.print("\nEnter student name (or type 'exit' to finalize):");
            String name=scanner.nextLine().trim();
            if(name.equalsIgnoreCase("exit")) 
                break;
            if(name.isEmpty()){
                System.out.println("Student name cannot be empty.");
                continue;
            }
            double grade=-1;
            while (true){
                System.out.print("Enter numerical grade (0 - 100) for "+ name +": ");
                try{
                    grade=scanner.nextDouble();
                    scanner.nextLine(); 
                    if (grade >= 0 && grade <= 100){
                        break; 
                    }
                    else{
                    System.out.println("Grade must be between 0 and 100.");
                    }
                } 
                catch(InputMismatchException e){
                    System.out.println("Invalid input.Please enter a valid decimal number.");
                    scanner.nextLine();
                }
            }
            students.add(new Student(name,grade));
        }
        if(!students.isEmpty()) {
            displaySummaryReport(students);
        }
        else{
            System.out.println("Process aborted.No student metrics recorded.");
        }
        scanner.close();
    }
    private static void displaySummaryReport(ArrayList<Student>students){
        double total=0;
        double highest=students.get(0).getGrade();
        double lowest=students.get(0).getGrade();
        for (Student s : students){
            double g=s.getGrade();
            total+=g;
            if(g>highest)highest=g;
            if(g<lowest)lowest=g;
        }
        System.out.println("\n=================================");
        System.out.println("        METRIC SUMMARY REPORT     ");
        System.out.println("=================================");
        System.out.printf("Total Enrolled Records : %d\n",students.size());
        System.out.printf("Class Average Score    : %.2f%%\n",(total/students.size()));
        System.out.printf("Peak Performance       : %.2f%%\n",highest);
        System.out.printf("Minimum Threshold      : %.2f%%\n",lowest);
        System.out.println("=================================");
    }
}