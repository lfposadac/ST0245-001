
/**
 * Write a description of class Punto1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto1
{
    public static void hanoi(int  topN){
    hanoi(topN, "Tower1", "Tower2", "Tower3");
 }
 public static void hanoi(int topN, String a, String b, String c){
    if (topN == 1)
        System.out.println (a + " -> " + c);
    else {
        hanoi(topN - 1 ,a , c ,b);
        hanoi(1 , a , b , c);
        hanoi(topN - 1 ,b , a ,c);
    }
 }
 public static void main(String[] args){
   hanoi(3);
 }
}
