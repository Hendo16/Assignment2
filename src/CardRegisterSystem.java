import java.util.ArrayList;

public class CardRegisterSystem {
    private ArrayList<FlyerCard> flyerCards;
    private ArrayList<Coupon> coupons;
    private CardRegisterView view;
    private MainSystem main;

    public CardRegisterSystem(MainSystem main){
        this.main = main;
        view = new CardRegisterView();
    }
    public String[] getCardRegisterInfoFromUser(){
        String[][] output = new String[3][];
        output[0]= view.getFlyerCardIDFromConsole();
        output[1]= view.getNameFromConsole();
        output[2]= view.getAddressFromConsole();

        output
    }
    public Address buildAddressFromArray(String[] content){
        StreetNum = content[0];
        StreetName = content[1];
        City = content[2];
        State = content[3];
        Postcode = content[4];
        Suburb = content[5];
        Address output = new Address(StreetNum, StreetName, City, State, Postcode, Suburb);
        return output;
    }
    public void displayCardInfo(){}
    public void displayCardInfo(String content){}
    public void displayCouponInfo(){}
    public void displayCouponInfo(String content){}
    public void createNewCard(){}
    public void createCouponFromCard(){}
    protected void registerCard(String[] content){}
    protected void genCoupon(String discountID){}
    protected AirTicket.DiscountType getDiscountType(String discountID){}
    protected void getDiscountAmount(String discountid, double price, AirTicket.TicketType ticketType){}
    protected Discount searchByDiscountID(String DiscountID){}
}
