import java.util.Scanner; //nested package/ hierarchical package

public class BusMain {
	public static void main(String[] args) {
		BusDAO busdao = new BusDAO();

		try {
			busdao.displayBusInfo();

			int userOpt = 1;
			Scanner scanner = new Scanner(System.in);

			while (userOpt == 1) {
				System.out.println("Enter 1 to Book and 2 to exit");
				if (scanner.hasNextInt()) {
					userOpt = scanner.nextInt();
					scanner.nextLine(); // consume the newline
				} else {
					System.out.println("Invalid input. Please enter 1 or 2.");
					scanner.nextLine(); // Clear the invalid input
					continue; // Restart the loop
				}

				if (userOpt == 1) {
					Booking booking = new Booking(scanner); // Pass the scanner object
					if (booking.isAvailable()) {
						BookingDAO bookingdao = new BookingDAO();
						bookingdao.addBooking(booking);
						System.out.println("Your booking is confirmed");
					} else {
						System.out.println("Sorry. Bus is full. Try another bus or date.");
					}
				}
			}

			// Display thank you message if the user exits
			System.out.println("Thank you for using the booking system!");
			scanner.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}