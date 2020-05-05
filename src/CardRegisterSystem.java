import java.time.LocalDate;
import java.util.ArrayList;

public class CardRegisterSystem {
    private ArrayList<FlyerCard> flyerCards;
    private ArrayList<Coupon> coupons;
    private CardRegisterView view;

    public CardRegisterSystem(){
        view = new CardRegisterView();
        flyerCards = new ArrayList<FlyerCard>();
        coupons = new ArrayList<Coupon>();
    }
    public Address buildAddressFromArray(String[] content){
        String StreetNum = content[0];
        String StreetName = content[1];
        String City = content[2];
        String State = content[3];
        String Postcode = content[4];
        String Suburb = content[5];
        return new Address(StreetNum, StreetName, City, State, Postcode, Suburb);
    }
    public void displayCardInfo(){
        String ID = view.getFlyerCardIDFromConsole();
        displayCardInfo(ID);
    }
    public void displayCardInfo(String ID){
        for (FlyerCard card: flyerCards){
            if(ID.equals(card.getDiscountID())){
                view.displayInformationToConsole(card.toString());
                break;
            }
        }
    }
    public void displayCouponInfo(){
        String coupon = view.getCouponIDFromConsole();
        displayCouponInfo(coupon);
    }
    public void displayCouponInfo(String coupID){
        for (Coupon coup: coupons){
            if(coupID.equals(coup.getDiscountID())){
                view.displayInformationToConsole(coup.toString());
                break;
            }
        }
    }
    public void createNewCard(){
        String[][] content = view.getCardRegisterInfoFromUser();
        registerCard(content);
    }
    public void createCouponFromCard(){
        String coupon = view.getFlyerCardIDFromConsole();
        genCoupon(coupon);
    }
    protected void registerCard(String[][] content){
        String ID = content[0][0];
        String name = content[0][1];
        String cardtype = content[0][2];
        Address address = buildAddressFromArray(content[1]);
        LocalDate date = LocalDate.now();
        if(cardtype.equals("Platinum")){
            PlatniumCard card = new PlatniumCard(ID, name, date, address, 0);
            flyerCards.add(card);
            view.displayInformationToConsole("Registered card information:\nID: "+ID+"\nName: "+name+"\nDate of Activation: "+date.toString());
        }
        if(cardtype.equals("Titanium")){
            TitaniumCard card = new TitaniumCard(ID, name, date, address, 0);
            flyerCards.add(card);
            view.displayInformationToConsole("Registered card information:\nID: "+ID+"\nName: "+name+"\nDate of Activation: "+date.toString());
        }
    }
    protected void genCoupon(String discountID){
        for(FlyerCard card: flyerCards){
            if(discountID.equals(card.getDiscountID())){
                Coupon coup = card.getYearlyCoupon(view.getCouponIDFromConsole());
                coupons.add(coup);
            }
        }
    }
    protected AirTicket.DiscountType getDiscountType(String discountID){
        for(FlyerCard card: flyerCards){
            if(discountID.equals(card.getDiscountID())){
                return AirTicket.DiscountType.Card;
            }
        }
        for(Coupon coup: coupons){
            if(discountID.equals(coup.getDiscountID())){
                return AirTicket.DiscountType.Coupon;
            }
        }
        return AirTicket.DiscountType.None;
    }
    protected double getDiscountAmount(String discountid, double price, AirTicket.TicketType ticketType){
        for(FlyerCard card:flyerCards){
            if(discountid.equals(card.getDiscountID())){
                return card.getDiscountAmount(price, ticketType);
            }
        }
        for(Coupon coup: coupons){
            if(discountid.equals(coup.getDiscountID())){
                return coup.getDiscountAmount(price, ticketType);
            }
        }
        return 0.0;
    }
    protected Discount searchByDiscountID(String DiscountID){
        for(FlyerCard card:flyerCards){
            if(DiscountID.equals(card.getDiscountID())){
                return card;
            }
        }
        for(Coupon coup: coupons){
            if(DiscountID.equals(coup.getDiscountID())){
                return coup;
            }
        }
        return null;
    }
}