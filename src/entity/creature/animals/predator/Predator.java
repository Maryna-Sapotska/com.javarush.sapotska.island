package entity.creature.animals.predator;
import config.AnimalSettings;
import entity.CreatureType;
import entity.creature.animals.Animal;

public class Predator extends Animal {
    public Predator(CreatureType species, int hungerThreshold, boolean b) {
        super(species, hungerThreshold, b);
    }

    public Predator(CreatureType animalType, AnimalSettings predatorSettings) {
        super(animalType);
    }

    void setFoodRequirement(double foodRequirement) {
    }

    void setMaxSpeed(int maxSpeed) {
    }

    void setMaxCountPerCell(int maxCountPerCell) {
    }

//    @Override
//    public void eat(Location location) {
//        for (Animal animal : location.getAnimals()) {
//            if (animal instanceof Herbivore && animal.isAlive) {
//                Double probability = Settings.getEatingProbability(this.name, animal.name);
//                if (probability != null && Math.random() < probability / 100.0) {
//                    location.removeAnimal(animal);
//                }
//                System.out.println(this.name + "съел" + animal.name);
//            }
//        }
//    }

    void setWeight(double weight) {
    }
}
