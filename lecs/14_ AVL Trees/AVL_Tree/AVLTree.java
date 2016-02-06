public class AVLTree<T extends Comparable<? super T>> {

  private int size = 0;
  private Node root;

  public AVLTree() {
    root = null;
    size = 0;
  }

  private class Node {
    T element;
    Node left, right;
    int bf; // Balance Factor

    public Node(T element) {
      this.element = element;
      bf = 0;
    }
  }

  public void add(T element) {
    root = put(root, element);
    size++;
  }

  private Node put(Node n, T element) {
    if (n == null)
      return new Node(element);
    int cmp = element.compareTo(n.element);
    if (cmp < 0)      { n.left = put(n.left, element); }
    else if (cmp > 0) { n.right = put(n.right, element);}

    n.bf = height(n.right) - height(n.left);
    if (n.bf == 2) {
      if (n.right.bf < 0)
        n.right = rotateRight(n.right);
      n = rotateLeft(n);
    }
    else if (n.bf == -2) {
      if (n.left.bf > 0)
        n.left = rotateLeft(n.left);
      n = rotateRight(n);
    }

    return n;
  }

  private Node rotateLeft(Node n) {
    Node m = n.right;
    n.right = m.left;
    m.left = n;
    return m;
  }
  private Node rotateRight(Node n) {
    Node m = n.left;
    n.left = m.right;
    m.right = n;
    return m;
  }

  public boolean contains(T element) {
    return search(root, element);
  }

  private boolean search(Node n, T element) {
    if (n == null)
      return false;
    int cmp = element.compareTo(n.element);
    if (cmp < 0)      {return search(n.left, element);}
    else if (cmp > 0) {return search(n.right, element);}
    else              {return true;}
  }

  public void remove(T element) {
    root = delete(root, element);
    size--;
  }

  private Node delete(Node n, T element) {
    if (n != null) {
      int cmp = element.compareTo(n.element);
      if (cmp < 0)        n.left = delete(n.left, element);
      else if (cmp > 0)   n.right = delete(n.right, element);
      else {
        if (n.left == null && n.right == null)      n = null;
        else if (n.left == null && n.right != null) n = n.right;
        else if (n.left != null && n.right == null) n = n.left;
        else {
          T replacement = inOrderSuccessor(n, n.element);
          n = delete(n, replacement);
          n.element = replacement;
        }
      }
    }

    if (n != null) {
      n.bf = height(n.right) - height(n.left);
      if (n.bf == 2) {
        if (n.right.bf < 0)
          n.right = rotateRight(n.right);
        n = rotateLeft(n);
      }
      else if (n.bf == -2) {
        if (n.left.bf > 0)
          n.left = rotateLeft(n.left);
        n = rotateRight(n);
      }
    }

    return n;
  }

  public int height() {
    return height(root);
  }

  private int height(Node n) {
    if (n == null)
      return 0;
    else
      return 1 + Math.max(height(n.left), height(n.right));
  }

  private T inOrderSuccessor(Node n, T element) {
    T successor = null;
    if (n != null) {
      Node s = n.right;
      while (s.left != null) {
        s = s.left;
      }
      successor = s.element;
    }
    return successor;
  }

  public int size() {
    return this.size;
  }

  @Override
  public String toString() {
    return inOrderString(root);
  }

  private String inOrderString(Node n) {
    if (n == null)
      return "";
    else
      return inOrderString(n.left) + " " + n.element + " " + inOrderString(n.right);
  }

}
