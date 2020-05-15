package srpfacadelab;

public class playerHealth {

    RpgPlayer player;

    playerHealth(RpgPlayer player) {
        this.player = player;
    }

    public void takeDamage(int damage) {
        if (damage < player.getArmour()) {
            player.getEngine().playSpecialEffect("parry");
        }

        int damageToDeal = damage - player.getArmour();
        player.setHealth(player.getHealth() - damageToDeal);

        player.getEngine().playSpecialEffect("lots_of_gore");
    }

    
}