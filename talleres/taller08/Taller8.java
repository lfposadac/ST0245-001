/**
 *
 * 
 * @author (Luis Fernando Posada Cano)
 * @version(25/10/2020)
*/
import java.util.*;
public class Taller8 {
    /**
    * @param string es una cadena de texto que viene de la siguiente maanera 3 4 5 * + o de la siguiente manera 2 3 * 5 +
    * todo va estar separado por espacios para esto la funcion split.
    * Se intenta hacer el calculo por medio del metodo polaco posfijo
    * @return un entero resultado de la operación
    */
    public static int polaca (String string){
        String[] prefixStr = string.split(" ");
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<prefixStr.length;i++){
            if(prefixStr[i].equals("+")){
                stack.push(stack.pop()+ stack.pop());
            }
            else if(prefixStr[i].equals("*")){
                stack.push(stack.pop()*stack.pop());
            }
            else if(prefixStr[i].equals("-")){
                stack.push(stack.pop() - stack.pop());
            }
            else if(prefixStr[i].equals("/")){
                stack.push(stack.pop()/stack.pop());
            }
            else{
                stack.push(Integer.parseInt(prefixStr[i]));
            }
       }
       return stack.pop();
    }
    /**
    * @param stack es una pila ya implementada que se crea en el test
    * Este método se encarga de poner la pila stack en orden inverso
    * @return una pila que haga el inverso de stack
    */
    public static Stack<Integer> inversa (Stack<Integer> stack){
        int n = stack.size();
        Stack<Integer> temp= new Stack<Integer>();
          for(int i = 0; i < n; i++) 
            temp.push(stack.pop());
         return temp;
    }
    /**
    * @param queue es una cola ya implementada que se crea en el test
    * Este método se encarga de atender a personas.
    * 
    */
    public static void cola (Queue<String> queue){
       while(!queue.isEmpty()){
            System.out.println("Atendiendo a "+queue.poll());
        }
    }
}