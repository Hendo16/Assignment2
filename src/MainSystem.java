public class MainSystem {
    CardRegisterSystem cardsys;
    public MainSystem(){
        cardsys = new CardRegisterSystem();
    }
    public void generateCoupon(){
        cardsys.createCouponFromCard();
    }
    public void createCard(){
        cardsys.createNewCard();
    }
    protected DiscountType getDiscountType(String discountID){
        return cardsys.getDiscountType(discountID);
    }
    protected double getDiscountAmount(String discountID, double price, TicketType ticketType){
        return cardsys.getDiscountAmount(discountID, price, ticketType);
    }
}
