/**
 * Lab3AGenerics.java
 * Used to illustrate basic principles of generic types
 * and type safety in Java.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  2015-08-24
 *
 */
public class Lab3AGenerics {

   /** 
    * Make this method generic. Use a type variable named
    * T that will allow you to search through an array
    * of any type and return the location of target in a
    * or -1 if it doesn't exist.
    */
   public static int search(Comparable a[], Comparable target) {
      int i = 0;
      while ((i < a.length) && (a[i].compareTo(target) == 0 )) {
      //while ( (i < a.size()) && (!a[i].equals(target)) ) {
         i++;
      }
      if (i < a.length) {
         return i;
      }
      else {
         return -1;
      }
   }

  /** Drives execution. */
   /*public static void main(String[] args) {
       // You'll need to change these statements once
       // you make the search method generic.
      //int[] a1 = {4, 10, 2, 8, 6};
      Integer[] a1 = {4, 10, 2, 8, 6};
      int i = Lab3AGenerics.<Integer>search(a1, 8);
      System.out.println(i);
   } */

   public static void main(String[] args) {
      Comparable[] a = {"red", new Double(3.14), new String("3.14")};
      int i = Lab3AGenerics.search(a, new Double(3.14));
      System.out.println(i);
   }

}