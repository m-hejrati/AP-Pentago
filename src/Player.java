/**
 * this class holds information of player
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.05
 */

public class Player {

    private String name;
    // black: 2, white: 1;
    private int colorCode;

    public Player(String name, int colorCode) {
        this.name = name;
        this.colorCode = colorCode;
        Map hello = new Map();
    }

    public int getColorCode() {
        return colorCode;
    }

    public String getName() {
        return name;
    }
}
