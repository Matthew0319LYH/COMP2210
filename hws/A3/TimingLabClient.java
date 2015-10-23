/**
 * TimingLabClient.java. 
 * Provides a simple example client of TimingLab.java.
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2015-09-11
 *
 */
public class TimingLabClient {

  /** Drives execution. */
   public static void main(String[] args) {
   
      // some useful variables that you will need in
      // your own code
      double BILLION = 1000000000d; // nanoseconds to seconds
      double start = 0;         // start time of the current run
      double elapsedTime = 0;   // elapsed time of current run
      double prevTime = 0;      // elapsed time of previous run
      double ratio = 1;         // currentTime / prevTime
      double lgratio = 0;       // log base 2 of ratio
      int N = 1;                // problem size parameter
      int key = 46;             // selects internal method of RunningTime
      
      double[] t = new double[100];
      double R;
      double k;
   
      // time a single method in this class
      start = System.nanoTime();
      foo();
      elapsedTime = (System.nanoTime() - start) / BILLION;
      System.out.print("This call to method foo() took ");
      System.out.printf("%4.3f", elapsedTime);
      System.out.println(" seconds.");
   
      // measure elapsed time for a single call to timeTrial
      TimingLab tl = new TimingLab(key);
      start = System.nanoTime();
      tl.timeTrial(N);
      elapsedTime = (System.nanoTime() - start) / BILLION;
      System.out.print("This call to method TimingLab.timeTrial("
         + N + ") took ");
      System.out.printf("%4.3f", elapsedTime);
      System.out.println(" seconds.");
   
      // measure elapsed time for multiple calls to timeTrial
      // with increasing N values
      System.out.print("Timing multiple calls to timeTrial(N) ");
      System.out.println("with increasing N values.");
      System.out.println("N\tElapsed Time (sec) \tR\tK");
      for (int i = 0; i < 10; i++) {
         start = System.nanoTime();
         tl.timeTrial(N);
         elapsedTime = (System.nanoTime() - start) / BILLION;
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
   * Something that will hopefully take time >= 0.001 seconds
   * so that the program output looks better.
   */
   private static void foo() {
      for (int i = 0; i < 100000; i++) {
         String s1 = "War";
         String s2 = "Eagle";
         String s3 = s1 + s2;
         s1 = null;
         s2 = null;
         s3 = null;
      }
   }

}
