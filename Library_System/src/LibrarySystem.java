import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
	private List<Resource> resources;
	private List<User> users;
	private User currentUser;

	public LibrarySystem() {
		resources = new ArrayList<>();
		users = new ArrayList<>();
		currentUser = null;

		// 初始化一些資源（書籍、期刊、多媒體）
		resources.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "Fiction", 30, "3782914398742"));
		resources.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Fiction", 30, "8273498237498"));
		resources.add(new Book("1984", "George Orwell", 1949, "Dystopian Fiction", 30, "9382749274923"));
		resources.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937, "Fantasy", 30, "7398237498234"));
		resources.add(new Book("Pride and Prejudice", "Jane Austen", 1813, "Classic Fiction", 30, "9374928374928"));
		resources.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "Fiction", 30, "72890312462382"));

		resources.add(new Journal("National Geographic", "Various Authors", 2022, 4, 14, "Science"));
		resources.add(new Journal("Economics 7", "Various Authors", 2022, 3, 14, "Academic"));
		resources.add(new Journal("Nature", "Various Authors", 2022, 6, 30, "Science"));
		resources.add(new Journal("History Today", "Various Authors", 2022, 2, 14, "History"));
		resources.add(new Journal("Computer Science Review", "Various Authors", 2022, 1, 30, "Computer Science"));

		resources.add(new Multimedia("Introduction to Java Programming", "Li Yang", 2020, "Ebook", 7, "perfect", "243"));
		resources.add(new Multimedia("The Art of Painting", "John Smith", 2021, "Video", 7, "4K", "130min"));
		resources.add(new Multimedia("Learn to Paint with Watercolors", "Emily Turner", 2021, "Video", 7, "HD", "90min"));
		resources.add(new Multimedia("Introduction to Machine Learning", "Dr. Smith", 2020, "Online Course", 30, "HD","8 hours"));
		resources.add(new Multimedia("Python Programming Basics", "Jane Doe", 2020, "Ebook", 14, "good", "180"));
	}

	public void login(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.login(password)) {
				currentUser = user;
				System.out.println("Login successful. Welcome, " + username + "!");
				return;
			}
		}
		System.out.println("Login failed. Incorrect username or password.");
	}

	public void registerUser(String username, String password) {
		if (username.length() < 4 || password.length() < 8) {
			System.out.println(
					"Username must be at least 4 characters long, and password must be at least 8 characters long.");
			return;
		} else {
			users.add(new User(username, password));
			System.out.println("User '" + username + "' registered successfully.");
		}
	}

	public void borrowResource() {
		if (currentUser != null) {
			displayLibraryResources();
			System.out.print("Enter the title of the resource you want to borrow: ");
			Scanner scanner = new Scanner(System.in);
			String borrowTitle = scanner.nextLine();

			Resource borrowResource = findResourceByTitle(borrowTitle);
			if (borrowResource != null) {
				currentUser.borrowResource(borrowResource);
			} else {
				System.out.println("Resource not found in the library.");
			}
		} else {
			System.out.println("You need to log in first.");
		}
	}

	public void returnResource() {
		if (currentUser != null) {
			currentUser.displayBorrowingList();
			System.out.print("Enter the title of the resource you want to return: ");
			Scanner scanner = new Scanner(System.in);
			String returnTitle = scanner.nextLine();

			Resource returnResource = findBorrowedResourceByTitle(returnTitle);
			if (returnResource != null) {
				currentUser.returnResource(returnResource);
			} else {
				System.out.println("Resource not found in your borrowing list.");
			}
		} else {
			System.out.println("You need to log in first.");
		}
	}

	public void displayBorrowingList() {
		if (currentUser != null) {
			currentUser.displayBorrowingList();
		} else {
			System.out.println("You need to log in first.");
		}
	}

	public void displayLibraryResources() {
		System.out.println("Library Resources:");
		for (Resource resource : resources) {
			resource.displayInfo();
		}
	}

	public void logout() {
		currentUser = null;
		System.out.println("Logout successful.");
	}

	private Resource findResourceByTitle(String title) {
		for (Resource resource : resources) {
			if (resource.getTitle().equals(title)) {
				return resource;
			}
		}
		return null;
	}

	private Resource findBorrowedResourceByTitle(String title) {
		if (currentUser != null) {
			for (Resource resource : currentUser.getBorrowingList()) {
				if (resource.getTitle().equals(title)) {
					return resource;
				}
			}
		}
		return null;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public static void main(String[] args) {
		LibrarySystem library = new LibrarySystem();
		LibrarySystemTester tester = new LibrarySystemTester(library);

		tester.run();
	}
}