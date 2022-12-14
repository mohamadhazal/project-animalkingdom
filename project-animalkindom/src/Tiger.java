import java.awt.Color;
import java.util.Random;

public class Tiger extends Critter {
    private static final Color[] COLORS = {Color.RED, Color.GREEN, Color.BLUE};
    private int moves;
    private Color currentColor;
    private final Random rand;

    public Tiger() {
        rand = new Random();
    }

    // Infect if not Tiger (i.e. OTHER). Turn left if it's a Wall in front or right.
    // If Tiger in front, turn right. If empty, hop.
    public Action getMove(CritterInfo info) {
        moves++;
        moves %= 3;
        Neighbor nf = info.getFront();
        Neighbor nr = info.getRight();
        if (nf == Neighbor.OTHER) return Action.INFECT;
        else if (nf == Neighbor.WALL || nr == Neighbor.WALL) return Action.LEFT;
        else if (nf == Neighbor.SAME) return Action.RIGHT;
        else return Action.HOP;
    }

    // Randomly picks Red, Green or Blue for each move
    public Color getColor() {
        if (moves == 0) currentColor = COLORS[rand.nextInt(COLORS.length)];
        return currentColor;
    }

    // Tiger is represented by TGR
    public String toString() {
        return "TGR";
    }

}