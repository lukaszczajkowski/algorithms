package graphs;

import java.util.*;

public class BreadthFirstSearch {

    static class Node {

        private String name;
        //todo: change it to a hashmap
        private List<Node> children;

        public Node (String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }

        public List<String> breadthFirstSearch(List<String> list) {
            Map<String, Boolean> searched = new HashMap<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                list.add(current.name);
                current.children.forEach(child -> {
                    if (!searched.containsKey(child.name)) {
                        searched.put(child.name, true);
                        queue.add(child);
                    }
                });
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
