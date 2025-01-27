package config;

public class PlantSettings {
    private double weight; // Вес растения, кг
    private int maxCountPerCell; // Максимальное количество растений на одной клетке

    public PlantSettings(double weight, int maxCountPerCell) {
        this.weight = weight;
        this.maxCountPerCell = maxCountPerCell;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCountPerCell() {
        return maxCountPerCell;
    }
}
