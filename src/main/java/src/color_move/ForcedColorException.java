package src.color_move;

public class ForcedColorException extends Exception {
    public final int nodeId;
    public final Color color;

    public ForcedColorException(int nodeId, Color color) {
        super("Cannot set color of node " + nodeId + " because it is forced to " + color + "!");
        this.nodeId = nodeId;
        this.color = color;
    }
}
