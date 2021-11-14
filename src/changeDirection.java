import java.util.PriorityQueue;

public class changeDirection {
    public void worker(Node currentNode, PriorityQueue<Node> priorityQueue, heuristic h) {
        if(currentNode.blankRow == 0 && currentNode.blankCol == 0){
            //move down, move right
            moves.moveDown(currentNode,priorityQueue,h);
            moves.moveRight(currentNode,priorityQueue,h);
        }
        else if(currentNode.blankRow == 3 && currentNode.blankCol == 0){
            //move up, move right
            moves.moveUp(currentNode,priorityQueue,h);
            moves.moveRight(currentNode,priorityQueue,h);
        }
        else if(currentNode.blankRow == 0 && currentNode.blankCol == 3){
            //move left, move down
            moves.moveLeft(currentNode,priorityQueue,h);
            moves.moveDown(currentNode,priorityQueue,h);
        }
        else if(currentNode.blankRow == 3 && currentNode.blankCol == 3){
            //move up, move left
            moves.moveUp(currentNode,priorityQueue,h);
            moves.moveLeft(currentNode,priorityQueue,h);
        }
        else if(currentNode.blankCol == 0){
            //move up,move right,move down
            moves.moveUp(currentNode,priorityQueue,h);
            moves.moveDown(currentNode,priorityQueue,h);
            moves.moveRight(currentNode,priorityQueue,h);
        }
        else if(currentNode.blankCol == 3){
            //move up,move left,move down
            moves.moveUp(currentNode,priorityQueue,h);
            moves.moveDown(currentNode,priorityQueue,h);
            moves.moveLeft(currentNode,priorityQueue,h);

        }
        else if(currentNode.blankRow == 0){
            //move left,move right,move down
            moves.moveDown(currentNode,priorityQueue,h);
            moves.moveLeft(currentNode,priorityQueue,h);
            moves.moveRight(currentNode,priorityQueue,h);
        }
        else if(currentNode.blankRow == 3){
            //move up,move left,move right
            moves.moveLeft(currentNode,priorityQueue,h);
            moves.moveRight(currentNode,priorityQueue,h);
            moves.moveUp(currentNode,priorityQueue,h);
        }
        else{
            //move in all 4 directions
            moves.moveLeft(currentNode,priorityQueue,h);
            moves.moveRight(currentNode,priorityQueue,h);
            moves.moveUp(currentNode,priorityQueue,h);
            moves.moveDown(currentNode,priorityQueue,h);
        }
    }
}

