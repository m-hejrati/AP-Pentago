/**
 * this class holds information of player
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.05
 */

public class Player {

    private String name;
    // black: 1, white: 2;
    private int colorCode;

    /**
     * constructor for player
     * @param name name of the player
     * @param colorCode code of his color
     */
    public Player(String name, int colorCode) {
        this.name = name;
        this.colorCode = colorCode;
    }

    public int getColorCode() {
        return colorCode;
    }
}
