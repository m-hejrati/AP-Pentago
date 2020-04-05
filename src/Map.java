/**
 * this is the major class that hold the information of map
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.05
 */

public class Map {

    private int[][] map;

    /**
     * create the map
     */
    public Map() {
        map = new int[6][6];
    }


    public void print() {
        // print A to H character
        System.out.print("   ");
        for (int k = 65 ; k <= 70; k++) {
            System.out.print((char) k + " ");
            if (k == 67)
                System.out.print("  ");
        }
        System.out.println();

        for (int i = 0; i < 6; i++) {
            if (i == 3)
                System.out.println("   -------------");
                System.out.print(i + 1 + "  ");
            for (int j = 0; j < 6; j++) {
                if (map[i][j] == 1)
                    System.out.print('\u25cf' + " ");
                else if (map[i][j] == 2)
                    System.out.print('\u25cc' + " ");
                else
                    System.out.print("O ");
                if (j == 2)
                    System.out.print("| ");
            }
            System.out.println();
        }
        /*
        // print online result in the match
        System.out.print(p1.getName() + ": " + countColor(p1));
        System.out.println("    " + p2.getName() + ": " + countColor(p2));
        */
    }
}
