
import java.util.Arrays;

/**
 * La clase MiArrayList tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList"
 * es claro que no se puede utilizar dicha estructura ya utilizada dentro de este ejercicio. 
 * Para más información de la clase ArrayList:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 * 
 * 
 * @author (Luis Fernando Posada Cano)
 * @version(25/10/2020)
 */

public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 
    
    /**
    * El metodo constructor se utiliza para incializar
    * variables a valores neutros como 0 o null.
    * El contructor no lleva parámetros en este caso.
    */
    public MiArrayList() {
        size = 0;
        elements = new int [DEFAULT_CAPACITY];
    }     

    
    /**
    * Tiene la intención de retornar la longitud del objeto
    * @return longitud del objeto
    *
    * El size esta influenciado por las funciones add y del
    */
    public int size() {
        return this.size;
    }   
    
    /** 
    * @param e el elemento a guardar
    * Agrega un elemento e a la última posición de la lista
    *
    */
    public void add(int e) {
        if (size == elements.length) { // A1 = 2 0(1)
            int [] nuevo = new int [elements.length*2];// A2 = 3 O(1)
            for (int i = 0; i < elements.length; i++)// A3 + A4n O(n)
            nuevo [i] = elements [i]; // A5n        O(n)
            elements = nuevo; // A6 O(1)
    }    
    elements[size] = e; //A7 O(1)
    size++; //A8
}
    /** 
    * @param i es un íncide donde se encuentra el elemento posicionado
    * Retorna el elemento que se encuentra en la posición i de la lista.
    *
    */
    public int get(int i) {
        if (i < size && i >= 0) // A1
    
    return elements[i]; //A2
    
    else 
    throw new ArrayIndexOutOfBoundsException(); //A3
}

    
    /**
    * @param index es la posicion en la cual se va agregar el elemento
    * @param e el elemento a guardar
    * Agrega un elemento e en la posición index de la lista
    *
    */
    public void add(int index, int e) {
      if (size == elements.length) {
          int [] nuevo = new int [ elements.length*2];
          for (int i = 0; i < elements.length; i++){
              nuevo[i] = elements[i];
    } 

    elements = nuevo;


}

int [] nuevo1;
nuevo1 = elements;
for (int i = index+1; i < elements.length; i++){
    nuevo1[i] = elements[i-1];
}
 elements = nuevo1;
elements[size] = e;
size++;
}


    /**
    * @param index es la posicion en la cual se va eliminar el elemento
    *
    * ELimina el elemento  en la posición index de la lista
    *
    */

  public void del(int index){
       int [] nuevo1;
       nuevo1=elements;
       for (int i = index; i < elements.length-1; i++){
           nuevo1[i] = elements[i+1];
        }
        elements = nuevo1;
        size--;
    }
    
  public static void main (String[] args){
        MiArrayList prueba= new MiArrayList();
        prueba.add('1');
        System.out.println(prueba.size());
        prueba.add('2',1);
        System.out.println(prueba.size());
        prueba.del(0);
        System.out.println(prueba.size());
    }
}