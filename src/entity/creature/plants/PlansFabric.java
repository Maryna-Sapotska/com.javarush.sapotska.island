package entity.creature.plants;

import config.Settings;
import entity.CreatureType;

public class PlansFabric {

    Settings set = new Settings();

    public static Plants createPlant(CreatureType name) {
        if (Settings.getPlantSettings(name) != null) {
            return new Plants(name);
        }
        return null; // Если растения с таким именем нет
    }
}
