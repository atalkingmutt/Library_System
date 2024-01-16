class Book extends Resource {
	private String genre, ISBN;

	public Book(String title, String author, int year, String genre, int period, String ISBN) {
		super(title, author, year, period);
		this.genre = genre;
		this.ISBN = ISBN;
	}

	public String getGenre() {
		return genre;
	}

	public String getISBN() {
		return ISBN;
	}

	@Override
	public void displayInfo() {
		System.out.println("Kind: Book");
		super.displayInfo();
		System.out.println("Genre: " + genre);
		System.out.println("ISBN: " + ISBN);
		System.out.println("--------------");
	}
}