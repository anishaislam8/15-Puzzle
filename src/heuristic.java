import java.util.*;

public class heuristic {
    int ExploredNodeCount = 1;
    displacement dis = new displacement();
    manhattan man = new manhattan();
    HashMap<String, Integer> map = new HashMap<>();


    int swapNumber = -1;
    changeDirection cd = new changeDirection();

    public void search(Node node, int[][] goalMatrix, int choice) {
        if (choice == 1) {
            long startTime = System.currentTimeMillis();
            Comparator<Node> costComparator = new Comparator<Node>() {
                @Override
                public int compare(Node s1, Node s2) {
                    return (dis.cost(s1,goalMatrix)+s1.level) - (dis.cost(s2,goalMatrix)+s2.level);
                }
            };


            PriorityQueue<Node> priorityQueue = new PriorityQueue<>(costComparator);

            priorityQueue.add(node);
            String s = Arrays.deepToString(node.matrix);
            map.put(s, 1);

            Node currentNode;

            while (!priorityQueue.isEmpty()) {
                currentNode = priorityQueue.remove();
                ExploredNodeCount+=1;

                if (dis.cost(currentNode, goalMatrix) == 0) {
                    //reached the goal state
                    Node current = currentNode;
                    ArrayList<Node> result = new ArrayList<>();
                    while (current != null) {
                        result.add(0, current);
                        swapNumber += 1;
                        current = current.parent;
                    }
                    for (int i = 0; i < result.size(); i++) {
                        for (int m = 0; m < 4; m++) {
                            for (int n = 0; n < 4; n++) {
                                    System.out.print(result.get(i).matrix[m][n] + " ");
                                }
                        }
                        System.out.println();

                    }
                    break;
                } else {
                    cd.worker(currentNode, priorityQueue, this);
                }
            }

            long endTime = System.currentTimeMillis();
            long timeSpent = endTime - startTime;
            System.out.println("Total milliseconds passed : " + timeSpent);
            System.out.println("Total path length : " + swapNumber);
            System.out.println("Expanded node count : " + ExploredNodeCount);
        }
        else if (choice == 2) {
            long startTime = System.currentTimeMillis();
            Comparator<Node> costComparator = new Comparator<Node>() {
                @Override
                public int compare(Node s1, Node s2) {
                    return (man.cost(s1,goalMatrix)+s1.level) - (man.cost(s2,goalMatrix)+s2.level);
                }
            };


            PriorityQueue<Node> priorityQueue = new PriorityQueue<>(costComparator);

            priorityQueue.add(node);
            String s = Arrays.deepToString(node.matrix);
            map.put(s, 1);

            Node currentNode;

            while (!priorityQueue.isEmpty()) {

                currentNode = priorityQueue.remove();
                ExploredNodeCount+=1;
                if (man.cost(currentNode, goalMatrix) == 0) {
                    //reached the goal state
                    Node current = currentNode;
                    ArrayList<Node> result = new ArrayList<>();
                    while (current != null) {
                        result.add(0, current);
                        swapNumber += 1;
                        current = current.parent;
                    }
                    for (int i = 0; i < result.size(); i++) {
                        for (int m = 0; m < 4; m++) {
                            for (int n = 0; n < 4; n++) {
                                System.out.print(result.get(i).matrix[m][n] + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                } else {
                    cd.worker(currentNode, priorityQueue, this);
                }
            }

            long endTime = System.currentTimeMillis();
            long timeSpent = endTime - startTime;
            System.out.println("Total milliseconds passed : " + timeSpent);
            System.out.println("Total path length : " + swapNumber);
            System.out.println("Expanded node count : " + ExploredNodeCount);
        }


    }
}

