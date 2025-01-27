package entity.creature.animals;

import entity.CreatureType;
import entity.creature.animals.herbivore.*;
import entity.creature.animals.predator.*;

public class AnimalFabric extends Animal {

    public AnimalFabric(CreatureType creatureType) {
        super(creatureType);
    }

    public static Animal createAnimal(CreatureType type){

        switch (type){

            case WOLF:
                return new Wolf();
            case FOX:
                return new Fox();
            case EAGLE:
                return new Eagle();
            case BOA_CONSTRICTOR:
                return new BoaConstrictor();
            case BEAR:
                return new Bear();
            case HORSE:
                return new Horse();
            case MOUSE:
                return new Mouse();
            case RABBIT:
                return new Rabbit();
            case SHEEP:
                return new Sheep();
            case GOAT:
                return new Goat();
            case DUCK:
                return new Duck();
            case DEER:
                return new Deer();
            case CATERPILLAR:
                return new Caterpillar();
            case BUFFALO:
                return new Buffalo();
            case BOAR:
                return new Boar();
            default:
                throw new IllegalArgumentException("Unknown animal type: " + type);
        }
    }
}
