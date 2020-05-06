import java.time.LocalDate;

public class PlatniumCard extends FlyerCard {
    private static double EconomyClassDiscountRate = 0.01;
    private static double BusinessAndFirstClassDiscountRate = 0.05;

    public PlatniumCard(String Name, Address address) {
        super(Name, address);
    }

    protected PlatniumCard(String ID, String name, LocalDate signup, Address ad, int ffp){
        super(ID,name, signup,ad, ffp);
    }


    @Override
    public double getDiscountAmount(double price, TicketType ticketType) {
        return CalculateDiscount(price, EconomyClassDiscountRate, BusinessAndFirstClassDiscountRate, ticketType);
    }

    @Override
    public String getDataToSaveToTextFile() {
        return super.getDataToSaveToTextFile()+",PlatinumCard";
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
}