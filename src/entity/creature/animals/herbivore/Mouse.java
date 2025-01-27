package entity.creature.animals.herbivore;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Mouse extends Herbivore {

    Settings set = new Settings();

    public Mouse() {
        super(CreatureType.MOUSE, Settings.getHerbivoreSettings(CreatureType.MOUSE));
        AnimalSettings settings = Settings.getHerbivoreSettings(CreatureType.MOUSE);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
