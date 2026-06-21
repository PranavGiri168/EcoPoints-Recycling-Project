import java.time.LocalDate;

public class RecyclingEvent {
    private String materialType;
    private double weight;
    private LocalDate recyclingDate;
    private int ecoPoints;

    public RecyclingEvent(String materialType, double weight, LocalDate recyclingDate) {
        this.materialType = materialType;
        this.weight = weight;
        this.recyclingDate = recyclingDate;
        this.ecoPoints = (int)(weight * 10);
    }

    public String getMaterialType() { return materialType; }
    public double getWeight() { return weight; }
    public LocalDate getRecyclingDate() { return recyclingDate; }
    public int getEcoPoints() { return ecoPoints; }

    @Override
    public String toString() {
        return "Material: " + materialType +
                ", Weight: " + weight + "kg" +
                ", Date: " + recyclingDate +
                ", Points: " + ecoPoints;
    }
}