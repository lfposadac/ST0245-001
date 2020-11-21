
/**
 * Creación del Arból y complejidad
 * 
 * @author (Luis Fernando Posada) 
 * @version (16/11/2020)
 */
import java.util.*;
import javafx.util.Pair;
public class Tree
{
    public static TreeSet<String> valoresSinRep(String[][] m, int variable){
        TreeSet<String> respuesta = new TreeSet();
        if(!isNumeric(m[0][variable])){
            for (int fila = 0; fila < m.length; fila++){
                if(!m[fila][variable].equals("")){
                    respuesta.add(m[fila][variable]);
                }
            }
        }else{
            double promedio = promedioNumerico(m, variable);
            respuesta.add(String.valueOf(promedio));

        }  
        return respuesta; 
    }

    public static boolean countLabelsMatrix(String[][] m){
        int contSi = 0;
        int cont = m.length;
        for(int i = 0; i < m.length; i++){
            if(m[i][m[0].length-1].equals("1")){
                contSi++;
            }            
        } 
        double probabilidad = (contSi*100) / cont;
        if(probabilidad >= 51)return true; 
        return false;
    }     

    public static Pair<String[][],String[][]> divideMatrix(String[][] m, int posVariable, String valor){
        int nodeTrueIzq = 0;
        if(isNumeric(valor)){
            double val = Double.parseDouble(valor);
            for (int fila = 0; fila < m.length; fila++){
                if (Double.parseDouble(m[fila][posVariable]) >= val){ 
                    nodeTrueIzq++;
                }
            }
        }else{
            for (int fila = 0; fila < m.length; fila++){
                if (m[fila][posVariable].equals(valor)){ 
                    nodeTrueIzq++;
                }
            }
        }
        int nodeFalseDrch = m.length - nodeTrueIzq;
        String[][] nodeIzqTrue = new String[nodeTrueIzq][m[0].length];
        String[][] nodeDrchFalse = new String[nodeFalseDrch][m[0].length];
        // Gracias a esto podemos copiar los datos en las matrices.
        int fila = 0;
        int filaN1 = 0;
        int filaN2=0;
        while(fila<m.length){ //
            if(!isNumeric(valor)){
                if(m[fila][posVariable].equals(valor)){
                    nodeIzqTrue[filaN1]=m[fila];
                    fila++;filaN1++;
                }else{
                    nodeDrchFalse[filaN2]=m[fila];
                    fila++;filaN2++;
                }
            }else{
                if(Double.parseDouble(m[fila][posVariable]) >= Double.parseDouble(valor)){
                    nodeIzqTrue[filaN1]=m[fila];
                    fila++;filaN1++;
                }else{
                    nodeDrchFalse[filaN2]=m[fila];
                    fila++;filaN2++;
                }
            }
        }
        
        Pair<String[][],String[][]> parMatrix = new Pair(nodeIzqTrue,nodeDrchFalse);
        return parMatrix;
    }
    // IG = 1 - (p0)^2 - (p1)^2. P0 = no/total P1 = si
    public static float giniNodo(String[][] m){
        float successfull = 0;
        for (int fila = 0; fila < m.length; fila++){
            if (m[fila][m[0].length-1].equals("1")){
                successfull++;
            }
        }
        float unsuccessfull = (float)m.length - successfull;
        float groupSuccessfull = successfull/(float)m.length;
        float groupUnsuccessfull = unsuccessfull/(float)m.length;
        float impurity = 1 - groupSuccessfull*groupSuccessfull - groupUnsuccessfull*groupUnsuccessfull;
        return impurity;        
    }

    public static double infoGain(String[][] nodeIzq, String[][] nodeDrch, float impurityMatrix){
        double p = (double)nodeIzq.length/((double)nodeIzq.length + (double)nodeDrch.length);
        return impurityMatrix - p * giniNodo(nodeIzq) - (1-p) * giniNodo(nodeDrch);
    }

    public static Pair< Float, Pair<String,Integer>> betterQuestion(String[][] matrix){ 
        // n*m*n = O(n^2*m*2^m)
        double best_gain = 0; 
        String best_question = "";
        float curren_uncertainty = giniNodo(matrix);
        int columna = 0; 
        double promedio = 0;
        for(int i = 0; i < matrix[0].length-1; i++){ //t(n) = m;//las columnas
            TreeSet<String> t = valoresSinRep(matrix, i);
            while(!t.isEmpty()){ // filas 
                String question = t.pollFirst();                 
                Pair<String[][],String[][]> pareja = divideMatrix(matrix, i, question); // las filas
                if(pareja.getKey().length == 0 || pareja.getValue().length == 0){
                    continue;
                }else{
                    double gain = infoGain(pareja.getKey(), pareja.getValue(), curren_uncertainty);
                    if(gain >= best_gain){
                        best_gain = gain;
                        best_question = question;
                        columna = i;
                    }
                }
            } 
        }
        Pair<String,Integer> m = new Pair(best_question, columna);
        Pair<Float,Pair<String,Integer>> bestQuestion = new Pair(best_gain, m);        
        return bestQuestion;
    }     

    public static double promedioNumerico(String[][] m, int columna) {
        double prom = 0;
        double suma = 0;
        double total = 0;
        for (int fila = 1; fila < m.length; fila++) {
            suma += Double.parseDouble(m[fila][columna]);
            total++;
        }
        prom = suma / total;
        return prom;
    }

    public static boolean isNumeric(String str)  
    {  
        try  
        {  
            double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe)  
        {  
            return false;  
        }  
        return true;  
    } 
}