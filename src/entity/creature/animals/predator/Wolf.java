package entity.creature.animals.predator;


import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Wolf extends Predator {

    Settings set = new Settings();

    public Wolf() {
        super(CreatureType.WOLF, Settings.getPredatorSettings(CreatureType.WOLF));
        AnimalSettings settings = Settings.getPredatorSettings(CreatureType.WOLF);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }

}
