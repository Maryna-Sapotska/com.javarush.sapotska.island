package config;

public class AnimalSettings {

    private double weight; // Вес животного, кг
    private int maxCountPerCell; // Максимальное количество животных на одной клетке
    private int maxSpeed; // Максимальная скорость перемещения (клетки за ход)
    private double foodRequirement; // Сколько килограммов пищи нужно для насыщения

    public AnimalSettings(double weight, int maxCountPerCell, int maxSpeed, double foodRequirement) {
        this.weight = weight;
        this.maxCountPerCell = maxCountPerCell;
        this.maxSpeed = maxSpeed;
        this.foodRequirement = foodRequirement;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCountPerCell() {
        return maxCountPerCell;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getFoodRequirement() {
        return foodRequirement;
    }
}
