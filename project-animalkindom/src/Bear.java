import java.awt.Color;

public class Bear extends Critter {
    private final boolean polar;
    private String rep = "/";

    public Bear(boolean polar) {
        this.polar = polar;
    }

    // Infect if not BEAR. Else, hop or turn left if empty or wall
    public Action getMove(CritterInfo info) {
        Neighbor n = info.getFront();
        if (n == Neighbor.OTHER) return Action.INFECT;
        else if (n == Neighbor.EMPTY) return Action.HOP;
        else return Action.LEFT;
    }

    // If it is POLAR bear, then WHITE polar. Else, BLACK bear.
    public Color getColor() {
        if (polar) return Color.WHITE;
        else return Color.BLACK;
    }

    // Starts with "/" and alternate to "\" in each step
    public String toString() {
        if (rep.equals("/")) rep = "\\";
        else rep =  "/";
        return rep;
    }

}