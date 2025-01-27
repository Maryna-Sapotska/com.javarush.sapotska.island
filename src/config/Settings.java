package config;

import entity.CreatureType;

import java.util.HashMap;
import java.util.Map;

public class Settings {

    public final static int ROWS = 1;
    public final static int COLUMNS = 1;

    // Map для хранения характеристик хищников
    private static final Map<CreatureType, AnimalSettings> predatorSettingsMap = new HashMap<>();

    // Map для хранения характеристик травоядных
    private static final Map<CreatureType, AnimalSettings> herbivoreSettingsMap = new HashMap<>();

    // Map для хранения характеристик растений
    private static final Map<CreatureType, PlantSettings> plantSettingsMap = new HashMap<>();

    // Map для хранения вероятностей поедания
    private static final Map<CreatureType, Map<CreatureType, Double>> eatingProbabilities = new HashMap<>();

    public static final int maxCountPerCellWolf = 30;
    public static final int maxCountPerCellBoaConstrictor = 30;
    public static final int maxCountPerCellFox = 30;
    public static final int maxCountPerCellBear = 5;
    public static final int maxCountPerCellEagle = 20;
    public static final int maxCountPerCellHorse = 20;
    public static final int maxCountPerCellDeer = 20;
    public static final int maxCountPerCellRabbit = 150;
    public static final int maxCountPerCellMouse = 500;
    public static final int maxCountPerCellGoat = 140;
    public static final int maxCountPerCellSheep = 140;
    public static final int maxCountPerCellBoar = 50;
    public static final int maxCountPerCellBuffalo = 10;
    public static final int maxCountPerCellDuck = 200;
    public static final int maxCountPerCellCaterpillar = 1000;
    public static final int maxCountPerCellPlant = 200;


    {
        predatorSettingsMap.put(CreatureType.WOLF, new AnimalSettings(50, 30, 3, 8));   // Волк
        predatorSettingsMap.put(CreatureType.BOA_CONSTRICTOR, new AnimalSettings(15, 30, 1, 3)); // Удав
        predatorSettingsMap.put(CreatureType.FOX, new AnimalSettings(8, 30, 2, 2)); // Лиса
        predatorSettingsMap.put(CreatureType.BEAR, new AnimalSettings(500, 5, 2, 80)); // Медведь
        predatorSettingsMap.put(CreatureType.EAGLE, new AnimalSettings(6, 20, 3, 1)); // Орел

        herbivoreSettingsMap.put(CreatureType.HORSE, new AnimalSettings(400, 20, 4, 60)); // Лошадь
        herbivoreSettingsMap.put(CreatureType.DEER, new AnimalSettings(300, 20, 4, 50)); // Олень
        herbivoreSettingsMap.put(CreatureType.RABBIT, new AnimalSettings(2, 150, 2, 0.45)); // Кролик
        herbivoreSettingsMap.put(CreatureType.MOUSE, new AnimalSettings(0.05, 500, 1, 0.01)); // Мышь
        herbivoreSettingsMap.put(CreatureType.GOAT, new AnimalSettings(60, 140, 3, 10)); // Коза
        herbivoreSettingsMap.put(CreatureType.SHEEP, new AnimalSettings(70, 140, 3, 15)); // Овца
        herbivoreSettingsMap.put(CreatureType.BOAR, new AnimalSettings(400, 50, 2, 50)); // Кабан
        herbivoreSettingsMap.put(CreatureType.BUFFALO, new AnimalSettings(700, 10, 3, 100)); // Буйвол
        herbivoreSettingsMap.put(CreatureType.DUCK, new AnimalSettings(1, 200, 4, 0.15)); // Утка
        herbivoreSettingsMap.put(CreatureType.CATERPILLAR, new AnimalSettings(0.01, 1000, 0, 0)); // Гусеница

        plantSettingsMap.put(CreatureType.PLANT, new PlantSettings(1, 200));

        initializeEatingProbabilities();
    }

    private void initializeEatingProbabilities() {
        eatingProbabilities.put(CreatureType.WOLF, createEatingProbabilities(0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0));
        eatingProbabilities.put(CreatureType.BOA_CONSTRICTOR, createEatingProbabilities(0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0));
        eatingProbabilities.put(CreatureType.FOX, createEatingProbabilities(0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0));
        eatingProbabilities.put(CreatureType.BEAR, createEatingProbabilities(0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0));
        eatingProbabilities.put(CreatureType.EAGLE, createEatingProbabilities(0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0));
        eatingProbabilities.put(CreatureType.HORSE, createEatingProbabilities(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0));
        eatingProbabilities.put(CreatureType.DEER, createEatingProbabilities(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0));
        eatingProbabilities.put(CreatureType.RABBIT, createEatingProbabilities(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0));
        eatingProbabilities.put(CreatureType.MOUSE, createEatingProbabilities(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 0));
        eatingProbabilities.put(CreatureType.GOAT, createEatingProbabilities(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0));
        eatingProbabilities.put(CreatureType.SHEEP, createEatingProbabilities(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0));
        eatingProbabilities.put(CreatureType.BOAR, createEatingProbabilities(0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90, 0));
        eatingProbabilities.put(CreatureType.BUFFALO, createEatingProbabilities(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0));
        eatingProbabilities.put(CreatureType.DUCK, createEatingProbabilities(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 0));
        eatingProbabilities.put(CreatureType.CATERPILLAR, createEatingProbabilities(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0));

        eatingProbabilities.put(CreatureType.PLANT, new HashMap<>());
    }

    private Map<CreatureType, Double> createEatingProbabilities(double... probabilities) {
        Map<CreatureType, Double> probabilitiesMap = new HashMap<>();
        CreatureType[] animals = {CreatureType.WOLF, CreatureType.BOA_CONSTRICTOR, CreatureType.FOX, CreatureType.BEAR, CreatureType.EAGLE, CreatureType.HORSE, CreatureType.DEER, CreatureType.RABBIT, CreatureType.MOUSE, CreatureType.GOAT, CreatureType.SHEEP, CreatureType.BOAR, CreatureType.BUFFALO, CreatureType.DUCK, CreatureType.CATERPILLAR, CreatureType.PLANT};
        //AnimalType[] animals = {"Wolf", "BoaConstrictor", "Fox", "Bear", "Eagle", "Horse", "Deer", "Rabbit", "Mouse", "Goat", "Sheep", "WildBoar", "Buffalo", "Duck", "Caterpillar", "Plant"};

        for (int i = 0; i < animals.length; i++) {
            probabilitiesMap.put(animals[i], probabilities[i]);
        }
        return probabilitiesMap;
    }

    public static AnimalSettings getPredatorSettings(CreatureType animalName) {
        return predatorSettingsMap.get(animalName);
    }

    public static AnimalSettings getHerbivoreSettings(CreatureType animalName) {
        return herbivoreSettingsMap.get(animalName);
    }

    public static PlantSettings getPlantSettings(CreatureType plantName) {
        return plantSettingsMap.get(plantName);
    }

    // Метод для получения вероятности поедания (поедание другого животного)
    public static double getEatingProbability(CreatureType predator, CreatureType prey) {
        Map<CreatureType, Double> predatorProbabilities = eatingProbabilities.get(predator);
        if (predatorProbabilities != null) {
            return predatorProbabilities.getOrDefault(prey, 0.0);
        }
        return 0.0;
    }

}
