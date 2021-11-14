public class displacement {

    public int cost(Node node,int[][] goalMatrix){
        int totalCost = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(node.matrix[i][j] != 0) {
                    if (node.matrix[i][j] != goalMatrix[i][j]) {
                        totalCost += 1;
                    }
                }
            }
        }
        return totalCost;
    }



}
