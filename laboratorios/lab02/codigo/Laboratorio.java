
/**
Esta clase contiene los algoritmos merge sort e insertion sort, los cuales fueron propuestos en el Laboratorio 2.
@author Luis Fernando Posada Cano y Juan Pablo Giraldo Ramirez
@version 06/09/2020
*/
public class Laboratorio
{
 /**
 *Este método permite ordenar un arreglo empleando el concepto de divide y vencerás. 
 *@param int[] a arreglo que se organizará. 
 *@see merge(int[] a, int[] a1, int[] a2, int izq, int der)
 */
 public static void mergeSort(int[] a) {
        if (a.length > 1) {                                                     
        int[] a1 = new int[a.length/2];                                         
        int[] a2 = new int[a.length - a1.length];                               
     
        System.arraycopy(a, 0, a1, 0, a1.length);                               
        System.arraycopy(a, a1.length, a2, 0, a2.length);                       
        mergeSort(a1);                                                          
        mergeSort(a2);                                                          
        merge(a, a1, a2, a1.length, a2.length);                                
       }                                                                       
 }                                                                           
      
 /** 
 *Este método compacta los arreglos que se separan en el método mergSort(int [] a) en un solo arreglo y  luego se realizan las comparaciones
 *correspondientes para ordenarlo.
 @param int[]a arreglo original.
 @param int[]a1 primera mitad del arreglo separado.
 @param int[]a2 segunda mitad del arreglo separado.
 @param int izq longitud del arreglo a1.
 @param int der longitud del arreglo a2.
 */
 private static void merge(int[] a, int[] a1, int[] a2, int izq, int der) {  
    int x = 0;
    int y = 0;
    int z = 0;
    while (x < izq && y < der) {                                                
        if (a1[x] <= a2[y]){
            a[z] = a1[x];
            x++;
        }
        else{
            a[z] = a2[y];
            y++;
        }
        z++;
    }
    while (y < der) {
        a[z] = a2[y];
        y++;
        z++;
    }
    while (x < izq) {
        a[z] = a1[x];
        x++;
        z++;
    }
 }
 
 /**
 * Este método se utiliza para organizar un arreglo comparando si el elemento a organizar es mayor que los elementos anteriores.
 * para determinar su posición para que quede en orden.
 * @param int [] array arreglo que se organizará
 */
 public static void insertionSort(int[] array) {
    for (int i = array.length - 1; i > 0; i--) {                             
        int mayor = 0;                                                       
        for (int j = 0; j < i; j++) {                                       
            if (array[j + 1] > array[mayor]) {
                mayor = j + 1;                                               
            }
        }
        swap(array, i, mayor);                                               
    }                                                                                   
 }                                                                            
                                                                         
 /**
 * Este método permite intercambiar de posición los elementos de un arreglo.
 * @param int [] array arreglo donde están los valores principales a cambiar.
 * @param int m posición del primer elemento. 
 * @param int n posición del segundo elemento 
 */
 private static void swap(int[] array, int m, int n) {
        int temp = array[n];
        array[n] = array[m];
        array[m] = temp;  
    }

 /**
 *Este método permite tomar el tiempo de ejecución de cualquiera de los algoritmos.
 */
 public static void main (String args[]){
   for(int i = 110000; i <= 300000; i = i + 10000){
      long ti = System.currentTimeMillis();
      mergeSort(new int[i]);
      long tf = System.currentTimeMillis();
      System.out.println(tf - ti);
        }
 }
}