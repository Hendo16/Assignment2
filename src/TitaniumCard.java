import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class TitaniumCard extends PlatniumCard {

    private enum Discount{
        EconomyClass(.02),
        BuisnessClass(.1),
        FirstClass(.1);

        private final double percent;
        Discount(double p){
            this.percent = p;
        }

        public double getDiscount(){
            return this.percent;
        }
    }

    private static double EconomyClassDiscountRate = 0.01;
    private static double BusinessClassDiscountRate = 0.10;
    private static double FirstClassDiscountRate = 0.10;

    public TitaniumCard(String Name, Address address) {
        super(Name, address);
    }

    protected TitaniumCard(String ID, String name, LocalDate date, Address ad, int ffp) {
        super(ID, name, date, ad, ffp);
    }

    public int CalculateYears(){

        LocalDate now = LocalDate.now();
        Period p = Period.between(this.GetDate(), now);
        int difference = p.getYears();
        return difference;
    }

    @Override
    public double getDiscountAmount(double price, AirTicket.TicketType ticketType) {
        double discount = 0;
        if(ticketType == AirTicket.TicketType.EconomyClass){
            discount = .02*price;
        }
        if(ticketType == AirTicket.TicketType.BusinessClass || ticketType == AirTicket.TicketType.FirstClass){
            discount = .1*price;
        }
        return discount;
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
        TitaniumCard other = (TitaniumCard) obj;
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

    @Override
    public TitaniumCard clone() throws CloneNotSupportedException{
        TitaniumCard card = (TitaniumCard) super.clone();
        Address cloneaddress = (Address)this.GetAddress().clone();
        card.SetAddress(cloneaddress);
        return card;
    }

    public static TitaniumCard getInstanceFromStringArray(String[] content){
        var ID = content[0];
        var name = content[1];
        var address = new Address(content[2], content[3], content[4], content[5], content[6], content[7]);
        var ffp = Integer.parseInt(content[8]);
        LocalDate localdate = LocalDate.parse(content[9]);

        TitaniumCard output = new TitaniumCard(ID, name, localdate, address,ffp);
        //output.Coupon = Double.parseDouble(content[10]);
        return output;
    }
}