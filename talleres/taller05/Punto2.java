
/**
 * Write a description of class Punto1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto2
{
      public static int suma(int[] a){
     int acum = 0;  // c1 
     for (int i = 0; i < a.length; i++) // c2 + c3n
        acum = acum + a[i]; // c4n
     return acum; // c5
  }               // T(n) = c1 + c2 + c5 + (c3 + c4)n
                  // T(n) es O(n)
                  
  public static void main(String[] args){
      for (int n = 10000000; n < 100000000; n = n + 10000000){ 
        long ti = System.currentTimeMillis();
        suma(new int[n]);
        long tf = System.currentTimeMillis();
        System.out.println(tf-ti);      
      }
  }
}
