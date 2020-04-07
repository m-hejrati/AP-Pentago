/**
 * this class holds information of required map
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.06
 */

public class Block {
    private int[][] block;

    /**
     * constructor to create the map
     */
    public Block() {
        block = new int[3][3];
    }

    /**
     * check if there is an empty class or not
     * @param map the whole map of game
     * @return true if there is an empty block or not
     */
    public boolean checkEmpty(int[][] map) {
        boolean flag = true;
        // check all the blocks
        for (int i = 1; i < 5; i++) {
            setBlockAndMap(map, i, true);
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    if (block[j][k] != 0)
                        flag = false;
            if (flag)
                return true;
            flag = true;
        }
        return false;
    }

    /**
     * get the map and quadrant number, copy it in a block and rotate it 90 degree.
     * @param map the whole map of game
     * @param quadrant quadrant to spin
     * @param direction direction of spin clockwise or counterclockwise
     */
    public void completeRotate (int [][] map, int quadrant, char direction){
        // copy the required part of map to block with true mod of method.
        setBlockAndMap(map, quadrant, true);
        // rotate cells of block
        rotate(block, direction);
        // copy changed block to the map whit false mode of method.
        setBlockAndMap(map, quadrant, false);
    }

    /**
     * copy the required part of map to block or copy the block into map.
     * @param map the whole map of game
     * @param quadrant quadrant to spin
     * @param mod if it is true it copy the required part of map to block and if false it copy from block to map.
     */
    public void setBlockAndMap(int[][] map, int quadrant, boolean mod) {
        switch (quadrant) {
            case 1:
                dualCopy(map, 0, 3, mod);
                break;
            case 2:
                dualCopy(map, 0, 0, mod);
                break;
            case 3:
                dualCopy(map, 3, 0, mod);
                break;
            case 4:
                dualCopy(map, 3, 3, mod);
                break;
        }
    }

    /**
     * copy an specific part of map to block or copy the block into an map specific part of map.
     * @param map the whole map of game
     * @param k its added to make new row
     * @param l its added to make new column
     * @param mod true for copy from map to block and false to copy from block to map.
     */
    public void dualCopy(int[][] map, int l, int k, boolean mod) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                // mod 0 copy to map, mod 1 copy to block
                if (mod)
                   block[i][j] = map[i + l][j + k];
                else
                    map[i + l][j + k] = block[i][j];
    }

    /**
     * spin a block 90 degree
     * @param block block to spin
     * @param direction of spin clockwise or counterclockwise
     */
    public void rotate(int[][] block, char direction) {
        // rotate clockwise
        if (direction == 'C') {
            int tmp = block[0][1];
            block[0][1] = block[1][0];
            block[1][0] = block[2][1];
            block[2][1] = block[1][2];
            block[1][2] = tmp;

            tmp = block[0][0];
            block[0][0] = block[2][0];
            block[2][0] = block[2][2];
            block[2][2] = block[0][2];
            block[0][2] = tmp;

            // rotate counterclockwise
        }else if (direction == 'O'){
            int tmp = block[0][1];
            block[0][1] = block[1][2];
            block[1][2] = block[2][1];
            block[2][1] = block[1][0];
            block[1][0] = tmp;

            tmp = block[0][0];
            block[0][0] = block[0][2];
            block[0][2] = block[2][2];
            block[2][2] = block[2][0];
            block[2][0] = tmp;
        }
    }
}