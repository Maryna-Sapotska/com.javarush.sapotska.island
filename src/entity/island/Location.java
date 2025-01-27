package entity.island;

import entity.creature.animals.Animal;
import entity.creature.plants.Plants;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private int rows;
    private int columns;
    private List<Animal> animals;
    private List<Plants> plants;


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Location(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.animals = new ArrayList<>();
        this.plants = new ArrayList<>();
    }

    public List<Plants> getPlants() {
        return plants;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void addPlants(Plants plant) {
        plants.add(plant);
    }

    public void removePlants(Plants plant) {
        plants.remove(plant);
    }

}
