
/**
 * Write a description of class Punto1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto1
{
    public static int maximo(int[] a){

         return maximo(a, a.length);

        }
    private static int maximo(int[] a, int lon){
         if (lon == 1)

             return a[0];

         else

             return Math.max(a[lon-1], maximo(a, lon-1)); // T(n) = c2 + T(n-1)
                                                                // T(n) = c1 + c2.n 
       }    
}
