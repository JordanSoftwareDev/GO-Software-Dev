import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {

    public static void displayMenu() {
        boolean isRunning = true;
        while (isRunning) {

            System.out.print("Welcome to GO!\n");
            System.out.print("Let's get to work. Select an option to start.\n\n");

            // Displays menu options
            System.out.print("1.) Create Record\n");
            System.out.print("2.) Read Record\n");
            System.out.print("3.) Update Record\n");
            System.out.print("4.) Display Records\n");
            System.out.print("5.) Calculate TWL\n");
            System.out.print("6.) Exit\n");

            Scanner menuChoice = new Scanner(System.in);
            int choice = 0;

            while (true) { // Keep asking until valid input is given
                try {
                    System.out.print("Enter an integer: ");
                    choice = menuChoice.nextInt(); // Attempt to read an integer
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    menuChoice.next(); // Clear the invalid input from scanner buffer
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("You entered: " + choice + "\n");
                    createRecord();
                    break;
                case 2:
                    System.out.println("You entered: " + choice + "\n");
                    readFromFile();
                    break;
                case 3:
                    System.out.println("You entered: " + choice + "\n");
                    updateRecord();
                    break;
                case 4:
                    System.out.println("You entered: " + choice + "\n");
                    displayRecords();
                    break;
                case 5:
                    System.out.println("You entered: " + choice + "\n");
                    calculateTWL();
                    break;
                case 6:
                    System.out.println("You entered: " + choice + "\n");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid entry" + "\n");
                    break;
            }
        }
    }

    public static void createRecord() {
        Scanner scanner = new Scanner(System.in);

        // Input for Exercise Name
        System.out.print("What exercise will you be doing?\n");
        String exercise = scanner.nextLine();

        // Validate Weight
        double weight = -1;
        while (weight <= 0) {
            try {
                System.out.print("How much weight?\n");
                weight = scanner.nextDouble();
                if (weight <= 0) {
                    System.out.println("Weight must be a positive number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for weight.");
                scanner.next(); // Clear invalid input
            }
        }

        // Validate Reps
        int reps = -1;
        while (reps <= 0) {
            try {
                System.out.print("How many reps?\n");
                reps = scanner.nextInt();
                if (reps <= 0) {
                    System.out.println("Reps must be a positive number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for reps.");
                scanner.next(); // Clear invalid input
            }
        }

        // Validate Sets
        int sets = -1;
        while (sets <= 0) {
            try {
                System.out.print("How many sets?\n");
                sets = scanner.nextInt();
                if (sets <= 0) {
                    System.out.println("Sets must be a positive number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for sets.");
                scanner.next(); // Clear invalid input
            }
        }

        // Validate RPE (Rate of Perceived Exertion)
        double rpe = -1;
        while (rpe < 1 || rpe > 10) {
            try {
                System.out.print("How difficult was it? (RPE 1-10)\n");
                rpe = scanner.nextDouble();
                if (rpe < 1 || rpe > 10) {
                    System.out.println("RPE must be between 1 and 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for RPE.");
                scanner.next(); // Clear invalid input
            }
        }

        // Create the exercise record
        Day newDay = new Day(exercise, weight, reps, sets, rpe);
        System.out.println("Exercise record created successfully!\n");
    }

    public static void readFromFile() {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("You've selected read from file.\n");
        System.out.print("Input the filepath of the file you want to read session data from: ");
        String filePath = inputScanner.nextLine();

        System.out.println("Filepath: " + filePath + "\n");

        ReadFile.readFile(filePath);

    }

    public static void updateRecord() {
        Scanner scanner = new Scanner(System.in);

        // Validate Exercise ID
        int id = -1;
        while (id <= 0) {
            try {
                System.out.print("Enter the Exercise ID to update: ");
                id = scanner.nextInt();
                if (id <= 0) {
                    System.out.println("ID must be a positive integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the Exercise ID.");
                scanner.next(); // Clear invalid input
            }
        }

        // Find the record by ID
        Day recordToUpdate = Day.findExerciseById(id);
        if (recordToUpdate != null) {
            // Validate new exercise name
            System.out.print("Enter new exercise name: ");
            scanner.nextLine(); // Consume newline
            String exercise = scanner.nextLine();

            // Validate new weight
            double weight = -1;
            while (weight <= 0) {
                try {
                    System.out.print("Enter new weight: ");
                    weight = scanner.nextDouble();
                    if (weight <= 0) {
                        System.out.println("Weight must be a positive number.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number for weight.");
                    scanner.next(); // Clear invalid input
                }
            }

            // Validate new reps
            int reps = -1;
            while (reps <= 0) {
                try {
                    System.out.print("Enter new reps: ");
                    reps = scanner.nextInt();
                    if (reps <= 0) {
                        System.out.println("Reps must be a positive number.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number for reps.");
                    scanner.next(); // Clear invalid input
                }
            }

            // Validate new sets
            int sets = -1;
            while (sets <= 0) {
                try {
                    System.out.print("Enter new sets: ");
                    sets = scanner.nextInt();
                    if (sets <= 0) {
                        System.out.println("Sets must be a positive number.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number for sets.");
                    scanner.next(); // Clear invalid input
                }
            }

            // Validate new RPE (Rate of Perceived Exertion)
            double rpe = -1;
            while (rpe < 1 || rpe > 10) {
                try {
                    System.out.print("Enter new RPE: ");
                    rpe = scanner.nextDouble();
                    if (rpe < 1 || rpe > 10) {
                        System.out.println("RPE must be between 1 and 10.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number for RPE.");
                    scanner.next(); // Clear invalid input
                }
            }

            // Update the exercise record
            Day.updateExercise(id, exercise, weight, reps, sets, rpe);
            System.out.println("Record updated successfully.\n");
        } else {
            System.out.println("Exercise not found!\n");
        }
    }

    public static void displayRecords() {
        Day.displayExercises();
    }

    public static void calculateTWL() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Exercise ID to calculate TWL: ");
        int id = scanner.nextInt();

        Day record = Day.findExerciseById(id);
        if (record != null) {
            double twl = record.calculateTWL();
            System.out.println("Total Weight Lifted (TWL) for Exercise ID " + id + ": " + twl + "\n");
        } else {
            System.out.println("Exercise not found!\n");
        }
    }
}