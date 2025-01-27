package entity.creature.animals.herbivore;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Duck extends Herbivore {

    Settings set = new Settings();

    public Duck() {
        super(CreatureType.DUCK, Settings.getHerbivoreSettings(CreatureType.DUCK));
        AnimalSettings settings = Settings.getHerbivoreSettings(CreatureType.DUCK);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
