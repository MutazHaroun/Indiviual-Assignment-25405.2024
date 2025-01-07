import java.util.Scanner;
class PizzaTest {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of pizzas to order: ");
            int n;

            while (true) {
                if (scanner.hasNextInt()) {
                    n = scanner.nextInt();
                    if (n > 0) {
                        break;
                    } else {
                        System.out.println("Please enter a positive number.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Consume invalid input
                }
            }

            Pizza[] pizzas = new Pizza[n];
            for (int i = 0; i < n; i++) {
                System.out.println("\nOrdering pizza " + (i + 1) + " of " + n + ":");

                int slices;
                while (true) {
                    System.out.print("Enter number of slices: ");
                    if (scanner.hasNextInt()) {
                        slices = scanner.nextInt();
                        if (slices > 0) {
                            break;
                        } else {
                            System.out.println("Number of slices must be positive.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next(); // Consume invalid input
                    }
                }

                MeatChoice meat = null;
                while (meat == null) {
                    System.out.print("Choose meat (CHICKEN, BEEF, PEPPERONI): ");
                    String meatInput = scanner.next().toUpperCase();
                    try {
                        meat = MeatChoice.valueOf(meatInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid meat choice. Please choose from CHICKEN, BEEF, PEPPERONI.");
                    }
                }

                VegChoice veg = null;
                while (veg == null) {
                    System.out.print("Choose vegetable (ONIONS, PEPPERS, OLIVES, MUSHROOMS, TOMATOES): ");
                    String vegInput = scanner.next().toUpperCase();
                    try {
                        veg = VegChoice.valueOf(vegInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid vegetable choice. Please choose from ONIONS, PEPPERS, OLIVES, MUSHROOMS, TOMATOES.");
                    }
                }

                pizzas[i] = new Pizza(slices, meat, veg);
                System.out.println("Pizza ordered: " + pizzas[i]);
            }

            System.out.println("\nAll pizzas ordered:");
            for (Pizza pizza : pizzas) {
                System.out.println(pizza);
            }
        }
    }
}
