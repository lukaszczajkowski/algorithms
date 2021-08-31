package graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static graphs.BreadthFirstSearch.Node;

public class BreadthFirstSearchTest {

    Node nodeA;
    List<String> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        nodeA = new Node("A");
        nodeA.addChildren("B", "C", "D");

        nodeA.getChildren().stream().forEach(child -> {
            if (child.getName().equals("B")) {
                child.addChildren("E", "F");
            }

            if (child.getName().equals("D")) {
                child.addChildren("G", "H");
            }
        });

        nodeA.getChildren().stream().filter(child -> child.getName().equals("B")).findFirst().get()
                .getChildren().stream().filter(child -> child.getName().equals("F")).findFirst().get()
                .addChildren("I", "J");

        nodeA.getChildren().stream().filter(child -> child.getName().equals("D")).findFirst().get()
                .getChildren().stream().filter(child -> child.getName().equals("G")).findFirst().get()
                .addChild("K");
    }

    @Test
    public void bfsTest() {
        List<String> bfsResult = nodeA.breadthFirstSearch(list);
        List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K");

        bfsResult.forEach(System.out::print);

        assertThat(bfsResult, equalTo(expected));
    }
}