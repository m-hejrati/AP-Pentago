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

        System.out.println("Enter first player name (black color):");
        Player p1 = new Player(input.next(), 1);

        System.out.println("Enter second player name (white color):");
        Player p2 = new Player(input.next(), 2);

        System.out.println("Game starts");
        System.out.println("Please Choose your block in \"I C form\" (I: an integer for row, C: a char in capital for column)");
        System.out.println("And choose a quadrant to spin in ...");

        myMap.print();


    }
}
