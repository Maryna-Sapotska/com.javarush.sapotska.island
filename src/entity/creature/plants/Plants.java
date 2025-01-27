package entity.creature.plants;

import entity.Creature;
import entity.CreatureType;

import java.util.Random;

public class Plants extends Creature {
    private CreatureType name;
    private double weight = 1;

    public Plants(double weight, CreatureType name) {
        this.weight = weight;
        this.name = name;
    }

    public Plants(CreatureType animalType) {
    }

    public CreatureType getName() {
        return name;
    }

    public void setName(CreatureType name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public static Plants multiply() {
        Random rand = new Random();
        // Растение вырастает с некоторой вероятностью
        if (rand.nextInt(10) > 5) {
            return new Plants(CreatureType.PLANT);
        }
        return null;
    }


}
