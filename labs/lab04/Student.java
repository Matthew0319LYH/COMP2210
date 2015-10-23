/**
 * Student.java
 * A class to represent student data, for the
 * purpose of illustrating order by Comparable
 * and Comparator.
 *
 * @author   Dean Hendrix (dh@auburn.edu)
<<<<<<< HEAD
 * @version  2015-08-28
 *
 */
public class Student implements Comparable<Student> {
=======
 * @version  2014-09-02
 *
 */
public class Student implements Comparable<Student>{
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
   private String fname;
   private String lname;
   private int    section;

<<<<<<< HEAD
  /** Creates a new student. */
=======
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
   public Student(String fn, String ln, int sec) {
      fname   = fn;
      lname   = ln;
      section = sec;
   }

<<<<<<< HEAD
  /** Returns this student's first name. */
=======
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
   public String getFirstName() {
      return fname;
   }

<<<<<<< HEAD
  /** Returns this student's last name. */
=======
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
   public String getLastName() {
      return lname;
   }

<<<<<<< HEAD
  /** Returns this student's section. */
=======
>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
   public int getSection() {
      return section;
   }

   /**
    * Implement compareTo so that students are ordered in the
    * following way: in ascending order of last name, then in
    * ascending order of first name, and then in ascending order
    * of section.
    */
   @Override
   public int compareTo(Student s) {
<<<<<<< HEAD
      //return -99;
      int first = (this.getLastName()).compareTo(s.getLastName());
      if (first != 0)
         return first;
      int second = (this.getFirstName()).compareTo(s.getFirstName());
      if (second != 0)
         return second;
      return Integer.compare(this.getSection(), s.getSection());
   }

  /** Returns a string representation of this student. */
=======
      return -99;
   }

>>>>>>> cf41ef796647a6a74cfac8bffeab7c21c7f5f940
   @Override
   public String toString() {
      return section + ", " + lname + ", " + fname;
   }
}
