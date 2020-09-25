package src.color_move;

import src.graph.GraphException;

public interface GameMove {
    void setColor(int nodeId, Color color) throws GraphException, ForcedColorException;

    void increaseWeight(int fromId, int toId) throws GraphException;

    void decreaseWeight(int fromId, int toId) throws GraphException, NegativeWeightException;
}
