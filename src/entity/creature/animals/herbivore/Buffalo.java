package entity.creature.animals.herbivore;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Buffalo extends Herbivore {

    Settings set = new Settings();

    public Buffalo() {
        super(CreatureType.BUFFALO, Settings.getHerbivoreSettings(CreatureType.BUFFALO));
        AnimalSettings settings = Settings.getHerbivoreSettings(CreatureType.BUFFALO);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
