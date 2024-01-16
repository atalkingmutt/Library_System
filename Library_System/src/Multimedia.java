public class Multimedia extends Resource {
	private String format, quality, length;

	public Multimedia(String title, String author, int year, String format, int period, String quality, String length) {
		super(title, author, year, period);
		this.format = format;
		this.quality = quality;
		this.length = length;
	}

	public String getFormat() {
		return format;
	}

	public String getQuality() {
		return quality;
	}

	public String getLength() {
		return length;
	}

	@Override
	public void displayInfo() {
		System.out.println("Kind: Multimedia");
		super.displayInfo();
		System.out.println("Format: " + format);
		System.out.println("Quality: " + quality);
		System.out.println("Length or Page:" + length);
		System.out.println("--------------");
	}
}
