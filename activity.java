import java.util.Scanner;

public class activity {

    static boolean[] seats = new boolean[40];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. View Seats\n2. Book Seat\n3. Cancel Seat\n4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewSeats();
                    break;
                case 2:
                    bookSeat(sc);
                    break;
                case 3:
                    cancelSeat(sc);
                    break;
                case 4:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }

    
    static void viewSeats() {
        System.out.println("Seats: ");
        for (int i = 0; i < seats.length; i++) {
            System.out.print((i + 1) + (seats[i] ? " [Booked] " : " [Available] "));
        }
        System.out.println();
    }

    
    static void bookSeat(Scanner sc) {
        System.out.print("Enter seat number (1-40): ");
        int seat = sc.nextInt();
        if (seat < 1 || seat > 40 || seats[seat - 1]) {
            System.out.println("Invalid or already booked.");
        } else {
            seats[seat - 1] = true;
            System.out.println("Seat " + seat + " booked.");
        }
    }

    
    static void cancelSeat(Scanner sc) {
        System.out.print("Enter seat number to cancel (1-40): ");
        int seat = sc.nextInt();
        if (seat < 1 || seat > 40 || !seats[seat - 1]) {
            System.out.println("Invalid or not booked.");
        } else {
            seats[seat - 1] = false;
            System.out.println("Seat " + seat + " cancelled.");
        }
    }
}