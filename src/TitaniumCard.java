import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
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
       /* In order to get the year from the signup date, we need to utilise the Calendar class. Using the .get() method
         and passing through 'Calendar.YEAR' returns the stored year in the parent object, in this case being the
         Calendar object we generated when the card was created. This is stored in 'sign_year', and we also need to poll
         the current year so we create a new calendar for right now and store the Year from that object in 'now'.
         */
        int sign_year = this.GetDate().get(Calendar.YEAR);
        Calendar curr_cal = Calendar.getInstance();
        int now = curr_cal.get(Calendar.YEAR);
        int difference = now - sign_year;
        return difference;
    }


    public static TitaniumCard getInstanceFromStringArray(String[] content){
        var ID = Integer.parseInt(content[0]);
        var name = content[1];
        var address = new Address(content[2], content[3], content[4], content[5], content[6], content[7]);
        var ffp = Integer.parseInt(content[8]);
        Calendar actdate = Calendar.getInstance();
        String[] date = content[9].split("/", 3);
        actdate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date[0]));
        actdate.set(Calendar.MONTH, Integer.parseInt(date[1]));
        actdate.set(Calendar.YEAR, Integer.parseInt(date[2]));
        TitaniumCard output = new TitaniumCard(ID, name, address);
        output.AddPoints(ffp);
        return output;
    }
}