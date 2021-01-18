package com.daryn.unimarket.graphnode;

import java.util.List;
import java.util.Set;

public interface GraphNode {

    /**
     * Returns all the GraphNodes directly linked
     * to this GraphNode.
     * These are considered to be distance 1 from this node.
     */
    Set<GraphNode> getDirectlyLinkedNodes();
}