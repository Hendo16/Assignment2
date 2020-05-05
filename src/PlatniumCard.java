import java.time.LocalDate;
import java.util.Calendar;

public class PlatniumCard extends FlyerCard {

    @Override
    public double getDiscountAmount(double price, AirTicket.TicketType ticketType) {
        double discount = 0;
        if(ticketType == AirTicket.TicketType.EconomyClass){
            discount = .01*price;
        }
        if(ticketType == AirTicket.TicketType.BusinessClass || ticketType == AirTicket.TicketType.FirstClass){
            discount = .05*price;
        }
        return discount;
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
        Address cloneaddress = (Address)this.GetAddress().clone();
        card.SetAddress(cloneaddress);
        return card;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        PlatniumCard other = (PlatniumCard) obj;
        if(this.getDiscountID() == null){
            if(this.getDiscountID() != null){
                return false;
            }
            else if(!this.getDiscountID().equals(other.getDiscountID())){
                return false;
            }
        }
        if(this.GetName() == null){
            if(this.GetName() != null){
                return false;
            }
            else if(!this.GetName().equals(other.GetName())){
                return false;
            }
        }
        if(this.GetAddress() == null){
            if(this.GetAddress() != null){
                return false;
            }
            else if(!this.GetAddress().equals(other.GetAddress())){
                return false;
            }
        }
        if(this.GetPoints() != other.GetPoints()){
            return false;
        }
        if(this.GetDate() == null){
            if(this.GetDate() != null){
                return false;
            }
            else if(!this.GetDate().equals(other.GetDate())){
                return false;
            }
        }
        return true;
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