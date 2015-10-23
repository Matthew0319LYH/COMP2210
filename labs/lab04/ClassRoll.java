import java.util.Collections;
<<<<<<< HEAD
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
=======
import java.util.List;
import java.util.LinkedList;
import java.util.Comparator;
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940

/**
 * ClassRoll.java.
 * A class to illustrate storing and sorting
 * a list of Students.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
<<<<<<< HEAD
 * @version  2015-08-28
=======
 * @version  2014-09-02
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
 *
 */
public class ClassRoll {

<<<<<<< HEAD
  /** Drives execution. */
=======
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
   public static void main(String[] args) {
      List<Student> roll = new LinkedList<Student>();
      buildRoll(roll);
      printRoll(roll, "Original");
   
     // Use the Collections.shuffle() method to
     // arrange the Students in the roll in some
     // random order.
<<<<<<< HEAD
      Collections.shuffle(roll);
     
=======
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
   
      printRoll(roll, "Shuffled");
   
      Collections.<Student>sort(roll);
      printRoll(roll, "Sorted in natural order");
   
      Comparator<Student> orderBySection = new CompareStudentsBySection();
      Collections.<Student>sort(roll, orderBySection);
      printRoll(roll, "Sorted by section");
   
     // Use the Collections.reverseOrder() method to
     // set the following Comparator to the reverse of
     // CompareStudentsBySection; that is, a comparator
<<<<<<< HEAD
     // for descending order of section.     
     
      Comparator<Student> reverseOrderBySection = Collections.reverseOrder();  // null;
      Collections.<Student>sort(roll, reverseOrderBySection);
      printRoll(roll, "Sorted in reverse order of section");
   }

  /** Adds students to the given class roll. */
=======
     // for descending order of section.
      Comparator<Student> reverseOrderBySection = null;
      printRoll(roll, "Sorted in reverse order of section");
   }

>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
   private static void buildRoll(List<Student> roll) {
      roll.add(new Student("Alan", "Turing", 1));
      roll.add(new Student("John", "von Neumann", 1));
      roll.add(new Student("Alonzo", "Church", 1));
      roll.add(new Student("Don", "Knuth", 2));
      roll.add(new Student("John", "McCarthy", 2));
      roll.add(new Student("Tony", "Hoare", 2));
      roll.add(new Student("Edsger", "Dijkstra", 2));
   }

<<<<<<< HEAD
  /** Prints the given class roll to System.out. */
=======
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
   private static void printRoll(List<Student> roll, String header) {
      StringBuilder output = new StringBuilder(header + "\n");
      for (Student s : roll) {
         output.append(s + "\n");
      }
      System.out.println(output.toString());
   }

   /**
    * Implement this Comparator so that Student objects are compared
    * in ascending order of section. That is, compare(s1, s2) must
    * return a negative integer if s1's section is less than s2's section,
    * zero if s1 and s2 have the same section, and a postive integer
    * if s1's section is greater than s2's section.
    */
   private static class CompareStudentsBySection implements Comparator<Student> {
<<<<<<< HEAD
      /** Compares s1 to s2 in with respect to the defined total order. */
      public int compare(Student s1, Student s2) {
         //return -99;
         return Integer.compare(s1.getSection(), s2.getSection());
=======
      public int compare(Student s1, Student s2) {
         return -99;
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
      }
   }

}
