public class Coupon implements Discount, StringForFile {
    private String id;
    private double value;

    public Coupon(String id, double value){
        this.id = id;
        this.value = value;
    }
    public Coupon(double value){
        this.value = value;
        this.id = Double.toString(Math.random());
    }

    public double getValue() {
        return value;
    }
    public static Coupon getInstanceFromStringArray(String[] content){
        String ID = content[0];
        double value = Double.parseDouble(content[1]);
        Coupon output = new Coupon(ID, value);
        return output;
    }

    @Override
    public String toString(){
        return "ID: "+this.id+"\nValue: "+this.value;
    }
    @Override
    public String getDiscountID() {
        return id;
    }


    @Override
    public double getDiscountAmount(double price, AirTicket.TicketType ticketType) {
        return price - this.getValue();
    }

    @Override
    public String getDataToSaveToTextFile() {
        return null;
    }
}