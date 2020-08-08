
/**
 * Arreglo recursivo para mostrar las diferentes combinaciones de objetos dentro de mi inventario.
 * 
 * @author (Juan Pablo Giraldo Ramirez, Luis Fernando Posada Cano) 
 * @version (07/08/2020)
 */
public class Punto3
{
    public static void combinacion(String base, String s){
       if(s.length()==0){
        System.out.println(base);
     }else{
        combinacion(base+s.charAt(0),s.substring(1));
        combinacion(base,s.substring(1));
        }
   }
}
