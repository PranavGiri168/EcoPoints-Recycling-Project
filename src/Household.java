import java.time.LocalDate;
import java.util.ArrayList;

public class Household {
    private String id;
    private String name;
    private String address;
    private LocalDate joinDate;
    private int totalPoints;
    private ArrayList<RecyclingEvent> events;

    public Household(String id, String name, String address, LocalDate joinDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.joinDate = joinDate;
        this.totalPoints = 0;
        this.events = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public LocalDate getJoinDate() { return joinDate; }
    public int getTotalPoints() { return totalPoints; }
    public ArrayList<RecyclingEvent> getEvents() { return events; }

    public void addEvent(RecyclingEvent event) {
        events.add(event);
        totalPoints += event.getEcoPoints();
    }

    public double getTotalWeight() {
        double total = 0;
        for (RecyclingEvent event : events) {
            total += event.getWeight();
        }
        return total;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name +
                ", Address: " + address +
                ", Join Date: " + joinDate +
                ", Total Points: " + totalPoints;
    }
}