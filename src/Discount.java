public interface Discount {
    public String getDiscountID();
    public double getDiscountAmount(double price, AirTicket.TicketType ticketType);
}