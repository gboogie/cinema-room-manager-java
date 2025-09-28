package cinema;

import java.util.Scanner;

/**
 * Cinema
 */
public class Cinema {

    /**
     * Main
     *
     * @param args an array of strings containing arguments from the console
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();

        // Create a room
        Room room;

        if ((rows * seatsPerRow) > 60) {
            room = new LargeRoom(rows, seatsPerRow);
        } else {
            room = new SmallRoom(rows, seatsPerRow);
        }

        // Show the menu
        boolean programOn = true;

        while (programOn) {
            printMenu();

            int choice = scanner.nextInt();

            switch(choice) {
                case 1 -> room.printLayout();
                case 2 -> room.buyTicket(scanner);
                case 3 -> room.printStatistics();
                case 0 -> programOn = false;
            }
        }

        // Clean up
        scanner.close();
    }

    /**
     * Print the cinema's menu
     */
    private static void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }
}