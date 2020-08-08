
/**
 * Algoritmo para determinar si exite o no existe un subgrupo de elementos cuya suma sea igual al peso maximo.
 * 
 * @author (Luis Fernando Posada Cano,Juan Pablo Giraldo Ramirez) 
 * @version (07/08/2020)
 */
public class Punto2
{
   private static boolean SumaGrupo(final int start, final int [] nums, final int target){
    if (target == 0){
        return true;
    }else if(start == nums.length){
        return false;
    }else{
        return SumaGrupo(start+1, nums, target-nums[start]) || SumaGrupo(start+1,nums, target);
    }
    }
}
