
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Models a 2-dimensional maze.
 *
 * @author Dean Hendrix
 * @version 1.0, 2009-06-17
 *
 */
public class Maze {

   public static final char[][] DEFAULT_GRID1 = 
   {
      {'S','x','-','x','x'},
      {'-','-','-','x','x'},
      {'-','x','-','-','-'},
      {'-','x','-','x','-'},
      {'x','-','-','x','F'}
      };

   private final char START   = 'S';
   private final char FINISH  = 'F';
   private final char WALL    = 'x';
   private final char OPEN    = '-';
   private final char TRIED   = '.';
   private final char PATH    = 'o';
   
   private char[][] grid;

   private Position ENTRANCE;
   private Position EXIT;
  
     
   public Maze() {
      grid = DEFAULT_GRID1;
      ENTRANCE = new Position(0, 0);
      EXIT = new Position(grid.length-1, grid[0].length-1);
   }
  	
		
   public Maze (char [][] grid) {
      this.grid = grid;
      ENTRANCE = new Position(0, 0);
      EXIT = new Position(grid.length-1, grid[0].length-1);
   }


   public Maze (char [][] grid, Position entrance, Position exit) {
      this.grid = grid;
      ENTRANCE = entrance;
      EXIT = exit;
   }


   public String bfsolve () {
      Queue<Node> queue = new LinkedList<Node>();
      Node startNode = new Node(ENTRANCE, null);
      queue.add(startNode);
      
      Node endNode = new Node(EXIT, null);
      boolean done = false;
   
      while ( (!done) && (!queue.isEmpty()) ) {
         Node current = queue.remove();
         Position pos = current.position;
         
         if ( !pos.equals(ENTRANCE) ) {
            grid[pos.getx()][pos.gety()] = TRIED;
         }
         
         List<Position> openPositions = new LinkedList<>();
         if (isValidPosition(pos.north()))   openPositions.add(pos.north());
         if (isValidPosition(pos.east()))    openPositions.add(pos.east());
         if (isValidPosition(pos.south()))   openPositions.add(pos.south());
         if (isValidPosition(pos.west()))    openPositions.add(pos.west());
         
         for (Position p : openPositions) {
            if (p.equals(EXIT)) {
               endNode.parent = current;
               done = true;
               break;
            }
            queue.add(new Node(p, current));
         }
      }
      
      if (done)
         return asString(pathFromStart(endNode));
      else
         return "There is no path from the entrance to the exit in this maze.";
   }
   
   
   private boolean isValidPosition (Position pos)
   {
      int row = pos.getx();
      int column = pos.gety();
      boolean result = false;
   
      if (row >= 0 && row < grid.length &&
       column >= 0 && column < grid[row].length)
      
         if ( (grid[row][column] == OPEN) ||
         	  (grid[row][column] == FINISH) )
            result = true;
   
      return result;
   }

   
   private List<Position> pathFromStart(Node n) {
      List<Position> path = new LinkedList<Position>();
      path.add(n.position);
      Node p = n.parent;
      while (p != null) {
         path.add(0, p.position);
         p = p.parent;
      }
      return path;
   }
   
   private String asString(List<Position> list) {
      StringBuilder s = new StringBuilder();
      for (Position pos : list) {
         s.append(pos.toString() + " -> ");
      }
      s.delete(s.length()-4, s.length()-1);
      return s.toString();
   }
   
   private class Node {
   
      private Position position;
      private Node parent;
      
      public Node(Position position, Node parent) {
         this.position = position;
         this.parent = parent;
      }
      
      @Override
      public String toString() {
         return position.toString();
      }
   
   }






//-----------------------------------------------------------------
//  Returns the maze as a string.
//-----------------------------------------------------------------
   public String toString ()
   {
      String result = "\n";
   
      for (int row=0; row < grid.length; row++)
      {
         for (int column=0; column < grid[row].length; column++)
            result += grid[row][column] + "";
         result += "\n";
      }//for
   
      return result;
   }//method toString
   
	
	
}//class Maze



