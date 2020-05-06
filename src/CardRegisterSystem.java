import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class CardRegisterSystem {
    private static Formatter fileoutput;
    private static Scanner input;
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
    public ArrayList<FlyerCard> cardarray(){
        return flyerCards;
    }
    public ArrayList<Coupon> couparray(){
        return coupons;
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
    protected DiscountType getDiscountType(String discountID){
        for(FlyerCard card: flyerCards){
            if(discountID.equals(card.getDiscountID())){
                return DiscountType.Card;
            }
        }
        for(Coupon coup: coupons){
            if(discountID.equals(coup.getDiscountID())){
                return DiscountType.Coupon;
            }
        }
        return DiscountType.None;
    }
    protected double getDiscountAmount(String discountID, double price, TicketType ticketType){
        for(FlyerCard card:flyerCards){
            if(discountID.equals(card.getDiscountID())){
                return card.getDiscountAmount(price, ticketType);
            }
        }
        for(Coupon coup: coupons){
            if(discountID.equals(coup.getDiscountID())){
                return coup.getDiscountAmount(price, ticketType);
            }
        }
        return 0.0;
    }
    protected Discount searchByDiscountID(String discountID){
        for(FlyerCard card:flyerCards){
            if(discountID.equals(card.getDiscountID())){
                return card;
            }
        }
        for(Coupon coup: coupons){
            if(discountID.equals(coup.getDiscountID())){
                return coup;
            }
        }
        return null;
    }
    public static void openFile(String filename){
        try{
            fileoutput = new Formatter(filename);
        }
        catch(SecurityException securityException){
            System.err.println("Write permission denied. Ending...");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException){
            System.err.println("Error opening file. Ending...");
            System.exit(1);
        }
    }
    public static void closeFile(){
        if(fileoutput != null){
            fileoutput.close();
        }
        if(input != null){
            input.close();
        }
    }
    public void ObjectToFile(String filename){
        openFile(filename);
        try{
            if(filename.contains("card")){
                for(FlyerCard fc: flyerCards){
                    fileoutput.format(fc.getDataToSaveToTextFile()+"\n");
                }
            }
            if(filename.contains("coupon")){
                for(Coupon c: coupons){
                    fileoutput.format(c.getDataToSaveToTextFile()+"\n");
                }
            }
        }
        catch(FormatterClosedException formatterClosedException){
            System.err.println("Error writing to file. Terminating.");
            System.exit(1);
        }
        closeFile();
    }
    public Discount buildObjectFromArray(String[] content){
        if(content.length > 2){
            for (int i=0;i<content.length;i++){
                content[i] = content[i].replace("_", " ");
            }
            /*This means that the array is a card and not a coupon.*/
            String ID = content[0];
            String name = content[1];
            Address add = new Address(content[2], content[3], content[4], content[5], content[6], content[7]);
            LocalDate date = LocalDate.parse(content[8]);
            int ffp = Integer.parseInt(content[9]);
            if(content[10].equals("PlatinumCard")){
                return new PlatniumCard(ID, name, date, add, ffp);
            }
            if(content[10].equals("TitaniumCard")){
                return new TitaniumCard(ID, name, date, add, ffp);
            }
        }
        else{
            String ID = content[0];
            Double value = Double.parseDouble(content[1]);
            return new Coupon(ID, value);
        }
        return null;
    }
    public void getObjectFromFile(String filename){
        try{
            input = new Scanner(Paths.get(filename));
        }
        catch(IOException ioException){
            System.err.println("Error opening file. Ending...");
            System.exit(1);
        }
        try{
            while(input.hasNext()){
                String[] file = input.next().split(",");
                Discount object = buildObjectFromArray(file);
                if(object instanceof FlyerCard){
                    flyerCards.add((FlyerCard)object);
                }
                if(object instanceof Coupon){
                    coupons.add((Coupon)object);
                }
            }
        }
        catch(NoSuchElementException elementException){
            System.err.println("File improperly formed. Ending...");
        }
        catch(IllegalStateException stateException){
            System.err.println("Error reading from file. Ending...");
        }
        closeFile();
    }
}