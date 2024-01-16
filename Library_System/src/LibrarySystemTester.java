import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrarySystemTester {
	private LibrarySystem library;

	public LibrarySystemTester(LibrarySystem library) {
		this.library = library;
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);

		outerLoop: while (true) {
			System.out.println("\nLibrary System Menu:");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out.print("Enter your choice (1-3): ");

			int choice;

			try {
				choice = scanner.nextInt();
				scanner.nextLine(); // Consume newline
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine(); // Consume invalid input
				continue; // Restart the loop
			}

			switch (choice) {
			case 1:
				// 登入
				System.out.print("Enter your username: ");
				String loginUsername = scanner.nextLine();
				System.out.print("Enter your password: ");
				String loginPassword = scanner.nextLine();
				library.login(loginUsername, loginPassword);
				break;
			case 2:
				// 註冊
				System.out.print("Enter a new username > 4 characters: ");
				String registerUsername = scanner.nextLine();
				System.out.print("Enter a new password > 8 caharcters: ");
				String registerPassword = scanner.nextLine();
				library.registerUser(registerUsername, registerPassword);
				break;
			case 3:
				// 退出
				System.out.println("Exiting Library System. Goodbye!");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 3.");
				break;
			}

			if (library.getCurrentUser() != null) {
				while (true) {
					System.out.println("\nLibrary User Menu:");
					System.out.println("1. Borrow a resource");
					System.out.println("2. Return a resource");
					System.out.println("3. Display borrowing list");
					System.out.println("4. Display library resources");
					System.out.println("5. Logout");
					System.out.print("Enter your choice (1-5): ");

					int userChoice;

					try {
						userChoice = scanner.nextInt();
						scanner.nextLine(); // Consume newline
					} catch (InputMismatchException e) {
						System.out.println("Invalid input. Please enter a number.");
						scanner.nextLine(); // Consume invalid input
						continue; // Restart the loop
					}

					switch (userChoice) {
					case 1:
						// 借書
						library.borrowResource();
						break;
					case 2:
						// 還書
						library.returnResource();
						break;
					case 3:
						// 顯示借還書清單
						library.displayBorrowingList();
						break;
					case 4:
						// 展示館藏資源
						library.displayLibraryResources();
						break;
					case 5:
						// 登出
						library.logout();
						break outerLoop;
					default:
						System.out.println("Invalid choice. Please enter a number between 1 and 5.");
						break;
					}
				}
			}
		}
		scanner.close();
	}

	public static void main(String[] args) {
		LibrarySystem library = new LibrarySystem();
		LibrarySystemTester tester = new LibrarySystemTester(library);
		tester.run();
	}

}
