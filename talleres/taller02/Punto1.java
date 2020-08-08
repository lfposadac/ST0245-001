
/**
 * Algoritmo de euclides de forma recursiva.
 * 
 * @author (Luis Fernando Posada Cano, Juan Pablo Giraldo Ramirez) 
 * @version (07/08/2020)
 */
public class Punto1
{
    public static int gcd(int p,int q){ 
      // p > q  
      if (q == 0)
        return p;
       else
        return gcd(q, p % q);
    }
}
