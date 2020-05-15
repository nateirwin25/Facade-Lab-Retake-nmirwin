package srpfacadelab;

public class PlayerFacade {

    private RpgPlayer player;
    private playerHealth health;
    private PlayerInventory inventory;

    public PlayerFacade(IGameEngine engine) {
        this.player = new RpgPlayer(engine);
        this.health = new playerHealth(player);
        this.inventory = new PlayerInventory(player);
    }

    public void takeDamage(int damage) {
        health.takeDamage(damage);
    }

    public boolean pickUpItem(Item item) {
        return inventory.pickUpItem(item);
    }

    public void useItem(Item item) {
        inventory.useItem(item);
    }

    
    /* 
     * The following accessor/modifier methods should be public based on use case.
     * The chosen below are based on what was originally public in RpgPlayer class.
     */
    public int getHealth() {
        return player.getHealth();
    }

    public void setHealth(int health) {
        player.setHealth(health);
    }

    public int getMaxHealth() {
        return player.getMaxHealth();
    }

    public void setMaxHealth(int maxHealth) {
        player.setMaxHealth(maxHealth);
    }

    public int getArmour() {
        return player.getArmour();
    }

    public int getCarryingCapacity() {
        return player.getCarryingCapacity();
    }

}