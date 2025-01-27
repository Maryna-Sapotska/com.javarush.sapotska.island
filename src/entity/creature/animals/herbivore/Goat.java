package entity.creature.animals.herbivore;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Goat extends Herbivore {

    Settings set = new Settings();

    public Goat() {
        super(CreatureType.GOAT, Settings.getHerbivoreSettings(CreatureType.GOAT));
        AnimalSettings settings = Settings.getHerbivoreSettings(CreatureType.GOAT);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
