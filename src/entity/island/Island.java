package entity.island;

import config.Settings;
import entity.CreatureType;
import entity.creature.animals.Animal;
import entity.creature.animals.AnimalFabric;
import entity.creature.plants.PlansFabric;
import entity.creature.plants.Plants;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Island {

    private int rows;
    private int columns;
    private Location[][] locations;
    private Random random = new Random();
    private ScheduledExecutorService scheduler;

    private Plants plants = PlansFabric.createPlant(CreatureType.PLANT);

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Island(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.locations = new Location[columns][rows];

        initializeLocations();
        this.scheduler = Executors.newScheduledThreadPool(3);
    }

    private void initializeLocations() {
        for (int y = 0; y < columns; y++) {
            for (int x = 0; x < rows; x++) {
                Location location = new Location(x, y);
                addRandomCreaturesToLocation(location);
                locations[y][x] = location;
            }
        }
    }

    private void addRandomCreaturesToLocation(Location location) {
        addRandomAnimal(location, CreatureType.WOLF, Settings.maxCountPerCellWolf);
        addRandomAnimal(location, CreatureType.FOX, Settings.maxCountPerCellFox);
        addRandomAnimal(location, CreatureType.EAGLE, Settings.maxCountPerCellEagle);
        addRandomAnimal(location, CreatureType.BOA_CONSTRICTOR, Settings.maxCountPerCellBoaConstrictor);
        addRandomAnimal(location, CreatureType.BEAR, Settings.maxCountPerCellBear);
        addRandomAnimal(location, CreatureType.HORSE, Settings.maxCountPerCellHorse);
        addRandomAnimal(location, CreatureType.MOUSE, Settings.maxCountPerCellMouse);
        addRandomAnimal(location, CreatureType.RABBIT, Settings.maxCountPerCellRabbit);
        addRandomAnimal(location, CreatureType.SHEEP, Settings.maxCountPerCellSheep);
        addRandomAnimal(location, CreatureType.BOAR, Settings.maxCountPerCellBoar);
        addRandomAnimal(location, CreatureType.BUFFALO, Settings.maxCountPerCellBuffalo);
        addRandomAnimal(location, CreatureType.CATERPILLAR, Settings.maxCountPerCellCaterpillar);
        addRandomAnimal(location, CreatureType.DEER, Settings.maxCountPerCellDeer);
        addRandomAnimal(location, CreatureType.DUCK, Settings.maxCountPerCellDuck);
        addRandomAnimal(location, CreatureType.GOAT, Settings.maxCountPerCellGoat);
        addRandomPlant(location, CreatureType.PLANT, Settings.maxCountPerCellPlant);
    }

    private void addRandomAnimal(Location location, CreatureType animalType, int maxCount) {
        int randomCount = random.nextInt(maxCount + 1);
        for (int i = 0; i < randomCount; i++) {
            Animal animals = AnimalFabric.createAnimal(animalType);
            location.addAnimal(animals);
        }
    }

    private void addRandomPlant(Location location, CreatureType plantType, int maxCount) {
        int randomCount = random.nextInt(maxCount + 1);
        for (int i = 0; i < randomCount; i++) {
            Plants plants1 = PlansFabric.createPlant(plantType);
            location.addPlants(plants1);
        }
    }

    public Location getLocation(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < columns) {
            return locations[y][x];
        }
        return null;
    }

//    public void start() {
//        // Планируем выполнение задач через определенные интервалы
//        scheduler.scheduleAtFixedRate(this::growPlants, 0, 10, TimeUnit.SECONDS); // Задача роста растений
//        scheduler.scheduleAtFixedRate(new CircleLife(this), 0, 1, TimeUnit.SECONDS);   // Задача жизненного цикла животных
//        scheduler.scheduleAtFixedRate(new Statistic(this), 0, 10, TimeUnit.SECONDS); // Задача вывода статистики
//    }

    private void growPlants() {
        for (int y = 0; y < columns; y++) {
            for (int x = 0; x < rows; x++) {
                Location location = getLocation(x, y);
                Plants newPlant = Plants.multiply();
                if (newPlant != null) {
                    location.addPlants(newPlant);
                }
            }
        }
    }

    public void shutdown() {
        scheduler.shutdown();
    }


}
