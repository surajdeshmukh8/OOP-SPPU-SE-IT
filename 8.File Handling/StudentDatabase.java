/**8.File Handling -- CO5
Implement a program for maintaining a database of student records using Files.
Student has Student_id,name, Roll_no, Class, marks and address. Display the data for few
students.
1. Create Database
2. Display Database
3. Delete Records
4. Update Record
5. Search Record
*/


import java.io.*;
import java.util.*;

class StudentDatabase {
    private static final String FILE_NAME = "student_database.txt";

    // Method to add student records to the file
    public static void createDatabase(Scanner scanner) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) { // Appends to file if it exists
            System.out.print("Enter Student ID: ");
            String studentId = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Roll Number: ");
            String rollNo = scanner.nextLine();
            System.out.print("Enter Class: ");
            String studentClass = scanner.nextLine();
            System.out.print("Enter Marks: ");
            String marks = scanner.nextLine();
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();

            String record = studentId + "," + name + "," + rollNo + "," + studentClass + "," + marks + "," + address;
            writer.write(record + System.lineSeparator());
            System.out.println("Record added successfully.");
        }
    }

    // Method to display all records from the file
    public static void displayDatabase() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("Student Records:");
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                System.out.println("ID: " + details[0] + ", Name: " + details[1] + ", Roll No: " + details[2] +
                                   ", Class: " + details[3] + ", Marks: " + details[4] + ", Address: " + details[5]);
            }
        }
    }

    // Method to delete a specific record based on student ID
    public static void deleteRecord(Scanner scanner) throws IOException {
        System.out.print("Enter Student ID to delete: ");
        String studentId = scanner.nextLine();

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp_" + FILE_NAME);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (!details[0].equals(studentId)) {
                    writer.write(line + System.lineSeparator());
                } else {
                    found = true;
                }
            }

            if (found) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("Record not found.");
            }
        }

        if (inputFile.delete() && tempFile.renameTo(inputFile)) {
            System.out.println("Database updated.");
        }
    }

    // Method to update a specific record based on student ID
    public static void updateRecord(Scanner scanner) throws IOException {
        System.out.print("Enter Student ID to update: ");
        String studentId = scanner.nextLine();

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp_" + FILE_NAME);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details[0].equals(studentId)) {
                    found = true;
                    System.out.print("Enter new Name: ");
                    details[1] = scanner.nextLine();
                    System.out.print("Enter new Roll Number: ");
                    details[2] = scanner.nextLine();
                    System.out.print("Enter new Class: ");
                    details[3] = scanner.nextLine();
                    System.out.print("Enter new Marks: ");
                    details[4] = scanner.nextLine();
                    System.out.print("Enter new Address: ");
                    details[5] = scanner.nextLine();

                    line = String.join(",", details);
                    System.out.println("Record updated successfully.");
                }
                writer.write(line + System.lineSeparator());
            }

            if (!found) {
                System.out.println("Record not found.");
            }
        }

        if (inputFile.delete() && tempFile.renameTo(inputFile)) {
            System.out.println("Database updated.");
        }
    }

    // Method to search for a specific record based on student ID
    public static void searchRecord(Scanner scanner) throws IOException {
        System.out.print("Enter Student ID to search: ");
        String studentId = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details[0].equals(studentId)) {
                    System.out.println("Record found:");
                    System.out.println("ID: " + details[0] + ", Name: " + details[1] + ", Roll No: " + details[2] +
                                       ", Class: " + details[3] + ", Marks: " + details[4] + ", Address: " + details[5]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Record not found.");
            }
        }
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        try {
            do {
                System.out.println("\nStudent Database Management");
                System.out.println("1. Create Database");
                System.out.println("2. Display Database");
                System.out.println("3. Delete Record");
                System.out.println("4. Update Record");
                System.out.println("5. Search Record");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> createDatabase(scanner);
                    case 2 -> displayDatabase();
                    case 3 -> deleteRecord(scanner);
                    case 4 -> updateRecord(scanner);
                    case 5 -> searchRecord(scanner);
                    case 6 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 6);
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
