package Exercises2_MultidimensionalArrays;

import java.util.Scanner;

public class P08TheHeiganDance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int playerRow = 7;
        int playerCol = 7;

        int playerPoints = 18500;
        double heiganPoints = 3000000;

        double damage = Double.parseDouble(scanner.nextLine());

        int cloudDamage = 3500;
        int eruption = 6000;

        String lastSpell = "";

        while (true) {

            if (playerPoints >= 0) {

                heiganPoints -= damage;
            }

            if (lastSpell.equals("Cloud")) {

                playerPoints -= 3500;
            }

            if (heiganPoints <= 0 || playerPoints <= 0) {

                break;
            }

            String[] input = scanner.nextLine().split("\\s+");

            String currentSpell = input[0];
            int targetRow = Integer.parseInt(input[1]);
            int targetCol = Integer.parseInt(input[2]);

            if (isInDamageArea(targetRow, targetCol, playerRow, playerCol)) {


                if (!isInDamageArea(targetRow, targetCol, playerRow - 1, playerCol) && !isWall(playerRow - 1)) {

                    playerRow--;
                    lastSpell = "";

                } else if (!isInDamageArea(targetRow, targetCol, playerRow, playerCol + 1) && !isWall(playerCol + 1)) {

                    playerCol++;
                    lastSpell = "";

                } else if (!isInDamageArea(targetRow, targetCol, playerRow + 1, playerCol) && !isWall(playerRow + 1)) {

                    playerRow++;
                    lastSpell = "";

                } else if (!isInDamageArea(targetRow, targetCol, playerRow, playerCol - 1) && !isWall(playerCol - 1)) {

                    playerCol--;
                    lastSpell = "";


                } else {

                    if (currentSpell.equals("Cloud")) {

                        playerPoints -= cloudDamage;

                        lastSpell = "Cloud";
                    } else if (currentSpell.equals("Eruption")) {

                        playerPoints -= eruption;

                        lastSpell = "Eruption";
                    }
                }
            }
        }

        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";

        String heiganState = heiganPoints <= 0 ? "Heigan: Defeated!" :
                String.format("Heigan: %.2f", heiganPoints);
        String playerState = playerPoints <= 0 ? String.format("Player: Killed by %s", lastSpell) :
                String.format("Player: %d", playerPoints);
        String playerEndCoordinates = String.format("Final position: %d, %d", playerRow, playerCol);

        System.out.println(heiganState);
        System.out.println(playerState);
        System.out.println(playerEndCoordinates);
    }


    private static boolean isWall(int moveCell) {

        return moveCell < 0 || moveCell >= 15;
    }

    private static boolean isInDamageArea(int targetRow, int targetCol, int moveRow, int moveCol) {

        return ((targetRow - 1 <= moveRow && moveRow <= targetRow + 1) &&
                targetCol - 1 <= moveCol && moveCol <= targetCol + 1);
    }
}
