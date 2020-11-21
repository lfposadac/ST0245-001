
/**
 * Nodo
 * 
 * @author (Luis Fernando Posada Cano) 
 * @version (16/11/2020)
 */
import java.util.*;
import javafx.util.Pair;
public class Node {
    public String[][] matrix;
    public Pair< Float, Pair<String,Integer>>  bestQuestion;
    public int bestCol;
    public String bestVal;
    public boolean succes; 
    public Node trueBranch;
    public Node falseBranch;
    public String[][] trueMatrix;
    public String[][] falseMatrix;

    public Node(String[][] M){
        matrix = M;
        bestQuestion = Tree.betterQuestion(matrix); 
        bestVal = bestQuestion.getValue().getKey();
        bestCol = bestQuestion.getValue().getValue();
        Pair<String[][],String[][]> parMatrix = Tree.divideMatrix(M, bestCol, bestVal);
        trueMatrix = parMatrix.getKey();
        falseMatrix = parMatrix.getValue();
        succes = Tree.countLabelsMatrix(matrix);
    }       
}
