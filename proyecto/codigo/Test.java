
/**
 * Esta clase es la clase para testear el programa.
 * 
 * @author (Luis Fernando Posada Cano) 
 * @version (16/11/2020)
 */
public class Test
{
    public static int[] labelsTree(String[][] m, Node n){
        int labelsTree [] = new int[m.length];
        for(int fila = 0; fila < m.length; fila++){
            if(decideLabels(m, fila, n)){
                labelsTree[fila] = 1;
            }else{
                labelsTree[fila] = 0;
            }
        }
        return labelsTree;
    }  

    public static boolean decideLabels(String[][] m, int fila, Node n){
        int columna =  n.bestCol;
        String valor = n.bestVal;
        if(n.trueBranch == null || n.falseBranch == null) return n.succes;

        if(Tree.isNumeric(valor)){
            double v = Double.parseDouble(valor);
            if(Double.parseDouble(m[fila][columna]) >= v){
                return decideLabels(m, fila, n.trueBranch);
            }else{
                return decideLabels(m, fila, n.falseBranch);
            }
        }else{
            if(m[fila][columna].equals(valor)){
                return decideLabels(m, fila, n.trueBranch);
            }else{
                return decideLabels(m, fila, n.falseBranch);
            }
        }
    }

    public static double[] information(String[][] m, Node n){
        int[] etiquetas = labelsTree(m,n);
        double truePositives = 0; 
        double falseNegatives = 0;
        double falsePositives = 0;
        double trueNegatives = 0;
        for(int fila = 0; fila < m.length; fila++){
            if(Integer.parseInt(m[fila][m[0].length-1]) == (etiquetas[fila]) && (etiquetas[fila] == 1)){
                truePositives++;
            }else if(Integer.parseInt(m[fila][m[0].length-1]) != (etiquetas[fila]) && (etiquetas[fila] == 1)){
                falsePositives++; 
            }else if(Integer.parseInt(m[fila][m[0].length-1]) == (etiquetas[fila]) && (etiquetas[fila] == 0)){
                trueNegatives++;
            }else if(Integer.parseInt(m[fila][m[0].length-1]) != (etiquetas[fila]) && (etiquetas[fila] == 0)){
                falseNegatives++;
            }            
        }
        double precision = (truePositives) / (truePositives + falsePositives);
        double sensitivity = (truePositives) / (truePositives + falseNegatives);
        double exactitude = (truePositives + trueNegatives) / (falsePositives + truePositives + falseNegatives+trueNegatives);
        double[] info = new double[3];
        info[0] = precision;
        info[1] = sensitivity;
        info[2] = exactitude;
        return info;
    }
}