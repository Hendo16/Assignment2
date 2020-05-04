import java.time.LocalDate;
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
            if(ID.equals(card.getId())){
                view.displayInformationToConsole(card.toString());
                break;
            }
        }
    }
    public void displayCouponInfo(){
        String coupon = view.getFlyerCardIDFromConsole();
        displayCouponInfo(coupon);
    }
    public void displayCouponInfo(String coupID){
        for (Coupon coup: coupons){
            if(coupID.equals(coup.getId())){
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
            if(discountID.equals(card.getId())){
                Coupon coup = card.getYearlyCoupon();
                coupons.add(coup);
            }
        }
    }
    protected AirTicket.DiscountType getDiscountType(String discountID){}
    protected void getDiscountAmount(String discountid, double price, AirTicket.TicketType ticketType){}
    protected Discount searchByDiscountID(String DiscountID){}
}