import java.util.Random;

class PlayerHealth {
    static int hp = 100, damageNum;
    static Random rand = new Random();

    // damage to player
    public static void playerDamaged()
    {
        damageNum = 0;
        damageNum = rand.nextInt(15) + 5;
        hp -= damageNum;
        System.out.println("You lost " + damageNum + " health.\n Current health: " + hp);
    }
    // kill the player
    public static void killPlayer()
    {
        hp -= 101;
    }

}