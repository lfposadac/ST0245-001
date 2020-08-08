
/**
 *  Algoritmo para calcular la subsecuencia común más larga a dos cadenas de caracteres.
 * 
 * @author (Juan Pablo Giraldo Ramirez, Luis Fernando Posada Cano) 
 * @version (07/08/2020)
 */
public class punto4
{  
    public int main(String subSe1, String subSe2){
        return this.subsecuencia(subSe1, subSe2, 0, 0);
    }
    
    private int subsecuencia(String subSe1, String subSe2, int contador, int index){
        if (subSe1.length() == 0 || subSe2.length() == 0){
            return contador;
        }
        else {
            if (index <= subSe2.length()-1){
                if (subSe1.charAt(0) != subSe2.charAt(index)){
                    return subsecuencia(subSe1, subSe2, contador, index+1);
                }
                else {
                    return subsecuencia(subSe1.substring(1), this.idk(subSe2, index), contador+1, 0);
                }
            }
            else{
                return subsecuencia(subSe1.substring(1), subSe2, contador, 0);
            }
        }
    }
    
    private String idk (String s, int index){
        if (index != 0 && index < s.length() -1){
            return s.substring(0,index) + s.substring(index + 1);
        }
        else if (index == 0){
            return s.substring(1);
        }
        else if (index == s.length() -1){
            return s.substring(0, index);
        }
        return s;
    }
}

