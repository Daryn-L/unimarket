import com.daryn.unimarket.graphnode.GraphNode;

import java.util.HashSet;
import java.util.Set;

public class GraphNodeImplTest implements GraphNode {

    private final Set<GraphNode> connectedNodes;

    public GraphNodeImplTest() {
        this.connectedNodes = new HashSet<>();
    }

    @Override
    public Set<GraphNode> getDirectlyLinkedNodes() {
        return connectedNodes;
    }

}
