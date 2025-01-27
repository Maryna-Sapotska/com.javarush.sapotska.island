package entity.creature.animals.herbivore;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Deer extends Herbivore {

    Settings set = new Settings();

    public Deer() {
        super(CreatureType.DEER, Settings.getHerbivoreSettings(CreatureType.DEER));
        AnimalSettings settings = Settings.getHerbivoreSettings(CreatureType.DEER);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
