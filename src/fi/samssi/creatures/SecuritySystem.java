package fi.samssi.creatures;

public class SecuritySystem {
    private int shields;
    private int hullIntegrity;
    private final int collisionDamage;

    public SecuritySystem(final int shields, final int hullIntegrity, final int collisionDamage) {
        this.shields = shields;
        this.hullIntegrity = hullIntegrity;
        this.collisionDamage = collisionDamage;
    }

    public void registerCollision(final int collisionDamage) {
        System.err.println("collisionDamage: " + collisionDamage);
    }

    public int getCollisionDamage() {
        return collisionDamage;
    }

    public int getShields() {
        return shields;
    }

    public void setShields(final int shields) {
        this.shields = shields;
    }

    public int getHullIntegrity() {
        return hullIntegrity;
    }

    public void setHullIntegrity(final int hullIntegrity) {
        this.hullIntegrity = hullIntegrity;
    }

}
