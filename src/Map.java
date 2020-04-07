/**
 * this is the major class that hold the information of map
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.05
 */

public class Map {

    private int[][] map;

    /**
     * constructor to create the map
     */
    public Map() {
        map = new int[6][6];
    }

    /**
     * get a cell and if it possible put stone there
     * @param player player
     * @param row row of cell
     * @param column column of cell
     * @return true if the entered row and column is valid and its possible to put or false if not.
     */
    public boolean placeStone(Player player, int row, int column) {
        // if he entered correctly to an empty cell, set his color to block.
        if (isInMap(row, column))
            if (map[row][column] == 0) {
                map[row][column] = player.getColorCode();
                return true;
            }
        System.out.println("Please enter in the correct form");
        return false;
    }

    /**
     * spin a block in an specific direction
     * @param quadrant quadrant to spin
     * @param spinDirection spin direction between clockwise or Counterclockwise.
     * @return true if the entered quadrant and spin direction are valid or false if not.
     */
    public boolean spin (int quadrant, char spinDirection){
        Block block = new Block();
        // if there is empty block and he dont want to spin.
        if (quadrant == 0 && block.checkEmpty(map)){
                System.out.println("Pass");
                return true;
            }
            // if he entered correct, quadrant spin.
        if ((quadrant > 0 && quadrant < 5) && (spinDirection == 'O' || spinDirection == 'C')) {
            block.completeRotate(map, quadrant, spinDirection);
            return true;
        } else {
            System.out.println("Please enter in the correct form");
            return false;
        }
    }

    /**
     * check if one of the player win or not.
     * @param player player to check
     * @return true if finish or false if not.
     */
    public boolean checkFinish(Player player) {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (checkAround(i, j, player.getColorCode()))
                    return true;
        return false;
    }

    /**
     * check all around the cell
     * @param i row of cell
     * @param j column of cell
     * @param colorCode color code of player
     * @return true if at least in one direction are 5 stone in a row or false if there is not any direction.
     */
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

    /**
     * get a cell and two parameter to check an specific direction around it.
     * @param k its added to make new row
     * @param l its added to make new column
     * @param i row of cell
     * @param j column of cell
     * @param colorCode color to check
     * @return true if there are 5 stone in a row or false if not.
     */
    public boolean checkDirection(int k, int l, int i, int j, int colorCode) {
        int i2 = i + k, j2 = j + l;
        // check if it is in the map or not
        if (isInMap(i2, j2)) {
            int counter = 0;
            while ((map[i2][j2] == colorCode)) {
                // if there are five stone with his color in a row, he win.
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

    /**
     * check if the map is full or not.
     * @return true if it is full or false if not
     */
    public boolean isFull (){
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                if (map[i][j] == 0)
                    return false;
    return true;
    }

    /**
     * check if the cell is in map or not.
     * @param i row of cell
     * @param j column of cell
     * @return true if it is in map and false if not.
     */
    public boolean isInMap(int i, int j) {
        return ((i >= 0) && (i <= 5)) && ((j >= 0) && (j <= 5));
    }

    /**
     * print map of the game
     */
    public void printMap() {
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
                if (map[i][j] == 2)
                    System.out.print('\u25cf' + " ");
                else if (map[i][j] == 1)
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