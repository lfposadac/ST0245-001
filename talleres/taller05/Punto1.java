
/**
 * Write a description of class Punto2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto1
{
    private static void seIntercambian(int[] a, int primero, int segundo){
      int temp = a[primero];
    a[primero] = a[segundo];
    a[segundo] = temp;
  }
    private static void bailesito(int[] a, int primero, int segundo){
        if (a[segundo] < a[primero])
          seIntercambian(a, primero, segundo);
  }
  public static void insertionSort(int[] a){
      for(int i = 1; i < a.length; i++) //El verde
      {
          for(int j = i; j > 0; j--) // El rojo
        {
              bailesito(a, j, j-1);
        }
      }
  }
}
