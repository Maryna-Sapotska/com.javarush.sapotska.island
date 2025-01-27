package entity.creature.animals;

import config.AnimalSettings;
import config.Settings;
import entity.Creature;
import entity.CreatureType;
import entity.creature.animals.herbivore.Herbivore;
import entity.creature.animals.predator.Predator;
import entity.creature.plants.Plants;
import entity.island.Island;
import entity.island.Location;

import java.util.Random;


public abstract class Animal extends Creature {


    private double hunger;      // Уровень голода
    private double hungerThreshold; // Порог голода для смерти
    private double weight;      // Вес животного
    public boolean isAlive = true;    // Живое ли животное

    private AnimalSettings animalSettings; // Настройки для животного

    public Animal(CreatureType creatureType) {
        super(creatureType);
    }

    public double getWeight() {
        return weight;
    }
//
//    public Animal(CreatureType creatureType) {
//        this(creatureType, 0, false);
//    }

    public AnimalSettings getSettings() {
        return animalSettings;
    }

    public Animal(CreatureType species, int hungerThreshold, boolean b) {
        super(species);
    }

    public void updateHunger() {
        if (!isAlive) return;  // Если животное мертвое, не обновляем голод

        hunger += 10; // Увеличиваем уровень голода (можно настроить скорость)

        if (hunger >= hungerThreshold) {
            // Животное умирает от голода
            isAlive = false;
            System.out.println(this.getCreatureType() + " has died from hunger.");
        } else {
            // Если животное не поело, оно теряет вес
            double weightLoss = animalSettings.getFoodRequirement() * (hunger / hungerThreshold);
            weight -= weightLoss;
            if (weight <= 0) {
                isAlive = false;
                System.out.println(this.getCreatureType() + " has died due to starvation (weight reached zero).");
            }
        }
    }

    public void eat(Location location) {
        hunger = 0.0;
        weight = animalSettings.getWeight(); // Устанавливаем начальный вес из настроек
        hungerThreshold = 100.0; // Устанавливаем порог голода (можно настроить)
        if (this instanceof Herbivore) {
            eatPlants(location);
        } else if (this instanceof Predator) {
            animalSettings = Settings.getPredatorSettings(this.getCreatureType());
            eatAnimals(location);
        }
        // После поедания уменьшаем голод
        hunger = Math.max(0, hunger - animalSettings.getFoodRequirement()); // Уменьшаем голод, но не ниже 0
        if (hunger == 0) {
            System.out.println(this.getCreatureType() + " is no longer hungry.");
        }
    }

    private void eatPlants(Location location) {
        if (!location.getPlants().isEmpty() && hunger > 0.0) {
            Plants plant = location.getPlants().get(0); // Берем первое растение
            double plantWeight = plant.getWeight();
            if (plantWeight > 0) {
                // Съедаем растение
                location.removePlants(plant);
                System.out.println(getCreatureType() + " съел растение!");
                hunger = Math.max(0, hunger - animalSettings.getFoodRequirement()); // Уменьшаем голод
                weight += plant.getWeight(); // Увеличиваем вес после поедания
            }
        }
    }

    // Метод поедания животных (для хищников)
    private void eatAnimals(Location location) {
        if (!location.getAnimals().isEmpty() && hunger > 0.0) {
            for (Animal prey : location.getAnimals()) {
                // Проверяем, если животное травоядное и хищник может его съесть
                if (prey instanceof Herbivore) {
                    double probability = Settings.getEatingProbability(this.getCreatureType(), prey.getCreatureType());
                    if (Math.random() * 100 < probability) {
                        // Съедаем травоядное животное
                        location.removeAnimal(prey);
                        System.out.println(getCreatureType() + " съел " + prey.getCreatureType());
                        hunger = Math.max(0, hunger - animalSettings.getFoodRequirement()); // Уменьшаем голод
                        weight += prey.getWeight(); // Увеличиваем вес после поедания
                        break;
                    }
                }
            }
        }
    }


    public void move(Location location, Island destination) {
        //в соседние локации
        // Перемещаемся на соседнюю локацию
        Random rand = new Random();
        int dx = rand.nextInt(3) - 1;  // -1, 0, 1
        int dy = rand.nextInt(3) - 1;  // -1, 0, 1

        Location newLocation = destination.getLocation(location.getRows() + dx, location.getColumns() + dy);
        if (newLocation != null) {
            location.removeAnimal(this);
            newLocation.addAnimal(this);
        }
    }

    public void multiply(Location location) {
        // Считаем количество животных того же типа на локации
        long count = location.getAnimals().stream()
                .filter(animal -> animal.getCreatureType().equals(this.getCreatureType()))
                .count();

        // Если на локации есть хотя бы 2 одинаковых животных, они могут размножаться
        if (count >= 2) {
            // Создаем нового детеныша того же типа
            Animal offspring = createOffspring();
            location.addAnimal(offspring);  // Добавляем нового детеныша на локацию
            System.out.println("New animal: " + offspring.getCreatureType());
        }
    }

    // Метод для создания детеныша (можно переопределить в классах-наследниках)
    protected Animal createOffspring() {
        try {
            return this.getClass().getDeclaredConstructor().newInstance(); // Создаем новый объект того же типа
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при создании детеныша", e);
        }
    }
}
