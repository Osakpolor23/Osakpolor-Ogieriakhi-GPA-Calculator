package com.gpacalculator.main;

// import the course, calculator switches, and input receiver classes
import com.gpacalculator.models.Course;
import com.gpacalculator.services.GPACalculatorSwitches;
import com.gpacalculator.utils.InputReceiver;

// main app
public class MyGPACalculator {

    public static void main(String[] args) {
        System.out.println("GPA Calculator");

        int numberOfCourses = InputReceiver.retrievePositiveNumber("Enter the number of Courses: ");
        Course[] courses = new Course[numberOfCourses];


        for (int i = 0; i < numberOfCourses; i++) {
            Course course = captureCourseInput(i);
            
            courses[i] = course;
        }

        printCourseInfo(courses);

        double gpa = GPACalculatorSwitches.calculateGPA(courses);
        System.out.printf("\nYour GPA is: %.2f\n", gpa);
    }

    private static void printCourseInfo(Course[] courses) {
        System.out.println("\nCourse details and grades:\n");

        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE              | COURSE UNIT           | GRADE      | GRADE-UNIT          |");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");

        for (Course course : courses) {
            String grade = GPACalculatorSwitches.scoreToAlphabetConverter(course.getScore());
            int gradePoint = GPACalculatorSwitches.letterToNumeicGradeConverter(course.getScore());

            System.out.format("| %-27s| %-21s | %-10s | %-19s |\n",
                    course.getCourseNameAndCode(), course.getUnits(), grade, gradePoint);
        }
        System.out.println("|---------------------------------------------------------------------------------------|");
    }

    private static Course captureCourseInput(int index) {
        int count = index + 1;
        System.out.println("\nInput Details for Course " + count);

        String courseNameAndCode = InputReceiver.retrieveCourseNameAndCode("Course Name And Code: ");
        int units = InputReceiver.retrieveCourseUnit("Units: ");
        double score = InputReceiver.retrieveCourseScore("Score: ");

        return new Course(courseNameAndCode, units, score);
    }
}