import java.util.ArrayList;

public class manhattan {

    public int cost(Node node,int[][] goalMatrix){
        int totalCost = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(node.matrix[i][j] != 0) {
                    if (node.matrix[i][j] != goalMatrix[i][j]) {
                        int goalRow = findPosition(node.matrix[i][j], goalMatrix).get(0);
                        int goalCol = findPosition(node.matrix[i][j], goalMatrix).get(1);
                        totalCost += Math.abs(i - goalRow) + Math.abs(j - goalCol);
                    }
                }
            }
        }
        return totalCost;
    }

    public ArrayList<Integer> findPosition(int i, int[][] goalMatrix){
        ArrayList<Integer> found = new ArrayList<>();
        int k = 0;
        for(int m = 0; m < 4; m++){
            for(int n = 0; n < 4; n++){
                if(goalMatrix[m][n] == i){
                    found.add(m);
                    found.add(n);
                    k = 1;
                    break;
                }
            }
            if(k == 1){
                break;
            }
        }
        return found;
    }



}
