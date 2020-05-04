import java.time.LocalDate;
import java.util.Calendar;

public class PlatniumCard extends FlyerCard {
    @Override
    public void getDiscountID() {

    }

    @Override
    public double getDiscountAmount(double price, AirTicket.TicketType ticketType) {
        return 0;
    }

    /*Although we're inheriting from the FrequentFlyerCard, we still need a variable to cling to when accessing the
            attribute. We've also got the constructor here, and 'super()' simply passes the values through to mirror the constructor
            that's in the inherited/superclass, in this case being FrequentFlyerCard.
            */
    private enum Discount{
        EconomyClass(.01),
        BuisnessClass(.05),
        FirstClass(.05);

        private final Double percent;

        Discount(Double p){
            this.percent = p;
        }

        public Double getDiscount(){
            return this.percent;
        }
    }
    private static double EconomyClassDiscountRate = 0.01;
    private static double BusinessClassDiscountRate = 0.05;
    private static double FirstClassDiscountRate = 0.05;

    public PlatniumCard(String Name, Address address) {
        super(Name, address);
    }

    protected PlatniumCard(String ID, String name, LocalDate signup, Address ad, int ffp){
        super(ID,name, signup,ad, ffp);
    }


    @Override
    public PlatniumCard clone() throws CloneNotSupportedException{
        PlatniumCard card = (PlatniumCard) super.clone();
        card.SetAddress(this.GetAddress().clone());
        return card;
    }

    public static PlatniumCard getInstanceFromStringArray(String[] content){
        var ID = content[0];
        var name = content[1];
        var address = new Address(content[2], content[3], content[4], content[5], content[6], content[7]);
        var ffp = Integer.parseInt(content[8]);
        LocalDate localdate = LocalDate.parse(content[9]);

        PlatniumCard output = new PlatniumCard(ID, name, localdate, address,ffp);
        //output.Coupon = Double.parseDouble(content[10]);
        return output;
    }
}