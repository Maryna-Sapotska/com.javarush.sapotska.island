package entity.creature.animals.predator;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Eagle extends Predator {

    Settings set = new Settings();

    public Eagle() {
        super(CreatureType.EAGLE, Settings.getPredatorSettings(CreatureType.EAGLE));
        AnimalSettings settings = Settings.getPredatorSettings(CreatureType.EAGLE);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
