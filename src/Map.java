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
//        map [0][0] = 2;
//        map [1][1] = 2;
//        map [2][2] = 2;
//        map [3][3] = 2;
//        map [4][4] = 2;
    }


    public boolean placeStone(Player player, int row, int column) {

        // if he entered correct, set his color to block.
        if (isInMap(row, column)) {
            map[row][column] = player.getColorCode();
            return true;
        } else {
            System.out.println("Please enter in the correct form");
            return false;
        }
    }


    public boolean checkFinish(Player player) {

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (checkAround(i, j, player.getColorCode()))
                    return true;
        return false;
    }


    public boolean checkAround(int i, int j, int colorCode) {
        if (checkDirection(-1, 1, i, j, colorCode))
            return true;
        if (checkDirection(0, 1, i, j, colorCode))
            return true;
        if (checkDirection(1, 1, i, j, colorCode))
            return true;
        if (checkDirection(1, 0, i, j, colorCode))
            return true;
        if (checkDirection(1, -1, i, j, colorCode))
            return true;
        if (checkDirection(0, -1, i, j, colorCode))
            return true;
        if (checkDirection(-1, -1, i, j, colorCode))
            return true;
        if (checkDirection(-1, 0, i, j, colorCode))
            return true;
        return false;
    }


    public boolean checkDirection(int k, int l, int i, int j, int colorCode) {
        int i2 = i + k, j2 = j + l;
        // check if it is in the map or not
        if (isInMap(i2, j2)) {
            int counter = 0;
            while ((map[i2][j2] == colorCode)) {
                // if there are five stone with his color in a row, he win
                if (++counter == 5)
                    return true;
                i2 = i2 + k;
                j2 = j2 + l;
                if (!isInMap(i2, j2))
                    return false;
            }
        }
        return false;
    }


    public boolean isInMap(int i, int j) {
        if (((i >= 0) && (i <= 5)) && ((j >= 0) && (j <= 5)))
            return true;
        else
            return false;
    }


    public int countColor (Player player) {
        int sum = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                if (map[i][j] == player.getColorCode())
                    sum++;
        return sum;
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
    }
}
