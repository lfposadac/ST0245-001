
/**
 * Leer el archivo CSV
 * 
 * @author (Juan Pablo Ramirez Giraldo, Luis Fernando Posada Cano) 
 * @version (16/08/2020)
 */
  
import java.io.*;
import java.net.*;
import java.util.*;

public class LeerCSV { 
    public static String Matriz[][]= null;
    public LeerCSV() throws Exception {
        BufferedReader C1= new BufferedReader(new FileReader(""));
        String datos;      
        int contador = 0;
        while((datos = C1.readLine()) != null) {
            contador++; 
        }
        C1.close();
        LeerCSV.Matriz=  new String[69][contador];
        BufferedReader C2= new BufferedReader(new FileReader(""));
        int x= 0;
        while((datos = C2.readLine())!=null){
            String[] splitted = datos.split(";");
            for(int i =0; i< splitted.length; i++) {
                Matriz[i][x]= splitted[i];
            }
            x++;
        }
        C2.close();
    }
    public static void main(String[] args) throws Exception{
        LeerCSV un = new LeerCSV();
        for(int i = 0; i<69;i++) {
            System.out.println(Matriz[i][10]);
        }
    }
}