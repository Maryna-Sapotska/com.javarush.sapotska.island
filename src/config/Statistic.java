package config;

import entity.CreatureType;
import entity.creature.animals.Animal;
import entity.island.Island;
import entity.island.Location;

import java.util.HashMap;
import java.util.Map;

public class Statistic implements Runnable {
    public Statistic(Island island) {
        this.island = island;
    }

    Island island;

    @Override
    public void run() {
        System.out.println("Island Statistics:");
        for (int y = 0; y < island.getColumns(); y++) {
            for (int x = 0; x < island.getRows(); x++) {
                Location location = island.getLocation(x, y);
                System.out.println("Животные на локации: ");
                printAnimalStats(location);
                System.out.println("Растения на локации: " + location.getPlants().size());
//                CircleLife circleLife = new CircleLife(island);
//                circleLife.start();
                //circleLife.run();
            }
        }
    }

    private void printAnimalStats(Location location) {
        // Считаем количество животных каждого типа на локации
        Map<CreatureType, Integer> animalCounts = countAnimals(location);

        for (Map.Entry<CreatureType, Integer> entry : animalCounts.entrySet()) {
            String unicode = entry.getKey().getUnicode();
            int count = entry.getValue();
            System.out.println(unicode + " (" + entry.getKey() + "): " + count);
        }
    }

    // Метод для подсчета животных на локации
    private Map<CreatureType, Integer> countAnimals(Location location) {
        Map<CreatureType, Integer> animalCounts = new HashMap<>();

        for (Animal animal : location.getAnimals()) {
            CreatureType type = animal.getCreatureType();
            animalCounts.put(type, animalCounts.getOrDefault(type, 0) + 1);
        }
        return animalCounts;
    }
}
