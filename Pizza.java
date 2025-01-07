// Part A: Pizza Class
import java.util.*;

// Enum for Meat Choices
enum MeatChoice {
    CHICKEN, BEEF, PEPPERONI;
}

// Enum for Vegetable Choices
enum VegChoice {
    ONIONS, PEPPERS, OLIVES, MUSHROOMS, TOMATOES;
}

// Custom Exception for invalid options
class InvalidPizzaOptionException extends Exception {
    public InvalidPizzaOptionException(String message) {
        super(message);
    }
}

// Pizza Class
class Pizza {
    private int numSlices;
    private MeatChoice meatChoice;
    private VegChoice vegChoice;

    // Default Constructor
    public Pizza() {
        Random random = new Random();
        this.numSlices = random.nextInt(8) + 1;
        this.meatChoice = MeatChoice.values()[random.nextInt(MeatChoice.values().length)];
        this.vegChoice = VegChoice.values()[random.nextInt(VegChoice.values().length)];
    }

    // Parameterized Constructor
    public Pizza(int numSlices, MeatChoice meatChoice, VegChoice vegChoice) {
        this.numSlices = numSlices;
        this.meatChoice = meatChoice;
        this.vegChoice = vegChoice;
    }

    // Getters and Setters
    public int getNumSlices() {
        return numSlices;
    }

    public void setNumSlices(int numSlices) {
        this.numSlices = numSlices;
    }

    public MeatChoice getMeatChoice() {
        return meatChoice;
    }

    public void setMeatChoice(MeatChoice meatChoice) {
        this.meatChoice = meatChoice;
    }

    public VegChoice getVegChoice() {
        return vegChoice;
    }

    public void setVegChoice(VegChoice vegChoice) {
        this.vegChoice = vegChoice;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "numSlices=" + numSlices +
                ", meatChoice=" + meatChoice +
                ", vegChoice=" + vegChoice +
                '}';
    }
}