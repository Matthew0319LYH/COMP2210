package spelling;

import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. */
	public boolean addWord(String word)
	{
	    //TODO: Implement this method.
	    //return false;
		TrieNode next = root;
	    for (Character c : word.toLowerCase().toCharArray()) {
	    	if (next == null || !next.getValidNextCharacters().contains(c)) {
	    		next.insert(c);
	    	}
	    	next = next.getChild(c);	    		
	    }
	    if (next.endsWord()) {
	    	return false;
	    }
	    next.setEndsWord(true);
	    size++;
	    return true;
	    //END TODO
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
	    return size;
	}
	
	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) 
	{
	    // TODO: Implement this method
		TrieNode n = root;
		for (Character c : s.toLowerCase().toCharArray()) {
			if (n == null || !n.getValidNextCharacters().contains(c))
				return false;
			n = n.getChild(c);
		}
		if (n.endsWord())
			return true;
		else
			return false;
		// END TODO
	}

	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 List<String> completions = new LinkedList<String>();
    	 if (numCompletions <= 0)
    		 return completions;
    	 TrieNode n = root;
    	 for (Character c : prefix.toLowerCase().toCharArray()) {
    		 if (n == null || !n.getValidNextCharacters().contains(c))
    			 return completions;
    		 n = n.getChild(c);
    	 }
    	 if (n == null)
    		 return completions;
    	 if (n.endsWord()) 
    		 completions.add(n.getText());
    	 LinkedList<TrieNode> queue = new LinkedList<TrieNode>();
    	 for (Character c : n.getValidNextCharacters())
    		 queue.addLast(n.getChild(c));    	 
    	 while (!queue.isEmpty()) {
    		 n = queue.removeFirst();
    		 if (n == null)
    			 continue;
    		 if (n.endsWord()) 
    			 completions.add(n.getText());
    		 for (Character c : n.getValidNextCharacters())
    			 queue.addLast(n.getChild(c));
    		 if (completions.size() >= numCompletions)
    			 return completions;
    	 }
    	 return completions;
    	 // END TODO
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}