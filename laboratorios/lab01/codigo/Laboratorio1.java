
/**
 * La siguiente clase da respuesta al punto 1.1 y el punto 1.2 del laboratorio 01
 * 
 * @author (Luis Fernando Posada Cano && Juan Pablo Giraldo Ramirez) 
 * @version (23/08/2020)
 */
public class Laboratorio1
{
    /*
     * Algoritmo para calcular la longitud de la subsecuencia común más larga entre dos cadenas de caracteres.
     * @param m Primera cadena de caracteres.
     * @param n Segunda cadena de caracteres.
     * @return La longitud de la subsecuencia común más larga.
     */
    
    public static int lcs(String m, String n) {
        if((m.length()==0) || (n.length()==0)){
            return 0;
        }
        if(m.charAt(m.length()-1) == n.charAt(n.length() -1)){
            return 1 + lcs(m.substring(0,m.length() - 1), n.substring(0, n.length() -1));
        }else{
            return Math.max(lcs(m, n.substring(0, n.length() -1)), lcs(m.substring(0,  m.length() -1),n));
        }
    }
    /*
     * Algoritmo para encontrar cuantas formas se puede llenar un rectángulo de 2xn cm^2 con rectángulos de 1x2 cm^2
     * @param r  lado del rectagungulo 2xn
     * @return La cantidad de maneras que hay para ordenar rectangulos 1x2 en un rectangulo 2xn
     */
     public static int ways(int r){
        if(r<=2)
            return r; //C1
            
            return ways(r-1)+ways(r-2); //C2+T(n-1)+T(n-2)
        /*
        ECUACION DE RECURRENCIA:
            -C2+C1*Fn+C2*Ln
        CALCULO DE COMPLEJIDAD:
            O(2^n)
        */
    }
}
