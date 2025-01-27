package entity.creature.animals.herbivore;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Horse extends Herbivore {

    Settings set = new Settings();

    public Horse() {
        super(CreatureType.HORSE, Settings.getHerbivoreSettings(CreatureType.HORSE));
        AnimalSettings settings = Settings.getHerbivoreSettings(CreatureType.HORSE);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
