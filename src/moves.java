import java.util.Arrays;
import java.util.PriorityQueue;

public class moves {
    public static void moveDown(Node currentNode, PriorityQueue<Node> priorityQueue, heuristic h){
        int[][] matrix = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                matrix[i][j] = currentNode.matrix[i][j];
            }
        }
        int x = matrix[currentNode.blankRow +1][currentNode.blankCol];
        matrix[currentNode.blankRow +1][currentNode.blankCol] = 0;
        matrix[currentNode.blankRow][currentNode.blankCol] = x;

        currentNode.downChild = new Node(currentNode.blankRow + 1, currentNode.blankCol,matrix,currentNode,currentNode.level + 1);

        String s = Arrays.deepToString(currentNode.downChild.matrix);

        if(h.map.get(s) == null) {
            priorityQueue.add(currentNode.downChild);
            //h.ExploredNodeCount += 1;
            h.map.put(s, 1);
        }

    }

    public static void moveRight(Node currentNode, PriorityQueue<Node> priorityQueue,heuristic h){
        int[][] matrix = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                matrix[i][j] = currentNode.matrix[i][j];
            }
        }
        int x = matrix[currentNode.blankRow][currentNode.blankCol + 1];
        matrix[currentNode.blankRow][currentNode.blankCol + 1] = 0;
        matrix[currentNode.blankRow][currentNode.blankCol] = x;

        currentNode.rightChild = new Node(currentNode.blankRow, currentNode.blankCol+1,matrix,currentNode,currentNode.level + 1);

        String s = Arrays.deepToString(currentNode.rightChild.matrix);


        if(h.map.get(s) == null) {
            priorityQueue.add(currentNode.rightChild);
            //h.ExploredNodeCount += 1;
            h.map.put(s, 1);
        }
    }

    public static void moveUp(Node currentNode, PriorityQueue<Node> priorityQueue,heuristic h){
        int[][] matrix = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                matrix[i][j] = currentNode.matrix[i][j];
            }
        }
        int x = matrix[currentNode.blankRow - 1][currentNode.blankCol];
        matrix[currentNode.blankRow  - 1][currentNode.blankCol] = 0;
        matrix[currentNode.blankRow][currentNode.blankCol] = x;

        currentNode.upChild = new Node(currentNode.blankRow - 1, currentNode.blankCol,matrix,currentNode,currentNode.level + 1);

        String s = Arrays.deepToString(currentNode.upChild.matrix);

        if(h.map.get(s) == null){
            priorityQueue.add(currentNode.upChild);
            //h.ExploredNodeCount += 1;
            h.map.put(s, 1);
        }
    }

    public static void moveLeft(Node currentNode, PriorityQueue<Node> priorityQueue,heuristic h){
        int[][] matrix = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                matrix[i][j] = currentNode.matrix[i][j];
            }
        }
        int x = matrix[currentNode.blankRow][currentNode.blankCol - 1];
        matrix[currentNode.blankRow][currentNode.blankCol - 1] = 0;
        matrix[currentNode.blankRow][currentNode.blankCol] = x;

        currentNode.leftChild = new Node(currentNode.blankRow, currentNode.blankCol - 1,matrix,currentNode,currentNode.level + 1);

        String s = Arrays.deepToString(currentNode.leftChild.matrix);

        if(h.map.get(s) == null){
            priorityQueue.add(currentNode.leftChild);
            //h.ExploredNodeCount += 1;
            h.map.put(s, 1);
        }
    }
}
