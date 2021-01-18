package com.daryn.unimarket.graphnode;

import java.util.*;

public class GraphNodeUtility {

    /**
     * Finds the shortest distance between two nodes of a Graph.
     *
     * @param startNode  (cannot be null, should be before finishNode in node order)
     * @param finishNode (cannot be null, should be after startNode in node order)
     * @return int of shortest distance count between two graph nodes.
     */
    public static int getShortestPathDistance(GraphNode startNode, GraphNode finishNode) throws GraphNodeException {

        if (startNode == null) throw new GraphNodeException("startNode cannot be null");
        if (finishNode == null) throw new GraphNodeException("finishNode cannot be null");

        int depth = 0;  //if startNode = finishNode 0 will be returned (is the same node).

        Set<GraphNode> alreadyCheckedNodes = new HashSet<>(); //prevents a node being checked more than once.
        Set<GraphNode> currentTestSet = new HashSet<>();
        currentTestSet.add(startNode);

        while (true) {
            Set<GraphNode> nextSet = new HashSet<>();
            for (GraphNode currentNode : currentTestSet) {
                for (GraphNode graphNode : currentNode.getDirectlyLinkedNodes()) {
                    if (graphNode == finishNode) return depth;
                    if (!alreadyCheckedNodes.contains(graphNode)) nextSet.add(graphNode);
                    alreadyCheckedNodes.add(graphNode);
                }
            }
            if (nextSet.isEmpty())
                throw new GraphNodeException("The start node is not connected to finish node");
            depth++;
            currentTestSet = nextSet;
        }
    }


    public static class GraphNodeException extends Exception {
        /**
         * This exception will be thrown if the start node is not connected to the finish node.
         */
        public GraphNodeException(String message) {
            super(message);
        }
    }

}
