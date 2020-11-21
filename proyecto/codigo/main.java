
/**
 * Ejecutamos el programa.
 * 
 * @author (Luis Fernando Posada Cano) 
 * @version (16/11/2020)
 */
import java.io.*;
import java.util.*;
import javafx.util.Pair;
public class main
{
    public static void main(String[] args) throws Exception{
        BufferedReaderClass br = new BufferedReaderClass("4_train_balanced_135000.csv");
        BuildTree t = new BuildTree();
        long start = System.currentTimeMillis();
        Node y = t.decisionTree(br.matrix);
        long finalT = System.currentTimeMillis();
        System.out.println("It's takes " + (finalT -start));
        
        BufferedReaderClass br2 = new BufferedReaderClass("4_test_balanced_135000.csv");
        double[] in = Test.information(br2.matrix, y);
        System.out.println("Precision: " + in[0]);
        System.out.println("Sensibilidad: " + in[1]);
        System.out.println("Exactitud: " + in[2]);
    }
}