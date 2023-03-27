package program;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class program {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Random random = new Random();
        int figters = 6;
        int firstPlayer;
        int secondPlayer;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < figters; i++) {
            int temp = random.nextInt(3);

            if (temp == 0) {
                players.add(new Tank("Tank-" + (i + 1)));
            } else if (temp == 1) {
                players.add(new Seluk("Seluk-" + (i + 1)));
            } else if (temp == 2) {
                players.add(new Rogue("Rogue-" + (i + 1)));
            }
        }
        while (players.size() > 1) {
            firstPlayer = random.nextInt(players.size());
            secondPlayer = random.nextInt(players.size());


            while (firstPlayer == secondPlayer) {
                secondPlayer = random.nextInt(players.size());
            }
            if (fight(players.get(firstPlayer), players.get(secondPlayer))) {
                System.out.print(players.get(firstPlayer).name);
                players.get(firstPlayer).resetHp();
                players.remove(secondPlayer);
            } else {
                System.out.print(players.get(secondPlayer).name);
                players.get(secondPlayer).resetHp();
                players.remove(firstPlayer);
            }
            if (players.size() == 1){
                System.out.println(" всех отпиздил, красавчик!");
                System.out.println();
            } else {System.out.println(" отпиздил своего оппонента!");
                System.out.println();}
        }
        scanner.close();
    }


    public static boolean fight(Player firstFighter, Player secondFighter) {
        while (true) {
            firstFighter.atack(secondFighter);

            if (secondFighter.isDead()) {
                return true;
            } else {
                secondFighter.atack(firstFighter);

                if (firstFighter.isDead()) {
                    return false;
                }
            }
        }
    }
}