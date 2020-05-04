public class Coupon implements Discount, StringForFile {
    private String id;
    private double value;

    public Coupon(String id, double value){
        this.id = id;
        this.value = value;
    }
    public Coupon(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }
    public static Coupon getInstanceFromStringArray(String[] content){

    }

    @Override
    public void getDiscountID() {

    }

    @Override
    public double getDiscountAmount(double price, TicketType ticketType) {
        return 0;
    }

    @Override
    public String getDataToSaveToTextFile() {
        return null;
    }
}
