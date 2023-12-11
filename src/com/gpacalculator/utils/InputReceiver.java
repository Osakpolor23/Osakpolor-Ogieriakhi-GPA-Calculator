
// Take in the details of the number of course codes, course units and scores

package com.gpacalculator.utils;

// import scanner to receive inputs
import java.util.Scanner;


//declare the class input receiver
public class InputReceiver {
    private static final Scanner scanner = new Scanner(System.in);

    public static int retrievePositiveNumber(String prompt) {
        int value;

        while (true) {
            System.out.print(prompt);
            String inputValue = scanner.nextLine();

            if (!ValidInputs.isValidInteger(inputValue)) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            value = Integer.parseInt(inputValue);
            if (value > 0) break;
        }
        return value;
    }
    // Take in the course codes
    public static String retrieveCourseNameAndCode(String prompt) {
        String courseName;

        while (true) {
            System.out.print(prompt);
            courseName = scanner.nextLine();

            if (ValidInputs.isValidCourseNameAndCode(courseName)) {
                break;
            }

            System.out.println("Invalid course name and code. Please enter a valid one.");
        }
        return courseName;
    }

    // Take in the course scores
    public static int retrieveCourseScore(String prompt) {
        int courseScore;

        while (true) {
            System.out.print(prompt);
            String inputValue = scanner.nextLine();

            if (!ValidInputs.isValidInteger(inputValue)) {
                System.out.println("Invalid input. Please enter a valid course score.");
                continue;
            }

            courseScore = Integer.parseInt(inputValue);
            
            if (!ValidInputs.isValidCourseScore(courseScore)) {
                System.out.printf("Course Score Should be between %d and %d\n", 0, 100);
                continue;
            }
            
            break;
        }
        
        return courseScore;
    }

    // Take in the course units
    public static int retrieveCourseUnit(String prompt) {
        int courseUnit;

        while (true) {
            System.out.print(prompt);
            String inputValue = scanner.nextLine();

            if (!ValidInputs.isValidInteger(inputValue)) {
                System.out.println("Invalid input, Please enter a valid course unit.");
                continue;
            }
            
            courseUnit = Integer.parseInt(inputValue);
            if  (courseUnit < 0 || courseUnit > 10){
                System.out.println("Input numbers only within 0 to 10.");
                continue;
            }
            break;
        }

        return courseUnit;
    }
}
