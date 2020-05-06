import java.time.LocalDate;
import java.util.Random;

public abstract class FlyerCard implements Discount, Cloneable, Comparable<FlyerCard>, StringForFile {
    private String id;
    private String name;
    private LocalDate date;
    private Address address;
    private int ffp=0;

    public FlyerCard(String name, Address address){
        this.name = name;
        this.address = address;
        this.date = LocalDate.now();
        this.id = Double.toString(new Random().nextInt(99999));
    }
    protected FlyerCard(String id, String name, LocalDate date, Address address, int ffp){
        this.id = id;
        this.name = name;
        this.date = date;
        this.address = address;
        this.ffp = ffp;
    }

    public String getDataToSaveToTextFile() {
        return (this.getDiscountID()+","+this.GetName()+","+this.GetAddress().toString()+","+this.GetDate().toString()+","+this.GetPoints()).replace(" ","_");
    }

    public String GetName() {
        return this.name;
    }

    public void SetAddress(Address address){
        this.address = address;
    }

    public Address GetAddress() {
        return this.address;
    }

    public int GetPoints() {
        return this.ffp;
    }

    public LocalDate GetDate() {
        return this.date;
    }

    @Override
    public String getDiscountID(){
        return id;
    }

    public Coupon getYearlyCoupon(String ID){
        double value = 0.0;
        if(this instanceof PlatniumCard){
            if(this.GetPoints() < 10000){
                value = .005*this.GetPoints();
            }
            if(this.GetPoints()>10000){
                value = .01*this.GetPoints();
            }
        }
        if(this instanceof TitaniumCard){
            if(this.GetPoints() < 100000){
                value = .015*this.GetPoints();
            }
            if(this.GetPoints()>100000 && this.GetPoints() < 300000){
                value = .2*this.GetPoints();
            }
            if(this.GetPoints()>300000 || ((TitaniumCard) this).CalculateYears() > 5 && this.GetPoints()>100000 && this.GetPoints() < 300000){
                value = .3*this.GetPoints();
            }
        }
        return new Coupon(ID, value);
    }

    public double CalculateDiscount(double price, double EconomyRate, double BusinessAndFirstRate, TicketType ticketType){
        double discount = 0;
        if(ticketType == TicketType.EconomyClass){
            discount = EconomyRate*price;
        }
        if(ticketType == TicketType.BusinessClass || ticketType == TicketType.FirstClass){
            discount = BusinessAndFirstRate*price;
        }
        return discount;
    }

    @Override
    public int compareTo(FlyerCard fc){
        return (Double.compare(Double.parseDouble(this.getDiscountID()), Double.parseDouble(fc.getDiscountID())));
    }

    @Override
    public FlyerCard clone() throws CloneNotSupportedException{
        FlyerCard card = (FlyerCard) super.clone();
        card.SetAddress(this.GetAddress().clone());
        return card;
    }

    @Override
    public String toString(){
        String output = "ID: "+ this.getDiscountID()+
                "\nCustomer Name: " + this.GetName() +
                "\n Address: "+ this.GetAddress() +
                "\n Signup Date: " + this.GetDate().toString() +
                "\n Current Points: " + this.GetPoints();
        return output;
    }

}