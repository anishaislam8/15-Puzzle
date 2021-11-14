public class Node {
    Node parent;
    Node leftChild = null;
    Node rightChild = null;
    Node upChild = null;
    Node downChild = null;

    int level;

    int[][] matrix = new int[4][4];
    int blankRow;
    int blankCol;

    Node(int blankRow, int blankCol, int[][] matrix,Node parent,int level){
        this.blankRow = blankRow;
        this.blankCol = blankCol;
        this.matrix = matrix;
        this.parent = parent;
        this.level = level;
    }
}

