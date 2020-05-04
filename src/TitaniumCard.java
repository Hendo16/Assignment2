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
    public TitaniumCard clone() throws CloneNotSupportedException{
        TitaniumCard card = (TitaniumCard) super.clone();
        card.SetAddress(this.GetAddress().clone());
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