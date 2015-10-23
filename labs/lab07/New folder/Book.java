public class Book implements Comparable<Book> {
	private String author = new String("no title");
	private String title = new String("none");
	private int pages = 0;

	public Book(String author, String title, int page) {
		this.author = author;
		this.title = title;
		this.pages = page;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getTitle() {
		return this.title;
	}

	@Override
	public int compareTo(Book that) {
		int cmp = (this.title).compareTo(that.title);
		if (cmp == 0)
			cmp = (this.author).compareTo(that.author);
		return cmp;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Book))
			return false;
		Book other = (Book) o;
		return this.compareTo(other) == 0;
	}

	@Override
	public String toString() {
		return ("\nAuthor: " + author + "\nTitle: " + title + "\nPages: " + pages + "\n");
	}

}