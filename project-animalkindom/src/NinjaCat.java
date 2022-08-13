import java.awt.Color;
import java.util.Random;

public class NinjaCat extends Critter {
    // private static final Action[] RL = {Action.LEFT, Action.RIGHT};
    // Picked all remaining available colors that are not used in other classes.
    private static final Color[] COLORS = {Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW};
    private final Random rand;

    public NinjaCat() {
        rand = new Random();
    }

    // Infect if not NinjaCat. If it is Wall or NinjaCat, turn right. Else HOP.
    public Action getMove(CritterInfo info) {
        Neighbor nf = info.getFront();
        if (nf == Neighbor.OTHER) return Action.INFECT;
        else if (nf == Neighbor.WALL || nf == Neighbor.SAME) return Action.LEFT;
        else return Action.HOP;
    }

    // Select random colors from total 6 choices
    public Color getColor() {
        return COLORS[rand.nextInt(COLORS.length)];
    }

    // NinjaCat represented by ^x^
    public String toString() {
        return "^x^";
    }

}