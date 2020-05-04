public interface Discount {
    public void getDiscountID();
    public double getDiscountAmount(double price, AirTicket.TicketType ticketType);
}