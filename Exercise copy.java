public class Exercise {
    private String name;
    private double weight;
    private int reps;
    private int sets;
    private double rpe;

    public Exercise(String name, double weight, int reps, int sets, double rpe) {
        this.name = name;
        this.weight = weight;
        this.reps = reps;
        this.sets = sets;
        this.rpe = rpe;
    }

    @Override
    public String toString() {
        return "Exercise: " + name + ", Weight: " + weight + "kg, Reps: " + reps + ", Sets: " + sets + ", RPE: " + rpe;
    }
}