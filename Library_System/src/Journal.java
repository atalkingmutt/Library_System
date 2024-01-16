class Journal extends Resource {
	private int issueNumber;
	private String genre;

	public Journal(String title, String author, int year, int issueNumber, int period, String genre) {
		super(title, author, year, period);
		this.issueNumber = issueNumber;
		this.genre = genre;
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public String getGenre() {
		return genre;
	}

	@Override
	public void displayInfo() {
		System.out.println("Kind: Journal");
		super.displayInfo();
		System.out.println("Genre: " + genre);
		System.out.println("Issue Number: " + issueNumber);
		System.out.println("--------------");
	}
}