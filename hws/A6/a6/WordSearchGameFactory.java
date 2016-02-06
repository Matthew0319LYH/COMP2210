
/**
 * Provides a facotry method for creating word search games.
 */
public class WordSearchGameFactory {
   public static WordSearchGame createGame() {
   // change this to return an instance of your game engine
      //return null;
      return new DepthFirstWordSearchGame();
   }

   public static void main(String[] args) {
      WordSearchGame game = WordSearchGameFactory.createGame();
      //game.loadLexicon("wordfiles/words_small.txt");
      game.loadLexicon("wordfiles/words.txt");
      game.setBoard(new String[]{"E", "E", "C", "A", "A", "L", "E", "P", "H",
      "N", "B", "O", "Q", "T", "T", "Y"});
      System.out.print(game.getBoard());
      System.out.print("LENT is on the board at the following positions: ");
      System.out.println(game.isOnBoard("LENT"));
      System.out.print("POPE is not on the board: ");
      System.out.println(game.isOnBoard("POPE"));
      System.out.println("All words of length 6 or more: ");
      System.out.println(game.getAllValidWords(6));
   }
}
