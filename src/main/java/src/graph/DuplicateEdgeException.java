package src.graph;

public class DuplicateEdgeException extends GraphException {
    public final int fromId;
    public final int toId;

    public DuplicateEdgeException(int fromId, int toId) {
        super("The edge " + fromId + " -> " + toId + " already exists!");
        this.fromId = fromId;
        this.toId = toId;
    }
}
