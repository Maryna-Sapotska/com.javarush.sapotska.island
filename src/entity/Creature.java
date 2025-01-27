package entity;

public abstract class Creature {
    private CreatureType creatureType;

    public Creature (CreatureType creatureType) {
        this.creatureType = creatureType;
    }

    public Creature() {

    }

    public CreatureType getCreatureType() {
        return creatureType;
    }

}
