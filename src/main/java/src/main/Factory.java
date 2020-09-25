package src.main;

import src.graph.Graph;
//import de.tukl.programmierpraktikum2020.p2.a1.GraphImpl;
import src.graph.GraphImpl;
import src.color_move.Color;
import src.color_move.GameMove;
//import de.tukl.programmierpraktikum2020.p2.a2.GameMoveImpl;
import src.color_move.GameMoveImpl;
import src.player.ComputerPlayer;
import src.player.RandomComputerPlayer;

/**
 * Factory class to wrap the constructors of the student's {@link Graph} and {@link GameMove} implementations.
 */
public class Factory {
    public static <D, W> Graph<D, W> constructGraph() {
        return new GraphImpl<>();
    }

    public static GameMove constructGameMove(Graph<Color, Integer> graph) {
        return new GameMoveImpl(graph);
    }

    public static ComputerPlayer constructComputerPlayer() {
        // Hier können Sie Ihren ComputerPlayer eintragen (freiwillige Aufgabe 4)
        return new RandomComputerPlayer();
    }
}
