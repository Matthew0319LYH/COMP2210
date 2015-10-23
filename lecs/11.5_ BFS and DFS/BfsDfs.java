import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * BfsDfs.java
 * Sample implementations of breadth-first search using a queue,
 * depth-first search using a stack, and depth-first search using
 * recursion.
 *
 * @author      Dean Hendrix (dh@auburn.edu)
 * @version     2015-03-11
 *
 */
public class BfsDfs {
 
 // 2d area to search
   private int[][] grid;
   
 // visited positions in the search area
   private boolean[][] visited;
 
 // dimensions of the search area
   private int width;
   private int height;
   
 // number of neighbors, degrees of motion
   private final int MAX_NEIGHBORS = 8;
   
 // order in which positions are visited
   private int order;
   
 // model an (x,y) position in the grid
   class Position {
      int x;
      int y;
   
      public Position(int _x, int _y) {
         x = _x;
         y = _y;
      }
      
      @Override
      public String toString() {
         return "(" + x + ", " + y + ")";
      }
      
      public Position[] neighbors() {
         Position[] nbrs = new Position[MAX_NEIGHBORS];
         int count = 0;
         Position p;
         // generate all eight neighbor positions
         // add to return value if valid
         for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
               if (!((i == 0) && (j == 0))) {
                  p = new Position(x + i, y + j);
                  if (isValid(p)) {
                     nbrs[count++] = p;
                  }
               }
            }
         }
         
         return Arrays.copyOf(nbrs, count);
      }
   }
   
 /**
  * Is this position valid in the search area?
  */
   private boolean isValid(Position p) {
      return (p.x >= 0) && (p.x < width) && (p.y >= 0) && (p.y < height);
   }
   
 /**
  * Has this valid position been visited?
  */
   private boolean isVisited(Position p) {
      return visited[p.x][p.y];
   }
   
 /**
  * Mark this valid position as having been visited.
  */
   private void visit(Position p) {
      visited[p.x][p.y] = true;
   }
   
 /**
  * Process this valid position.
  */
   private void process(Position p) {
      grid[p.x][p.y] = order++;
   }
   
   
   
 /**
  * Initialize the search area and mark all
  * positions unvisited.
  */
   public BfsDfs(int[][] _grid) {
      // initialize grid dimensions
      width = _grid.length;
      height = _grid[0].length;
      // initialize grid with values in _grid
      grid = new int[width][height];
      int i = 0; 
      for (int[] a : _grid) {
         int j = 0;
         for (int ai : a) {
            grid[i][j] = ai;
            j++;
         }
         i++;
      }
      // initialize visited to false
      markAllUnvisited();
   }
   
  /**
   * Initializes visited to false.
   */
   public void markAllUnvisited() {
      visited = new boolean[width][height];
      for (boolean[] b : visited) {
         Arrays.fill(b, false);
      }
   
   }
   
  /**
   * Prints the grid to stdout.
   */ 
   public void printGrid() {
      int fieldWidth = 4;
      for (int i = 0; i < fieldWidth*width; i++) {
         System.out.print("*");
      } 
      System.out.println();
      for (int[] a : grid) {
         for (int ai : a) {
            System.out.printf("%4d", ai);
         }
         System.out.println();
      }
      for (int i = 0; i < fieldWidth*width; i++) {
         System.out.print("*");
      } 
      System.out.println();
      System.out.println();
   }

  /**
   * Initializes the grid with the given value.
   */ 
   public void initGrid(int value) {
      for (int x = 0; x < width; x++) {
         for (int y = 0; y < height; y++) {
            grid[x][y] = value;
         }
      }
   }
   
   
 /**
  * Public method to launch a breadth-first traversal
  * on grid from the given x,y position.
  */  
   public void breadth_first(int x, int y) {
      markAllUnvisited();
      Position start = new Position(x, y);
      if (isValid(start)) {
         order = 1;
         bfs(start);
      }
   }
   
 /**
  * Perform a breadth-first traversal on grid starting from
  * the given position.
  */
   private void bfs(Position start) {
      Deque<Position> q = new LinkedList<Position>();
      visit(start);
      process(start);
      q.add(start);
      while (!q.isEmpty()) {
         Position p = q.remove();
         for (Position n : p.neighbors()) {
            if (!isVisited(n)) {
               visit(n);
               process(n);
               q.add(n);
            }
         }
      }
   }
   
 /**
  * Public method to launch a depth-first traversal
  * on grid from the given x,y position. This dfs
  * is iterative and uses a stack.
  */  
   public void depth_first_stack(int x, int y) {
      markAllUnvisited();
      Position start = new Position(x, y);
      if (isValid(start)) {
         order = 1;
         dfs_stack(start);
      }
   }
   
 /**
  * Perform a depth-first traversal on grid starting from
  * the given position. This dfs is iterative and uses a stack.
  */
   private void dfs_stack(Position start) {
      Deque<Position> s = new LinkedList<Position>();
      s.addFirst(start);
      visit(start);
      while (!s.isEmpty()) {
         Position p = s.removeFirst();
         process(p);
         for (Position n : p.neighbors()) {
            if (!isVisited(n)) {
               visit(n);
               s.addFirst(n);
            }
         }
      }
   }
   
 /**
  * Public method to launch a depth-first traversal
  * on grid from the given x,y position. This dfs
  * is recursive.
  */  
   public void depth_first_recursive(int x, int y) {
      markAllUnvisited();
      Position start = new Position(x, y);
      if (isValid(start)) {
         order = 1;
         dfs_recursive(start);
      }
   }
   
 /**
  * Perform a depth-first traversal on grid starting from
  * the given position. This dfs is recursive.
  */
   private void dfs_recursive(Position p) {
      visit(p);
      process(p);
      for (Position n : p.neighbors()) {
         if (!isVisited(n)) {
            dfs_recursive(n);
         }
      }
   }
   
   public void depth_first_recursive2(int x, int y) {
      markAllUnvisited();
      Position start = new Position(x, y);
      if (isValid(start)) {
         order = 1;
         dfsr(start);
      }
   }
   
   private void dfsr(Position p) {
      if (isVisited(p)) {
         return;
      }
      visit(p);
      process(p);
      for (Position n : p.neighbors()) {
         dfsr(n);
      }
   }
   

  /**
   * Example client.
   */
   public static void main(String[] args) {
      int[][] g = 
                {
                 {0, 0, 0, 0, 0,},
                 {0, 0, 0, 0, 0,},
                 {0, 0, 0, 0, 0,},
                 {0, 0, 0, 0, 0,},
                 {0, 0, 0, 0, 0,},
                 {0, 0, 0, 0, 0,},
                };
      BfsDfs searcher = new BfsDfs(g);
      System.out.println("Breadth-first Search\n");
      searcher.printGrid();
      searcher.breadth_first(5, 4);
      searcher.printGrid();
      System.out.println();
      
      System.out.println("Iterative Depth-first Search\n");
      searcher.initGrid(0);
      searcher.printGrid();
      searcher.depth_first_stack(5, 4);
      searcher.printGrid();
      System.out.println();
      
      System.out.println("Recursive Depth-first Search\n");
      searcher.initGrid(0);
      searcher.printGrid();
      searcher.depth_first_recursive(5, 4);
      searcher.printGrid();
      System.out.println();
      
   }
 
}
