package src.player;

import src.graph.Graph;
import src.graph.GraphException;
import src.color_move.Color;
import src.color_move.GameMove;

public interface ComputerPlayer {
    void initialize(Graph<Color, Integer> graph, GameMove move, Color player, int numPlayers) throws GraphException;

    void makeMove() throws GraphException;
}
