package entity.creature.animals.herbivore;

import config.AnimalSettings;
import entity.CreatureType;
import entity.creature.animals.Animal;

public class Herbivore extends Animal {
    public Herbivore(CreatureType species, int hungerThreshold) {
        super(species, hungerThreshold, false);
    }

    public Herbivore(CreatureType animalType, AnimalSettings herbivoreSettings) {
        super(animalType);
    }

    void setFoodRequirement(double foodRequirement) {
    }

    void setMaxSpeed(int maxSpeed) {
    }

    void setMaxCountPerCell(int maxCountPerCell) {
    }

    void setWeight(double weight) {
    }

}

