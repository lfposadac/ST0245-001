
/**
 * Write a description of class Punto2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto2
{
   public static void permutación(String s) {
       permuAux("", s);
    }
   private static void permuAux(String base, String s){
        if(s.length()==0){
            System.out.println(base);
            System.out.println(AdvancedEncryptionStandar.desencriptarArchivo(base));
        }else{
            for(int x=0; x<s.length(); x++) {
                permuAux(base+s.charAt(x),s.substring(0,x)+s.substring(x+1));
            }
        }
    }
}

