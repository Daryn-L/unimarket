import com.daryn.unimarket.graphnode.GraphNode;
import com.daryn.unimarket.graphnode.GraphNodeUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GraphNodeUtilityTests {
    GraphNode startNode = new GraphNodeImplTest();
    GraphNode finishNode = new GraphNodeImplTest();
    GraphNode routeOne = new GraphNodeImplTest();
    GraphNode routeTwo = new GraphNodeImplTest();
    GraphNode routeThree = new GraphNodeImplTest();
    GraphNode routeOne_1 = new GraphNodeImplTest();
    GraphNode routeOne_2 = new GraphNodeImplTest();
    GraphNode routeOne_3 = new GraphNodeImplTest();
    GraphNode routeOne_4 = new GraphNodeImplTest();

    public GraphNodeUtilityTests() {

        startNode.getDirectlyLinkedNodes().add(routeOne);
        startNode.getDirectlyLinkedNodes().add(routeTwo);
        startNode.getDirectlyLinkedNodes().add(routeThree);

        routeOne.getDirectlyLinkedNodes().add(routeOne_1);
        routeOne_1.getDirectlyLinkedNodes().add(routeOne_2);
        routeOne_2.getDirectlyLinkedNodes().add(routeOne_3);
        routeOne_3.getDirectlyLinkedNodes().add(routeOne_4);
    }

    @Test
    @DisplayName("Should result in a distance of 5")
    void shouldShowRoute4ShortestPathTotalOf5() throws GraphNodeUtility.GraphNodeException {
        routeOne_4.getDirectlyLinkedNodes().add(finishNode);
        Assertions.assertEquals(GraphNodeUtility.getShortestPathDistance(startNode, finishNode), 5);
    }

    @Test
    @DisplayName("Should result in a distance of 1")
    void shouldShowRoute2ShortestPathTotalOf1() throws GraphNodeUtility.GraphNodeException {
        routeTwo.getDirectlyLinkedNodes().add(finishNode);
        Assertions.assertEquals(GraphNodeUtility.getShortestPathDistance(startNode, finishNode), 1);
    }

    @Test
    @DisplayName("Should throw exceptions on null values and starNode not connected to finishNode")
    void shouldThrowExceptions() throws GraphNodeUtility.GraphNodeException {

        Assertions.assertThrows(GraphNodeUtility.GraphNodeException.class, () ->
            GraphNodeUtility.getShortestPathDistance(null, finishNode)
        );
        Assertions.assertThrows(GraphNodeUtility.GraphNodeException.class, () ->
            GraphNodeUtility.getShortestPathDistance(startNode, null)
        );

        // Should throw exception when startNode is not connected to finishNode
        Assertions.assertThrows(GraphNodeUtility.GraphNodeException.class, () ->
            GraphNodeUtility.getShortestPathDistance(startNode, finishNode)
        );

        // Should not throw exception as startNode is connected to finishNode
        routeTwo.getDirectlyLinkedNodes().add(finishNode);
        GraphNodeUtility.getShortestPathDistance(startNode, finishNode);


    }

}
