package entity.creature.animals.herbivore;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Rabbit extends Herbivore {

    Settings set = new Settings();

    public Rabbit() {
        super(CreatureType.RABBIT, Settings.getHerbivoreSettings(CreatureType.RABBIT));
        AnimalSettings settings = Settings.getHerbivoreSettings(CreatureType.RABBIT);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
