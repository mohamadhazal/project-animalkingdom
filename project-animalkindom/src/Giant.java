import java.awt.Color;

public class Giant extends Critter {
    private static String[] REP = {"fee", "fie", "foe", "fum"};
    private int moves;

    // Each Giant type has 6 moves and resulting in 24 total moves.
    // If not Giant, infect whichever. Else, hop if empty. Turn right if it is Wall or Giant.
    public Action getMove(CritterInfo info) {
        moves++;
        moves %= 24;
        Neighbor nf;
        nf = info.getFront();
        if (nf == Neighbor.OTHER) return Action.INFECT;
        else if (nf == Neighbor.EMPTY) return Action.HOP;
        else return Action.RIGHT;
    }

    // Giants are Gray
    public Color getColor() {
        return Color.GRAY;
    }

    // Cycle through 4 times for fee, fie, foe and fum. Each time 6 steps.
    // Remainder in moves divided by 6 as integer to represent the string array
    public String toString() {
        return REP[moves / 6];
    }

}