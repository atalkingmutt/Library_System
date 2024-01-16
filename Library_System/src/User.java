import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private String password;
	private List<Resource> borrowingList;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.borrowingList = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public boolean login(String enteredPassword) {
		return password.equals(enteredPassword);
	}

	public void borrowResource(Resource resource) {
		borrowingList.add(resource);
		System.out.println("Resource '" + resource.getTitle() + "' borrowed successfully.");
	}

	// 還書
	public void returnResource(Resource resource) {
		if (borrowingList.contains(resource)) {
			borrowingList.remove(resource);
			System.out.println("Resource '" + resource.getTitle() + "' returned successfully.");
		} else {
			System.out.println("Resource not found in your borrowing list.");
		}
	}

	// 顯示借還書清單
	public void displayBorrowingList() {
		System.out.println("Borrowing List for " + username + ":");
		System.out.println("--------------");
		for (Resource resource : borrowingList) {
			resource.displayInfo();
		}
	}

	public List<Resource> getBorrowingList() {
		return borrowingList;
	}
}
