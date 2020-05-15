package srpfacadelab;

import java.util.List;

public class PlayerInventory {

    RpgPlayer player;

    PlayerInventory(RpgPlayer player) {
        this.player = player;
    }

    private int calculateInventoryWeight() {
        int sum=0;
        for (Item i: player.getInventory()) {
            sum += i.getWeight();
        }
        return sum;
    }

    protected boolean pickUpItem(Item item) {
        int weight = calculateInventoryWeight();
        if (weight + item.getWeight() > player.getCarryingCapacity())
            return false;

        if (item.isUnique() && checkIfItemExistsInInventory(item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth(player.getHealth() + item.getHeal());

            if (player.getHealth() > player.getMaxHealth())
                player.setHealth(player.getMaxHealth());;

            if (item.getHeal() > 500) {
                player.getEngine().playSpecialEffect("green_swirly");
            }

            return true;
        }

        if (item.isRare())
            player.getEngine().playSpecialEffect("cool_swirly_particles");

        player.getInventory().add(item);

        calculateStats();

        return true;
    }

    private void calculateStats() {
        int armour = player.getArmour();

        for (Item i: player.getInventory()) {
            armour += i.getArmour();
        }

        player.setArmour(armour);
    }

    private boolean checkIfItemExistsInInventory(Item item) {
        for (Item i: player.getInventory()){
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    protected void useItem(Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = player.getEngine().getEnemiesNear(player);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }
    
}