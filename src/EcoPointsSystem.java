import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class EcoPointsSystem {
    static HashMap<String, Household> households = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== EcoPoints Recycling Program =====");
            System.out.println("1. Register Household");
            System.out.println("2. Log Recycling Event");
            System.out.println("3. View All Households");
            System.out.println("4. View Household Events");
            System.out.println("5. View Household Summary");
            System.out.println("6. Generate Reports");
            System.out.println("7. Save Data");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    registerHousehold();
                    break;
                case 2:
                    logRecyclingEvent();
                    break;
                case 3:
                    displayHouseholds();
                    break;
                case 4:
                    displayEvents();
                    break;
                case 5:
                    householdSummary();
                    break;
                case 6:
                    generateReports();
                    break;
                case 7:
                    saveData();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Register household
    public static void registerHousehold() {
        try {
            System.out.print("Enter Household ID: ");
            String id = sc.nextLine();

            if (households.containsKey(id)) {
                throw new Exception("Duplicate Household ID!");
            }

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Address: ");
            String address = sc.nextLine();

            Household h = new Household(id, name, address, LocalDate.now());
            households.put(id, h);

            System.out.println("Household registered successfully!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Log recycling event
    public static void logRecyclingEvent() {
        try {
            System.out.print("Enter Household ID: ");
            String id = sc.nextLine();

            Household h = households.get(id);

            if (h == null) {
                System.out.println("Household not found!");
                return;
            }

            System.out.print("Enter Material Type: ");
            String material = sc.nextLine();

            System.out.print("Enter Weight (kg): ");
            double weight = sc.nextDouble();
            sc.nextLine();

            if (weight <= 0) {
                throw new Exception("Weight cannot be negative or zero!");
            }

            RecyclingEvent event = new RecyclingEvent(material, weight, LocalDate.now());
            h.addEvent(event);

            System.out.println("Recycling event added!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Display all households
    public static void displayHouseholds() {
        for (Household h : households.values()) {
            System.out.println(h);
        }
    }

    // Display events
    public static void displayEvents() {
        System.out.print("Enter Household ID: ");
        String id = sc.nextLine();

        Household h = households.get(id);

        if (h != null) {
            for (RecyclingEvent event : h.getEvents()) {
                System.out.println(event);
            }
        } else {
            System.out.println("Household not found!");
        }
    }

    // Household summary
    public static void householdSummary() {
        System.out.print("Enter Household ID: ");
        String id = sc.nextLine();

        Household h = households.get(id);

        if (h != null) {
            System.out.println("Total Weight: " + h.getTotalWeight() + "kg");
            System.out.println("Total Points: " + h.getTotalPoints());
        } else {
            System.out.println("Household not found!");
        }
    }

    // Generate reports
    public static void generateReports() {
        Household topHousehold = null;
        double communityWeight = 0;

        for (Household h : households.values()) {
            communityWeight += h.getTotalWeight();

            if (topHousehold == null || h.getTotalPoints() > topHousehold.getTotalPoints()) {
                topHousehold = h;
            }
        }

        if (topHousehold != null) {
            System.out.println("Top Household: " + topHousehold.getName() +
                    " with " + topHousehold.getTotalPoints() + " points");
        }

        System.out.println("Total Community Recycling Weight: " + communityWeight + "kg");
    }

    // Save data to files
    public static void saveData() {
        try {
            FileWriter householdWriter = new FileWriter("households.txt");
            FileWriter logWriter = new FileWriter("recycling_logs.txt");

            for (Household h : households.values()) {
                householdWriter.write(h.toString() + "\n");

                for (RecyclingEvent event : h.getEvents()) {
                    logWriter.write("Household ID: " + h.getId() + " | " + event + "\n");
                }
            }

            householdWriter.close();
            logWriter.close();

            System.out.println("Data saved successfully!");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}