import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AirTicket {
    private String ID;
    private String Name;
    private String Departure;
    private String Destination;
    private String FlightNum;
    private double Price;
    private double DiscountAmount;
    private TicketType ticketType;
    private DiscountType discountType;

    public enum TicketType{
        EconomyClass("Economy Class"),
        BusinessClass("Business Class"),
        FirstClass("First Class");

        private final String Ticket;

        TicketType(String s) {
            this.Ticket = s;
        }
        public String getTicket(){
            return this.Ticket;
        }
    }
    public enum DiscountType{
        Card("Card"),
        Coupon("Coupon");

        private final String Type;

        DiscountType(String s){
            this.Type = s;
        }
        public String getType(){
            return this.Type;
        }
    }

    public AirTicket(String ID, String Name, String Depart, String Destin, String FlightNum, double Price, double DiscAmount,
                     TicketType ticketType, DiscountType discountType){
        this.ID = ID;
        this.Name = Name;
        this.Departure = Depart;
        this.Destination = Destin;
        this.FlightNum = FlightNum;
        this.Price = Price;
        this.DiscountAmount = DiscAmount;
        this.ticketType = ticketType;
        this.discountType = discountType;
    }

    @Override
    public String toString(){
        return "\n ID: " + this.ID +
                "\n Name: " + this.Name +
                "\n Departure: " + this.Departure +
                "\n Destination " + this.Destination +
                "\n Flight Number: " + this.FlightNum +
                "\n Price: $" + this.Price +
                "\n Discount Amount: $" + this.DiscountAmount +
                "\n Ticket Type: " + this.ticketType.getTicket() +
                "\n Discount Type: " + this.discountType.getType();
    }

    public static AirTicket getInstanceFromStringArray(String[] content){
        AirTicket output = new AirTicket(content[0], content[1], content[2],
        content[3], content[4], Double.parseDouble(content[5]),Double.parseDouble(content[6]), TicketType.valueOf(content[7]),
                DiscountType.valueOf(content[8]));
        return output;
    }


    public void getDataToSaveToTextFile(){
        var output_string =
                this.ID + "," +
                this.Name + "," +
                this.Departure + "," +
                this.Destination + "," +
                this.FlightNum + "," +
                this.Price + "," +
                this.DiscountAmount + "," +
                this.ticketType + "," +
                this.discountType + "\n";
        try {
            /* BufferedWriter alongside setting append to true in FileWriter means we are constantly adding a new
            entry to the file, instead of overwriting whatever was there before */
            BufferedWriter output = new BufferedWriter(new FileWriter("AirTicket.csv",true));
            output.write(output_string);
            output.flush();
        }
        catch (IOException e){
            System.out.println("An error occured. Please try again.");
            e.printStackTrace();
        }
    }
}