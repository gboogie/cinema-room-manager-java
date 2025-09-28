package cinema;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @abstract
 * Room
 */
public abstract class Room {
    protected int rows;
    protected int seatsPerRow;
    protected char[][] matrix;
    protected int ticketsPurchased = 0;
    protected int currentIncome = 0;
    protected int totalIncome;

    /**
     * Constructor
     *
     * @param rows a number specifying the amount of rows in a cinema
     * @param seatsPerRow a number specifying the amount of seats per row
     */
    public Room(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;

        // Create the seating matrix
        createMatrix();
    }

    /**
     * @abstract
     * Calculate the total income for the room
     */
    public abstract int calculateTotalIncome();

    /**
     * @abstract
     * Increment the pricing of the ticket
     *
     * @param row a number specifying the row
     * @param seat a number specifying the seat
     */
    public abstract void incrementTicketPricing(int row, int seat);

    /**
     * Create the seating matrix
     */
    private void createMatrix() {
        this.matrix = new char[rows + 1][seatsPerRow + 1]; // Add extra row for labels

        // Top left corner (empty space)
        this.matrix[0][0] = ' ';

        // Column labels
        for (int column = 1; column <= seatsPerRow; column++) {
            this.matrix[0][column] = (char) (column + '0');
        }

        // Rows
        for (int row = 1; row <= rows; row++) {
            this.matrix[row][0] = (char) (row + '0');

            for (int column = 1; column <= seatsPerRow; column++) {
                this.matrix[row][column] = 'S';
            }
        }
    }

    /**
     * Print the room's layout
     */
    public void printLayout() {
        System.out.println("Cinema:");

        for (char[] row : this.matrix) {
            for (char column : row) {
                System.out.print(column + " ");
            }

            System.out.println();
        }
    }

    /**
     * Buy a ticket in the room
     *
     * @param scanner the object collecting user input
     */
    public void buyTicket(Scanner scanner) {
        while (true) {
            System.out.println("Enter a row number:");
            int row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seat = scanner.nextInt();

            // Choice of seat needs to be valid
            if ((row > this.rows) || (seat > this.seatsPerRow)) {
                System.out.println("Wrong input!");
                continue;
            }

            // Choice of seat needs to be available
            if (this.matrix[row][seat] == 'B') {
                System.out.println("That ticket has already been purchased!");
                continue;
            }

            // Issue ticket
            this.matrix[row][seat] = 'B';
            this.ticketsPurchased++;

            incrementTicketPricing(row, seat);

            break;
        }
    }

    /**
     * Print the room's statistics
     */
    public void printStatistics() {
        double percentage = (double) this.ticketsPurchased / (this.rows * this.seatsPerRow);

        System.out.println("Number of purchased tickets: " + this.ticketsPurchased);
        DecimalFormat df = new DecimalFormat("0.00%");
        System.out.println("Percentage: " + df.format(percentage));
        System.out.println("Current income: $" + this.currentIncome);
        System.out.println("Total income: $" + this.totalIncome);
    }
}
