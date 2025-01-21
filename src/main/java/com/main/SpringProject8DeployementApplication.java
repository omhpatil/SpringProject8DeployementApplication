package com.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.main.entities.Student;
import com.main.services.StudentService;
import com.main.services.StudentServiceImplement;

@SpringBootApplication
public class SpringProject8DeployementApplication{

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringProject8DeployementApplication.class, args);
        StudentService stdService = context.getBean(StudentServiceImplement.class);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n------ Student Management Menu ------");
            System.out.println("1. Insert Student Details");
            System.out.println("2. Update Student Details");
            System.out.println("3. Delete Student Details");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Insert operation
                    Student std = new Student();
                    System.out.print("Enter Student ID: ");
                    std.setId(scanner.nextLong());
                    System.out.print("Enter Student Name: ");
                    std.setName(scanner.next());
                    System.out.print("Enter Roll Number: ");
                    std.setRollno(scanner.nextInt());
                    System.out.print("Enter Marks: ");
                    std.setMarks(scanner.nextFloat());

                    boolean insertStatus = stdService.addStudnetDetails(std);
                    if (insertStatus) {
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Failed to add student.");
                    }
                    break;

                case 2:
                    // Update operation
                    System.out.print("Enter Student ID to update: ");
                    long updateId = scanner.nextLong();
                    System.out.print("Enter new marks: ");
                    float newMarks = scanner.nextFloat();

                    boolean updateStatus = stdService.updateStdDetails(updateId, newMarks);
                    if (updateStatus) {
                        System.out.println("Student details updated successfully.");
                    } else {
                        System.out.println("Failed to update student details.");
                    }
                    break;

                case 3:
                    // Delete operation
                    System.out.print("Enter Student ID to delete: ");
                    long deleteId = scanner.nextLong();

                    boolean deleteStatus = stdService.deleteStdDetails(deleteId);
                    if (deleteStatus) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Failed to delete student.");
                    }
                    break;

                case 4:
                    // Display all students
                    List<Student> list = stdService.getAllStdDetails();
                    for (Student student : list) {
                        System.out.println("ID: " + student.getId());
                        System.out.println("NAME: " + student.getName());
                        System.out.println("ROLL: " + student.getRollno());
                        System.out.println("MARKS: " + student.getMarks());
                        System.out.println("--------------------");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
