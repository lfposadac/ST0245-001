
/**
 * Write a description of class Ejercicioenlinea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ejercicioEnLinea
{
 //2.1 nestParen, strCount, triangle, powerN, noX.
  public boolean nestParen(String str) {
    if (str.equals("")) 
      return true;
    if (str.charAt(0) == '(' && str.charAt(str.length()-1) == ')')
    return nestParen(str.substring(1,str.length()-1));
    else
    return false;
 }
 
  public int strCount(String str, String sub) {
   int strlen = str.length();
   int sublen = sub.length();
   if (strlen < sublen) 
        return 0;
   if (str.substring(0,sublen).equals(sub))
        return 1 + strCount(str.substring(sublen), sub);
   else
        return strCount(str.substring(1), sub);
 }
 
 public int triangle(int rows) {
   if(rows==0)
   	   return 0;
     else 
           return rows+triangle(rows-1);	 
 }

 public String noX(String str) {
   if (str.length() == 0)
     return "";
    else if (str.charAt(0)=='x')
     return noX(str.substring(1));
    else 
     return str.charAt(0)+noX(str.substring(1));
 }
 
 public int powerN(int base, int n) {
  if(n==0)
    	   return 1;
  	  else if(n==1) 
    	   return base;
  	  else 
    	   return base* powerN(base,n-1);
}

//2.2 splitArray, split0dd10, groupsum6, groupNoAdj, split53.

 public boolean splitArray(int[] nums) {
     return splitArrayAux(nums,0,0,0);
        }
 public boolean splitArrayAux(int[] nums, int start, int sum1, int sum2) {
  if(start>=nums.length) 
     return sum1==sum2;
  else 
    return splitArrayAux(nums,start+1,sum1+nums[start],sum2) || splitArrayAux(nums,start+1,sum1,sum2+nums[start]);
 }
 
 public boolean splitOdd10(int[] nums) {
  return splitOdd10Aux(nums,0,0,0);
    }
 public boolean splitOdd10Aux(int[] nums, int start, int sum1, int sum2) {
   if(start>=nums.length) 
      return (sum1%10==0 && sum2%2!=0);
   else 
      return splitOdd10Aux(nums,start+1,sum1+nums[start],sum2) || splitOdd10Aux(nums,start+1,sum1,sum2+nums[start]);
 }

 public boolean groupSum6(int start, int[] nums, int target) {
   if (start >= nums.length)
     return (target == 0);
   if (groupSum6(start+1, nums, target - nums[start])) 
     return true;
   if (nums[start] != 6 && groupSum6(start+1, nums, target))
     return true;
     return false;
 }
 
 public boolean groupNoAdj(int start, int[] nums, int target) {
   if(start>=nums.length) 
      return target==0;
   else 
      return groupNoAdj(start+2,nums,target-nums[start]) || groupNoAdj(start+1,nums,target);
 }
 
 public boolean split53(int[] nums) {
  int index = 0;
  int sum1 = 0;
  int sum2 = 0;
    return rArray(nums, index, sum1, sum2);
 }
 private boolean rArray ( int[] nums, int index, int sum1, int sum2 ) {
  if ( index >= nums.length ) {
    return sum1 == sum2;
  }
    int value = nums[index];
  if (value%5 == 0)
    return rArray(nums, index + 1, sum1 + value, sum2);
  else if (value%3 == 0)
    return rArray(nums, index + 1, sum1, sum2 + value);
  else    
   return (rArray(nums, index + 1, sum1 + value, sum2) || rArray(nums, index + 1, sum1, sum2 + value));
 }
}

