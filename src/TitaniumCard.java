import java.time.LocalDate;
import java.time.Period;

public class TitaniumCard extends PlatniumCard {

    private static double EconomyClassDiscountRate = 0.02;
    private static double BusinessAndFirstClassDiscountRate = 0.10;

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
    public String getDataToSaveToTextFile() {
        return (super.getDataToSaveToTextFile()).replace(",PlatinumCard","")+",TitaniumCard";
    }

    @Override
    public double getDiscountAmount(double price, TicketType ticketType) {
        return CalculateDiscount(price, EconomyClassDiscountRate, BusinessAndFirstClassDiscountRate, ticketType);
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
}