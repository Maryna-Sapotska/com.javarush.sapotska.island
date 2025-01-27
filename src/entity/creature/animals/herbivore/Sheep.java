package entity.creature.animals.herbivore;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Sheep extends Herbivore {

    Settings set = new Settings();

    public Sheep() {
        super(CreatureType.SHEEP, Settings.getHerbivoreSettings(CreatureType.SHEEP));
        AnimalSettings settings = Settings.getHerbivoreSettings(CreatureType.SHEEP);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
