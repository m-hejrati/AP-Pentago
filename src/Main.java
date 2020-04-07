/**
 * this class run the game
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.05
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map myMap = new Map();

        System.out.println("Pentago Game");
        System.out.println("By Mahdi Hejrati 9723100\n");

        System.out.println("Enter first player name (white color):");
        Player p1 = new Player(input.next(), 1);

        System.out.println("Enter second player name (black color):");
        Player p2 = new Player(input.next(), 2);

        System.out.println("Game starts\n");
        System.out.println("Please choose a cell to put stone in \"I C form\" \t (I: an integer for row, C: a char in capital for column)");
        System.out.println("And then a block to spin in \"I C form\" \t\t\t\t (I: an integer for quadrant, C: a char in capital for spin direction between 'C' and 'O')");
        System.out.println("C: Clockwise \t O: Counterclockwise");
        System.out.println("Number of blocks are like coordinate system: \t\t\t\t\t\t 2 | 1");
        System.out.println("Note that you can write '0 C' to pass if there is an empty block: \t 3 | 4");

        System.out.println();
        myMap.printMap();

        boolean flag = true;
        // if our map has empty cell
        while (!myMap.isFull()) {

            if (finish(input, myMap, p1, p2)) {
                flag = false;
                break;
            }

            if (finish(input, myMap, p2, p1)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Finish");
            System.out.println("Draw");
        }
    }

    /**
     * this method is written to avoid code duplication
     * @param input in the method we get our inputs
     * @param myMap map of the game
     * @param firstPlayer first player
     * @return true if the game has not finish yet and false if finish
     */
    public static boolean playing(Scanner input, Map myMap, Player firstPlayer) {
        System.out.println(firstPlayer.getName() + " turn: (choose a cell to put stone)");
        // enter cell until it be correct
        while (!myMap.placeStone(firstPlayer, input.nextInt() - 1, (int) input.next().charAt(0) - 64 - 1)) ;
        myMap.printMap();
        // check if he win or not
        if (myMap.checkFinish(firstPlayer))
            return false;

        System.out.println(firstPlayer.getName() + " turn: (choose a block to spin)");
        // enter cell until it be correct
        while (!myMap.spin(input.nextInt(), input.next().charAt(0)));
        myMap.printMap();
        // check if he win or not
        if (myMap.checkFinish(firstPlayer))
            return false;

        return true;
    }

    /**
     * this method check if one player win or both of them has 5 stone in a row and print message
     * @param input in the method we get our inputs
     * @param myMap map of the game
     * @param firstPlayer first player
     * @param secondPlayer second player
     * @return true if game finish or false if not
     */
    public static boolean finish (Scanner input,Map myMap, Player firstPlayer, Player secondPlayer){
        if (!playing(input, myMap, firstPlayer)) {
            // in this state 5 stones of player 1 are in a row, check if the other player has or not
            if (myMap.checkFinish(secondPlayer)) {
                System.out.println("Finish");
                System.out.println("Draw");
                System.out.println("both players have 5 stones in a row");
                return true;
            } else {
                System.out.println("Finish");
                System.out.println("*" + firstPlayer.getName() + " win*");
                return true;
            }
        }
        return false;
    }
}