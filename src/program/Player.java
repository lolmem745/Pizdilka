package program;

import java.util.Random;

public class Player implements HaveHealthPoints{
    protected static long playerId;
    private final long id;
    protected String name;
    private final double damage;
    private double hp;
    private final double maxHp;
    Random random = new Random();

    static {
        playerId = 1L;
    }
    protected Player(String name, double hp, double damage){
        this.id = playerId++;

        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.maxHp = hp;
    }

    public void atack (Player player){
        if (player.isDead()){
            System.out.println();
            System.out.println("Зачем бить труп " + player.name + ". Не издевайтесь над телами погибших, пожалуйста.");
        } else {
            double damage = this.damage * random.nextInt(60, 101) / 100;
            player.hp -= damage;
            if (player.isDead()) {
                System.out.println(player.name + " совсем ослаб и умер, получив " + String.format("%.2f", damage) + " урона");
            } else {
                System.out.println(this.name + " ударил " + player.name + " с силой равной где-то " + String.format("%.2f", damage));
                System.out.println("У " + player.name + " осталось " + String.format("%.1f", player.hp));
            }
        }
        Render render = new Render();
        render.viewBar(player);
        System.out.println();
    }
    public boolean isDead()
    {
        return this.hp <= 0;
    }
    public void resetHp()
    {
        this.hp = maxHp;
    }
    @Override
    public double getMaxHealthPoints() {
        return this.maxHp;
    }

    public double getCurrentHealthPoints() {
        return this.hp;
    }
}

