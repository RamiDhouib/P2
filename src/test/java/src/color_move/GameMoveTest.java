package src.color_move;

import raw_none.tukl.programmierpraktikum2020.p2.a1.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.graph.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class GameMoveTest {
    @Test
    public void example() throws Exception {
        Graph<Color , Integer> graph = new GraphImpl<>();
        int a = graph.addNode(Color.WHITE);
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor( a , Color.GREEN);
        assertEquals(Color.GREEN ,graph.getData(a) );
    }
    @Test
    public void example_2() throws Exception {
        Graph<Color , Integer> graph = new Graph<Color, Integer>() {
            Color a=Color.WHITE;
            @Override
            public int addNode(Color data) {
                throw new UnsupportedOperationException();
            }

            @Override
            public Color getData(int nodeId) throws InvalidNodeException {
                if (nodeId==0){
                    System.out.println(a);
                    return a;}
                throw new InvalidNodeException(nodeId);
            }

            @Override
            public void setData(int nodeId, Color data) throws InvalidNodeException {
                if (nodeId==0){
                    a=data;
                    System.out.println(a);}
                else{
                throw new InvalidNodeException(nodeId);}

            }

            @Override
            public void addEdge(int fromId, int toId, Integer weight) throws InvalidNodeException, DuplicateEdgeException {
                throw new UnsupportedOperationException();

            }

            @Override
            public Integer getWeight(int fromId, int toId) throws InvalidEdgeException {
                throw new InvalidEdgeException(fromId, toId);

            }

            @Override
            public void setWeight(int fromId, int toId, Integer weight) throws InvalidEdgeException {
                throw new InvalidEdgeException(fromId, toId);

            }

            @Override
            public Set<Integer> getNodeIds() {
                return Set.of(0);
            }

            @Override
            public Set<Integer> getIncomingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of();}
                else{
                throw new InvalidNodeException(nodeId);}

            }

            @Override
            public Set<Integer> getOutgoingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of();}
                else{
                    throw new InvalidNodeException(nodeId);}

            }
        };
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor( 0 , Color.GREEN);
        assertEquals(Color.GREEN ,graph.getData(0) );
    }
    @Test
    public void example2() throws Exception {
        Graph<Color , Integer> graph = new GraphImpl<>();
        int a = graph.addNode(Color.WHITE);
        int b = graph.addNode(Color.WHITE);
        graph.addEdge(a ,b , 2);
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor( a , Color.GREEN);
        assertEquals(Color.GREEN ,graph.getData(b) );
    }
    @Test
    public void example2_2() throws Exception {
        Graph<Color , Integer> graph = new Graph<Color, Integer>(){
            Color a=Color.WHITE;
            Color b=Color.WHITE;
            int c=2;

            @Override
            public int addNode(Color data) {
                throw new UnsupportedOperationException();
            }

            @Override
            public Color getData(int nodeId) throws InvalidNodeException {
                if (nodeId==0){
                    System.out.println(a);
                    return a;}
                else if (nodeId==1){
                    System.out.println(b);
                    return b;}
                else {throw new InvalidNodeException(nodeId);}
            }

            @Override
            public void setData(int nodeId, Color data) throws InvalidNodeException {
                if (nodeId==0){
                    a=data;
                    System.out.println(a);}
                else if (nodeId==1){
                    b=data;
                    System.out.println(a);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public void addEdge(int fromId, int toId, Integer weight) throws InvalidNodeException, DuplicateEdgeException {
                throw new UnsupportedOperationException();

            }

            @Override
            public Integer getWeight(int fromId, int toId) throws InvalidEdgeException {
                if (fromId==0 & toId==1){
                    return(c);
                }
                else{
                throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public void setWeight(int fromId, int toId, Integer weight) throws InvalidEdgeException {
                if (fromId==0 & toId==1){
                    c=weight;
                }
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public Set<Integer> getNodeIds() {
                return Set.of(0,1);
            }

            @Override
            public Set<Integer> getIncomingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of();}
                else if (nodeId==1) {return Set.of(0);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public Set<Integer> getOutgoingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of(1);}
                else if (nodeId==1) {return Set.of();}
                else{
                    throw new InvalidNodeException(nodeId);}

            }
        };
        /*int a = graph.addNode(Color.WHITE);
        int b = graph.addNode(Color.WHITE);
         graph.addEdge(a ,b , 2);*/
        GameMove gm = new GameMoveImpl(graph);

        gm.setColor( 0 , Color.GREEN);
        assertEquals(Color.GREEN ,graph.getData(1) );
    }
    @Test
    public void example3() throws Exception {
        //Beispiel 1 (2 Spieler, setColor und increaseWeight)
        Graph<Color , Integer> graph = new GraphImpl<>();
        int a = graph.addNode(Color.WHITE);
        int b = graph.addNode(Color.WHITE);
        int c = graph.addNode(Color.WHITE);
        graph.addEdge(a ,b , 2);
        graph.addEdge(b ,a , 3);
        graph.addEdge(c ,a , 1);
        graph.addEdge(c ,b , 2);
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor( c , Color.RED);
        assertEquals(Color.RED ,graph.getData(c) );
        gm.increaseWeight(c ,b);
        assertEquals(Color.RED ,graph.getData(a) );
        assertEquals(Color.RED ,graph.getData(b) );
        gm.setColor( c , Color.RED);
        assertEquals(Color.RED ,graph.getData(c) );
        gm.setColor( c , Color.GREEN);
        assertEquals(Color.GREEN ,graph.getData(c) );
        assertEquals(Color.GREEN ,graph.getData(a) );
        assertEquals(Color.GREEN ,graph.getData(b) );
    }
    @Test
    public void example3_2() throws Exception {
        Graph<Color , Integer> graph = new Graph<Color, Integer>(){
            Color a=Color.WHITE;
            Color b=Color.WHITE;
            Color c=Color.WHITE;

            int A=2; // a-->b
            int B=3; // b--> a
            int C=1; // c-->a
            int D=2; // c-->b

            @Override
            public int addNode(Color data) {
                throw new UnsupportedOperationException();
            }

            @Override
            public Color getData(int nodeId) throws InvalidNodeException {
                if (nodeId==0){
                    System.out.println(a);
                    return a;}
                else if (nodeId==1){
                    System.out.println(b);
                    return b;}
                else if (nodeId==2){
                    System.out.println(c);
                    return c;}
                else {throw new InvalidNodeException(nodeId);}
            }

            @Override
            public void setData(int nodeId, Color data) throws InvalidNodeException {
                if (nodeId==0){
                    a=data;
                    System.out.println(a);}
                else if (nodeId==1){
                    b=data;
                    System.out.println(a);}
                else if (nodeId==2){
                    c=data;
                    System.out.println(a);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public void addEdge(int fromId, int toId, Integer weight) throws InvalidNodeException, DuplicateEdgeException {
                throw new UnsupportedOperationException();

            }

            @Override
            public Integer getWeight(int fromId, int toId) throws InvalidEdgeException {
                if (fromId==0 & toId==1){
                    return(A);
                }
                else if (fromId==1 & toId==0){
                    return(B);}
                else if (fromId==2 & toId==0){
                    return(C);}
                else if (fromId==2 & toId==1){
                    return(D);}
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public void setWeight(int fromId, int toId, Integer weight) throws InvalidEdgeException {
                if (fromId==0 & toId==1){
                    A=weight;
                }
                else if (fromId==1 & toId==0){
                    B=weight;}
                else if (fromId==2 & toId==0){
                    C=weight;}
                else if (fromId==2 & toId==1){
                    D=weight;}
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public Set<Integer> getNodeIds() {
                return Set.of(0,1,2);
            }

            @Override
            public Set<Integer> getIncomingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of(1,2);}
                else if (nodeId==1) {return Set.of(0,2);}
                else if (nodeId==2) {return Set.of();}
                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public Set<Integer> getOutgoingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of(1);}
                else if (nodeId==1) {return Set.of(0);}
                else if (nodeId==2) {return Set.of(0,1);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }
        };
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor( 2 , Color.RED);
        assertEquals(Color.RED ,graph.getData(2) );
        gm.increaseWeight(2 ,1);
        assertEquals(Color.RED ,graph.getData(0) );
        assertEquals(Color.RED ,graph.getData(1) );
        gm.setColor( 2 , Color.RED);
        assertEquals(Color.RED ,graph.getData(2) );
        gm.setColor( 2 , Color.GREEN);
        assertEquals(Color.GREEN ,graph.getData(2) );
        assertEquals(Color.GREEN ,graph.getData(0) );
        assertEquals(Color.GREEN ,graph.getData(1) );
    }
    @Test
    public void example4() throws Exception {
        //Beispiel 2 (2 Spieler, setColor und decreaseWeight)
        Graph<Color , Integer> graph = new GraphImpl<>();
        int a = graph.addNode(Color.WHITE);
        int b = graph.addNode(Color.WHITE);
        int c = graph.addNode(Color.WHITE);
        int d = graph.addNode(Color.WHITE);
        graph.addEdge(a ,c , 1);
        graph.addEdge(a ,b , 1);
        graph.addEdge(c ,b , 3);
        graph.addEdge(d ,b , 1);
        graph.addEdge(d ,c , 1);
        graph.addEdge(c ,c , 3);
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor( a , Color.RED);
        assertEquals(Color.RED ,graph.getData(a) );

        gm.setColor( c , Color.GREEN);
        assertEquals(Color.GREEN ,graph.getData(c) );
        assertEquals(Color.GREEN ,graph.getData(b) );

        gm.setColor(d, Color.RED);
        assertEquals(Color.RED ,graph.getData(d) );

        gm.decreaseWeight(c ,b);
        assertEquals(Color.RED ,graph.getData(a) );
        assertEquals(Color.GREEN ,graph.getData(c) );
        assertEquals(Color.GREEN ,graph.getData(b) );
        assertEquals(Color.RED ,graph.getData(d) );

        gm.decreaseWeight(c ,b);
        assertEquals(Color.RED ,graph.getData(a) );
        assertEquals(Color.GREEN ,graph.getData(c) );
        assertEquals(Color.RED ,graph.getData(b) );
        assertEquals(Color.RED ,graph.getData(d) );

    }
    @Test
    public void example4_2() throws Exception {
        Graph<Color , Integer> graph = new Graph<Color, Integer>(){
            Color a=Color.WHITE;
            Color b=Color.WHITE;
            Color c=Color.WHITE;
            Color d=Color.WHITE;

            int A=1; // a-->c
            int B=1; // a--> b
            int C=3; // c-->b
            int D=1; // d-->b
            int E=1; // d-->c
            int F=3; // c-->c

            @Override
            public int addNode(Color data) {
                throw new UnsupportedOperationException();
            }

            @Override
            public Color getData(int nodeId) throws InvalidNodeException {
                if (nodeId==0){
                    System.out.println(a);
                    return a;}
                else if (nodeId==1){
                    System.out.println(b);
                    return b;}
                else if (nodeId==2){
                    System.out.println(c);
                    return c;}
                else if (nodeId==3){
                    System.out.println(d);
                    return d;}
                else {throw new InvalidNodeException(nodeId);}
            }

            @Override
            public void setData(int nodeId, Color data) throws InvalidNodeException {
                if (nodeId==0){
                    a=data;
                    System.out.println(a);}
                else if (nodeId==1){
                    b=data;
                    System.out.println(b);}
                else if (nodeId==2){
                    c=data;
                    System.out.println(c);}
                else if (nodeId==3){
                    d=data;
                    System.out.println(d);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public void addEdge(int fromId, int toId, Integer weight) throws InvalidNodeException, DuplicateEdgeException {
                throw new UnsupportedOperationException();

            }

            @Override
            public Integer getWeight(int fromId, int toId) throws InvalidEdgeException {
                if (fromId==0 & toId==2){
                    return(A);
                }
                else if (fromId==0 & toId==1){
                    return(B);}
                else if (fromId==2 & toId==1){
                    return(C);}
                else if (fromId==3 & toId==1){
                    return(D);}
                else if (fromId==3 & toId==2){
                    return(E);}
                else if (fromId==2 & toId==2){
                    return(F);}
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public void setWeight(int fromId, int toId, Integer weight) throws InvalidEdgeException {
                if (fromId==0 & toId==2){
                    A=weight;
                }
                else if (fromId==0 & toId==1){
                    B=weight;}
                else if (fromId==2 & toId==1){
                    C=weight;}
                else if (fromId==3 & toId==1){
                    D=weight;}
                else if (fromId==3 & toId==2){
                    E=weight;}
                else if (fromId==2 & toId==2){
                    F=weight;}
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public Set<Integer> getNodeIds() {
                return Set.of(0,1,2,3);
            }

            @Override
            public Set<Integer> getIncomingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of();}
                else if (nodeId==1) {return Set.of(0,2,3);}
                else if (nodeId==2) {return Set.of(0,2,3);}
                else if (nodeId==3) {return Set.of();}
                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public Set<Integer> getOutgoingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of(1,2);}
                else if (nodeId==1) {return Set.of();}
                else if (nodeId==2) {return Set.of(1,2);}
                else if (nodeId==3) {return Set.of(2);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }
        };
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor( 0 , Color.RED);
        assertEquals(Color.RED ,graph.getData(0) );

        gm.setColor( 2 , Color.GREEN);
        assertEquals(Color.GREEN ,graph.getData(2) );
        assertEquals(Color.GREEN ,graph.getData(1) );

        gm.setColor(3, Color.RED);
        assertEquals(Color.RED ,graph.getData(3) );

        gm.decreaseWeight(2 ,1);
        assertEquals(Color.RED ,graph.getData(0) );
        assertEquals(Color.GREEN ,graph.getData(2) );
        assertEquals(Color.GREEN ,graph.getData(1) );
        assertEquals(Color.RED ,graph.getData(3) );

        gm.decreaseWeight(2 ,1);
        assertEquals(Color.RED ,graph.getData(0) );
        assertEquals(Color.GREEN ,graph.getData(2) );
        assertEquals(Color.RED ,graph.getData(1) );
        assertEquals(Color.RED ,graph.getData(3) );
    }
    @Test
    public void example5() throws Exception {
        //Beispiel 3 (4 Spieler, setColor und increaseWeight)
        Graph<Color , Integer> graph = new GraphImpl<>();
        int a = graph.addNode(Color.WHITE);
        int b = graph.addNode(Color.WHITE);
        int c = graph.addNode(Color.WHITE);
        int d = graph.addNode(Color.WHITE);
        graph.addEdge(a ,c , 1);
        graph.addEdge(a ,b , 1);
        graph.addEdge(c ,b , 2);
        graph.addEdge(d ,b , 2);
        graph.addEdge(d ,c , 1);
        graph.addEdge(c ,c , 2);
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor( d , Color.RED);
        gm.setColor( c , Color.GREEN);

        gm.setColor(b, Color.BLUE);
        assertEquals(Color.BLUE ,graph.getData(b) );
        gm.setColor(b, Color.YELLOW);
        assertEquals(Color.YELLOW,graph.getData(b) );


        gm.setColor( a , Color.RED);
        assertEquals(Color.RED ,graph.getData(a) );
        assertEquals(Color.RED ,graph.getData(b) );
        assertEquals(Color.RED ,graph.getData(d) );


        gm.increaseWeight(c , c);
        assertEquals(Color.GREEN ,graph.getData(c) );
        assertEquals(Color.RED ,graph.getData(a) );
        assertEquals(Color.RED ,graph.getData(b) );
        assertEquals(Color.RED ,graph.getData(d) );

        gm.setColor( d , Color.BLUE);
        assertEquals(Color.BLUE ,graph.getData(d) );

        gm.setColor( a , Color.YELLOW);
        assertEquals(Color.YELLOW ,graph.getData(a) );

        gm.setColor( d , Color.RED);
        assertEquals(Color.RED ,graph.getData(d) );

        gm.increaseWeight(c , b);
        assertEquals(Color.GREEN ,graph.getData(c) );
        assertEquals(Color.YELLOW ,graph.getData(a) );
        assertEquals(Color.RED ,graph.getData(b) );
        assertEquals(Color.RED ,graph.getData(d) );

        gm.setColor( b , Color.BLUE);
        assertEquals(Color.BLUE,graph.getData(b) );

        gm.setColor( d , Color.YELLOW);
        assertEquals(Color.YELLOW ,graph.getData(d) );

        gm.setColor( d , Color.RED);
        assertEquals(Color.RED ,graph.getData(d) );

        gm.increaseWeight(c , b);
        assertEquals(Color.GREEN ,graph.getData(c) );
        assertEquals(Color.YELLOW ,graph.getData(a) );
        assertEquals(Color.GREEN ,graph.getData(b) );
        assertEquals(Color.RED ,graph.getData(d) );

    }
    @Test
    public void example5_2() throws Exception {
        Graph<Color , Integer> graph = new Graph<Color, Integer>(){
            Color a=Color.WHITE;
            Color b=Color.WHITE;
            Color c=Color.WHITE;
            Color d=Color.WHITE;

            int A=1; // a-->c
            int B=1; // a--> b
            int C=2; // c-->b
            int D=2; // d-->b
            int E=1; // d-->c
            int F=2; // c-->c

            @Override
            public int addNode(Color data) {
                throw new UnsupportedOperationException();
            }

            @Override
            public Color getData(int nodeId) throws InvalidNodeException {
                if (nodeId==0){
                    System.out.println(a);
                    return a;}
                else if (nodeId==1){
                    System.out.println(b);
                    return b;}
                else if (nodeId==2){
                    System.out.println(c);
                    return c;}
                else if (nodeId==3){
                    System.out.println(d);
                    return d;}
                else {throw new InvalidNodeException(nodeId);}
            }

            @Override
            public void setData(int nodeId, Color data) throws InvalidNodeException {
                if (nodeId==0){
                    a=data;
                    System.out.println(a);}
                else if (nodeId==1){
                    b=data;
                    System.out.println(b);}
                else if (nodeId==2){
                    c=data;
                    System.out.println(c);}
                else if (nodeId==3){
                    d=data;
                    System.out.println(d);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public void addEdge(int fromId, int toId, Integer weight) throws InvalidNodeException, DuplicateEdgeException {
                throw new UnsupportedOperationException();

            }

            @Override
            public Integer getWeight(int fromId, int toId) throws InvalidEdgeException {
                if (fromId==0 & toId==2){
                    return(A);
                }
                else if (fromId==0 & toId==1){
                    return(B);}
                else if (fromId==2 & toId==1){
                    return(C);}
                else if (fromId==3 & toId==1){
                    return(D);}
                else if (fromId==3 & toId==2){
                    return(E);}
                else if (fromId==2 & toId==2){
                    return(F);}
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public void setWeight(int fromId, int toId, Integer weight) throws InvalidEdgeException {
                if (fromId==0 & toId==2){
                    A=weight;
                }
                else if (fromId==0 & toId==1){
                    B=weight;}
                else if (fromId==2 & toId==1){
                    C=weight;}
                else if (fromId==3 & toId==1){
                    D=weight;}
                else if (fromId==3 & toId==2){
                    E=weight;}
                else if (fromId==2 & toId==2){
                    F=weight;}
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public Set<Integer> getNodeIds() {
                return Set.of(0,1,2,3);
            }

            @Override
            public Set<Integer> getIncomingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of();}
                else if (nodeId==1) {return Set.of(0,2,3);}
                else if (nodeId==2) {return Set.of(0,2,3);}
                else if (nodeId==3) {return Set.of();}
                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public Set<Integer> getOutgoingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of(1,2);}
                else if (nodeId==1) {return Set.of();}
                else if (nodeId==2) {return Set.of(1,2);}
                else if (nodeId==3) {return Set.of(2);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }
        };
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor( 3 , Color.RED);
        gm.setColor( 2 , Color.GREEN);

        gm.setColor(1, Color.BLUE);
        assertEquals(Color.BLUE ,graph.getData(1) );
        gm.setColor(1, Color.YELLOW);
        assertEquals(Color.YELLOW,graph.getData(1) );


        gm.setColor( 0 , Color.RED);
        assertEquals(Color.RED ,graph.getData(0) );
        assertEquals(Color.RED ,graph.getData(1) );
        assertEquals(Color.RED ,graph.getData(3) );


        gm.increaseWeight(2 , 2);
        assertEquals(Color.GREEN ,graph.getData(2) );
        assertEquals(Color.RED ,graph.getData(0) );
        assertEquals(Color.RED ,graph.getData(1) );
        assertEquals(Color.RED ,graph.getData(3) );

        gm.setColor( 3 , Color.BLUE);
        assertEquals(Color.BLUE ,graph.getData(3) );

        gm.setColor( 0 , Color.YELLOW);
        assertEquals(Color.YELLOW ,graph.getData(0) );

        gm.setColor( 3 , Color.RED);
        assertEquals(Color.RED ,graph.getData(3) );

        gm.increaseWeight(2 , 1);
        assertEquals(Color.GREEN ,graph.getData(2) );
        assertEquals(Color.YELLOW ,graph.getData(0) );
        assertEquals(Color.RED ,graph.getData(1) );
        assertEquals(Color.RED ,graph.getData(3) );

        gm.setColor( 1 , Color.BLUE);
        assertEquals(Color.BLUE,graph.getData(1 ));

        gm.setColor( 3 , Color.YELLOW);
        assertEquals(Color.YELLOW ,graph.getData(3) );

        gm.setColor( 3 , Color.RED);
        assertEquals(Color.RED ,graph.getData(3) );

        gm.increaseWeight(2 , 1);
        assertEquals(Color.GREEN ,graph.getData(2) );
        assertEquals(Color.YELLOW ,graph.getData(0) );
        assertEquals(Color.GREEN ,graph.getData(1) );
        assertEquals(Color.RED ,graph.getData(3) );
    }
    @Test
    public void example6() throws Exception {
        //Beispiel 4 (2 Spieler, setColor und ForcedColorException)
        Graph<Color, Integer> graph = new GraphImpl<>();
        int a = graph.addNode(Color.WHITE);
        int b = graph.addNode(Color.WHITE);
        graph.addEdge(a, b, 1);
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor(a, Color.RED);
        assertEquals(Color.RED, graph.getData(a));
        Assertions.assertThrows(ForcedColorException.class, () ->  gm.setColor(b, Color.GREEN));
    }
    @Test
    public void example6_2() throws Exception {
        Graph<Color , Integer> graph = new Graph<Color, Integer>(){
            Color a=Color.WHITE;
            Color b=Color.WHITE;
             int c=1; //a-->b

            @Override
            public int addNode(Color data) {
                throw new UnsupportedOperationException();
            }

            @Override
            public Color getData(int nodeId) throws InvalidNodeException {
                if (nodeId==0){
                    System.out.println(a);
                    return a;}
                else if (nodeId==1){
                    System.out.println(b);
                    return b;}
                else {throw new InvalidNodeException(nodeId);}
            }

            @Override
            public void setData(int nodeId, Color data) throws InvalidNodeException {
                if (nodeId==0){
                    a=data;
                    System.out.println(a);}
                else if (nodeId==1){
                    b=data;
                    System.out.println(a);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public void addEdge(int fromId, int toId, Integer weight) throws InvalidNodeException, DuplicateEdgeException {
                throw new UnsupportedOperationException();

            }

            @Override
            public Integer getWeight(int fromId, int toId) throws InvalidEdgeException {
                if (fromId==0 & toId==1){
                    return(c);
                }
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public void setWeight(int fromId, int toId, Integer weight) throws InvalidEdgeException {
                if (fromId==0 & toId==1){
                    c=weight;
                }
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public Set<Integer> getNodeIds() {
                return Set.of(0,1);
            }

            @Override
            public Set<Integer> getIncomingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of();}
                else if (nodeId==1) {return Set.of(0);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public Set<Integer> getOutgoingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of(1);}
                else if (nodeId==1) {return Set.of();}
                else{
                    throw new InvalidNodeException(nodeId);}

            }
        };
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor(0, Color.RED);
        assertEquals(Color.RED, graph.getData(0));
        Assertions.assertThrows(ForcedColorException.class, () ->  gm.setColor(1, Color.GREEN));
    }
    @Test
    public void example7_2() throws Exception {
        Graph<Color , Integer> graph = new Graph<Color, Integer>(){
            Color a=Color.WHITE;
            int c=1; //a-->a

            @Override
            public int addNode(Color data) {
                throw new UnsupportedOperationException();
            }

            @Override
            public Color getData(int nodeId) throws InvalidNodeException {
                if (nodeId==0){
                    System.out.println(a);
                    return a;}
                else {throw new InvalidNodeException(nodeId);}
            }

            @Override
            public void setData(int nodeId, Color data) throws InvalidNodeException {
                if (nodeId==0){
                    a=data;
                    System.out.println(a);}

                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public void addEdge(int fromId, int toId, Integer weight) throws InvalidNodeException, DuplicateEdgeException {
                throw new UnsupportedOperationException();

            }

            @Override
            public Integer getWeight(int fromId, int toId) throws InvalidEdgeException {
                if (fromId==0 & toId==0){
                    return(c);
                }
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public void setWeight(int fromId, int toId, Integer weight) throws InvalidEdgeException {
                if (fromId==0 & toId==0){
                    c=weight;
                }
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public Set<Integer> getNodeIds() {
                return Set.of(0);
            }

            @Override
            public Set<Integer> getIncomingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of(0);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public Set<Integer> getOutgoingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of(0);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }
        };
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor(0, Color.RED);
        Assertions.assertThrows(ForcedColorException.class, () ->  gm.setColor(0, Color.GREEN));
    }
    @Test
    public void example7() throws Exception {
        //Beispiel 5 (2 Spieler, setColor und ForcedColorException)
        Graph<Color, Integer> graph = new GraphImpl<>();
        int a = graph.addNode(Color.WHITE);
        graph.addEdge(a, a, 1);
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor(a, Color.RED);
        Assertions.assertThrows(ForcedColorException.class, () ->  gm.setColor(a, Color.GREEN));
    }

    @Test
    public void example8() throws Exception {
        //Beispiel 6 (2 Spieler, setColor und decreaseWeight)
        Graph<Color, Integer> graph = new GraphImpl<>();
        int a = graph.addNode(Color.WHITE);
        graph.addEdge(a, a, 1);
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor(a, Color.RED);
        gm.decreaseWeight(a, a);
        gm.setColor(a, Color.GREEN);
        assertEquals(Color.GREEN, graph.getData(a));
    }
    @Test
    public void example8_2() throws Exception {
        Graph<Color , Integer> graph = new Graph<Color, Integer>(){
            Color a=Color.WHITE;
            int c=1; //a-->a

            @Override
            public int addNode(Color data) {
                throw new UnsupportedOperationException();
            }

            @Override
            public Color getData(int nodeId) throws InvalidNodeException {
                if (nodeId==0){
                    System.out.println(a);
                    return a;}
                else {throw new InvalidNodeException(nodeId);}
            }

            @Override
            public void setData(int nodeId, Color data) throws InvalidNodeException {
                if (nodeId==0){
                    a=data;
                    System.out.println(a);}

                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public void addEdge(int fromId, int toId, Integer weight) throws InvalidNodeException, DuplicateEdgeException {
                throw new UnsupportedOperationException();

            }

            @Override
            public Integer getWeight(int fromId, int toId) throws InvalidEdgeException {
                if (fromId==0 & toId==0){
                    return(c);
                }
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public void setWeight(int fromId, int toId, Integer weight) throws InvalidEdgeException {
                if (fromId==0 & toId==0){
                    c=weight;
                }
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public Set<Integer> getNodeIds() {
                return Set.of(0);
            }

            @Override
            public Set<Integer> getIncomingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of(0);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public Set<Integer> getOutgoingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of(0);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }
        };
        GameMove gm = new GameMoveImpl(graph);
        gm.setColor(0, Color.RED);
        gm.decreaseWeight(0, 0);
        gm.setColor(0, Color.GREEN);
        assertEquals(Color.GREEN, graph.getData(0));
    }
    @Test
    public void example9() throws Exception {
        //Beispiel 7 (2 Spieler, decreaseWeight und NegativeWeightException)
        Graph<Color, Integer> graph = new GraphImpl<>();
        int a = graph.addNode(Color.WHITE);
        graph.addEdge(a, a, 1);
        GameMove gm = new GameMoveImpl(graph);
        gm.decreaseWeight(a, a);

        Assertions.assertThrows(NegativeWeightException.class, () ->  gm.decreaseWeight(a, a));

    }
    @Test
    public void example9_2() throws Exception {
        Graph<Color , Integer> graph = new Graph<Color, Integer>(){
            Color a=Color.WHITE;
            int c=1; //a-->a

            @Override
            public int addNode(Color data) {
                throw new UnsupportedOperationException();
            }

            @Override
            public Color getData(int nodeId) throws InvalidNodeException {
                if (nodeId==0){
                    System.out.println(a);
                    return a;}
                else {throw new InvalidNodeException(nodeId);}
            }

            @Override
            public void setData(int nodeId, Color data) throws InvalidNodeException {
                if (nodeId==0){
                    a=data;
                    System.out.println(a);}

                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public void addEdge(int fromId, int toId, Integer weight) throws InvalidNodeException, DuplicateEdgeException {
                throw new UnsupportedOperationException();

            }

            @Override
            public Integer getWeight(int fromId, int toId) throws InvalidEdgeException {
                if (fromId==0 & toId==0){
                    return(c);
                }
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public void setWeight(int fromId, int toId, Integer weight) throws InvalidEdgeException {
                if (fromId==0 & toId==0){
                    c=weight;
                }
                else{
                    throw new InvalidEdgeException(fromId, toId);}

            }

            @Override
            public Set<Integer> getNodeIds() {
                return Set.of(0);
            }

            @Override
            public Set<Integer> getIncomingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of(0);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }

            @Override
            public Set<Integer> getOutgoingNeighbors(int nodeId) throws InvalidNodeException {
                if (nodeId==0) {return Set.of(0);}
                else{
                    throw new InvalidNodeException(nodeId);}

            }
        };
        GameMove gm = new GameMoveImpl(graph);
        gm.decreaseWeight(0, 0);

        Assertions.assertThrows(NegativeWeightException.class, () ->  gm.decreaseWeight(0,0));
    }
    }
