package src.graph;

public class InvalidNodeException extends GraphException {
    public final int nodeId;

    public InvalidNodeException(int nodeId) {
        super("There is no node " + nodeId + "!");
        this.nodeId = nodeId;
    }
}
