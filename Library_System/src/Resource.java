class Resource {
	private String title;
	private String author;
	private int year, period;

	public Resource(String title, String author, int year, int period) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.period = period;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public int getPeriod() {
		return period;
	}

	public void displayInfo() {
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Year: " + year);
		System.out.println("Lending period: " + period + " days");
	}

}