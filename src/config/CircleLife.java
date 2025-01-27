package config;

import entity.creature.animals.Animal;
import entity.island.Island;
import entity.island.Location;

public class CircleLife {

    Island island;

    public CircleLife(Island island) {
        this.island = island;
    }


    public void start() {
        System.out.println("CircleLife task is running...");
        for (int y = 0; y < island.getRows(); y++) {
            for (int x = 0; x < island.getColumns(); x++) {
                Location location = island.getLocation(x, y);
                for (Animal animal : location.getAnimals()) {
                    if (animal.isAlive) {
                       // animal.eat(location);
                      //  animal.updateHunger();
                        //animal.move(location, this);
                        if (location.getAnimals().size() > 1) {
                            animal.multiply(location);
                        }
                    }
                }
            }
        }
    }
}
