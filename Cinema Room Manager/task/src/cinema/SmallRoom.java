package cinema;

/**
 * Small room
 */
public class SmallRoom extends Room {
    private static final int TICKET_PRICE = 10;

    /**
     * Constructor
     *
     * @param rows a number specifying the amount of rows in a cinema
     * @param seatsPerRow a number specifying the amount of seats per row
     */
    public SmallRoom(int rows, int seatsPerRow) {
        super(rows, seatsPerRow);

        this.totalIncome = calculateTotalIncome();
    }

    /**
     * Calculate the total income for the room
     */
    @Override
    public int calculateTotalIncome() {
        return this.rows * this.seatsPerRow * TICKET_PRICE;
    }

    /**
     * Increment the pricing of the ticket
     *
     * @param row a number specifying the row
     * @param seat a number specifying the seat
     */
    @Override
    public void incrementTicketPricing(int row, int seat) {
        this.currentIncome += TICKET_PRICE;

        System.out.println("Ticket price: $" + TICKET_PRICE);
    }
}
