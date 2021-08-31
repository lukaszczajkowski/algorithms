package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    static class Node {

        private String name;
        private List<Node> children;

        public Node (String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }

        public List<String> breadthFirstSearch(List<String> list) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                list.add(current.name);
                queue.addAll(current.children);
            }

            return list;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }

        public Node addChildren(String... names) {
            for (String name: names) {
                addChild(name);
            }
            return this;
        }

        public List<Node> getChildren() {
            return children;
        }

        public String getName() {
            return name;
        }
    }
}
