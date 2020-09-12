
/**
 *Clase donde encontraremos las listasEnlazadas.
 * 
 * Como sabemos que el metodo insert y remove tienen una complejidad de O(n)
 * se pueden utilizar con millones de abejas.
 * 
 * @author Juan Pablo Giraldo, Luis Fernando Posada Cano
 */
import java.lang.IndexOutOfBoundsException;
// Lista enlazada simple.
public class ListaEnlazada {
   private Node primera;
   private int size;
   public ListaEnlazada(){
       size = 0;
       primera = null;    
   }

   /**
    * Retorna el nodo en un especifica posición en la lista.
    * @param index - indice del nodo a devolver.
    * @return El nodo en una posición espeficica de la liista.
    * @throws IndexOutOfBoundsException
    */
   private Node getNode(int index) throws IndexOutOfBoundsException {
     if (index >= 0 && index < size) {
        Node temp = primera;
        for (int i = 0; i < index; i++) {
          temp = temp.next;
         }
        return temp;
        } else {
        throw new IndexOutOfBoundsException();
     }
   }

   /**
    * Retorna el elemento en una especifica posición en la lista.
    * @param index - indice del elemento a devolver.
    * @return El elemento en la especifica posición en la lista.
    * @throws IndexOutOfBoundsException
    */
   public int get(int index) throws IndexOutOfBoundsException {
     Node temp = getNode(index);
     return temp.data;
   }
        
   /**
    * En este metodo se devuelve la cantidad de datos ingresados en 
    * la lista.
    * @return la cantidad de datos ingresados en la lista.
    */
   public int size(){
     return this.size;
   }
   
   /**
    * Este método nos permite insertar datos en la última posición.
    * @param datos a ingresar.
    */
   public void insert(int data){
     insert(data,size);
   }

   // Este metodo inserta un dato en la posición index
   public void insert(int data, int index) throws IndexOutOfBoundsException{
     if(index>=0 && index<=size){
       Node buscar = primera;
       Node nuevo = new Node(data);
       if(index == 0){
         this.primera = nuevo;
         primera.next = buscar;
         this.size++;
         return;
        }
       int cont = 0;
       while(cont<index-1){
         buscar = buscar.next;
         cont++;
       }      
       Node aux = buscar.next;
       buscar.next = nuevo;
       nuevo.next=aux;    
       size++;
       }else{
       throw new IndexOutOfBoundsException();
     }   
   }

   // Este metodo borra un dato en la posición index
   public void remove(int index)throws IndexOutOfBoundsException{
     if(index >= size || index < 0)
       throw new IndexOutOfBoundsException();   
     if(index == 0 ){
       primera = primera.next;
       size--;
       return;
     }
     Node buscar = primera;
     int cont = 0;
     while(cont<index-1){
       buscar = buscar.next;
       cont++;
     }      
     Node aux = buscar.next;
     buscar.next = aux.next;
     size--;    
   }

   public void clear(){
     this.primera = null;
     this.size = 0;
   }

   //Verificamos un dato en la lista.
   public boolean contains(int data){
     int n = containsPos(data);
     if(n==-1)
       return false;
     else 
       return true;
   }

   public int containsPos(int data){
     Node buscar = primera;
     int cont = 0;
     while(buscar != null){
       if(buscar.data == data)
         return cont;
       buscar = buscar.next;
       cont++;
     }
     return -1;
   }

   private static int maximo(Node nodo, int n){
     if(nodo == null) 
       return n;
     System.out.println(nodo.data);
     if(nodo.data>n){
       n = nodo.data;
     }
     return maximo(nodo.next,n);
   }

   public static int maximo (ListaEnlazada lista){
     return maximo(lista.primera,-999999999);
   }

   private static boolean comparar(Node nodo1,Node nodo2){
     if(nodo1.next == null) 
       return true;
     if(nodo1.data != nodo2.data) 
       return false;
     else 
       return comparar(nodo1.next,nodo2.next);
   }

   public static boolean comparar(ListaEnlazada lista1, ListaEnlazada lista2){
     if(lista1.size != lista2.size) 
       return false;
     else 
       return comparar(lista1.primera,lista2.primera);
   }
}