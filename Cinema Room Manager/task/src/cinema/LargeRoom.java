package cinema;

/**
 * Large room
 */
public class LargeRoom extends Room {
    private static final int FRONT_TICKET_PRICE = 10;
    private static final int BACK_TICKET_PRICE = 8;

    /**
     * Constructor
     *
     * @param rows a number specifying the amount of rows in a cinema
     * @param seatsPerRow a number specifying the amount of seats per row
     */
    public LargeRoom(int rows, int seatsPerRow) {
        super(rows, seatsPerRow);

        this.totalIncome = calculateTotalIncome();
    }

    /**
     * Calculate the total income for the room
     */
    @Override
    public int calculateTotalIncome() {
        int frontRows = this.rows / 2;
        int backRows = this.rows - frontRows;

        int frontProfit = frontRows * this.seatsPerRow * FRONT_TICKET_PRICE;
        int backProfit = backRows * this.seatsPerRow * BACK_TICKET_PRICE;

        return frontProfit + backProfit;
    }

    /**
     * Increment the pricing of the ticket
     *
     * @param row a number specifying the row
     * @param seat a number specifying the seat
     */
    @Override
    public void incrementTicketPricing(int row, int seat) {
        if ((this.rows / 2) >= row) {
            this.currentIncome += FRONT_TICKET_PRICE;

            System.out.println("Ticket price: $" + FRONT_TICKET_PRICE);
        } else {
            this.currentIncome += BACK_TICKET_PRICE;

            System.out.println("Ticket price: $" + BACK_TICKET_PRICE);
        }
    }
}
