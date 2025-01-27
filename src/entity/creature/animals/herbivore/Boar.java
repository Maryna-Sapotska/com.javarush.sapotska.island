package entity.creature.animals.herbivore;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Boar extends Herbivore {

    Settings set = new Settings();

    public Boar() {
        super(CreatureType.BOAR, Settings.getHerbivoreSettings(CreatureType.BOAR));
        AnimalSettings settings = Settings.getHerbivoreSettings(CreatureType.BOAR);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
