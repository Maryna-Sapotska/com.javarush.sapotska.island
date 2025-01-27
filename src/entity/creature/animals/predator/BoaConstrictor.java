package entity.creature.animals.predator;

import config.AnimalSettings;
import config.Settings;
import entity.CreatureType;

public class BoaConstrictor extends Predator {

    Settings set = new Settings();

    public BoaConstrictor() {
        super(CreatureType.BOA_CONSTRICTOR, Settings.getPredatorSettings(CreatureType.BOA_CONSTRICTOR));
        AnimalSettings settings = Settings.getPredatorSettings(CreatureType.BOA_CONSTRICTOR);
        setWeight(settings.getWeight());
        setMaxCountPerCell(settings.getMaxCountPerCell());
        setMaxSpeed(settings.getMaxSpeed());
        setFoodRequirement(settings.getFoodRequirement());
    }
}
