/**
 * SortingLabClient.java. 
 * Provides a simple example client of SortingLab.java.
 *
 * NOTE: The generic type of SortingLab must be bound
 *       to a Comparable type. The sorting methods in
 *       SortingLab use the natural ordering of the
 *       elements in the parameter array.
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2015-09-11
 *
 */
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public final class SortingLabClient {

  /** Drives execution. */
   public static void main(String[] args) {
      int key = 46;
      // run one sort on an array of Strings
      /*String[] as = {"D", "B", "E", "C", "A"};
      SortingLab<String> sls = new SortingLab<String>(key);
      sls.sort1(as);*/
      
      Pair[] a = {new Pair(5,1), new Pair(4,2), new Pair(3,3), 
                  new Pair(5,4),new Pair(2,5), new Pair(1,6), new Pair(5,7)};
       
      SortingLab<Pair> sl2 = new SortingLab<>(key);
      sl2.sort5(a);
      System.out.println("========sort 1===========================");
      for (int i = 0; i < 7; i++){
          System.out.print(a[i] + "\t");
      }
      
   
      // run a sort on multiple Integer arrays of increasing length
      SortingLab<Integer> sli = new SortingLab<Integer>(key);
      int M = 500000; //2000000; // max capacity for array
      int N = 1000;   //10000;   // initial size of array
      double start;
      double elapsedTime;
      
      double[] t = new double[100];
      double R;
      double k;
      
      //for (; N < M; N *= 2) {
      for (int i = 0; i < 16; i++) {
         Integer[] ai = getIntegerArray(N, Integer.MAX_VALUE);
         start = System.nanoTime();
         sli.sort5(ai);
         elapsedTime = (System.nanoTime() - start) / 1000000000d;
         System.out.print(N + "\t");
         System.out.printf("%4.3f\t", elapsedTime);
         
         t[i] = elapsedTime;
         if (i >= 1) {
            R = t[i] / t[i - 1];
            k = Math.log(R) / Math.log(2);
            System.out.printf("%4.3f\t", R);
            System.out.printf("%4.3f\n", k);
         }
         else {System.out.print("\n");}
         N *= 2;
      } 
   } 

  /** 
   * Returns an array of size N filled with Integer values
   * in the range 0 .. max - 1.
   */
   private static Integer[] getIntegerArray(int N, int max) {
      Integer[] a = new Integer[N];
      java.util.Random rng = new java.util.Random();
      for (int i = 0; i < N; i++) {
         a[i] = rng.nextInt(max);
      }
      Arrays.sort(a);
      /*Integer[] b = new Integer[N];
      for (int i = 0; i < N; i++) {
         b[i] = a[N - i - 1];
      }
      return b;*/
      return a;
   } 

}