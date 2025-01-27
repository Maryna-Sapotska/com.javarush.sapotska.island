package entity.creature.animals.herbivore;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class Caterpillar extends Herbivore {

    Settings set = new Settings();

    public Caterpillar() {
        super(CreatureType.CATERPILLAR, Settings.getHerbivoreSettings(CreatureType.CATERPILLAR));
        AnimalSettings settings = Settings.getHerbivoreSettings(CreatureType.CATERPILLAR);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
