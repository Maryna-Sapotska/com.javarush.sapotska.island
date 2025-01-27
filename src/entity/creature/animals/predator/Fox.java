package entity.creature.animals.predator;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Fox extends Predator {

    Settings set = new Settings();

    public Fox() {
        super(CreatureType.FOX, Settings.getPredatorSettings(CreatureType.FOX));
        AnimalSettings settings = Settings.getPredatorSettings(CreatureType.FOX);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
