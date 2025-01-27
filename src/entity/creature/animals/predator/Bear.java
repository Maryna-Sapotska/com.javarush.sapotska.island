package entity.creature.animals.predator;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Bear extends Predator {

    Settings set = new Settings();

    public Bear() {
        super(CreatureType.BEAR, Settings.getPredatorSettings(CreatureType.BEAR));
        AnimalSettings settings = Settings.getPredatorSettings(CreatureType.BEAR);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
