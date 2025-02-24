import java.util.ArrayList;
import java.util.List;

public class Day {
    private static int idCounter = 1;
    private int id;
    private String exercise;
    private double weight;
    private int reps;
    private int sets;
    private double rpe;

    // Static list of all exercises for the day
    private static List<Day> exerciseRecords = new ArrayList<>();

    // Constructor
    public Day(String exercise, double weight, int reps, int sets, double rpe) {
        this.id = idCounter++;
        this.exercise = exercise;
        this.weight = weight;
        this.reps = reps;
        this.sets = sets;
        this.rpe = rpe;
        exerciseRecords.add(this);  // Add the created exercise to the list
    }

    // Getter for exercise ID
    public int getId() {
        return id;
    }

    // Method to calculate Total Weight Lifted (TWL)
    public double calculateTWL() {
        return reps * sets * weight;
    }

    // Method to update an exercise record by ID
    public static boolean updateExercise(int id, String exercise, double weight, int reps, int sets, double rpe) {
        for (Day record : exerciseRecords) {
            if (record.getId() == id) {
                record.exercise = exercise;
                record.weight = weight;
                record.reps = reps;
                record.sets = sets;
                record.rpe = rpe;
                return true;
            }
        }
        return false;
    }

    // Method to delete an exercise record by ID
    public static boolean deleteExercise(int id) {
        for (Day record : exerciseRecords) {
            if (record.getId() == id) {
                exerciseRecords.remove(record);
                return true;
            }
        }
        return false;
    }

    // Method to display all exercise records
    public static void displayExercises() {
        if (exerciseRecords.isEmpty()) {
            System.out.println("No exercises to display.");
        } else {
            for (Day record : exerciseRecords) {
                System.out.println("ID: " + record.getId() + " | Exercise: " + record.exercise +
                        " | Weight: " + record.weight + " | Reps: " + record.reps +
                        " | Sets: " + record.sets + " | RPE: " + record.rpe +
                        " | TWL: " + record.calculateTWL());
            }
        }
    }

    // Method to search an exercise by ID
    public static Day findExerciseById(int id) {
        for (Day record : exerciseRecords) {
            if (record.getId() == id) {
                return record;
            }
        }
        return null;  // Return null if no exercise is found with the provided ID
    }

    // Getters and Setters for each field
    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public double getRpe() {
        return rpe;
    }

    public void setRpe(double rpe) {
        this.rpe = rpe;
    }

    // toString method to display exercise details
    @Override
    public String toString() {
        return "Exercise ID: " + id + ", Exercise: " + exercise + ", Weight: " + weight +
                ", Reps: " + reps + ", Sets: " + sets + ", RPE: " + rpe + " | TWL: " + calculateTWL();
    }
}